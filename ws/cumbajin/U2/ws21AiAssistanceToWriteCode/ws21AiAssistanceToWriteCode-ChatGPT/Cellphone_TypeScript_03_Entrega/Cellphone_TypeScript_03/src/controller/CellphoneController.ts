import { ArrayList } from '../model/ArrayList';
import { Cellphone } from '../model/Cellphone';
import { CellphoneRepository } from '../repository/CellphoneRepository';

/** Controller: business operations without console or file-handling details. */
export class CellphoneController {
  constructor(private readonly repository: CellphoneRepository) {}

  public createCellphone(id: string, brand: string, model: string, storageGB: number): Cellphone {
    const cellphone = new Cellphone(id, brand, model, storageGB);
    const cellphones = this.repository.readAll();

    if (cellphones.some((item) => item.id.toLowerCase() === cellphone.id.toLowerCase())) {
      throw new Error(`A cellphone with ID "${cellphone.id}" already exists.`);
    }

    cellphones.add(cellphone);
    this.repository.saveAll(cellphones);
    return cellphone;
  }

  public readCellphones(): ArrayList<Cellphone> {
    return this.repository.readAll();
  }
}
