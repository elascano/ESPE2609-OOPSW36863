import { FarmAnimal } from "./FarmAnimal";

export class Cow extends FarmAnimal{
    private isProducingMilk: boolean;
    private litersOfMilkPerWeek: number;

    constructor(
        isProducingMilk: boolean,
        litersOfMilkPerWeek: number,
        id: number,
        breed: string,
        bornOnDate: Date,
    ){
        super(id, breed, bornOnDate)

        this.isProducingMilk= isProducingMilk;
        this.litersOfMilkPerWeek= litersOfMilkPerWeek;
    }

    getIsProducingMilk(): boolean{
        return this.isProducingMilk;
    }
    
    setIsProducingMilk(isProducingMilk: boolean){
        this.isProducingMilk= isProducingMilk;
    }

    getLitersOfMilkPerWeek(): number{
        return this.litersOfMilkPerWeek;
    }

    setLitersOfMilkPerWeek(litersOfMilkPerWeek: number){
        this.litersOfMilkPerWeek= litersOfMilkPerWeek;
    }

    milk(): void{
        console.log("Milking the Cow");
    }

    toString(): string{
        return `Cow{${super.toString()}, isProducingMilk=${this.isProducingMilk}, litersOfMilkPerWeek=${this.litersOfMilkPerWeek}}`;
    }
}