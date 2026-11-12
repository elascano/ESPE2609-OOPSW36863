import { FarmAnimal } from "./FarmAnimal";

export class Sheep extends FarmAnimal {
    private lastShearing: Date;
    private woolWeightInKg: number;
    private woolColor: string;

    constructor(
        lastShearing: Date, woolWeightInKg: number, woolColor: string,
        id: number, breed: string, bornOnDate: Date
    ) {
        super(id, breed, bornOnDate);
        this.lastShearing = lastShearing;
        this.woolWeightInKg = woolWeightInKg;
        this.woolColor = woolColor;
    }

    public override toString(): string {
        return `Sheep{${super.toString()}lastShearing=${this.lastShearing.getDate()}/`
            + `${this.lastShearing.getMonth() + 1}/${this.lastShearing.getFullYear()}, `
            + `woolWeightInKg=${this.woolWeightInKg}, woolColor=${this.woolColor}}`;
    }

    public getLastShearing(): Date {
        return this.lastShearing;
    }

    public setLastShearing(lastShearing: Date): void {
        this.lastShearing = lastShearing;
    }

    public getWoolWeightInKg(): number {
        return this.woolWeightInKg;
    }

    public setWoolWeightInKg(woolWeightInKg: number): void {
        this.woolWeightInKg = woolWeightInKg;
    }

    public getWoolColor(): string {
        return this.woolColor;
    }

    public setWoolColor(woolColor: string): void {
        this.woolColor = woolColor;
    }
}
