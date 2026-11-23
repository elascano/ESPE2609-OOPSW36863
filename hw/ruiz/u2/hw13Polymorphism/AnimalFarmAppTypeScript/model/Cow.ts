import { FarmAnimal } from "./FarmAnimal.ts";
import { Food } from "./Food.ts";
export class Cow extends FarmAnimal{
    private isProducingMilk : boolean;
    private litersOfMilkPerWeek : number;
    
    constructor(isProducingMilk: boolean, litersOfMilkPerWeek: number, id: number, breed: string, bornOnDate: Date){
        super(id, breed, bornOnDate);
        this.isProducingMilk = isProducingMilk
        this.litersOfMilkPerWeek = litersOfMilkPerWeek
    } 
    milk(): void{
        console.log("milking the cow");
    }
    feed(food: Food, amountOfFood: number): void{
        console.log("feeding a cow with ---> " + amountOfFood + " of " + food.toString());
    }

    toString(): string {
        return "Cow {" + super.toString() + ", isProducingMilk= " + this.isProducingMilk + ", litersOfMilkPerWeek= " + this.litersOfMilkPerWeek + "}";
    }
}