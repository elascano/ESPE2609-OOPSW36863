import { Egg } from './egg';
import { Poop } from './poop';

export class Chicken {
    public static idCounter: number = 0;
    public id: number;
    public name: string;
    public color: string;
    public bornOnDate: string;
    public ageInYear: number;
    public molting: boolean;

    constructor(name: string, color: string, bornOnDate: string, molting: boolean, id?: number) {
        if (id !== undefined) {
            this.id = id;
            if (id > Chicken.idCounter) {
                Chicken.idCounter = id;
            }
        } else {
            Chicken.idCounter++;
            this.id = Chicken.idCounter;
        }
        this.name = name;
        this.color = color;
        this.bornOnDate = bornOnDate;
        this.ageInYear = this.computeAgeYears(bornOnDate);
        this.molting = molting;
    }

    private computeAgeYears(dateStr: string): number {
        const born = new Date(dateStr);
        const today = new Date();
        let age = today.getFullYear() - born.getFullYear();
        const m = today.getMonth() - born.getMonth();
        if (m < 0 || (m === 0 && today.getDate() < born.getDate())) {
            age--;
        }
        return age;
    }

    private cluck(): void {
        console.log(`The Chicken ${this.name} is clucking`);
    }

    private eat(): void {
        console.log(`The Chicken ${this.name} is eating`);
    }

    private drink(amountOfWater: number): void {
        console.log(`The Chicken ${this.name} is drinking ---- ${amountOfWater} liters`);
    }

    private poop(): void {
        const p = new Poop("Green", "s");
        console.log(p.toString());
    }

    private layAnEgg(): void {
        const egg = new Egg("M");
        console.log(egg.toString());
    }

    public doStuff(): void {
        this.cluck();
        this.eat();
        this.drink(10);
        this.eat();
        this.poop();
        this.layAnEgg();
    }

    public toDict(): any {
        return {
            id: this.id,
            name: this.name,
            color: this.color,
            born_on_date: this.bornOnDate,
            molting: this.molting
        };
    }

    public static fromDict(data: any): Chicken {
        return new Chicken(data.name, data.color, data.born_on_date, data.molting, data.id);
    }

    public toString(): string {
        return `Chicken [ID: ${this.id}, Name: ${this.name}, Age: ${this.ageInYear} years, Molting: ${this.molting}]`;
    }
}