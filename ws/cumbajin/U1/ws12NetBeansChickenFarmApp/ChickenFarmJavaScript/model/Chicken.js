const Egg = require("./Egg");
const Poop = require("./Poop");

/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
class Chicken {
  constructor(
    id = 0,
    name = "",
    color = "",
    bornOnDate = null,
    molting = false,
  ) {
    this.id = id;
    this.name = name;
    this.color = color;
    this.bornOnDate = bornOnDate;
    this.ageInYears = 0;
    this.molting = molting;

    if (this.bornOnDate != null) {
      this.ageInYears = this.computeAgeInYears();
    }
  }

  // Compute chicken age
  computeAgeInYears() {
    if (this.bornOnDate == null) {
      return 0;
    }

    let today = new Date();
    let birth = this.bornOnDate;

    let age = today.getFullYear() - birth.getFullYear();

    if (today.getMonth() < birth.getMonth()) {
      age--;
    } else if (
      today.getMonth() == birth.getMonth() &&
      today.getDate() < birth.getDate()
    ) {
      age--;
    }

    return age;
  }

  // Chicken behavior
  doStuff() {
    this.cluck();
    this.wander();
    this.drink(1.3);
    console.log("poop -->" + this.poop().toString());
    console.log("egg -->" + this.layAnEgg().toString());
  }

  cluck() {
    console.log("The chicken " + this.name + " is clucking ...");
  }

  wander() {
    console.log("The chicken " + this.name + " is wandering ...");
  }

  eat() {
    console.log("The chicken " + this.name + " is eating ...");
  }

  drink(amountOfWater) {
    console.log(
      "The chicken " +
        this.name +
        " is drinking -->" +
        amountOfWater +
        " ml of water",
    );
  }

  poop() {
    let poop = new Poop(2, "green", "M");
    return poop;
  }

  layAnEgg() {
    let egg = new Egg(2, "S");
    return egg;
  }

  toString() {
    return (
      "Chicken{" +
      "id=" +
      this.id +
      ", name=" +
      this.name +
      ", color=" +
      this.color +
      ", bornOnDate=" +
      this.bornOnDate +
      ", ageInYears=" +
      this.ageInYears +
      ", molting=" +
      this.molting +
      "}"
    );
  }

  getId() {
    return this.id;
  }

  setId(id) {
    this.id = id;
  }

  getName() {
    return this.name;
  }

  setName(name) {
    this.name = name;
  }

  getColor() {
    return this.color;
  }

  setColor(color) {
    this.color = color;
  }

  getBornOnDate() {
    return this.bornOnDate;
  }

  setBornOnDate(bornOnDate) {
    this.bornOnDate = bornOnDate;
  }

  getAgeInYears() {
    return this.ageInYears;
  }

  setAgeInYears(ageInYears) {
    if (ageInYears === undefined) {
      this.ageInYears = this.computeAgeInYears();
    } else {
      this.ageInYears = ageInYears;
    }
  }

  isMolting() {
    return this.molting;
  }

  setMolting(molting) {
    this.molting = molting;
  }
}

module.exports = Chicken;
