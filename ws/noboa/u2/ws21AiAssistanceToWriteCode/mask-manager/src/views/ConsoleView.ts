import * as readline from "readline";
import { Mask } from "../models/Mask";

/** Se lanza cuando el usuario cierra la entrada (Ctrl+C / Ctrl+D). */
export class InputClosedError extends Error {
  constructor() {
    super("Entrada cerrada");
    this.name = "InputClosedError";
  }
}

const C = {
  reset: "\x1b[0m",
  bold: "\x1b[1m",
  dim: "\x1b[2m",
  red: "\x1b[31m",
  green: "\x1b[32m",
  yellow: "\x1b[33m",
  cyan: "\x1b[36m",
};

/**
 * VISTA: todo lo que se muestra y se pide por consola.
 * No contiene lógica de negocio ni toca archivos.
 */
export class ConsoleView {
  private rl = readline.createInterface({ input: process.stdin, output: process.stdout });
  private lines: string[] = [];
  private waiting: { resolve: (l: string) => void; reject: (e: Error) => void } | null = null;
  private closed = false;

  constructor() {
    this.rl.on("line", (line) => {
      if (this.waiting) {
        const w = this.waiting;
        this.waiting = null;
        w.resolve(line);
      } else {
        this.lines.push(line);
      }
    });
    this.rl.on("close", () => {
      this.closed = true;
      if (this.waiting) {
        const w = this.waiting;
        this.waiting = null;
        w.reject(new InputClosedError());
      }
    });
  }

  // ===================== ENTRADA DE DATOS =====================
  ask(question: string): Promise<string> {
    if (!this.closed) {
      this.rl.setPrompt(question);
      this.rl.prompt();
    }
    if (this.lines.length > 0) {
      return Promise.resolve(this.lines.shift() as string);
    }
    if (this.closed) {
      return Promise.reject(new InputClosedError());
    }
    return new Promise((resolve, reject) => {
      this.waiting = { resolve, reject };
    });
  }

  async askNonEmpty(label: string): Promise<string> {
    while (true) {
      const answer = (await this.ask(`${C.cyan}${label}: ${C.reset}`)).trim();
      if (answer !== "") return answer;
      this.showError("Este campo no puede estar vacío.");
    }
  }

  async askInteger(label: string, defaultValue?: number): Promise<number> {
    const hint = defaultValue !== undefined ? ` [Enter = ${defaultValue}]` : "";
    while (true) {
      const answer = (await this.ask(`${C.cyan}${label}${hint}: ${C.reset}`)).trim();
      if (answer === "" && defaultValue !== undefined) return defaultValue;
      if (/^\d+$/.test(answer)) return parseInt(answer, 10);
      this.showError("Escribe un número entero no negativo.");
    }
  }

  async askChoice<T extends string>(label: string, options: readonly T[]): Promise<T> {
    while (true) {
      const answer = (await this.ask(`${C.cyan}${label} (${options.join("/")}): ${C.reset}`)).trim();
      const found = options.find((o) => o.toUpperCase() === answer.toUpperCase());
      if (found) return found;
      this.showError(`Opción inválida. Elige una de: ${options.join(", ")}.`);
    }
  }

  async askYesNo(label: string, defaultValue: boolean): Promise<boolean> {
    const hint = defaultValue ? "S/n" : "s/N";
    while (true) {
      const answer = (await this.ask(`${C.cyan}${label} (${hint}): ${C.reset}`)).trim().toLowerCase();
      if (answer === "") return defaultValue;
      if (["s", "si", "sí", "y", "yes"].includes(answer)) return true;
      if (["n", "no"].includes(answer)) return false;
      this.showError("Responde con s o n.");
    }
  }

  // ===================== SALIDA =====================
  showBanner(): void {
    console.log(`\n${C.bold}${C.cyan}╔══════════════════════════════════╗`);
    console.log("║      GESTOR DE MÁSCARAS (MVC)    ║");
    console.log(`╚══════════════════════════════════╝${C.reset}`);
  }

  showMenu(): void {
    console.log(`\n${C.bold}──────────── MENÚ ────────────${C.reset}`);
    console.log("  1. Añadir máscara");
    console.log("  2. Eliminar máscara");
    console.log("  3. Listar máscaras");
    console.log("  4. Revisar archivo JSON");
    console.log("  5. Poner / quitar máscara");
    console.log("  0. Salir");
    console.log(`${C.bold}──────────────────────────────${C.reset}`);
  }

  showTitle(title: string): void {
    console.log(`\n${C.bold}» ${title}${C.reset}`);
  }

  showMasks(masks: Mask[]): void {
    if (masks.length === 0) {
      this.showInfo("No hay máscaras registradas.");
      return;
    }
    const idW = Math.max(2, ...masks.map((m) => String(m.id).length));
    const nameW = Math.max(6, ...masks.map((m) => m.name.length));
    const line = "─".repeat(idW + nameW + 5 + 6 + 6);

    console.log(`\n${C.bold}${"ID".padEnd(idW)}  ${"NOMBRE".padEnd(nameW)}  ${"TALLA".padEnd(5)}  PUESTA${C.reset}`);
    console.log(line);
    for (const m of masks) {
      const wearing = m.isWearing ? `${C.green}Sí${C.reset}` : `${C.dim}No${C.reset}`;
      console.log(`${String(m.id).padEnd(idW)}  ${m.name.padEnd(nameW)}  ${m.size.padEnd(5)}  ${wearing}`);
    }
    console.log(line);
    console.log(`${C.dim}Total: ${masks.length}${C.reset}`);
  }

  showJson(filePath: string, content: string): void {
    console.log(`\n${C.dim}Archivo: ${filePath}${C.reset}`);
    console.log(C.yellow + content + C.reset);
  }

  showSuccess(message: string): void {
    console.log(`${C.green}✔ ${message}${C.reset}`);
  }

  showError(message: string): void {
    console.log(`${C.red}✘ ${message}${C.reset}`);
  }

  showInfo(message: string): void {
    console.log(`${C.yellow}ℹ ${message}${C.reset}`);
  }

  close(): void {
    this.rl.close();
  }
}
