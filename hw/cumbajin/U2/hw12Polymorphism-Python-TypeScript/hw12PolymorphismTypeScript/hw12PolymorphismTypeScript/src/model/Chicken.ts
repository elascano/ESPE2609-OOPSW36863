import { FarmAnimal } from "./FarmAnimal";

export class Chicken extends FarmAnimal {
    private isMolting: boolean;
    private numberOfLaidEggsLastMonth: number;
    private isMeat: boolean;

    public constructor(
        id: number,
        breed: string,
        bornOnDate: Date,
        isMolting: boolean,
        numberOfLaidEggsLastMonth: number,
        isMeat: boolean
    ) {
        super(id, breed, bornOnDate);
        this.isMolting = isMolting;
        this.numberOfLaidEggsLastMonth = numberOfLaidEggsLastMonth;
        this.isMeat = isMeat;
    }

    public getIsMolting(): boolean {
        return this.isMolting;
    }

    public setIsMolting(isMolting: boolean): void {
        this.isMolting = isMolting;
    }

    public getNumberOfLaidEggsLastMonth(): number {
        return this.numberOfLaidEggsLastMonth;
    }

    public setNumberOfLaidEggsLastMonth(quantity: number): void {
        this.numberOfLaidEggsLastMonth = quantity;
    }

    public getIsMeat(): boolean {
        return this.isMeat;
    }

    public setIsMeat(isMeat: boolean): void {
        this.isMeat = isMeat;
    }

    public override toString(): string {
        return `Chicken{${this.farmAnimalData()}, isMolting=${this.isMolting}, numberOfLaidEggsLastMonth=${this.numberOfLaidEggsLastMonth}, isMeat=${this.isMeat}}`;
    }
}
