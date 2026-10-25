const ChickenCoop = require("./ChickenCoop");
const { readInt, readYesNo } = require("./helpers");

const MAX_COOPS = 5;

class ChickenFarmer {
  constructor(id, name) {
    this.id = id;
    this.name = name;
    this.coops = [];
    this.currentIndex = 0;
  }

  existsCoopId(coopId) {
    for (const coop of this.coops) {
      if (coop.id === coopId) {
        return true;
      }
    }
    return false;
  }

  add(coop) {
    if (this.existsCoopId(coop.id)) {
      console.log(`The coop id ${coop.id} is already registered, the coop was not added`);
      return;
    }
    if (this.coops.length >= MAX_COOPS) {
      console.log("The farmer can't have more coops");
      return;
    }
    this.coops.push(coop);
    console.log("Coop added -->", coop.id);
  }

  // asks the data of the coops (and their chickens) with the keyboard
  async registerCoops() {
    let keepGoing = true;
    while (keepGoing) {
      if (this.coops.length >= MAX_COOPS) {
        console.log("The farmer can't have more coops");
        return;
      }

      console.log("Register a new coop");
      let coopId = await readInt("Enter the coop id: ");
      while (this.existsCoopId(coopId)) {
        console.log(`The coop id ${coopId} is already registered, try another one`);
        coopId = await readInt("Enter the coop id: ");
      }

      const coop = new ChickenCoop(coopId);
      if (await readYesNo("Want to register chickens for this coop? (y/n): ")) {
        await coop.registerChickens();
      }
      this.add(coop);

      keepGoing = await readYesNo("Want to register another coop? (y/n): ");
    }
  }

  remove(coopId) {
    for (let position = 0; position < this.coops.length; position++) {
      if (this.coops[position].id === coopId) {
        this.coops.splice(position, 1);
        if (position < this.currentIndex) {
          this.currentIndex--;
        }
        console.log(`Coop with id ${coopId} was removed`);
        return;
      }
    }
    console.log(`There is no coop with id ${coopId}`);
  }

  resetIteration() {
    this.currentIndex = 0;
  }

  next() {
    if (this.currentIndex >= this.coops.length) {
      return null;
    }
    const coop = this.coops[this.currentIndex];
    this.currentIndex++;
    return coop;
  }

  // the chickens of all the coops in one array (used to save them in a file)
  getAllChickens() {
    const allChickens = [];
    for (const coop of this.coops) {
      for (const chicken of coop.chickens) {
        allChickens.push(chicken);
      }
    }
    return allChickens;
  }

  toString() {
    let text = `ChickenFarmer(id=${this.id}, name=${this.name}, coops=\n`;
    for (const coop of this.coops) {
      text += coop + "\n";
    }
    return text + ")";
  }
}

module.exports = ChickenFarmer;