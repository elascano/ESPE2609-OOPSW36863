import { FarmAnimal } from "./farm_animal";
import { Food } from "./Food";
import { GrazeAnimal } from "./grazeAnimal";
import { Location } from "./location";

export class Sheep extends FarmAnimal implements GrazeAnimal {

    constructor(
        public isProducingWool: boolean,
        public woolInPounds: number,
        public woolColor: string,
        id: number,
        breed: string,
        bornOnDate: Date
    ) {
        super(id, breed, bornOnDate);
    }

    feed(food: Food, amountOfFood: number): void {
        console.log(
            `Feeding a sheep with ---> ${amountOfFood} of ${food}`
        );
    }

    graze(location: Location): void {
        console.log(`The sheep is grazing at ---> ${location}`);
    }

    shearWool(): void {
        console.log("Shearing the sheep...");
    }

    toString(): string {
        return `Sheep{isProducingWool=${this.isProducingWool}, woolInPounds=${this.woolInPounds}, woolColor=${this.woolColor}} ${super.toString()}`;
    }
}