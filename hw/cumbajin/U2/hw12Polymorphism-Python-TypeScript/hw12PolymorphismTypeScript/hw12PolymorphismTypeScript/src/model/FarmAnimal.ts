export abstract class FarmAnimal {
    private id: number;
    private breed: string;
    private bornOnDate: Date;

    protected constructor(id: number, breed: string, bornOnDate: Date) {
        this.id = id;
        this.breed = breed;
        this.bornOnDate = bornOnDate;
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

    public getAgeInMonths(): number {
        return 0;
    }

    protected farmAnimalData(): string {
        return `FarmAnimal{id=${this.id}, breed=${this.breed}, bornOnDate=${this.bornOnDate.getFullYear()}}`;
    }

    public toString(): string {
        return this.farmAnimalData();
    }
}
