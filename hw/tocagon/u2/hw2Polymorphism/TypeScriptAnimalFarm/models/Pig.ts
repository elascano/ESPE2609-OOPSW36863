import { FarmAnimal } from "./FarmAnimal";

export class Pig extends FarmAnimal{
    private weight: number;
    private isAdult: boolean;
    private fatPercentage: number;

    constructor(
        weight: number,
        isAdult: boolean,
        fatPercentage: number,
        id: number,
        breed: string,
        bornOnDate: Date,
    ){
        super(id, breed, bornOnDate)

        this.weight= weight;
        this.isAdult= isAdult;
        this.fatPercentage= fatPercentage;
    }

    getWeight(): number{
        return this.weight;
    }
    
    setWeight(weight: number){
        this.weight= weight;
    }

    getIsAdult(): boolean{
        return this.isAdult;
    }

    setIsAdult(isAdult: boolean){
        this.isAdult= isAdult;
    }

    getFatPercentage(): number{
        return this.fatPercentage;
    }

    setFatPercentage(fatPercentage: number){
        this.fatPercentage= fatPercentage;
    }

    checkHealth(): void{
        if (this.weight < 40) {
            console.log("The pig is underweight.");
        } else if (this.fatPercentage > 30) {
            console.log("The pig has a high fat percentage.");
        } else {
            console.log("The pig is healthy.");
        }   
    }

    toString(): string{
        return `Cow{${super.toString()}, weight=${this.weight}, isAdult=${this.isAdult}, fatPercentage=${this.fatPercentage}}`;
    }
}