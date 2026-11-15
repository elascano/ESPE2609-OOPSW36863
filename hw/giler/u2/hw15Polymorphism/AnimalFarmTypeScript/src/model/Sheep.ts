import { FarmAnimal } from './FarmAnimal';
import { GrazeAnimal } from './GrazeAnimal';
import { Location } from './Location';
import { Food } from './Food';
export class Sheep extends FarmAnimal implements GrazeAnimal {
    constructor(public woolWeight: number, public woolQuality: string, public lastShearingDate: Date, id: number, breed: string, bornOnDate: Date) {
        super(id, breed, bornOnDate);
    }
    shearForMarket(): number {
        if (this.woolWeight > 0) {
            let harvestedWool = this.woolWeight;
            console.log(`Shearing the sheep. Harvested ${harvestedWool} kg of ${this.woolQuality} wool.`);
            this.woolWeight = 0;
            this.lastShearingDate = new Date();
            return harvestedWool;
        } else {
            console.log("No wool ready to shear on this sheep.");
            return 0;
        }
    }
    graze(location: Location): void {
        console.log(`Sheep is grazing at --> ${location.description}. Wool is growing!`);
        this.woolWeight += 0.5;
    }
    feed(food: Food, amountOfFood: number): void {
        console.log(`Feeding a sheep with --> ${amountOfFood} units of ${food}`);
    }
    toString(): string {
        return `Sheep{${super.toString()}woolWeight=${this.woolWeight}, woolQuality=${this.woolQuality}, lastShearingDate=${this.lastShearingDate}}`;
    }
}
