
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

    milk(): void {
        console.log("Milking the cow");
    }

    override toString(): string {
        return `Cow{${super.toString()}, 
        isProducingMilk=${this.isProducingMilk}, 
        litersOfMilkPerWeek=${this.litersOfMilkPerWeek}}`;
    }

    getIsProducingMilk(): boolean {
        return this.isProducingMilk;
    }

    setIsProducingMilk(value: boolean): void {
        this.isProducingMilk = value;
    }

    getLitersOfMilkPerWeek(): number {
        return this.litersOfMilkPerWeek;
    }

    setLitersOfMilkPerWeek(value: number): void {
        this.litersOfMilkPerWeek = value;
    }
}
