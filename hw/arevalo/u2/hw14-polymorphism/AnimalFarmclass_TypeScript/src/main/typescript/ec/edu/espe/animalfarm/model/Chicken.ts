import { FarmAnimal } from "./FarmAnimal";

// @author Alvarez Juan Jose, MosQ, ESPE
export class Chicken extends FarmAnimal {
    #isMolting: boolean;
    #numberOfLaidEggInMonth: number;
    #isMeat: boolean;

    public constructor(isMolting: boolean, numberOfLaidEggInMonth: number, isMeat: boolean, id: number, breed: string, bornOnDate: Date) {
        super(id, breed, bornOnDate);
        this.#isMolting = isMolting;
        this.#numberOfLaidEggInMonth = numberOfLaidEggInMonth;
        this.#isMeat = isMeat;
    }

    public layAnEgg(): void {
        console.log("chicken is laying an egg()");
    }

    public override toString(): string {
        return "Chicken{" + super.toString()
            + "isMolting=" + this.#isMolting
            + ", numberOfLaidEggInMonth=" + this.#numberOfLaidEggInMonth
            + ", isMeat=" + this.#isMeat + "}";
    }

    public isIsMolting(): boolean {
        return this.#isMolting;
    }

    public setIsMolting(isMolting: boolean): void {
        this.#isMolting = isMolting;
    }

    public getNumberOfLaidEggInMonth(): number {
        return this.#numberOfLaidEggInMonth;
    }

    public setNumberOfLaidEggInMonth(numberOfLaidEggInMonth: number): void {
        this.#numberOfLaidEggInMonth = numberOfLaidEggInMonth;
    }

    public isIsMeat(): boolean {
        return this.#isMeat;
    }

    public setIsMeat(isMeat: boolean): void {
        this.#isMeat = isMeat;
    }
}
