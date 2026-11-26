import { FarmAnimal } from "./FarmAnimal.ts";
import { Food } from "./Food.ts";
export class Chicken extends FarmAnimal{
    private isMolting : boolean;
    private numberOfLaidEggsInAMonth : number;
    private isMeat : boolean;

    constructor(isMolting: boolean, numberOfLaidEggsInAMonth: number, isMeat: boolean, id: number, breed: string, bornOnDate: Date){
        super(id, breed, bornOnDate);
        this.isMolting = isMolting;
        this.numberOfLaidEggsInAMonth = numberOfLaidEggsInAMonth;
        this.isMeat = isMeat;
    }
    LayAnEgg(): void{
        console.log("chicken is laying an egg() ");
    }
    feed(food: Food, amountOfFood: number): void{
        console.log("feeding a chicken with ---> " + amountOfFood + " of " + food.toString());
    }

    toString(): string {
        return "Chicken {" + super.toString() + ", isMolting= " + this.isMolting + ", numberOfLaidEggsInAMonth= " + this.numberOfLaidEggsInAMonth +  ", isMeat= " + this.isMeat + "}";
    }
}