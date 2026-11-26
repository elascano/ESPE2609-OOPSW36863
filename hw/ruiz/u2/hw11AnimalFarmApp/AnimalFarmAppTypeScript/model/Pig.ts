import { FarmAnimal } from "./FarmAnimal.ts";
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
    toString(): string {
        return "Pig {" + super.toString() + ", isMeat= " + this.isMeat + ", weightInKg= " + this.weightInKg +  ", isPregnant= " + this.isPregnant + "}";
    }
}