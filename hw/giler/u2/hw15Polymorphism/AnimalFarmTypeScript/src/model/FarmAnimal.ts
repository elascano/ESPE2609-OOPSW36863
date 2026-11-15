import { Food } from './Food';
export abstract class FarmAnimal {
    constructor(public id: number, public breed: string, public bornOnDate: Date) {}
    abstract feed(food: Food, amountOfFood: number): void;
    getAgeInMonths(): number { return 0; }
    toString(): string {
        return `id=${this.id}, breed=${this.breed}, bornOnDate=${this.bornOnDate.getDate()}/${this.bornOnDate.getMonth()+1}/${this.bornOnDate.getFullYear()},`;
    }
}
