import { FarmAnimal } from "./FarmAnimal";
import { Food } from "./Food";
import { Location } from "./Location";
import { grazeAnimal } from "./grazeAnimal";

export class Cow extends FarmAnimal implements grazeAnimal {
    private IsProducingMilk: boolean;
    private litersOfMilkPerWeek: number;

    constructor(IsProducingMilk: boolean, litersOfMilkPerWeek: number, id: number, breed: string, bornOnDate: Date) {
        super(id, breed, bornOnDate);
        this.IsProducingMilk = IsProducingMilk;
        this.litersOfMilkPerWeek = litersOfMilkPerWeek;
    }

    graze(location: Location): void { console.log(`Sending the cow to eat grass at --> ${location.toString()}`); }
    feed(food: Food, amountOfFood: number): void { console.log(`Feeding a cow in the stabel with --> ${food.toString()}`); }

    toString(): string {
        return `Cow{${super.toString()}IsProducingMilk = ${this.IsProducingMilk}, litersOfMilkPerWeek = ${this.litersOfMilkPerWeek}}`;
    }

    milk(amountOfLiters?: number, hour?: Date): void {
        if (amountOfLiters === undefined) console.log("Milking the cow ");
        else if (hour !== undefined) console.log(`Milking the cow for ${amountOfLiters} liters, at ${hour.getHours()}:${hour.getMinutes()}`);
        else {
            this.litersOfMilkPerWeek += amountOfLiters;
            console.log(`Milking the cow -->${amountOfLiters}`);
        }
    }

    isIsProducingMilk(): boolean { return this.IsProducingMilk; }
    setIsProducingMilk(IsProducingMilk: boolean): void { this.IsProducingMilk = IsProducingMilk; }
    getLitersOfMilkPerWeek(): number { return this.litersOfMilkPerWeek; }
    setLitersOfMilkPerWeek(litersOfMilkPerWeek: number): void { this.litersOfMilkPerWeek = litersOfMilkPerWeek; }
}
