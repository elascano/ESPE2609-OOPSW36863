import { FarmAnimal } from "./farm_animal";
import { Food } from "./Food";

export class Chicken extends FarmAnimal {

    constructor(
        public isMolting: boolean,
        public numberOfLaidEggsInAMonth: number,
        public isMeat: boolean,
        id: number,
        breed: string,
        bornOnDate: Date
    ) {
        super(id, breed, bornOnDate);
    }

    feed(food: Food, amountOfFood: number): void {
        console.log(
            `Feeding a chicken with ---> ${amountOfFood} of ${food}`
        );
    }

    layAnEgg(): void {
        console.log("Chicken is laying an egg ()");
    }

    toString(): string {
        return `Chicken{isMolting=${this.isMolting}, numberOfLaidEggsInAMonth=${this.numberOfLaidEggsInAMonth}, isMeat=${this.isMeat}} ${super.toString()}`;
    }
}