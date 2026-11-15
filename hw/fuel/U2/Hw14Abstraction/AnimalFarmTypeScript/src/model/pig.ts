
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

    feed(): void {
        console.log("The pig is eating");
    }

    override toString(): string {
        return `Pig{${super.toString()}, weight = ${this.weight}, isBreeding = ${this.isBreeding}}`;
    }
}
