import { FlashDrive } from "../model/FlashDrive";
import { FlashDriveJsonFile } from "../data/FlashDriveJsonFile";
import { ConsoleInput } from "./ConsoleInput";

enum MenuOption {
    CreateFlashDrive = "1",
    ShowFlashDrives = "2",
    Exit = "0"
}

/**
 * View class: shows the main menu and runs the option chosen by the user.
 */
export class ConsoleMenu {
    private readonly jsonFile: FlashDriveJsonFile;
    private readonly consoleInput: ConsoleInput;
    private flashDrives: FlashDrive[];

    constructor(jsonFile: FlashDriveJsonFile, consoleInput: ConsoleInput) {
        this.jsonFile = jsonFile;
        this.consoleInput = consoleInput;
        this.flashDrives = jsonFile.read();
    }

    public async start(): Promise<void> {
        let selectedOption: string = "";

        while (selectedOption !== MenuOption.Exit) {
            this.printMenu();
            selectedOption = await this.consoleInput.ask("Choose an option: ");
            await this.runOption(selectedOption);
        }

        this.consoleInput.close();
    }

    private printMenu(): void {
        console.log("\n===== FLASH DRIVE MANAGER =====");
        console.log(`${MenuOption.CreateFlashDrive}. Create flash drive`);
        console.log(`${MenuOption.ShowFlashDrives}. Show flash drives (read JSON)`);
        console.log(`${MenuOption.Exit}. Exit`);
    }

    private async runOption(selectedOption: string): Promise<void> {
        switch (selectedOption) {
            case MenuOption.CreateFlashDrive:
                await this.createFlashDrive();
                break;
            case MenuOption.ShowFlashDrives:
                this.showFlashDrives();
                break;
            case MenuOption.Exit:
                console.log("Goodbye!");
                break;
            default:
                console.log("Invalid option.");
        }
    }

    private async createFlashDrive(): Promise<void> {
        console.log("\n--- CREATE FLASH DRIVE ---");

        const id: number = await this.askUnusedId();
        const brand: string = await this.consoleInput.askNonEmptyText("Brand: ");
        const capacityGB: number = await this.consoleInput.askPositiveInteger("Capacity (GB): ");
        const usbVersion: string = await this.consoleInput.askNonEmptyText("USB version (e.g. 2.0, 3.0, 3.2): ");

        this.flashDrives.push(new FlashDrive(id, brand, capacityGB, usbVersion));
        this.jsonFile.save(this.flashDrives);

        console.log(`Flash drive saved in ${this.jsonFile.getFilePath()}`);
    }

    /** Asks for an id until the user types one that no flash drive is using. */
    private async askUnusedId(): Promise<number> {
        while (true) {
            const id: number = await this.consoleInput.askPositiveInteger("Id: ");
            if (!this.isIdInUse(id)) {
                return id;
            }
            console.log("  That id already exists. Try another one.");
        }
    }

    private isIdInUse(id: number): boolean {
        return this.flashDrives.some((flashDrive) => flashDrive.getId() === id);
    }

    private showFlashDrives(): void {
        console.log("\n--- FLASH DRIVES IN THE JSON FILE ---");

        this.flashDrives = this.jsonFile.read();

        if (this.flashDrives.length === 0) {
            console.log("There are no flash drives registered.");
            return;
        }

        for (const flashDrive of this.flashDrives) {
            console.log(flashDrive.toString());
        }
        console.log(`Total: ${this.flashDrives.length}`);
    }
}
