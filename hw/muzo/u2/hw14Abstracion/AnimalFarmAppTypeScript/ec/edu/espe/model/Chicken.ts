import { FarmAnimal } from "./FarmAnimal";

export class Chicken extends FarmAnimal {
    private isMolting: boolean;
    private numberOfLaidEggsInAMonth: number;
    private isMeat: boolean;

    constructor(isMolting: boolean, numberOfLaidEggsInAMonth: number, isMeat: boolean, id: number, breed: string, bornOnDate: Date) {
        super(id, breed, bornOnDate);
        this.isMolting = isMolting;
        this.numberOfLaidEggsInAMonth = numberOfLaidEggsInAMonth;
        this.isMeat = isMeat;
    }

    layAnEgg(): void {
        console.log("Chicken is laying an egg () ");
    }

    toString(): string {
        return `Chicken{${super.toString()}isMolting=${this.isMolting}, numberOfLaidEggsInAMonth=${this.numberOfLaidEggsInAMonth}, isMeat=${this.isMeat}}`;
    }

    isIsMolting(): boolean {
        return this.isMolting;
    }

    setIsMolting(isMolting: boolean): void {
        this.isMolting = isMolting;
    }

    getNumberOfLaidEggsInAMonth(): number {
        return this.numberOfLaidEggsInAMonth;
    }

    setNumberOfLaidEggsInAMonth(numberOfLaidEggsInAMonth: number): void {
        this.numberOfLaidEggsInAMonth = numberOfLaidEggsInAMonth;
    }

    isIsMeat(): boolean {
        return this.isMeat;
    }

    setIsMeat(isMeat: boolean): void {
        this.isMeat = isMeat;
    }
}
