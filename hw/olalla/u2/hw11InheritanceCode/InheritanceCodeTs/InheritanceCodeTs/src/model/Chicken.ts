import { Cuts } from "./Cuts";
import { FarmAnimal } from "./FarmAnimal";
import { Food } from "./Food";

export class Chicken extends FarmAnimal {
    isMolting: boolean;
    numberOfLaidEggsInMonths: number;
    isMeat: boolean;

    constructor(animalId: number, breed: string, bornOnDate: Date,
                isMolting: boolean, numberOfLaidEggsInMonths: number, isMeat: boolean) {
        super(animalId, breed, bornOnDate, 0);
        this.isMolting = isMolting;
        this.numberOfLaidEggsInMonths = numberOfLaidEggsInMonths;
        this.isMeat = isMeat;
    }

    feed(food: Food, amountOfFood: number, unit: string): void {
        console.log(`Feeding a chicken with --> ${amountOfFood}${unit} of ${food}`);
    }

    cuts(cuts: Cuts): void {
        console.log(`Cutting a chicken into --> ${cuts}`);
    }

    layAnEgg(): void {
        this.numberOfLaidEggsInMonths += 1;
        console.log("Chicken lays an egg ");
    }

    toString(): string {
        return `${super.toString()} | molting=${this.isMolting}, `
            + `eggs/month=${this.numberOfLaidEggsInMonths}, `
            + `meat=${this.isMeat}`;
    }
}
