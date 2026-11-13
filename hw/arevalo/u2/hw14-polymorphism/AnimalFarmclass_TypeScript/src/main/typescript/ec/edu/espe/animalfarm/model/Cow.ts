import { FarmAnimal } from "./FarmAnimal";

// @author Alvarez Juan Jose, MosQ, ESPE
export class Cow extends FarmAnimal {
    #isProducingMilk: boolean;
    #litersOfMilkForWeek: number;

    public constructor(isProducingMilk: boolean, litersOfMilkForWeek: number, id: number, breed: string, bornOnDate: Date) {
        super(id, breed, bornOnDate);
        this.#isProducingMilk = isProducingMilk;
        this.#litersOfMilkForWeek = litersOfMilkForWeek;
    }

    public milk(): void {
        console.log("milking the cow");
    }

    public override toString(): string {
        return "Cow{" + super.toString()
            + "isProducingMilk=" + this.#isProducingMilk
            + ", litersOfMilkForWeek=" + this.#litersOfMilkForWeek + "}";
    }

    public isIsProducingMilk(): boolean {
        return this.#isProducingMilk;
    }

    public setIsProducingMilk(isProducingMilk: boolean): void {
        this.#isProducingMilk = isProducingMilk;
    }

    public getLitersOfMilkForWeek(): number {
        return this.#litersOfMilkForWeek;
    }

    public setLitersOfMilkForWeek(litersOfMilkForWeek: number): void {
        this.#litersOfMilkForWeek = litersOfMilkForWeek;
    }
}
