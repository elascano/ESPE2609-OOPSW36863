import { Mask } from "../models/Mask";
import { MaskRepository } from "../models/MaskRepository";
import { ConsoleView, InputClosedError } from "../views/ConsoleView";

/**
 * CONTROLADOR: conecta la vista con el modelo.
 * Pide datos a la vista, se los pasa al modelo y muestra el resultado.
 */
export class MaskController {
  constructor(
    private readonly repo: MaskRepository,
    private readonly view: ConsoleView
  ) {}

  async run(): Promise<void> {
    this.view.showBanner();
    try {
      let exit = false;
      while (!exit) {
        this.view.showMenu();
        const option = (await this.view.ask("Elige una opción: ")).trim();
        try {
          exit = await this.handleOption(option);
        } catch (error) {
          if (error instanceof InputClosedError) throw error;
          this.view.showError(error instanceof Error ? error.message : String(error));
        }
      }
      this.view.showInfo("¡Hasta luego!");
    } catch (error) {
      if (error instanceof InputClosedError) {
        this.view.showInfo("Entrada cerrada. ¡Hasta luego!");
      } else {
        throw error;
      }
    } finally {
      this.view.close();
    }
  }

  /** Devuelve true cuando el usuario quiere salir. */
  private async handleOption(option: string): Promise<boolean> {
    switch (option) {
      case "1": await this.addMask(); break;
      case "2": await this.removeMask(); break;
      case "3": this.listMasks(); break;
      case "4": this.showJson(); break;
      case "5": await this.toggleMask(); break;
      case "0": return true;
      default: this.view.showError("Opción inválida. Elige un número del menú.");
    }
    return false;
  }

  // ===================== CASOS DE USO =====================
  private async addMask(): Promise<void> {
    this.view.showTitle("Añadir máscara");

    const suggestedId = this.repo.nextId();
    let id: number;
    while (true) {
      id = await this.view.askInteger("ID", suggestedId);
      if (!this.repo.exists(id)) break;
      this.view.showError(`Ya existe una máscara con id ${id}.`);
    }

    const name = await this.view.askNonEmpty("Nombre");
    const size = await this.view.askChoice("Talla", Mask.VALID_SIZES);
    const isWearing = await this.view.askYesNo("¿La tienes puesta?", false);

    const mask = new Mask(id, name, size, isWearing);
    this.repo.add(mask);
    this.view.showSuccess(`Máscara "${mask.name}" (id ${mask.id}) guardada en el JSON.`);
  }

  private async removeMask(): Promise<void> {
    this.view.showTitle("Eliminar máscara");
    const masks = this.repo.loadAll();
    if (masks.length === 0) {
      this.view.showInfo("No hay máscaras para eliminar.");
      return;
    }
    this.view.showMasks(masks);

    const id = await this.view.askInteger("ID de la máscara a eliminar");
    const mask = this.repo.findById(id);
    if (!mask) {
      this.view.showError(`No existe una máscara con id ${id}.`);
      return;
    }

    const confirmed = await this.view.askYesNo(`¿Eliminar "${mask.name}"?`, false);
    if (!confirmed) {
      this.view.showInfo("Operación cancelada.");
      return;
    }
    this.repo.remove(id);
    this.view.showSuccess(`Máscara "${mask.name}" eliminada.`);
  }

  private listMasks(): void {
    this.view.showTitle("Lista de máscaras");
    this.view.showMasks(this.repo.loadAll());
  }

  private showJson(): void {
    this.view.showTitle("Contenido del archivo JSON");
    const raw = this.repo.readRaw();
    if (raw === null) {
      this.view.showInfo("El archivo aún no existe. Añade una máscara para generarlo.");
      return;
    }
    this.view.showJson(this.repo.getFilePath(), raw);
  }

  private async toggleMask(): Promise<void> {
    this.view.showTitle("Poner / quitar máscara");
    const masks = this.repo.loadAll();
    if (masks.length === 0) {
      this.view.showInfo("No hay máscaras registradas.");
      return;
    }
    this.view.showMasks(masks);

    const id = await this.view.askInteger("ID de la máscara");
    const mask = this.repo.findById(id);
    if (!mask) {
      this.view.showError(`No existe una máscara con id ${id}.`);
      return;
    }
    mask.toggleWearing();
    this.repo.update(mask);
    this.view.showSuccess(`"${mask.name}" ahora está ${mask.isWearing ? "puesta" : "quitada"}.`);
  }
}
