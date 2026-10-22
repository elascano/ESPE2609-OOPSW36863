import fs from "node:fs";
import { Chicken } from "../model/Chicken.js";
import { ChickenCoop } from "../model/ChickenCoop.js";
import { ChickenFarmer } from "../model/ChickenFarmer.js";

const SEPARATOR = ";";
const HEADER = "farmerId;farmerName;coopId;chickenId;name;color;bornOnDate;molting";

export class ChickenFarmCsvController {
  saveToCsv(chickenFarmer, fileName) {
    const lines = [HEADER];

    for (const coop of chickenFarmer.coops) {
      if (coop === null) {
        continue;
      }
      for (const chicken of coop.chickens) {
        if (chicken === null) {
          continue;
        }
        lines.push(
          [
            chickenFarmer.chickenFarmerId,
            chickenFarmer.name,
            coop.chickenCoopId,
            chicken.id,
            chicken.name,
            chicken.color,
            chicken.bornOnDate.getTime(), 
            chicken.molting,
          ].join(SEPARATOR)
        );
      }
    }

    try {
      fs.writeFileSync(fileName, lines.join("\n") + "\n", "utf-8");
      console.log("Archivo " + fileName + " guardado correctamente");
    } catch (e) {
      console.log("No se pudo guardar el archivo: " + e.message);
    }
  }

  loadFromCsv(fileName) {
    let chickenFarmer = null;

    try {
      const lines = fs.readFileSync(fileName, "utf-8").split(/\r?\n/);

      for (let i = 1; i < lines.length; i++) {
        if (lines[i].trim() === "") {
          continue;
        }
        const data = lines[i].split(SEPARATOR);
        if (data.length < 8) {
          throw new Error("faltan columnas en la línea " + (i + 1));
        }

        const farmerId = parseInt(data[0]);
        const farmerName = data[1];
        const coopId = parseInt(data[2]);
        const chickenId = parseInt(data[3]);
        const name = data[4];
        const color = data[5];
        const bornOnDate = new Date(parseInt(data[6]));
        const molting = data[7].toLowerCase() === "true";

        if (Number.isNaN(farmerId) || Number.isNaN(coopId) || Number.isNaN(chickenId) || Number.isNaN(bornOnDate.getTime())) {
          throw new Error("número inválido en la línea " + (i + 1));
        }

        if (chickenFarmer === null) {
          chickenFarmer = new ChickenFarmer(farmerId, farmerName, new Array(10).fill(null));
        }

        let coop = null;
        for (const existingCoop of chickenFarmer.coops) {
          if (existingCoop !== null && existingCoop.chickenCoopId === coopId) {
            coop = existingCoop;
            break;
          }
        }
        if (coop === null) {
          coop = new ChickenCoop(coopId, new Array(10).fill(null));
          chickenFarmer.add(coop);
        }

        coop.add(new Chicken(chickenId, name, color, bornOnDate, molting));
      }

      if (chickenFarmer !== null) {
        chickenFarmer.resetIteration();
        for (const coop of chickenFarmer.coops) {
          if (coop !== null) {
            coop.resetIteration();
          }
        }
      }
    } catch (e) {
      console.log("No se pudo leer el archivo o tiene un formato incorrecto: " + e.message);
    }

    return chickenFarmer;
  }
}
