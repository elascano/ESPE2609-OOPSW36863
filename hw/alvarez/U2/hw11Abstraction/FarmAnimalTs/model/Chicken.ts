import { FarmAnimal } from "./FarmAnimal";
import { Food } from "./Food";

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

    public feed(food: Food, amountOfFood: number): void {
        console.log(`feeding a chicken with -->${amountOfFood} of ${food}`);
    }

    public layAnEgg(): void {
        this.numberOfLaidEggsInAMonth++;
        console.log("chicken is laying an egg() ");
    }

    public toString(): string {
        return `Chicken{${super.toString()}isMolting=${this.isMolting}, numberOfLaidEggsInAMonth=${this.numberOfLaidEggsInAMonth}, isMeat=${this.isMeat}}`;
    }

    public isIsMolting(): boolean {
        return this.isMolting;
    }

    public setIsMolting(isMolting: boolean): void {
        this.isMolting = isMolting;
    }

    public getNumberOfLaidEggInMonth(): number {
        return this.numberOfLaidEggsInAMonth;
    }

    public setNumberOfLaidEggInMonth(numberOfLaidEggInMonth: number): void {
        this.numberOfLaidEggsInAMonth = numberOfLaidEggInMonth;
    }

    public isIsMeat(): boolean {
        return this.isMeat;
    }

    public setIsMeat(isMeat: boolean): void {
        this.isMeat = isMeat;
    }
}