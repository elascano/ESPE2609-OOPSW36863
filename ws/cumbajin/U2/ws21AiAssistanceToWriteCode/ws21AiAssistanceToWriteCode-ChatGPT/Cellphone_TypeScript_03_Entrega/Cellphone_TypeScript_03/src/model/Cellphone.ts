/** Data saved in the single JSON file. */
export interface CellphoneData {
  id: string;
  brand: string;
  model: string;
  storageGB: number;
}

/** Model: one cellphone with a required ID and exactly three other attributes. */
export class Cellphone implements CellphoneData {
  public readonly id: string;
  public readonly brand: string;
  public readonly model: string;
  public readonly storageGB: number;

  constructor(id: string, brand: string, model: string, storageGB: number) {
    if (typeof id !== 'string' || id.trim().length === 0) {
      throw new Error('ID is required.');
    }
    if (typeof brand !== 'string' || brand.trim().length === 0) {
      throw new Error('Brand is required.');
    }
    if (typeof model !== 'string' || model.trim().length === 0) {
      throw new Error('Model is required.');
    }
    if (!Number.isInteger(storageGB) || storageGB <= 0) {
      throw new Error('Storage must be a positive integer (GB).');
    }

    this.id = id.trim();
    this.brand = brand.trim();
    this.model = model.trim();
    this.storageGB = storageGB;
  }

  public toJSON(): CellphoneData {
    return {
      id: this.id,
      brand: this.brand,
      model: this.model,
      storageGB: this.storageGB
    };
  }

  public static fromObject(value: unknown): Cellphone {
    if (typeof value !== 'object' || value === null) {
      throw new Error('Invalid cellphone record in the JSON file.');
    }
    const record = value as Record<string, unknown>;
    return new Cellphone(
      record.id as string,
      record.brand as string,
      record.model as string,
      record.storageGB as number
    );
  }
}
