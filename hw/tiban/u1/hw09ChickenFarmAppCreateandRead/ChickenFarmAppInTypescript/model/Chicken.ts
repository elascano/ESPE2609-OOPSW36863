import { Egg } from "./Egg";
import { Poop } from "./Poop";

export class Chicken {
    // Encapsulamiento con la palabra clave 'private'
    private id: number;
    private name: string;
    private color: string;
    private bornOnDate: Date;
    private ageInYears: number = 0;
    private molting: boolean;
    
    // Constructor
    constructor(id: number, name: string, color: string, bornOnDate: Date, molting: boolean) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.bornOnDate = bornOnDate;
        this.molting = molting;
    }

    public computeAgeInYears(): number {
        // En TypeScript/JavaScript, Date maneja las fechas más fácil que Calendar de Java
        const today = new Date();
        let age = today.getFullYear() - this.bornOnDate.getFullYear();

        // Verificamos si el mes actual es menor al mes de nacimiento, 
        // o si es el mismo mes pero el día actual es menor
        if (today.getMonth() < this.bornOnDate.getMonth() || 
           (today.getMonth() === this.bornOnDate.getMonth() && today.getDate() < this.bornOnDate.getDate())) {
            age--;
        }

        return age;
    }

    public doStuff(): void {
        this.cluck();
        this.wander();
        this.drink(1.3);
        console.log("poop -->", this.poop().toString());
        console.log("egg -->", this.layAnEgg().toString());
    }

    // Métodos privados
    private cluck(): void {
        console.log(`The chicken ${this.name} is clucking...`); // Uso de template literals (`...`)
    }

    private wander(): void {
        console.log(`The chicken ${this.name} is wandering...`);
    }

    private eat(): void {
        console.log(`The chicken ${this.name} is eating....`);
    }

    private drink(amountOfWater: number): void {
        console.log(`The chicken is drinking ${amountOfWater}ml of water...`);
    }

    private poop(): Poop {
        return new Poop(2, "Green", "M");
    }

    private layAnEgg(): Egg {
        return new Egg(2, "S");
    }

    // Getters y Setters
    public getId(): number { return this.id; }
    public setId(id: number): void { this.id = id; }

    public getName(): string { return this.name; }
    public setName(name: string): void { this.name = name; }

    public getColor(): string { return this.color; }
    public setColor(color: string): void { this.color = color; }

    public getBornOnDate(): Date { return this.bornOnDate; }
    public setBornOnDate(bornOnDate: Date): void { this.bornOnDate = bornOnDate; }

    public getAgeInYears(): number { return this.ageInYears; }
    public setAgeInYears(): void { this.ageInYears = this.computeAgeInYears(); }

    public isMolting(): boolean { return this.molting; }
    public setMolting(molting: boolean): void { this.molting = molting; }

    // Método toString
    public toString(): string {
        return `Chicken{id=${this.id}, name=${this.name}, color=${this.color}, bornOnDate=${this.bornOnDate.toISOString().split('T')[0]}, ageInYears=${this.ageInYears}, molting=${this.molting}}`;
    }
}