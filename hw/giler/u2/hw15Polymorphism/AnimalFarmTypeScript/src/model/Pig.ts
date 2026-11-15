import { FarmAnimal } from './FarmAnimal';
import { Food } from './Food';
export class Pig extends FarmAnimal {
    constructor(public currentWeight: number, public targetMarketWeight: number, public isBreeder: boolean, id: number, breed: string, bornOnDate: Date) {
        super(id, breed, bornOnDate);
    }
    calculateMeatYield(): number {
        let meatYield = this.currentWeight * 0.70;
        console.log(`This pig can yield ${meatYield} kg of saleable meat.`);
        return meatYield;
    }
    collectManure(): number {
        let manureKg = this.currentWeight * 0.05;
        console.log(`Collected ${manureKg} kg of manure for crop fertilizer.`);
        return manureKg;
    }
    producePiglets(): number {
        if (this.isBreeder) {
            let piglets = 8;
            console.log(`The sow gave birth to ${piglets} new piglets!`);
            return piglets;
        } else {
            console.log("This pig is for meat, not a breeder.");
            return 0;
        }
    }
    feed(food: Food, amountOfFood: number): void {
        let gainedWeight = amountOfFood * 0.8;
        this.currentWeight += gainedWeight;
        console.log(`Feeding the pig with --> ${amountOfFood} of ${food}. It gained ${gainedWeight} kg. Current weight: ${this.currentWeight}`);
    }
    toString(): string {
        return `Pig{${super.toString()}currentWeight=${this.currentWeight}kg, targetMarketWeight=${this.targetMarketWeight}kg, isBreeder=${this.isBreeder}}`;
    }
}
