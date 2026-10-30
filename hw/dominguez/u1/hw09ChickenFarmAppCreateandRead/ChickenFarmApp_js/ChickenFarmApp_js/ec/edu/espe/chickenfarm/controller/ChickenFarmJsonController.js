import fs from "node:fs";
import { Chicken } from "../model/Chicken.js";
import { ChickenCoop } from "../model/ChickenCoop.js";
import { ChickenFarmer } from "../model/ChickenFarmer.js";

export class ChickenFarmJsonController {
  #toChicken(data) {
    if (data === null) {
      return null;
    }
    const chicken = new Chicken(data.id, data.name, data.color, new Date(data.bornOnDate), data.molting);
    chicken.ageInYears = data.ageInYears;
    return chicken;
  }

  #toCoop(data) {
    if (data === null) {
      return null;
    }
    const coop = new ChickenCoop(data.chickenCoopId, data.chickens.map((c) => this.#toChicken(c)));
    coop.currentIndex = data.currentIndex;
    return coop;
  }

  #toFarmer(data) {
    const farmer = new ChickenFarmer(data.chickenFarmerId, data.name, data.coops.map((c) => this.#toCoop(c)));
    farmer.currentIndex = data.currentIndex;
    return farmer;
  }

  saveToJson(chickenFarmer, fileName) {
    const json = JSON.stringify(chickenFarmer, null, 2);
    console.log("JSON -->\n" + json);

    try {
      fs.writeFileSync(fileName, json, "utf-8");
      console.log("Archivo " + fileName + " guardado correctamente");
    } catch (e) {
      console.log("No se pudo guardar el archivo: " + e.message);
    }
  }

  loadFromJson(fileName) {
    let chickenFarmer = null;

    try {
      const text = fs.readFileSync(fileName, "utf-8");
      chickenFarmer = this.#toFarmer(JSON.parse(text));
    } catch (e) {
      console.log("No se pudo leer el archivo: " + e.message);
    }

    return chickenFarmer;
  }
}
