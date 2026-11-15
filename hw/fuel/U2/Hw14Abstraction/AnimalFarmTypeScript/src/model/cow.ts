
import { FarmAnimal } from "./farm_animal";

export class Cow extends FarmAnimal {

    private isProducingMilk: boolean;
    private litersOfMilkPerWeek: number;

    constructor(
        isProducingMilk: boolean,
        litersOfMilkPerWeek: number,
        id: number,
        breed: string,
        bornOnDate: Date
    ) {
        super(id, breed, bornOnDate);

        this.isProducingMilk = isProducingMilk;
        this.litersOfMilkPerWeek = litersOfMilkPerWeek;
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

    milk(): void {
        console.log("The cow is producing milk");
    }

    override toString(): string {
        return `Cow{${super.toString()}, isProducingMilk = ${this.isProducingMilk}, litersOfMilkPerWeek = ${this.litersOfMilkPerWeek}}`;
    }
}
