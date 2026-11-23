import { FarmAnimal } from "./FarmAnimal.ts";
import { Food } from "./Food.ts";
export class Pig extends FarmAnimal{
    private isMeat : boolean;
    private weightInKg : number;
    private isPregnant : boolean;

    constructor(isMeat: boolean, weightInKg: number, isPregnant: boolean, id: number, breed: string, bornOnDate: Date){
        super(id, breed, bornOnDate);
        this.isMeat = isMeat;
        this.weightInKg = weightInKg;
        this.isPregnant = isPregnant;
    }
    select(): void{
        console.log("selecting the pig for slaughter");
    }
    
    feed(food: Food, amountOfFood: number): void{
        console.log("feeding a pig with ---> " + amountOfFood + " kg of " + food.toString());
    }

    toString(): string {
        return "Pig {" + super.toString() + ", isMeat= " + this.isMeat + ", weightInKg= " + this.weightInKg +  ", isPregnant= " + this.isPregnant + "}";
    }
}