const Chicken = require("./Chicken");
const ChickenCoop = require("./ChickenCoop");

/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
class ChickenFarmer {
  constructor() {
    this.chickenFarmerId = 1;
    this.name = "";
    this.coops = new Array(2).fill(null);

    let chickens = new Array(2).fill(null);

    chickens[0] = new Chicken(0, "pepita", "black", new Date(), true);
    chickens[1] = new Chicken(0, "marujita", "black", new Date(), true);

    this.coops[0] = new ChickenCoop(0, chickens);
    this.coops[1] = new ChickenCoop(1, chickens);
  }

  toString() {
    return (
      "ChickenFarmer{" +
      "chickenFarmerId=" +
      this.chickenFarmerId +
      ", name=" +
      this.name +
      ", coops=" +
      this.coops +
      "}"
    );
  }
}

module.exports = ChickenFarmer;
