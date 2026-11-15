
export abstract class FarmAnimal {

    protected id: number;
    protected breed: string;
    protected bornOnDate: Date;

    constructor(id: number, breed: string, bornOnDate: Date) {
        this.id = id;
        this.breed = breed;
        this.bornOnDate = bornOnDate;
    }

    abstract getAgeInMonths(): number;

    toString(): string {
        return `id = ${this.id}, breed = ${this.breed}, bornOnDate = ${this.bornOnDate.toDateString()}`;
    }
}
