import { FarmAnimal } from "./FarmAnimal";

export class Cow extends FarmAnimal {
    constructor(
        private isProducingMilk: boolean,
        private litersOfMilkPerWeek: number,
        id: number,
        bread: string,
        bornOnDate: Date,
    ) {
        super(id, bread, bornOnDate);
    }

    milk(): void {
        console.log("Milking the cow");
    }

    toString(): string {
        return `Cow{${super.toString()}, isProducingMilk=${this.isProducingMilk}, litersOfMilkPerWeek=${this.litersOfMilkPerWeek}}`;
    }

    isIsProducingMilk(): boolean { return this.isProducingMilk; }
    setIsProducingMilk(value: boolean): void { this.isProducingMilk = value; }

    getLitersOfMilkPerWeek(): number { return this.litersOfMilkPerWeek; }
    setLitersOfMilkPerWeek(value: number): void { this.litersOfMilkPerWeek = value; }
}
