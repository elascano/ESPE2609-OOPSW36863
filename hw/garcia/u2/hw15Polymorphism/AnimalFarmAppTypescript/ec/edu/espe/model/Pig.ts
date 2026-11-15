import { FarmAnimal } from "./FarmAnimal";
import { Food } from "./Food";

export class Pig extends FarmAnimal {
    private numberOfPigletsPerLitter: number;

    constructor(numberOfPigletsPerLitter: number, id: number, breed: string, bornOnDate: Date) {
        super(id, breed, bornOnDate);
        this.numberOfPigletsPerLitter = numberOfPigletsPerLitter;
    }

    feed(food: Food, amountOfFood: number): void {
        console.log(`Feeding pig with --> ${food.toString()} amount of food --> ${amountOfFood}`);
    }

    toString(): string { return `Pig{${super.toString()}numberOfPigletsPerLitter = ${this.numberOfPigletsPerLitter}}`; }
    registerLitter(numberOfPiglets: number): void { this.setNumberOfPigletsPerLitter(numberOfPiglets); }
    getNumberOfPigletsPerLitter(): number { return this.numberOfPigletsPerLitter; }
    setNumberOfPigletsPerLitter(numberOfPigletsPerLitter: number): void { this.numberOfPigletsPerLitter = numberOfPigletsPerLitter; }
}
