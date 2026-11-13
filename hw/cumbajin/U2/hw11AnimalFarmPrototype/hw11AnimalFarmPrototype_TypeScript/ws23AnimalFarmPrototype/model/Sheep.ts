import { FarmAnimal } from "./FarmAnimal";

export class Sheep extends FarmAnimal {
    constructor(
        private lastSheering: Date,
        id: number,
        bread: string,
        bornOnDate: Date,
    ) {
        super(id, bread, bornOnDate);
    }

    toString(): string {
        return `Sheep{${super.toString()}, lastSheering=${this.lastSheering.getUTCFullYear()}}`;
    }

    getLastSheering(): Date { return this.lastSheering; }
    setLastSheering(value: Date): void { this.lastSheering = value; }
}
