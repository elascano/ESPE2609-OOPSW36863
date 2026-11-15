
import { FarmAnimal } from "./farm_animal";

export class Sheep extends FarmAnimal {

    private woolLength: number;
    private isProducingWool: boolean;

    constructor(
        woolLength: number,
        isProducingWool: boolean,
        id: number,
        breed: string,
        bornOnDate: Date
    ) {
        super(id, breed, bornOnDate);

        this.woolLength = woolLength;
        this.isProducingWool = isProducingWool;
    }

    shear(): void {
        console.log("Shearing the sheep");
    }

    override toString(): string {
        return `Sheep{${super.toString()}, 
        woolLength=${this.woolLength}, 
        isProducingWool=${this.isProducingWool}}`;
    }

    getWoolLength(): number {
        return this.woolLength;
    }

    setWoolLength(value: number): void {
        this.woolLength = value;
    }

    getIsProducingWool(): boolean {
        return this.isProducingWool;
    }

    setIsProducingWool(value: boolean): void {
        this.isProducingWool = value;
    }
}
