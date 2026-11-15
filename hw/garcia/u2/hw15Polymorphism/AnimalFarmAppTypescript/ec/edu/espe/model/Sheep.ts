import { FarmAnimal } from "./FarmAnimal";
import { Food } from "./Food";
import { Location } from "./Location";
import { grazeAnimal } from "./grazeAnimal";

export class Sheep extends FarmAnimal implements grazeAnimal {
    private woolLength: number;
    private isSheared: boolean;

    constructor(woolLength: number, isSheared: boolean, id: number, breed: string, bornOnDate: Date) {
        super(id, breed, bornOnDate);
        this.woolLength = woolLength;
        this.isSheared = isSheared;
    }

    graze(location: Location): void { console.log(`Sending the sheep to eat grass at --> ${location.toString()}`); }
    toString(): string { return `Sheep{${super.toString()}woolLength = ${this.woolLength}, isSheared = ${this.isSheared}}`; }
    feed(food: Food, amountOfFood: number): void { console.log(`Feeding sheep with --> ${food.toString()} amount of food --> ${amountOfFood}`); }

    shearWool(): void {
        if (!this.isSheared) {
            this.isSheared = true;
            this.woolLength = 0;
            console.log("Sheep has been sheared successfully");
        } else console.log("Shee has already been sheared");
    }

    getWoolLength(): number { return this.woolLength; }
    setWoolLength(woolLength: number): void { this.woolLength = woolLength; }
    isIsSheared(): boolean { return this.isSheared; }
    setIsSheared(isSheared: boolean): void { this.isSheared = isSheared; }
}
