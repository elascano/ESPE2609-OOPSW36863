import { Cuts } from "./Cuts";
import { FarmAnimal } from "./FarmAnimal";
import { Food } from "./Food";

export class Pig extends FarmAnimal {
    weightInKg: number;
    isReadyToEat: boolean;

    constructor(animalId: number, breed: string, bornOnDate: Date, numberOfOffspring: number,
                weightInKg: number, isReadyToEat: boolean) {
        super(animalId, breed, bornOnDate, numberOfOffspring);
        this.weightInKg = weightInKg;
        this.isReadyToEat = isReadyToEat;
    }

    feed(food: Food, amountOfFood: number, unit: string): void {
        console.log(`Feeding a pig with --> ${amountOfFood}${unit} of ${food}`);
    }

    cuts(cuts: Cuts): void {
        console.log(`Cutting a pig into --> ${cuts}`);
    }

    gainWeight(kg: number): void {
        console.log(`The currently weight of the pig --> ${kg}`);
    }

    produceManure(manure: number, unit: string): void {
        console.log(`Pig's manure produced --> ${manure}${unit}`);
    }

    toString(): string {
        return `${super.toString()} | weightInKg=${this.weightInKg}, `
            + `readyToEat=${this.isReadyToEat}`;
    }
}
