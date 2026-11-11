
import * as fs from "fs";
import * as path from "path";
import { SDCard } from "./SDCard";

export class SDCardRepository {

    private sdCards: SDCard[] = [];

    private filePath = path.join(
        process.cwd(),
        "data",
        "sdCards.json"
    );

    constructor() {
        this.loadFromJSON();
    }

    public create(card: SDCard): void {

        if (this.sdCards.some(item => item.id === card.id)) {
            throw new Error("ID already exists.");
        }

        this.sdCards.push(card);
        this.saveToJSON();
    }

    public saveToJSON(): void {

        const directory = path.dirname(this.filePath);

        if (!fs.existsSync(directory)) {
            fs.mkdirSync(directory, { recursive: true });
        }

        const jsonData = JSON.stringify(
            this.sdCards,
            null,
            4
        );

        fs.writeFileSync(this.filePath, jsonData, "utf-8");
    }

    public loadFromJSON(): void {

        if (!fs.existsSync(this.filePath)) {
            this.sdCards = [];
            this.saveToJSON();
            return;
        }

        const jsonData = fs.readFileSync(
            this.filePath,
            "utf-8"
        );

        const data = JSON.parse(jsonData);

        this.sdCards = data.map((item: any) =>
            new SDCard(
                item.id,
                item.brand,
                item.capacityGB,
                item.speedClass
            )
        );
    }

    public findAll(): SDCard[] {
        this.loadFromJSON();
        return [...this.sdCards];
    }
}
