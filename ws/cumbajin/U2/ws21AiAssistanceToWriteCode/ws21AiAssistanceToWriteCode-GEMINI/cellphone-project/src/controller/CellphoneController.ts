import * as fs from 'fs';
import * as path from 'path';
import { Cellphone } from '../model/Cellphone';

export class CellphoneController {
  private cellphones: Cellphone[] = [];
  private filePath: string;

  constructor(fileName: string = 'cellphones.json') {
    // Usamos process.cwd() para apuntar directamente a la raíz del proyecto de forma segura
    this.filePath = path.join(process.cwd(), fileName);
  }

  public addCellphone(cellphone: Cellphone): void {
    this.cellphones.push(cellphone);
  }

  public getCellphones(): Cellphone[] {
    return this.cellphones;
  }

  // Método para guardar la lista en el archivo JSON
  public saveToJson(): void {
    const plainData = this.cellphones.map(c => ({
      id: c.getId(),
      brand: c.getBrand(),
      model: c.getModel(),
      price: c.getPrice()
    }));

    const jsonString = JSON.stringify(plainData, null, 2);
    fs.writeFileSync(this.filePath, jsonString, 'utf-8');
  }

  // Método para leer el archivo JSON y pasarlo de nuevo a la lista de objetos
  public readFromJson(): Cellphone[] {
    if (!fs.existsSync(this.filePath)) {
      return [];
    }

    const fileData = fs.readFileSync(this.filePath, 'utf-8');
    const parsedData = JSON.parse(fileData);

    this.cellphones = parsedData.map(
      (item: any) => new Cellphone(item.id, item.brand, item.model, item.price)
    );

    return this.cellphones;
  }
}