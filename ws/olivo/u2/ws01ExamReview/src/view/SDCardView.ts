
import { createInterface, Interface } from "readline/promises";
import { stdin, stdout } from "process";
import { SDCard } from "../model/SDCard";

export class SDCardView {

    private rl: Interface;

    constructor() {
        this.rl = createInterface({
            input: stdin,
            output: stdout
        });
    }

    public showMenu(): void {
        console.log("\n===== SD CARD MANAGEMENT =====");
        console.log("1. Create SD Card");
        console.log("2. Read SD Cards");
        console.log("3. Exit");
    }

    public async getOption(): Promise<string> {
        return await this.rl.question("Select an option: ");
    }

    public async getSDCardData(): Promise<SDCard> {

        const id = Number(
            await this.rl.question("Enter ID: ")
        );

        const brand = await this.rl.question("Enter brand: ");

        const capacityGB = Number(
            await this.rl.question("Enter capacity (GB): ")
        );

        const speedClass = await this.rl.question(
            "Enter speed class: "
        );

        return new SDCard(
            id,
            brand,
            capacityGB,
            speedClass
        );
    }

    public showCards(cards: SDCard[]): void {

        console.log("\n===== REGISTERED SD CARDS =====");

        if (cards.length === 0) {
            console.log("No SD Cards registered.");
            return;
        }

        cards.forEach(card => {
            console.log(card.getDetails());
        });
    }

    public showMessage(message: string): void {
        console.log(message);
    }

    public close(): void {
        this.rl.close();
    }
}
