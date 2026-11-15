import { FarmAnimal } from "./FarmAnimal";

export class Sheep extends FarmAnimal{
    private woolColor: string;
    private woolWeight: number;
    private isSheared: boolean;

    constructor(
        woolColor: string,
        woolWeight: number,
        isSheared: boolean,
        id: number,
        breed: string,
        bornOnDate: Date,
    ){
        super(id, breed, bornOnDate)

        this.woolColor= woolColor;
        this.woolWeight= woolWeight;
        this.isSheared= isSheared;
    }

    getWoolColor(): string{
        return this.woolColor;
    }
    
    setWoolColor(woolColor: string){
        this.woolColor= woolColor;
    }

    getWoolWeight(): number{
        return this.woolWeight;
    }

    setWoolWeight(woolWeight: number){
        this.woolWeight= woolWeight;
    }

    getIsSheared(): boolean{
        return this.isSheared;
    }

    setIsSheared(isSheared: boolean){
        this.isSheared= isSheared;
    }

    shearWool(): void{
        if(!this.isSheared){
            console.log("shearing the wool..");
            this.isSheared= true;
            this.woolWeight=0;
        }else{
            console.log("The sheep is already sheared");
        }
    }

    toString(): string{
        return `Cow{${super.toString()}, woolColor=${this.woolColor}, woolWeight=${this.woolWeight}, isSheared=${this.isSheared}}`;
    }
}