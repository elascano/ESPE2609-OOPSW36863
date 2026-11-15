import { FarmAnimal } from './FarmAnimal';

export class Chicken extends FarmAnimal {
    constructor(id: number, breed: string, bornOn: Date, public isMolting: boolean) {
        super(id, breed, bornOn);
    }

    feed(): void {
        console.log(`Alimentando gallina (ID: ${this.id}) con semillas.`);
    }

    produce(): string {
        return "Huevo";
    }
}
