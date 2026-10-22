import readline from "node:readline";
import { stdin as input, stdout as output } from "node:process";
import { ChickenFarmCsvController } from "../controller/ChickenFarmCsvController.js";
import { ChickenFarmJsonController } from "../controller/ChickenFarmJsonController.js";
import { Chicken } from "../model/Chicken.js";
import { ChickenCoop } from "../model/ChickenCoop.js";
import { ChickenFarmer } from "../model/ChickenFarmer.js";

const rl = readline.createInterface({ input, output });

const lineQueue = [];
let waiting = null; 
let inputClosed = false;

rl.on("line", (line) => {
  if (waiting !== null) {
    const resolve = waiting;
    waiting = null;
    resolve(line);
  } else {
    lineQueue.push(line);
  }
});

rl.on("close", () => {
  inputClosed = true;
  if (waiting !== null) {
    console.log("\nProgram ended.");
    process.exit(0);
  }
});
const jsonController = new ChickenFarmJsonController();
const csvController = new ChickenFarmCsvController();

let chickenFarmer = new ChickenFarmer(1, "Mateo", new Array(10).fill(null));

async function askText(message) {
  rl.setPrompt(message);
  rl.prompt();

  if (lineQueue.length > 0) {
    return lineQueue.shift().trim();
  }
  if (inputClosed) {
    console.log("\nProgram ended.");
    process.exit(0);
  }
  const line = await new Promise((resolve) => {
    waiting = resolve;
  });
  return line.trim();
}

async function askInt(message) {
  while (true) {
    const text = await askText(message);
    if (/^-?\d+$/.test(text)) {
      return parseInt(text);
    }
    console.log("Enter a whole number.");
  }
}

async function askDate(message) {
  while (true) {
    const match = (await askText(message)).match(/^(\d{4})-(\d{2})-(\d{2})$/);
    if (match) {
      const year = parseInt(match[1]);
      const month = parseInt(match[2]) - 1;
      const day = parseInt(match[3]);
      const date = new Date(year, month, day);
      if (date.getMonth() === month && date.getDate() === day) {
        return date;
      }
    }
    console.log("Invalid date. Use the format YYYY-MM-DD, for example 2024-09-15.");
  }
}

async function askYesNo(message) {
  while (true) {
    const text = (await askText(message + " (y/n): ")).toLowerCase();
    if (text === "y") return true;
    if (text === "n") return false;
    console.log("Enter y or n.");
  }
}

async function askFileName(defaultName) {
  const text = await askText(`File name (press Enter for "${defaultName}"): `);
  return text === "" ? defaultName : text;
}

function findCoop(coopId) {
  for (const coop of chickenFarmer.coops) {
    if (coop !== null && coop.chickenCoopId === coopId) {
      return coop;
    }
  }
  return null;
}

function findChicken(coop, chickenId) {
  for (const chicken of coop.chickens) {
    if (chicken !== null && chicken.id === chickenId) {
      return chicken;
    }
  }
  return null;
}

async function askExistingCoop() {
  const coop = findCoop(await askInt("Coop id: "));
  if (coop === null) {
    console.log("There is no coop with that id.");
  }
  return coop;
}

function formatDate(date) {
  const month = String(date.getMonth() + 1).padStart(2, "0");
  const day = String(date.getDate()).padStart(2, "0");
  return `${date.getFullYear()}-${month}-${day}`;
}

function restoreIndexes() {
  chickenFarmer.resetIteration();
  while (chickenFarmer.next() !== null);
  for (const coop of chickenFarmer.coops) {
    if (coop !== null) {
      coop.resetIteration();
      while (coop.next() !== null);
    }
  }
}

async function addCoop() {
  const coopId = await askInt("New coop id: ");
  if (findCoop(coopId) !== null) {
    console.log("A coop with that id already exists.");
    return;
  }
  chickenFarmer.add(new ChickenCoop(coopId, new Array(10).fill(null)));
}

async function removeCoop() {
  const coop = await askExistingCoop();
  if (coop !== null) {
    chickenFarmer.remove(coop.chickenCoopId);
    console.log("Coop removed.");
  }
}

async function addChicken() {
  const coop = await askExistingCoop();
  if (coop === null) return;

  const id = await askInt("Chicken id: ");
  if (findChicken(coop, id) !== null) {
    console.log("A chicken with that id already exists in this coop.");
    return;
  }
  const name = await askText("Name: ");
  const color = await askText("Color: ");
  const bornOnDate = await askDate("Date of birth (YYYY-MM-DD): ");
  const molting = await askYesNo("Is it molting?");

  coop.add(new Chicken(id, name, color, bornOnDate, molting));
}

async function removeChicken() {
  const coop = await askExistingCoop();
  if (coop === null) return;

  const chickenId = await askInt("Chicken id: ");
  if (findChicken(coop, chickenId) === null) {
    console.log("There is no chicken with that id in this coop.");
    return;
  }
  coop.remove(chickenId);
  console.log("Chicken removed.");
}

function showFarm() {
  console.log(`\nFarm of ${chickenFarmer.name} (id ${chickenFarmer.chickenFarmerId})`);

  let coopCount = 0;
  chickenFarmer.resetIteration();
  let coop;
  while ((coop = chickenFarmer.next()) !== null) {
    coopCount++;
    console.log(`  Coop ${coop.chickenCoopId}`);

    let chickenCount = 0;
    coop.resetIteration();
    let chicken;
    while ((chicken = coop.next()) !== null) {
      chickenCount++;
      console.log(
        `    - [${chicken.id}] ${chicken.name} | ${chicken.color} | born ${formatDate(chicken.bornOnDate)}` +
          ` | age ${chicken.computeAgeInYears()} | molting: ${chicken.molting ? "yes" : "no"}`
      );
    }
    if (chickenCount === 0) {
      console.log("    (no chickens)");
    }
  }
  if (coopCount === 0) {
    console.log("  (no coops)");
  }
}

async function makeChickenDoStuff() {
  const coop = await askExistingCoop();
  if (coop === null) return;

  const chicken = findChicken(coop, await askInt("Chicken id: "));
  if (chicken === null) {
    console.log("There is no chicken with that id in this coop.");
    return;
  }
  chicken.doStuff();
}

async function saveFile(controller, defaultName, saveMethod) {
  const fileName = await askFileName(defaultName);
  controller[saveMethod](chickenFarmer, fileName);
}

async function loadFile(controller, defaultName, loadMethod) {
  const fileName = await askFileName(defaultName);
  const loaded = controller[loadMethod](fileName);
  if (loaded !== null) {
    chickenFarmer = loaded;
    restoreIndexes();
    console.log("Farm loaded successfully.");
  }
}

function showMenu() {
  console.log("\n========== CHICKEN FARM ==========");
  console.log(" 1. Add coop");
  console.log(" 2. Remove coop");
  console.log(" 3. Add chicken to a coop");
  console.log(" 4. Remove chicken from a coop");
  console.log(" 5. View the farm");
  console.log(" 6. Make a chicken do its stuff");
  console.log(" 7. Save to JSON");
  console.log(" 8. Load from JSON");
  console.log(" 9. Save to CSV");
  console.log("10. Load from CSV");
  console.log(" 0. Exit");
}

async function main() {
  console.log("Mateo Dominguez´s Chicken Farm");

  let option = -1;
  while (option !== 0) {
    showMenu();
    option = await askInt("Choose an option: ");

    switch (option) {
      case 1: await addCoop(); break;
      case 2: await removeCoop(); break;
      case 3: await addChicken(); break;
      case 4: await removeChicken(); break;
      case 5: showFarm(); break;
      case 6: await makeChickenDoStuff(); break;
      case 7: await saveFile(jsonController, "chickenfarm.json", "saveToJson"); break;
      case 8: await loadFile(jsonController, "chickenfarm.json", "loadFromJson"); break;
      case 9: await saveFile(csvController, "chickenfarm.csv", "saveToCsv"); break;
      case 10: await loadFile(csvController, "chickenfarm.csv", "loadFromCsv"); break;
      case 0: console.log("Goodbye!"); break;
      default: console.log("Invalid option.");
    }
  }
  rl.close();
}

main();
