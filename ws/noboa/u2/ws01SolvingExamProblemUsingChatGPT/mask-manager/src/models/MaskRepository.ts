import * as fs from "fs";
import * as path from "path";
import { Mask, MaskData } from "./Mask";

/**
 * MODELO: acceso a datos.
 * Se encarga de generar y leer el archivo JSON. No sabe nada de la consola.
 */
export class MaskRepository {
  constructor(private readonly filePath: string) {}

  getFilePath(): string {
    return this.filePath;
  }

  /** Lee el JSON y devuelve instancias reales de Mask ([] si el archivo no existe). */
  loadAll(): Mask[] {
    const raw = this.readRaw();
    if (raw === null || raw.trim() === "") {
      return [];
    }
    let parsed: unknown;
    try {
      parsed = JSON.parse(raw);
    } catch {
      throw new Error("El archivo JSON está dañado o mal formado.");
    }
    if (!Array.isArray(parsed)) {
      throw new Error("El JSON debe contener un arreglo de máscaras.");
    }
    return (parsed as MaskData[]).map((item) => Mask.fromJSON(item));
  }

  /** Genera (o sobrescribe) el archivo JSON, creando la carpeta si hace falta. */
  saveAll(masks: Mask[]): void {
    fs.mkdirSync(path.dirname(this.filePath), { recursive: true });
    fs.writeFileSync(this.filePath, JSON.stringify(masks, null, 2), "utf-8");
  }

  /** Contenido crudo del archivo (null si todavía no existe). */
  readRaw(): string | null {
    if (!fs.existsSync(this.filePath)) {
      return null;
    }
    return fs.readFileSync(this.filePath, "utf-8");
  }

  exists(id: number): boolean {
    return this.loadAll().some((m) => m.id === id);
  }

  findById(id: number): Mask | undefined {
    return this.loadAll().find((m) => m.id === id);
  }

  nextId(): number {
    const masks = this.loadAll();
    return masks.length === 0 ? 1 : Math.max(...masks.map((m) => m.id)) + 1;
  }

  add(mask: Mask): void {
    const masks = this.loadAll();
    if (masks.some((m) => m.id === mask.id)) {
      throw new Error(`Ya existe una máscara con id ${mask.id}.`);
    }
    masks.push(mask);
    this.saveAll(masks);
  }

  update(mask: Mask): void {
    const masks = this.loadAll();
    const index = masks.findIndex((m) => m.id === mask.id);
    if (index === -1) {
      throw new Error(`No existe una máscara con id ${mask.id}.`);
    }
    masks[index] = mask;
    this.saveAll(masks);
  }

  /** Elimina por id. Devuelve true si se eliminó, false si no existía. */
  remove(id: number): boolean {
    const masks = this.loadAll();
    const filtered = masks.filter((m) => m.id !== id);
    if (filtered.length === masks.length) {
      return false;
    }
    this.saveAll(filtered);
    return true;
  }
}
