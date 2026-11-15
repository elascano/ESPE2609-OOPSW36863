import { FarmAnimal } from "./farm_animal";
import { Food } from "./Food";

export class Pig extends FarmAnimal {

    constructor(
        public isProducingMeat: boolean,
        public weightInPounds: number,
        public meatType: string,
        id: number,
        breed: string,
        bornOnDate: Date
    ) {
        super(id, breed, bornOnDate);
    }

    feed(food: Food, amountOfFood: number): void {
        console.log(
            `Feeding a pig with ---> ${amountOfFood} of ${food}`
        );
    }

    gainWeight(amount: number): void {
        this.weightInPounds += amount;

        console.log(
            `The pig's new weight is ${this.weightInPounds} pounds`
        );
    }

    toString(): string {
        return `Pig{isProducingMeat=${this.isProducingMeat}, weightInPounds=${this.weightInPounds}, meatType=${this.meatType}} ${super.toString()}`;
    }
}