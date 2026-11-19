import { Food } from "./Food";

export abstract class FarmAnimal {
    private id: number;
    private breed: string;
    private bornOnDate: Date;

    constructor(id: number, breed: string, bornOnDate: Date) {
        this.id = id;
        this.breed = breed;
        this.bornOnDate = bornOnDate;
    }

    public abstract feed(food: Food, amountOfFood: number): void;

    public getAgeInMonths(): number {
        return 0;
    }

    public toString(): string {
        // Replica exacta de Java Date: getDate(), getMonth()+1, getYear()+1900
        return `id=${this.id}, breed=${this.breed}, bornOnDate=${this.bornOnDate.getDate()}/${this.bornOnDate.getMonth() + 1}/${this.bornOnDate.getFullYear() + 1900},`;
    }

    public getId(): number {
        return this.id;
    }

    public setId(id: number): void {
        this.id = id;
    }

    public getBreed(): string {
        return this.breed;
    }

    public setBreed(breed: string): void {
        this.breed = breed;
    }

    public getBornOnDate(): Date {
        return this.bornOnDate;
    }

    public setBornOnDate(bornOnDate: Date): void {
        this.bornOnDate = bornOnDate;
    }
}