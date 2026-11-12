import { FarmAnimal } from './FarmAnimal';

export class Cow extends FarmAnimal {
    constructor(id: number, breed: string, bornOn: Date, public isProducingMilk: boolean) {
        super(id, breed, bornOn);
    }

    feed(): void {
        console.log(`Alimentando vaca (ID: ${this.id}) con pasto.`);
    }

    produce(): string {
        return "Leche";
    }
}
