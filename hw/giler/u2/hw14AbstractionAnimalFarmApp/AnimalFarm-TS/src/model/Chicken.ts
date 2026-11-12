import { FarmAnimal } from './FarmAnimal';

export class Chicken extends FarmAnimal {
    constructor(
        id: number, 
        breed: string, 
        bornOnDate: string, 
        public isMolting: boolean,
        public numberOfLaidEggInMonth: number,
        public isMeat: boolean
    ) {
        super(id, breed, bornOnDate);
    }
    
    feed(): void {}
    
    layAnEgg(): void {
        console.log("chicken is laying an egg...");
    }

    toString(): string {
        return `Chicken{id=${this.id}, breed=${this.breed}, bornOnDate=${this.bornOnDate},isMolting=${this.isMolting}, numberOfLaidEggInMonth=${this.numberOfLaidEggInMonth}, isMeat=${this.isMeat}}`;
    }
}