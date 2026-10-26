class ChickenCoop {
  #chickenCoopId;
  #chickens;
  #currentIndex = 0;

  constructor(chickenCoopId, chickens) {
    this.#chickenCoopId = chickenCoopId;
    this.#chickens = chickens;
  }

  add(chicken) {
    for (let i = 0; i < this.#chickens.length; i++) {
      if (this.#chickens[i] === null) {
        this.#chickens[i] = chicken;
        console.log(`Chicken --> ${chicken} added successfully`);
        return;
      }
    }
    console.log("The coop is full, the chicken can not be added.");
  }

  remove(chickenId) {
    for (let i = 0; i < this.#chickens.length; i++) {
      if (this.#chickens[i] === null) {
        continue;
      }
      if (this.#chickens[i].getId() === chickenId) {
        this.#chickens[i] = null;
        console.log(`Chicken with ID ${chickenId} has been removed.`);
        return;
      }
    }
    console.log(`Chicken with ID ${chickenId} not found.`);
  }

  resetIteration() {
    this.#currentIndex = 0;
  }

  next() {
    while (this.#currentIndex < this.#chickens.length) {
      const chicken = this.#chickens[this.#currentIndex];
      this.#currentIndex++;
      if (chicken !== null) {
        return chicken;
      }
    }
    return null;
  }

  toString() {
    let localChickens = "";
    for (const chicken of this.#chickens) {
      localChickens += chicken + "\n\t";
    }
    return `ChickenCoop{chickenCoopId=${this.#chickenCoopId}, chickens=${localChickens}}`;
  }

  getChickenCoopId() { return this.#chickenCoopId; }
  setChickenCoopId(chickenCoopId) { this.#chickenCoopId = chickenCoopId; }

  getChickens() { return this.#chickens; }
  setChickens(chickens) { this.#chickens = chickens; }
}

module.exports = ChickenCoop;