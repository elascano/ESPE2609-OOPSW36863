/** Connects the keyboard/menu view to the animal model. */
import { AnimalView } from "../view/AnimalView";
import { Chicken } from "../model/Chicken";
import { Cow } from "../model/Cow";
import { Pig } from "../model/Pig";
import { Sheep } from "../model/Sheep";

export class AnimalController {
    constructor(private readonly view: AnimalView) {}

    async run(): Promise<void> {
        let option: number;
        do {
            option = await this.view.showMenu();
            switch (option) {
                case 1: {
                    const chicken = await this.createChicken();
                    console.log("Chicken -> " + chicken.toString());
                    break;
                }
                case 2: {
                    const cow = await this.createCow();
                    console.log("Cow -> " + cow.toString());
                    cow.milk();
                    break;
                }
                case 3: {
                    const pig = await this.createPig();
                    console.log("Pig -> " + pig.toString());
                    break;
                }
                case 4: {
                    const sheep = await this.createSheep();
                    console.log("Sheep -> " + sheep.toString());
                    break;
                }
                case 5:
                    console.log("Exiting program...");
                    break;
                default:
                    console.log("Invalid option.");
            }
            console.log();
        } while (option !== 5);
    }

    async createChicken(): Promise<Chicken> {
        console.log("----- ENTER CHICKEN DATA -----");
        const id = await this.view.readId();
        const bread = await this.view.readBread();
        const bornOnDate = await this.view.readDate("born date");
        const isMolting = await this.view.readBool("Is molting? (true/false): ");
        const numberOffLatIsMonth = await this.view.readInt("Number of eggs this month: ");
        const isMeat = await this.view.readBool("Is meat? (true/false): ");
        return new Chicken(id, bread, bornOnDate, isMolting, numberOffLatIsMonth, isMeat);
    }

    async createCow(): Promise<Cow> {
        console.log("----- ENTER COW DATA -----");
        const id = await this.view.readId();
        const bread = await this.view.readBread();
        const bornOnDate = await this.view.readDate("born date");
        const isProducingMilk = await this.view.readBool("Is producing milk? (true/false): ");
        const litersOfMilkPerWeek = await this.view.readFloat("Liters of milk per week: ");
        return new Cow(isProducingMilk, litersOfMilkPerWeek, id, bread, bornOnDate);
    }

    async createPig(): Promise<Pig> {
        console.log("----- ENTER PIG DATA -----");
        const id = await this.view.readId();
        const bread = await this.view.readBread();
        const bornOnDate = await this.view.readDate("born date");
        return new Pig(id, bread, bornOnDate);
    }

    async createSheep(): Promise<Sheep> {
        console.log("----- ENTER SHEEP DATA -----");
        const id = await this.view.readId();
        const bread = await this.view.readBread();
        const bornOnDate = await this.view.readDate("born date");
        const lastSheering = await this.view.readDate("last sheering date");
        return new Sheep(lastSheering, id, bread, bornOnDate);
    }
}
