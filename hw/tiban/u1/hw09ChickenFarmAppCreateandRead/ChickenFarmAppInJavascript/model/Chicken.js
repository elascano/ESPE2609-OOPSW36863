import { Poop } from './Poop.js';
import { Egg } from './Egg.js';

export class Chicken {
    constructor(id, name, color, bornOnDate, molting) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.bornOnDate = bornOnDate; 
        this.molting = molting;
        this.ageInYears = 0; 
    }

    computeAgeInYears() {
        const today = new Date();
        let age = today.getFullYear() - this.bornOnDate.getFullYear();
        const monthDiff = today.getMonth() - this.bornOnDate.getMonth();
        
        if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < this.bornOnDate.getDate())) {
            age--;
        }
        
        return age;
    }

    setAgeInYears() {
        this.ageInYears = this.computeAgeInYears();
    }

    doStuff() {
        this.#cluck();
        this.#wander();
        this.#drink(1.3);
        console.log(`poop --> \${this.#poop()}`);
        console.log(`egg --> \${this.#layAnEgg()}`);
    }
    
    #cluck() {
        console.log(`The chicken \${this.name} is clucking...`);
    }
    
    #wander() {
        console.log(`The chicken \${this.name} is wandering...`);
    }
    
    #eat() {
        console.log(`The chicken \${this.name} is eating....`);
    }
    
    #drink(amountOfWater) {
        console.log(`The chicken is drinking \${amountOfWater}ml of water...`);
    }
    
    #poop() {
        return new Poop(2, "Green", 'M');
    }
    
    #layAnEgg() {
        return new Egg(2, 'S');
    }

    toString() {
        return `Chicken{id=${this.id}, name=${this.name}, color=${this.color}, bornOnDate=${this.bornOnDate.toISOString().split('T')[0]}, ageInYears=${this.ageInYears}, molting=${this.molting}}`;
    }
}