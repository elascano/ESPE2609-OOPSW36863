import { FarmAnimal } from "./FarmAnimal";
import { Food } from "./Food";
import { grazeAnimal } from "./grazeAnimal";
import { Location } from "./Location";

export class Cow extends FarmAnimal implements grazeAnimal {
    private isProducingMilk: boolean;
    private litersOfMilkPerWeek: number;

    constructor(
        isProducingMilk: boolean,
        litersOfMilkForWeek: number,
        id: number,
        breed: string,
        bornOnDate: Date
    ) {
        super(id, breed, bornOnDate);
        this.isProducingMilk = isProducingMilk;
        this.litersOfMilkPerWeek = litersOfMilkForWeek;
    }

    public graze(location: Location): void {
        console.log(`sending the cow to eat grass at -->${location}`);
    }

    public feed(food: Food, amountOfFood: number): void {
        console.log(`feeding a cow with -->${food}`);
    }

    // Sobrecarga de métodos milk() tal cual en Java
    public milk(): void;
    public milk(amountOfLiters: number): void;
    public milk(amountOfLiters: number, hour: Date): void;
    public milk(amountOfLiters?: number, hour?: Date): void {
        if (amountOfLiters === undefined) {
            console.log("milking the cow as I need");
        } else if (hour === undefined) {
            this.litersOfMilkPerWeek += amountOfLiters;
            console.log(`milking the cow for ${amountOfLiters} liters.`);
        } else {
            console.log(`milking the cow for${amountOfLiters} liters, at ${hour.getHours()}:${hour.getMinutes()}`);
        }
    }

    public toString(): string {
        return `Cow{${super.toString()}isProducingMilk=${this.isProducingMilk}, litersOfMilkForWeek=${this.litersOfMilkPerWeek}}`;
    }

    public isIsProducingMilk(): boolean {
        return this.isProducingMilk;
    }

    public setIsProducingMilk(isProducingMilk: boolean): void {
        this.isProducingMilk = isProducingMilk;
    }

    public getLitersOfMilkPerWeek(): number {
        return this.litersOfMilkPerWeek;
    }

    public setLitersOfMilkPerWeek(litersOfMilkPerWeek: number): void {
        this.litersOfMilkPerWeek = litersOfMilkPerWeek;
    }
}