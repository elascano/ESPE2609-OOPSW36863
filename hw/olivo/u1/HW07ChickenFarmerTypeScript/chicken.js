"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Chicken = void 0;
const egg_1 = require("./egg");
const poop_1 = require("./poop");
class Chicken {
    constructor(name, color, bornOnDate, molting, id) {
        if (id !== undefined) {
            this.id = id;
            if (id > Chicken.idCounter) {
                Chicken.idCounter = id;
            }
        }
        else {
            Chicken.idCounter++;
            this.id = Chicken.idCounter;
        }
        this.name = name;
        this.color = color;
        this.bornOnDate = bornOnDate;
        this.ageInYear = this.computeAgeYears(bornOnDate);
        this.molting = molting;
    }
    computeAgeYears(dateStr) {
        const born = new Date(dateStr);
        const today = new Date();
        let age = today.getFullYear() - born.getFullYear();
        const m = today.getMonth() - born.getMonth();
        if (m < 0 || (m === 0 && today.getDate() < born.getDate())) {
            age--;
        }
        return age;
    }
    cluck() {
        console.log(`The Chicken ${this.name} is clucking`);
    }
    eat() {
        console.log(`The Chicken ${this.name} is eating`);
    }
    drink(amountOfWater) {
        console.log(`The Chicken ${this.name} is drinking ---- ${amountOfWater} liters`);
    }
    poop() {
        const p = new poop_1.Poop("Green", "s");
        console.log(p.toString());
    }
    layAnEgg() {
        const egg = new egg_1.Egg("M");
        console.log(egg.toString());
    }
    doStuff() {
        this.cluck();
        this.eat();
        this.drink(10);
        this.eat();
        this.poop();
        this.layAnEgg();
    }
    toDict() {
        return {
            id: this.id,
            name: this.name,
            color: this.color,
            born_on_date: this.bornOnDate,
            molting: this.molting
        };
    }
    static fromDict(data) {
        return new Chicken(data.name, data.color, data.born_on_date, data.molting, data.id);
    }
    toString() {
        return `Chicken [ID: ${this.id}, Name: ${this.name}, Age: ${this.ageInYear} years, Molting: ${this.molting}]`;
    }
}
exports.Chicken = Chicken;
Chicken.idCounter = 0;
