import { FarmAnimal } from "./FarmAnimal";
import { Food } from "./Food";
import { grazeAnimal } from "./grazeAnimal";
import { Location } from "./Location";

export class Sheep extends FarmAnimal implements grazeAnimal {
    private lastShearing: Date;
    private isProducingWool: boolean;

    constructor(
        lastShearing: Date,
        isProducingWool: boolean,
        id: number,
        breed: string,
        bornOnDate: Date
    ) {
        super(id, breed, bornOnDate);
        this.lastShearing = lastShearing;
        this.isProducingWool = isProducingWool;
    }

    public graze(location: Location): void {
        console.log(`sending the sheep to eat grass at -->${location}`);
    }

    public feed(food: Food, amountOfFood: number): void {
        console.log(`feeding a sheep with -->${amountOfFood} of ${food}`);
    }

    public shear(): void {
        console.log("shearing the sheep for wool");
    }

    public toString(): string {
        return `Sheep{${super.toString()}lastShearing=${this.lastShearing.getDate()}/${this.lastShearing.getMonth() + 1}/${this.lastShearing.getFullYear() + 1900}, isProducingWool=${this.isProducingWool}}`;
    }

    public getLastShearing(): Date {
        return this.lastShearing;
    }

    public setLastShearing(lastShearing: Date): void {
        this.lastShearing = lastShearing;
    }

    public isIsProducingWool(): boolean {
        return this.isProducingWool;
    }

    public setIsProducingWool(isProducingWool: boolean): void {
        this.isProducingWool = isProducingWool;
    }
}