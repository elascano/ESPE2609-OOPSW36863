import { Cellphone } from '../model/Cellphone';

export class CellphoneView {
  public displayCellphones(cellphones: Cellphone[]): void {
    console.log("\n=========================================");
    console.log("          CELLPHONE LIST (FROM JSON)      ");
    console.log("=========================================");
    if (cellphones.length === 0) {
      console.log("No cellphones found.");
    } else {
      cellphones.forEach((cellphone) => {
        console.log(`[ID: ${cellphone.getId()}] - ${cellphone.getBrand()} ${cellphone.getModel()} | Price: $${cellphone.getPrice()}`);
      });
    }
    console.log("=========================================\n");
  }

  public showMessage(message: string): void {
    console.log(`[INFO]: ${message}`);
  }
}