import { createInterface, Interface } from 'node:readline/promises';
import { stdin as input, stdout as output } from 'node:process';
import { CellphoneController } from '../controller/CellphoneController';
import { Cellphone } from '../model/Cellphone';

/** View: interactive console menu and all user-facing messages. */
export class CellphoneView {
  private readonly terminal: Interface = createInterface({ input, output });

  constructor(private readonly controller: CellphoneController) {}

  public async start(): Promise<void> {
    try {
      let running = true;
      while (running) {
        console.log('\n========== CELLPHONE SYSTEM ==========');
        console.log('1. Create cellphone');
        console.log('2. Read cellphones from JSON');
        console.log('3. Exit');

        const option = (await this.terminal.question('Choose an option: ')).trim();
        switch (option) {
          case '1':
            await this.createCellphone();
            break;
          case '2':
            this.showCellphones();
            break;
          case '3':
            console.log('Goodbye!');
            running = false;
            break;
          default:
            console.log('Invalid option. Enter 1, 2, or 3.');
        }
      }
    } finally {
      this.terminal.close();
    }
  }

  private async createCellphone(): Promise<void> {
    console.log('\n--- REGISTER CELLPHONE ---');
    const id = await this.terminal.question('ID: ');
    const brand = await this.terminal.question('Brand: ');
    const model = await this.terminal.question('Model: ');
    const storageText = await this.terminal.question('Storage (GB): ');
    const storageGB = Number(storageText.trim());

    try {
      const cellphone = this.controller.createCellphone(id, brand, model, storageGB);
      console.log(`Saved successfully: ${cellphone.id} (${cellphone.brand} ${cellphone.model}).`);
      console.log('JSON file: data/cellphones.json');
    } catch (error) {
      this.showError(error);
    }
  }

  private showCellphones(): void {
    try {
      const cellphones = this.controller.readCellphones();
      console.log('\n--- CELLPHONES READ FROM JSON ---');
      if (cellphones.isEmpty()) {
        console.log('No cellphones found.');
        return;
      }
      for (const cellphone of cellphones.toArray()) {
        this.printCellphone(cellphone);
      }
      console.log(`Total: ${cellphones.size()} cellphone(s).`);
    } catch (error) {
      this.showError(error);
    }
  }

  private printCellphone(cellphone: Cellphone): void {
    console.log(`ID: ${cellphone.id} | Brand: ${cellphone.brand} | Model: ${cellphone.model} | Storage: ${cellphone.storageGB} GB`);
  }

  private showError(error: unknown): void {
    console.error(`ERROR: ${error instanceof Error ? error.message : 'Unexpected error.'}`);
  }
}
