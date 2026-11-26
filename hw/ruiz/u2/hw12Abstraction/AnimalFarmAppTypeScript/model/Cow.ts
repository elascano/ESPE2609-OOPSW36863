import { FarmAnimal } from "./FarmAnimal.ts";
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
    toString(): string {
        return "Cow {" + super.toString() + ", isProducingMilk= " + this.isProducingMilk + ", litersOfMilkPerWeek= " + this.litersOfMilkPerWeek + "}";
    }
}