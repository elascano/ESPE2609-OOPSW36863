
import { SDCard } from "../model/SDCard";
import { SDCardRepository } from "../model/SDCardRepository";
import { SDCardView } from "../view/SDCardView";

export class SDCardController {

    constructor(
        private repository: SDCardRepository,
        private view: SDCardView
    ) {}

    public async start(): Promise<void> {

        let option: string;

        do {
            this.view.showMenu();
            option = await this.view.getOption();

            switch (option) {

                case "1":
                    await this.createSDCard();
                    break;

                case "2":
                    this.readSDCards();
                    break;

                case "3":
                    this.view.showMessage("Exiting program...");
                    break;

                default:
                    this.view.showMessage("Invalid option.");
            }

        } while (option !== "3");

        this.view.close();
    }

    private async createSDCard(): Promise<void> {

        try {
            const card: SDCard =
                await this.view.getSDCardData();

            if (
                !Number.isInteger(card.id) || card.id <= 0 ||
                !card.brand.trim() ||
                !Number.isFinite(card.capacityGB) ||
                card.capacityGB <= 0 ||
                !card.speedClass.trim()
            ) {
                throw new Error("Invalid SD Card information.");
            }

            this.repository.create(card);

            this.view.showMessage(
                "SD Card created and saved successfully!"
            );

        } catch (error) {
            this.view.showMessage(
                error instanceof Error
                    ? error.message
                    : "An unexpected error occurred."
            );
        }
    }

    private readSDCards(): void {

        try {
            const cards = this.repository.findAll();

            this.view.showCards(cards);

        } catch {
            this.view.showMessage(
                "Error reading the JSON file."
            );
        }
    }
}
