export abstract class FarmAnimal {
    constructor(public name: string, public age: number) {}

    abstract makeSound(): string;

    public toString(): string {
        return `Animal: ${this.name}, Age: ${this.age} years`;
    }
}