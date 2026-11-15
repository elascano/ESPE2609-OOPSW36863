
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

    layEgg(): void {
        console.log("The chicken laid an egg");
    }

    override toString(): string {
        return `Chicken{${super.toString()}, 
        isMolting=${this.isMolting}, 
        numberOfLaidEggsInAMonth=${this.numberOfLaidEggsInAMonth}, 
        isMeat=${this.isMeat}}`;
    }

    getIsMolting(): boolean {
        return this.isMolting;
    }

    setIsMolting(isMolting: boolean): void {
        this.isMolting = isMolting;
    }

    getNumberOfLaidEggsInAMonth(): number {
        return this.numberOfLaidEggsInAMonth;
    }

    setNumberOfLaidEggsInAMonth(value: number): void {
        this.numberOfLaidEggsInAMonth = value;
    }

    getIsMeat(): boolean {
        return this.isMeat;
    }

    setIsMeat(isMeat: boolean): void {
        this.isMeat = isMeat;
    }
}
