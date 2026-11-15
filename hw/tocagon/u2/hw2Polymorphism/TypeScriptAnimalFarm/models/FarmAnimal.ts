export abstract class FarmAnimal{
    private id: number;
    private breed: string;
    private bornOnDate: Date;

    constructor(id: number, breed: string, bornOnDate: Date){
        this.id= id;
        this.breed= breed;
        this.bornOnDate= bornOnDate;
    }

    getId():number {
        return this.id;
    }

    setId(id:number): void {
        this.id= id;
    }

    getBreed():string{
        return this.breed;
    }

    setBreed(breed:string){
        this.breed=breed;
    }

    getBornOnDate(): Date{
        return this.bornOnDate;
    }

    setBornOnDate(bornOnDate: Date){
        this.bornOnDate= bornOnDate;
    }

    toString(): string {
        const day = String(this.bornOnDate.getDate()).padStart(2, "0");
        const month = String(this.bornOnDate.getMonth() + 1).padStart(2, "0");
        const year = this.bornOnDate.getFullYear();

        return `id=${this.id}, breed=${this.breed}, bornOnDate=${day}/${month}/${year}`;
    }

    getAgeInMonths(): number {
        const today = new Date();

        let months = (today.getFullYear() - this.bornOnDate.getFullYear()) * 12;
        months += today.getMonth() - this.bornOnDate.getMonth();

        if (today.getDate() < this.bornOnDate.getDate()) {
            months--;
        }

        return months;
    }
}   