import { FarmAnimal } from "./FarmAnimal";

export class Sheep extends FarmAnimal {
    private lastShearing: Date;

    public constructor(
        lastShearing: Date,
        id: number,
        breed: string,
        bornOnDate: Date
    ) {
        super(id, breed, bornOnDate);
        this.lastShearing = lastShearing;
    }

    public getLastShearing(): Date {
        return this.lastShearing;
    }

    public setLastShearing(lastShearing: Date): void {
        this.lastShearing = lastShearing;
    }

    public override toString(): string {
        return `Sheep{${this.farmAnimalData()}, lastShearing=${this.lastShearing.getFullYear()}}`;
    }
}
