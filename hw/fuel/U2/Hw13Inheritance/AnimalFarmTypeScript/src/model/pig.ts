
import { FarmAnimal } from "./farm_animal";

export class Pig extends FarmAnimal {

    private weight: number;
    private isBreeding: boolean;

    constructor(
        weight: number,
        isBreeding: boolean,
        id: number,
        breed: string,
        bornOnDate: Date
    ) {
        super(id, breed, bornOnDate);

        this.weight = weight;
        this.isBreeding = isBreeding;
    }

    feed(): void {
        console.log("Feeding the pig");
    }

    override toString(): string {
        return `Pig{${super.toString()}, 
        weight=${this.weight}, 
        isBreeding=${this.isBreeding}}`;
    }

    getWeight(): number {
        return this.weight;
    }

    setWeight(value: number): void {
        this.weight = value;
    }

    getIsBreeding(): boolean {
        return this.isBreeding;
    }

    setIsBreeding(value: boolean): void {
        this.isBreeding = value;
    }
}
