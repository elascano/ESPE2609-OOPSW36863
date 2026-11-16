import { Cuts } from "./Cuts";
import { FarmAnimal } from "./FarmAnimal";
import { Food } from "./Food";

export class Sheep extends FarmAnimal {
    isReadyToShear: boolean;
    lastShearing: Date;
    woolKgPerShearing: number;

    constructor(animalId: number, breed: string, bornOnDate: Date, numberOfOffspring: number,
                isReadyToShear: boolean, lastShearing: Date, woolKgPerShearing: number) {
        super(animalId, breed, bornOnDate, numberOfOffspring);
        this.isReadyToShear = isReadyToShear;
        this.lastShearing = lastShearing;
        this.woolKgPerShearing = woolKgPerShearing;
    }

    graze(location: Location): void {
        console.log(`Sending the sheep to eat grass at --> ${location}`);
    }

    feed(food: Food, amountOfFood: number, unit: string): void {
        console.log(`Feeding a sheep with --> ${amountOfFood}${unit} of ${food}`);
    }

    cuts(cuts: Cuts): void {
        console.log(`Cutting a sheep into --> ${cuts}`);
    }

    shear(): void {
        console.log("Shearing the sheep...");
    }

    woolProducePerMonth(wool: number, unit: string): void {
        console.log(`Wool produced --> ${wool}${unit}`);
    }

    toString(): string {
        return `${super.toString()} | readyToShear=${this.isReadyToShear}, `
            + `lastShearing=${this.lastShearing.toDateString()}, `
            + `woolKgPerShearing=${this.woolKgPerShearing}`;
    }
}
