import { FarmAnimal } from "./FarmAnimal";

export class Chicken extends FarmAnimal {
    constructor(
        id: number,
        bread: string,
        bornOnDate: Date,
        private isMolting: boolean,
        private numberOffLatIsMonth: number,
        private isMeat: boolean,
    ) {
        super(id, bread, bornOnDate);
    }

    toString(): string {
        return `Chicken{${super.toString()}, isMolting=${this.isMolting}, numberOffLatIsMonth=${this.numberOffLatIsMonth}, isMeat=${this.isMeat}}`;
    }

    isIsMolting(): boolean { return this.isMolting; }
    setIsMolting(value: boolean): void { this.isMolting = value; }

    getNumberOffLatIsMonth(): number { return this.numberOffLatIsMonth; }
    setNumberOffLatIsMonth(value: number): void { this.numberOffLatIsMonth = value; }

    isIsMeat(): boolean { return this.isMeat; }
    setIsMeat(value: boolean): void { this.isMeat = value; }
}
