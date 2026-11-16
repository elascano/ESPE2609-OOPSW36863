import { Cuts } from "./Cuts";
import { Food } from "./Food";

export abstract class FarmAnimal {
    animalId: number;
    breed: string;
    bornOnDate: Date;
    numberOfOffspring: number;

    constructor(animalId: number, breed: string, bornOnDate: Date, numberOfOffspring: number) {
        this.animalId = animalId;
        this.breed = breed;
        this.bornOnDate = bornOnDate;
        this.numberOfOffspring = numberOfOffspring;
    }

    /** Feed the animal with their own food */
    abstract feed(food: Food, amountOfFood: number, unit: string): void;

    /** Cut the animal into their own cuts */
    abstract cuts(cuts: Cuts): void;

    giveBirth(offspring: number): void {
        console.log(`Number of offspring the ${this.constructor.name} gave birth --> ${offspring}`);
    }

    getAgeInMonths(): number {
        const today = new Date();
        return (today.getFullYear() - this.bornOnDate.getFullYear()) * 12
            + (today.getMonth() - this.bornOnDate.getMonth());
    }

    toString(): string {
        return `${this.constructor.name}(id=${this.animalId}, `
            + `breed=${this.breed}, age=${this.getAgeInMonths()} months, `
            + `offspring=${this.numberOfOffspring})`;
    }
}
