const fs = require("fs");
const Chicken = require("../model/Chicken");

/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
class ChickenFileManager {
  
  static saveJSON(chickens) {
    let data = [];

    for (let i = 0; i < chickens.length; i++) {
      if (chickens[i] != null) {
        data[data.length] = chickens[i];
      }
    }

    let json = JSON.stringify(data, null, 4);

    fs.writeFileSync("chickens.json", json);

    console.log("Chickens saved in JSON successfully!");
  }

  static readJSON() {
    let json = fs.readFileSync("chickens.json", "utf8");
    let data = JSON.parse(json);

    let chickens = new Array(data.length).fill(null);

    for (let i = 0; i < data.length; i++) {
      let item = data[i];

      chickens[i] = new Chicken(
        item.id,
        item.name,
        item.color,
        new Date(item.bornOnDate),
        item.molting,
      );

      chickens[i].setAgeInYears(item.ageInYears);
    }

    return chickens;
  }

  
  static saveCSV(chickens) {
    let csv = "id,name,color,bornOnDate,ageInYears,molting\n";

    for (let i = 0; i < chickens.length; i++) {
      if (chickens[i] != null) {
        let chicken = chickens[i];

        csv +=
          chicken.getId() +
          "," +
          chicken.getName() +
          "," +
          chicken.getColor() +
          "," +
          chicken.getBornOnDate().getTime() +
          "," +
          chicken.getAgeInYears() +
          "," +
          chicken.isMolting() +
          "\n";
      }
    }

    fs.writeFileSync("chickens.csv", csv);

    console.log("Chickens saved in CSV successfully!");
  }

  
  static readCSV() {
    let chickens = new Array(10).fill(null);

    let csv = fs.readFileSync("chickens.csv", "utf8");
    let lines = csv.trim().split("\n");

    let index = 0;

    for (let i = 1; i < lines.length && index < chickens.length; i++) {
      let data = lines[i].trim().split(",");

      let id = parseInt(data[0]);
      let name = data[1];
      let color = data[2];
      let bornOnDate = new Date(Number(data[3]));
      let age = parseInt(data[4]);
      let molting = data[5] === "true";

      chickens[index] = new Chicken(id, name, color, bornOnDate, molting);

      chickens[index].setAgeInYears(age);

      index++;
    }

    return chickens;
  }
}

module.exports = ChickenFileManager;
