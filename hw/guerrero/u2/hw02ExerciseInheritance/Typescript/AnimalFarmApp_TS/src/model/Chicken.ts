import { FarmAnimal } from './FarmAnimal';

export class Chicken extends FarmAnimal {
    constructor(name: string, age: number, public eggsPerWeek: number) {
        super(name, age);
    }

    public makeSound(): string {
        return "Cluck! Cluck!";
    }

    public toString(): string {
        return `Chicken -> ${super.toString()}, Eggs per week: ${this.eggsPerWeek}, Sound: ${this.makeSound()}`;
    }
}