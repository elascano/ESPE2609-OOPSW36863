const Chicken = require("./Chicken");
const ChickenCoop = require("./ChickenCoop");

class ChickenFarmer {
  constructor() {
    this.chickenFarmerId = 1;
    this.name = "";
    this.coops = new Array(2).fill(null);

    const chickens = new Array(2).fill(null);
    chickens[0] = new Chicken(0, "pepita", "black", new Date(), true);
    chickens[1] = new Chicken(0, "marujita", "black", new Date(), true);

    // Igual que en el Java, ambos gallineros comparten el mismo arreglo de pollos
    this.coops[0] = new ChickenCoop(0, chickens);
    this.coops[1] = new ChickenCoop(1, chickens);
  }

  toString() {
    let localCoops = "";
    for (const coop of this.coops) {
      localCoops += coop;
      localCoops += "\n";
    }
    return `ChickenFarmer{chickenFarmerId=${this.chickenFarmerId}, name=${this.name}, coops=${localCoops}}`;
  }
}

module.exports = ChickenFarmer;