
import { FarmAnimal } from "./farm_animal";

export class Chicken extends FarmAnimal {

    private isMolting: boolean;
    private numberOfLaidEggsInAMonth: number;
    private isMeat: boolean;

    constructor(
        isMolting: boolean,
        numberOfLaidEggsInAMonth: number,
        isMeat: boolean,
        id: number,
        breed: string,
        bornOnDate: Date
    ) {
        super(id, breed, bornOnDate);

        this.isMolting = isMolting;
        this.numberOfLaidEggsInAMonth = numberOfLaidEggsInAMonth;
        this.isMeat = isMeat;
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

    layAnEgg(): void {
        console.log("The chicken is laying an egg");
    }

    override toString(): string {
        return `Chicken{${super.toString()}, isMolting = ${this.isMolting}, numberOfLaidEggsInAMonth = ${this.numberOfLaidEggsInAMonth}, isMeat = ${this.isMeat}}`;
    }
}
