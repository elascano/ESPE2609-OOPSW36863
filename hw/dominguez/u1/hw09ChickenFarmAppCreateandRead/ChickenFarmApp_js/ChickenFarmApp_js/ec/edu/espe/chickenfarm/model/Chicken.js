import { Egg } from "./Egg.js";
import { Poop } from "./Poop.js";


function formatDate(date) {
  const month = String(date.getMonth() + 1).padStart(2, "0");
  const day = String(date.getDate()).padStart(2, "0");
  return `${date.getFullYear()}-${month}-${day}`;
}

export class Chicken {
  constructor(id, name, color, bornOnDate, molting) {
    this.id = id;
    this.name = name;
    this.color = color;
    this.bornOnDate = bornOnDate; 
    this.ageInYears = 0;
    this.molting = molting;
  }

  doStuff() {
    this.#cluck();
    this.#wander();
    this.#eat();
    this.#drink(1.3);
    console.log("poop -->" + this.#poop());
    console.log("egg -->" + this.#layAnEgg());
  }

  #cluck() {
    console.log(`The chicken ${this.name} is clucking ...`);
  }

  #wander() {
    console.log(`The chicken ${this.name} is wandering ...`);
  }

  #eat() {
    console.log(`The chicken ${this.name} is eating ...`);
  }

  #drink(amountOfWater) {
    console.log(`The chicken ${this.name} is drinking -->${amountOfWater} ml of water`);
  }

  #poop() {
    return new Poop(2, "green", "M");
  }

  #layAnEgg() {
    return new Egg(this.id, "B");
  }

  computeAgeInYears() {
    const today = new Date();
    let age = today.getFullYear() - this.bornOnDate.getFullYear();

    if (today.getMonth() < this.bornOnDate.getMonth()) {
      age--;
    } else if (
      today.getMonth() === this.bornOnDate.getMonth() &&
      today.getDate() < this.bornOnDate.getDate()
    ) {
      age--;
    }

    return age;
  }

  setAgeInYears(ageInYears) {
    this.ageInYears = this.computeAgeInYears();
  }

  toString() {
    return `Chicken{id=${this.id}, name=${this.name}, color=${this.color}, bornOnDate=${formatDate(this.bornOnDate)}, age=${this.ageInYears}, molting=${this.molting}}`;
  }
}
