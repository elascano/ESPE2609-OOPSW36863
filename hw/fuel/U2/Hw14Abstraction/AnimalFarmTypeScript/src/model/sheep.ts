
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

    getAgeInMonths(): number {
        const today = new Date();

        let months =
            (today.getFullYear() - this.bornOnDate.getFullYear()) * 12;

        months += today.getMonth() - this.bornOnDate.getMonth();

        if (today.getDate() < this.bornOnDate.getDate()) {
            months--;
        }

        return months;
    }

    shear(): void {
        console.log("Shearing the sheep");
    }

    override toString(): string {
        return `Sheep{${super.toString()}, woolLength = ${this.woolLength}, isProducingWool = ${this.isProducingWool}}`;
    }
}
