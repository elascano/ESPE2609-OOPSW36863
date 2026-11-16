import { FarmAnimal } from "./FarmAnimal";

export class Cow extends FarmAnimal {
    private IsProducingMilk: boolean;
    private litersOfMilkPerWeek: number;

    constructor(IsProducingMilk: boolean, litersOfMilkPerWeek: number, id: number, breed: string, bornOnDate: Date) {
        super(id, breed, bornOnDate);
        this.IsProducingMilk = IsProducingMilk;
        this.litersOfMilkPerWeek = litersOfMilkPerWeek;
    }

    toString(): string {
        return `Cow{${super.toString()}IsProducingMilk=${this.IsProducingMilk}, litersOfMilkPerWeek=${this.litersOfMilkPerWeek}}`;
    }

    milk(): void {
        console.log("Milking the cow ");
    }

    isIsProducingMilk(): boolean {
        return this.IsProducingMilk;
    }

    setIsProducingMilk(IsProducingMilk: boolean): void {
        this.IsProducingMilk = IsProducingMilk;
    }

    getLitersOfMilkPerWeek(): number {
        return this.litersOfMilkPerWeek;
    }

    setLitersOfMilkPerWeek(litersOfMilkPerWeek: number): void {
        this.litersOfMilkPerWeek = litersOfMilkPerWeek;
    }
}
