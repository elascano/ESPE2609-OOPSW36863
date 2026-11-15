import { FarmAnimal } from "./farm_animal";
import { Food } from "./Food";
import { GrazeAnimal } from "./grazeAnimal";
import { Location } from "./location";

export class Cow extends FarmAnimal implements GrazeAnimal {

    public food: string | null = null;

    constructor(
        public isProducingMilk: boolean,
        public litersOfMilkPerWeek: number,
        id: number,
        breed: string,
        bornOnDate: Date
    ) {
        super(id, breed, bornOnDate);
    }

    graze(location: Location): void {
        console.log(`Feeding a cow in the stable with ---> ${this.food}`);
    }

    feed(food: Food, amountOfFood: number): void {
        console.log(`Feeding a cow with ---> ${food}`);
    }

    milk(amountOfLiters?: number, hour?: Date): void {

        if (amountOfLiters === undefined) {
            console.log("Milking the cow as I need");
            return;
        }

        this.litersOfMilkPerWeek += amountOfLiters;

        if (hour !== undefined) {
            const formattedHour = hour.toTimeString().substring(0, 5);

            console.log(
                `The cow produced ${this.litersOfMilkPerWeek} liters of milk per week at ${formattedHour}`
            );
        } else {
            console.log(
                `The cow produced ${this.litersOfMilkPerWeek} liters of milk per week`
            );
        }
    }

    toString(): string {
        return `Cow{isProducingMilk=${this.isProducingMilk}, litersOfMilkPerWeek=${this.litersOfMilkPerWeek}, food=${this.food}} ${super.toString()}`;
    }
}