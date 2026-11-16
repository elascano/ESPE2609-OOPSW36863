import { existsSync, mkdirSync, readFileSync, writeFileSync } from 'node:fs';
import { dirname, resolve } from 'node:path';
import { ArrayList } from '../model/ArrayList';
import { Cellphone } from '../model/Cellphone';

/** Repository: reads and writes a SINGLE file (data/cellphones.json). */
export class CellphoneRepository {
  constructor(private readonly filePath: string = resolve(process.cwd(), 'data', 'cellphones.json')) {}

  private ensureFileExists(): void {
    mkdirSync(dirname(this.filePath), { recursive: true });
    if (!existsSync(this.filePath)) {
      writeFileSync(this.filePath, '[]\n', 'utf8');
    }
  }

  public readAll(): ArrayList<Cellphone> {
    this.ensureFileExists();
    let records: unknown;
    try {
      records = JSON.parse(readFileSync(this.filePath, 'utf8')) as unknown;
    } catch {
      throw new Error('The JSON file could not be read or contains invalid JSON.');
    }
    if (!Array.isArray(records)) {
      throw new Error('The JSON file must contain an array of cellphones.');
    }

    const cellphones = new ArrayList<Cellphone>();
    for (const record of records) {
      cellphones.add(Cellphone.fromObject(record));
    }
    return cellphones;
  }

  public saveAll(cellphones: ArrayList<Cellphone>): void {
    this.ensureFileExists();
    writeFileSync(this.filePath, JSON.stringify(cellphones.toArray(), null, 2) + '\n', 'utf8');
  }
}
