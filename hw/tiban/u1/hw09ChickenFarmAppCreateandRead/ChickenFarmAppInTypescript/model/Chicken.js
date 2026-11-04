"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Chicken = void 0;
const Egg_1 = require("./Egg");
const Poop_1 = require("./Poop");
class Chicken {
    // Encapsulamiento con la palabra clave 'private'
    id;
    name;
    color;
    bornOnDate;
    ageInYears = 0;
    molting;
    // Constructor
    constructor(id, name, color, bornOnDate, molting) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.bornOnDate = bornOnDate;
        this.molting = molting;
    }
    computeAgeInYears() {
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
    doStuff() {
        this.cluck();
        this.wander();
        this.drink(1.3);
        console.log("poop -->", this.poop().toString());
        console.log("egg -->", this.layAnEgg().toString());
    }
    // Métodos privados
    cluck() {
        console.log(`The chicken ${this.name} is clucking...`); // Uso de template literals (`...`)
    }
    wander() {
        console.log(`The chicken ${this.name} is wandering...`);
    }
    eat() {
        console.log(`The chicken ${this.name} is eating....`);
    }
    drink(amountOfWater) {
        console.log(`The chicken is drinking ${amountOfWater}ml of water...`);
    }
    poop() {
        return new Poop_1.Poop(2, "Green", "M");
    }
    layAnEgg() {
        return new Egg_1.Egg(2, "S");
    }
    // Getters y Setters
    getId() { return this.id; }
    setId(id) { this.id = id; }
    getName() { return this.name; }
    setName(name) { this.name = name; }
    getColor() { return this.color; }
    setColor(color) { this.color = color; }
    getBornOnDate() { return this.bornOnDate; }
    setBornOnDate(bornOnDate) { this.bornOnDate = bornOnDate; }
    getAgeInYears() { return this.ageInYears; }
    setAgeInYears() { this.ageInYears = this.computeAgeInYears(); }
    isMolting() { return this.molting; }
    setMolting(molting) { this.molting = molting; }
    // Método toString
    toString() {
        return `Chicken{id=${this.id}, name=${this.name}, color=${this.color}, bornOnDate=${this.bornOnDate.toISOString().split('T')[0]}, ageInYears=${this.ageInYears}, molting=${this.molting}}`;
    }
}
exports.Chicken = Chicken;
//# sourceMappingURL=Chicken.js.map