import { FarmAnimal } from "./FarmAnimal";
import { Food } from "./Food";

export class Pig extends FarmAnimal {
    private weight: number;
    private isReadyForSlaughter: boolean;

    constructor(
        weight: number,
        isReadyForSlaughter: boolean,
        id: number,
        breed: string,
        bornOnDate: Date
    ) {
        super(id, breed, bornOnDate);
        this.weight = weight;
        this.isReadyForSlaughter = isReadyForSlaughter;
    }

    public feed(food: Food, amountOfFood: number): void {
        this.weight += amountOfFood * 0.5;
        console.log(`feeding a pig with -->${amountOfFood} of ${food}`);
    }

    public toString(): string {
        return `Pig{${super.toString()}weight=${this.weight}, isReadyForSlaughter=${this.isReadyForSlaughter}}`;
    }

    public getWeight(): number {
        return this.weight;
    }

    public setWeight(weight: number): void {
        this.weight = weight;
    }

    public isIsReadyForSlaughter(): boolean {
        return this.isReadyForSlaughter;
    }

    public setIsReadyForSlaughter(isReadyForSlaughter: boolean): void {
        this.isReadyForSlaughter = isReadyForSlaughter;
    }
}