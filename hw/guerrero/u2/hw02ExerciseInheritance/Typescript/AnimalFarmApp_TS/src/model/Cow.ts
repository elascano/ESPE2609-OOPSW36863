import { FarmAnimal } from './FarmAnimal';

export class Cow extends FarmAnimal {
    constructor(name: string, age: number, public litersOfMilk: number) {
        super(name, age);
    }

    public makeSound(): string {
        return "Moo!";
    }

    public toString(): string {
        return `Cow -> ${super.toString()}, Milk production: ${this.litersOfMilk}L, Sound: ${this.makeSound()}`;
    }
}