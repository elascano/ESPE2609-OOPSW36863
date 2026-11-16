import { Cuts } from "./Cuts";
import { FarmAnimal } from "./FarmAnimal";
import { Food } from "./Food";
import { GrazeAnimal } from "./GrazeAnimal";
import { Location } from "./Location";

export class Cow extends FarmAnimal implements GrazeAnimal {
    isProducingMilk: boolean;
    litersOfMilk: number;

    constructor(animalId: number, breed: string, bornOnDate: Date,
                isProducingMilk: boolean, litersOfMilk: number) {
        super(animalId, breed, bornOnDate, 0);
        this.isProducingMilk = isProducingMilk;
        this.litersOfMilk = litersOfMilk;
    }

    graze(location: Location): void {
        console.log(`Sending the cow to eat grass at --> ${location}`);
    }

    feed(food: Food, amountOfFood: number, unit: string): void {
        console.log(`Feeding a cow with --> ${amountOfFood}${unit} of ${food}`);
    }

    cuts(cuts: Cuts): void {
        console.log(`Cutting a cow into --> ${cuts}`);
    }

    milk(): void {
        console.log("Milking the cow");
    }

    toString(): string {
        return `${super.toString()} | producingMilk=${this.isProducingMilk}, `
            + `liters=${this.litersOfMilk}`;
    }
}
