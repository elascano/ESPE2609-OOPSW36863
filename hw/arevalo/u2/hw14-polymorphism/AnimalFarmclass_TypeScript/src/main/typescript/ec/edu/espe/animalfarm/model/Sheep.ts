import { FarmAnimal } from "./FarmAnimal";

// @author Anthony Arevalo, MosQ, ESPE
export class Sheep extends FarmAnimal {
    #lastShearing: Date;
    #woolWeightInKg: number;
    #woolColor: string;

    public constructor(lastShearing: Date, woolWeightInKg: number, woolColor: string, id: number, breed: string, bornOnDate: Date) {
        super(id, breed, bornOnDate);
        this.#lastShearing = lastShearing;
        this.#woolWeightInKg = woolWeightInKg;
        this.#woolColor = woolColor;
    }

    public override toString(): string {
        return "Sheep{" + super.toString()
            + "lastShearing=" + this.#lastShearing
            + ", woolWeightInKg=" + this.#woolWeightInKg
            + ", woolColor=" + this.#woolColor + "}";
    }

    public getLastShearing(): Date {
        return this.#lastShearing;
    }

    public setLastShearing(lastShearing: Date): void {
        this.#lastShearing = lastShearing;
    }

    public getWoolWeightInKg(): number {
        return this.#woolWeightInKg;
    }

    public setWoolWeightInKg(woolWeightInKg: number): void {
        this.#woolWeightInKg = woolWeightInKg;
    }

    public getWoolColor(): string {
        return this.#woolColor;
    }

    public setWoolColor(woolColor: string): void {
        this.#woolColor = woolColor;
    }
}
