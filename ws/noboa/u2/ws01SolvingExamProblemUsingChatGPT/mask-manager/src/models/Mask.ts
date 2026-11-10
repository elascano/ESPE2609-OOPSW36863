/** Tallas permitidas para una máscara. */
export type MaskSize = "XS" | "S" | "M" | "L" | "XL";

/** Forma "plana" del objeto tal como se guarda en el JSON. */
export interface MaskData {
  id: number;
  name: string;
  size: MaskSize;
  isWearing: boolean;
}

/**
 * MODELO: entidad Mask.
 * Encapsula sus datos (atributos privados) y valida su propio estado.
 */
export class Mask {
  static readonly VALID_SIZES: readonly MaskSize[] = ["XS", "S", "M", "L", "XL"];

  constructor(
    private _id: number,
    private _name: string,
    private _size: MaskSize,
    private _isWearing: boolean = false
  ) {
    if (!Number.isInteger(_id) || _id < 0) {
      throw new Error("El id debe ser un entero no negativo.");
    }
    if (!_name || _name.trim() === "") {
      throw new Error("El nombre no puede estar vacío.");
    }
    if (!Mask.isValidSize(_size)) {
      throw new Error(`Talla inválida: ${_size}`);
    }
    this._name = _name.trim();
  }

  // ---------- Getters ----------
  get id(): number {
    return this._id;
  }
  get name(): string {
    return this._name;
  }
  get size(): MaskSize {
    return this._size;
  }
  get isWearing(): boolean {
    return this._isWearing;
  }

  // ---------- Comportamiento ----------
  toggleWearing(): void {
    this._isWearing = !this._isWearing;
  }

  // ---------- Serialización ----------
  /** JSON.stringify llama automáticamente a este método. */
  toJSON(): MaskData {
    return {
      id: this._id,
      name: this._name,
      size: this._size,
      isWearing: this._isWearing,
    };
  }

  /** Reconstruye una instancia de Mask a partir de datos leídos del JSON. */
  static fromJSON(data: MaskData): Mask {
    if (
      typeof data !== "object" || data === null ||
      typeof data.id !== "number" ||
      typeof data.name !== "string" ||
      typeof data.size !== "string" ||
      typeof data.isWearing !== "boolean"
    ) {
      throw new Error("El JSON contiene una máscara con datos inválidos.");
    }
    return new Mask(data.id, data.name, data.size, data.isWearing);
  }

  static isValidSize(value: string): value is MaskSize {
    return (Mask.VALID_SIZES as readonly string[]).includes(value);
  }
}
