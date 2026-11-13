import { FarmAnimal } from "./FarmAnimal";

export class Pig extends FarmAnimal {
    public constructor(id: number, breed: string, bornOnDate: Date) {
        super(id, breed, bornOnDate);
    }

    public override toString(): string {
        return `Pig{${this.farmAnimalData()}}`;
    }
}
