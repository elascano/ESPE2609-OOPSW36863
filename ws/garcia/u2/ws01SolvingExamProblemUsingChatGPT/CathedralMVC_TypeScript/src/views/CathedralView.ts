import { createInterface, Interface } from "node:readline/promises";
import { stdin as input, stdout as output } from "node:process";
import { Cathedral } from "../models/Cathedral";

export class CathedralView {
    private readonly terminal: Interface;

    constructor() {
        this.terminal = createInterface({ input, output });
    }

    public showMenu(): void {
        console.log("\n=== ECUADORIAN CATHEDRALS ===");
        console.log("1. Register a cathedral");
        console.log("2. Show saved cathedrals");
        console.log("3. Exit");
    }

    public async ask(question: string): Promise<string> {
        return (await this.terminal.question(question)).trim();
    }

    public async collectCathedralData(): Promise<Omit<Cathedral, "constructor"> & {
        id: string;
        name: string;
        city: string;
        province: string;
        architecturalStyle: string;
    }> {
        console.log("\n--- New cathedral ---");
        const id = await this.ask("ID: ");
        const name = await this.ask("Cathedral name (Spanish is allowed): ");
        const city = await this.ask("City: ");
        const province = await this.ask("Province: ");
        const architecturalStyle = await this.ask("Architectural style: ");

        return { id, name, city, province, architecturalStyle };
    }

    public showCathedrals(cathedrals: Cathedral[]): void {
        console.log("\n--- CATHEDRAL RECORDS ---");

        if (cathedrals.length === 0) {
            console.log("No cathedral records found.");
            return;
        }

        cathedrals.forEach((cathedral, index) => {
            console.log(`\n${index + 1}. ${cathedral.name}`);
            console.log(`   ID: ${cathedral.id}`);
            console.log(`   City: ${cathedral.city}`);
            console.log(`   Province: ${cathedral.province}`);
            console.log(`   Architectural style: ${cathedral.architecturalStyle}`);
        });
    }

    public showMessage(message: string): void {
        console.log(message);
    }

    public async close(): Promise<void> {
        this.terminal.close();
    }
}