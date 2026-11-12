import { FarmAnimal } from "./FarmAnimal";

export class Pig extends FarmAnimal {
    constructor(id: number, bread: string, bornOnDate: Date) {
        super(id, bread, bornOnDate);
    }

    toString(): string {
        return `Pig{${super.toString()}}`;
    }
}
