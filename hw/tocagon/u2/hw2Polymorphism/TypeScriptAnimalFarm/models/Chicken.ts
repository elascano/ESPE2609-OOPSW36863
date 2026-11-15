import { FarmAnimal } from "./FarmAnimal";

export class Chicken extends FarmAnimal{
    private isMolting: boolean;
    private numberOfLaidEggsInAMonth: number;
    private isMeat: boolean;

    constructor(
        isMolting:boolean,
        numberOfLaidEggsInAMonth: number,
        isMeat: boolean,
        id: number,
        breed: string,
        bornOnDate: Date,
    ){
        super(id, breed, bornOnDate);

        this.isMolting= isMolting;
        this.numberOfLaidEggsInAMonth= numberOfLaidEggsInAMonth;
        this.isMeat= isMeat;
    }

    layAnEgg(): void{
        console.log("chicken is laying an egg()");
    }

    getIsMolting(): boolean{
        return this.isMolting;
    }
    
    setIsMolting(isMolting: boolean){
        this.isMolting= isMolting;
    }

    getNumberOfLaidEggsInAMonth(): number{
        return this.numberOfLaidEggsInAMonth;
    }

    setNumberOfLaidEggsInAMonth(numberOfLaidEggsInAMonth: number){
        this.numberOfLaidEggsInAMonth= numberOfLaidEggsInAMonth;
    }

    getIsMeat(): boolean{
        return this.isMeat;
    }

    setIsMeat(isMeat: boolean){
        this.isMeat= isMeat;
    }

    toString(): string {
        return `Chicken{${super.toString()}, isMolting=${this.isMolting}, numberOfLaidEggsInAMonth=${this.numberOfLaidEggsInAMonth}, isMeat=${this.isMeat}}`;
    }
}