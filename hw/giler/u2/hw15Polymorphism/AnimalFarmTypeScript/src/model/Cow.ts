import { FarmAnimal } from './FarmAnimal';
import { GrazeAnimal } from './GrazeAnimal';
import { Location } from './Location';
import { Food } from './Food';
export class Cow extends FarmAnimal implements GrazeAnimal {
    constructor(public isProducingMilk: boolean, public litersOfMilkPerWeek: number, id: number, breed: string, bornOnDate: Date) {
        super(id, breed, bornOnDate);
    }
    milk(amount?: number, time?: Date): void {
        if (amount !== undefined && time !== undefined) {
            console.log(`milking the cow for ${amount} liters, at ${time.getHours()}:${time.getMinutes()}`);
            this.litersOfMilkPerWeek += amount;
        } else if (amount !== undefined) {
            console.log(`milking the cow for ${amount} liters`);
            this.litersOfMilkPerWeek += amount;
        } else {
            console.log("milking the cow as I need");
        }
    }
    graze(location: Location): void { console.log(`Cow is grazing at --> ${location.description}`); }
    feed(food: Food, amountOfFood: number): void { console.log(`feeding a cow in the stable with --> ${food}`); }
    toString(): string {
        return `Cow{${super.toString()}isProductingMilk=${this.isProducingMilk}, litersOfMilkPerWeek=${this.litersOfMilkPerWeek}}`;
    }
}
