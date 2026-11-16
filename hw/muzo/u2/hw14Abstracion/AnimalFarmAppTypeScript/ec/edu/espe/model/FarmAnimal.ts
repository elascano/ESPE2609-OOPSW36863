export abstract class FarmAnimal {
    private id: number;
    private breed: string;
    private bornOnDate: Date;

    constructor(id: number, breed: string, bornOnDate: Date) {
        this.id = id;
        this.breed = breed;
        this.bornOnDate = bornOnDate;
    }

    toString(): string {
        return `id = ${this.id}, breed = ${this.breed}, bornOnDate = ${this.bornOnDate.getDate()}/${this.bornOnDate.getMonth() + 1}/${this.bornOnDate.getFullYear()}, `;
    }

    getAgeInMonths(): number {
        return 0;
    }

    getId(): number {
        return this.id;
    }

    setId(id: number): void {
        this.id = id;
    }

    getBreed(): string {
        return this.breed;
    }

    setBreed(breed: string): void {
        this.breed = breed;
    }

    getBornOnDate(): Date {
        return this.bornOnDate;
    }

    setBornOnDate(bornOnDate: Date): void {
        this.bornOnDate = bornOnDate;
    }
}
