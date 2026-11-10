import path from "node:path";
import { Cathedral } from "../models/Cathedral";
import { CathedralView } from "../views/CathedralView";

export class CathedralController {
    private readonly dataFilePath: string;

    constructor(private readonly view: CathedralView) {
        this.dataFilePath = path.join(process.cwd(), "data", "cathedrals.json");
    }

    public async start(): Promise<void> {
        let isRunning = true;

        while (isRunning) {
            this.view.showMenu();
            const option = await this.view.ask("Choose an option: ");

            try {
                switch (option) {
                    case "1":
                        await this.registerCathedral();
                        break;
                    case "2":
                        await this.showCathedrals();
                        break;
                    case "3":
                        isRunning = false;
                        this.view.showMessage("Goodbye!");
                        break;
                    default:
                        this.view.showMessage("Invalid option. Please choose 1, 2 or 3.");
                }
            } catch (error) {
                const message = error instanceof Error ? error.message : "Unknown error";
                this.view.showMessage(`Operation failed: ${message}`);
            }
        }

        await this.view.close();
    }

    private async registerCathedral(): Promise<void> {
        const data = await this.view.collectCathedralData();

        if (Object.values(data).some((value) => value.length === 0)) {
            this.view.showMessage("All fields are required. The cathedral was not saved.");
            return;
        }

        const cathedrals = await Cathedral.readFromJson(this.dataFilePath);
        if (cathedrals.some((cathedral) => cathedral.id === data.id)) {
            this.view.showMessage("That ID already exists. Please use a unique ID.");
            return;
        }

        const newCathedral = new Cathedral(
            data.id,
            data.name,
            data.city,
            data.province,
            data.architecturalStyle
        );

        cathedrals.push(newCathedral);
        await Cathedral.saveToJson(this.dataFilePath, cathedrals);
        this.view.showMessage("Cathedral saved successfully in data/cathedrals.json.");
    }

    private async showCathedrals(): Promise<void> {
        const cathedrals = await Cathedral.readFromJson(this.dataFilePath);
        this.view.showCathedrals(cathedrals);
    }
}