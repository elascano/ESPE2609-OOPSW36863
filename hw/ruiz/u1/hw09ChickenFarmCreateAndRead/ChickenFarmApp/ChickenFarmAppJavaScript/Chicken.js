const Egg = require("./Egg");
const Poop = require("./Poop");

class Chicken {
  #id;
  #name;
  #color;
  #bornOnDate;
  #ageInYears;
  #molting;

  constructor(id, name, color, bornOnDate, molting) {
    this.#id = id;
    this.#name = name;
    this.#color = color;
    this.#bornOnDate = bornOnDate;
    this.#ageInYears = this.computeAgeInYears();
    this.#molting = molting;
  }

  // ---- comportamiento ----
  doStuff() {
    this.#cluck();
    this.#wander();
    this.#eat();
    this.#drink(1.3);
    console.log("poop --> " + this.#poop());
    console.log("egg --> " + this.#layAnEgg());
  }

  #cluck() {
    console.log(`The chicken ${this.#name} is clucking...`);
  }

  #wander() {
    console.log(`The chicken ${this.#name} is wandering...`);
  }

  #eat() {
    console.log(`The chicken ${this.#name} is eating...`);
  }

  #drink(amountOfWater) {
    console.log(`The chicken ${this.#name} is drinking --> ${amountOfWater} ml of water`);
  }

  #poop() {
    return new Poop(2, "green", "M");
  }

  #layAnEgg() {
    return new Egg(2, "S");
  }

  computeAgeInYears() {
    const today = new Date();
    const birth = this.#bornOnDate;
    let age = today.getFullYear() - birth.getFullYear();
    if (today.getMonth() < birth.getMonth()) {
      age--;
    } else if (today.getMonth() === birth.getMonth() && today.getDate() < birth.getDate()) {
      age--;
    }
    return age;
  }

  toString() {
    const d = this.#bornOnDate;
    const pad = (n) => String(n).padStart(2, "0");
    const dateText = `${d.getFullYear()}-${pad(d.getMonth() + 1)}-${pad(d.getDate())}`;
    return `Chicken{id=${this.#id}, name=${this.#name}, color=${this.#color}, bornOnDate=${dateText}, age=${this.#ageInYears}, molting=${this.#molting}}`;
  }

  // ---- getters / setters ----
  getId() { return this.#id; }
  setId(id) { this.#id = id; }

  getName() { return this.#name; }
  setName(name) { this.#name = name; }

  getColor() { return this.#color; }
  setColor(color) { this.#color = color; }

  getBornOnDate() { return this.#bornOnDate; }
  setBornOnDate(bornOnDate) { this.#bornOnDate = bornOnDate; }

  getAgeInYears() { return this.#ageInYears; }
  setAgeInYears(ageInYears) { this.#ageInYears = ageInYears; }

  isMolting() { return this.#molting; }
  setMolting(molting) { this.#molting = molting; }
}

module.exports = Chicken;