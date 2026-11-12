export abstract class FarmAnimal {
    constructor(public id: number, public breed: string, public bornOn: Date) {}
    
    abstract feed(): void;
    abstract produce(): string;
}
