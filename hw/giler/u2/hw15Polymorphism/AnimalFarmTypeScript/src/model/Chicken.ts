import { FarmAnimal } from './FarmAnimal';
import { Food } from './Food';
export class Chicken extends FarmAnimal {
    constructor(public isMolting: boolean, public numberOfLaidEggsInMonths: number, public isMeat: boolean, id: number, breed: string, bornOnDate: Date) {
        super(id, breed, bornOnDate);
    }
    feed(food: Food, amountOfFood: number): void {
        console.log(`feeding a chicken with -->${amountOfFood} of ${food}`);
    }
    layAnEgg(): void { console.log("Chicken is laying an egg"); }
    toString(): string {
        return `Chicken{${super.toString()}isMolting=${this.isMolting}, numberOfLaidEggsInMonths=${this.numberOfLaidEggsInMonths}, isMeat=${this.isMeat}}`;
    }
}
