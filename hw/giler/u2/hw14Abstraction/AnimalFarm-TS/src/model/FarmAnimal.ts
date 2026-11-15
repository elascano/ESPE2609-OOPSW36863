export abstract class FarmAnimal {
    constructor(public id: number, public breed: string, public bornOnDate: string) {}
    abstract feed(): void;
}