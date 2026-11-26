export abstract class FarmAnimal{
    private id: number;
    private breed: string;
    private bornOnDate: Date;

    constructor(id: number, breed: string, bornOnDate: Date) {
        this.id = id;
        this.breed = breed;
        this.bornOnDate = bornOnDate;

    }
    toString(): string{
        return "id= " + this.id + ", breed= " + this.breed + ", bornOnDate= " + this.bornOnDate.getDate() + "/" + (this.bornOnDate.getMonth()+1) + "/" + this.bornOnDate.getFullYear();

    }
}