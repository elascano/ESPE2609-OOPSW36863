import { FarmAnimal } from "./FarmAnimal.ts";
export class Sheep extends FarmAnimal{
    private lastShearing : Date;
    private isShorn : boolean;
    private kgOfWoolPerShearing : number;

    constructor(lastShearing: Date, isShorn: boolean, kgOfWoolPerDhearing: number, id: number, breed: string, bornOnDate: Date){
        super(id, breed, bornOnDate);
        this.lastShearing = lastShearing;
        this.isShorn = isShorn;
        this.kgOfWoolPerShearing = kgOfWoolPerDhearing;
    }
    shearn(): void{
        console.log("shearning the sheep");
    }
    
    toString(): string {
        return "Sheep {" + super.toString() + ", lastShearing= " + this.lastShearing.getDate() +
         "/" + (this.lastShearing.getMonth()+1) +
         "/" + this.lastShearing.getFullYear()+
          ", isShorn= " + this.isShorn +  ", kgOfWoolPerShearing= " + this.kgOfWoolPerShearing + "}";
    }
}