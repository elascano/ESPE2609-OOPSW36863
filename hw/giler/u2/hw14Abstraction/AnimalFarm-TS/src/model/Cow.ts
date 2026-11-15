import { FarmAnimal } from './FarmAnimal';

export class Cow extends FarmAnimal {
    constructor(
        id: number, 
        breed: string, 
        bornOnDate: string, 
        public isProducingMilk: boolean,
        public litersOfMilkForWeek: number
    ) {
        super(id, breed, bornOnDate);
    }
    
    feed(): void {}
    
    milking(): void {
        console.log("milking the cow");
    }

    toString(): string {
        return `Cow{id=${this.id}, breed=${this.breed}, bornOnDate=${this.bornOnDate},isProducingMilk=${this.isProducingMilk},  litersOfMilkForWeek=${this.litersOfMilkForWeek}}`;
    }
}