const path = require("path");
const fileManager = require("./fileManager");
const ChickenFarmer = require("./ChickenFarmer");
const { ask, closeInput, readInt } = require("./helpers");

// the files are saved in the same folder as this main.js
const JSON_FILE = path.join(__dirname, "chickens.json");
const CSV_FILE = path.join(__dirname, "chickens.csv");

function showMenu() {
  console.log("\n========= MENU =========");
  console.log("1. Register farmer, coops and chickens (keyboard)");
  console.log("2. Show the farmer");
  console.log("3. Save the chickens in JSON");
  console.log("4. Read the chickens from JSON");
  console.log("5. Save the chickens in CSV");
  console.log("6. Read the chickens from CSV");
  console.log("0. Exit");
}

function showChickens(chickens) {
  for (let i = 0; i < chickens.length; i++) {
    console.log(`chicken ${i + 1} --> ${chickens[i]}`);
  }
}

function saveChickens(chickens, filePath, saveFunction) {
  try {
    saveFunction(chickens, filePath);
    console.log(`${chickens.length} chickens saved in ${filePath}`);
  } catch (error) {
    console.log("The file could not be saved:", error.message);
  }
}

function loadChickens(filePath, loadFunction) {
  try {
    const chickens = loadFunction(filePath);
    console.log(`${chickens.length} chickens read from ${filePath}`);
    return chickens;
  } catch (error) {
    if (error.code === "ENOENT") {
      console.log("The file does not exist yet, save it first");
    } else {
      console.log("The file could not be read:", error.message);
    }
    return [];
  }
}

async function main() {
  console.log("Julian Olalla's Chicken Farm App");
  console.log("=================================");

  let farmer = null;
  let option = "";

  while (option !== "0") {
    showMenu();
    option = (await ask("Choose an option: ")).trim();

    if (option === "1") {
      const farmerId = await readInt("Enter the farmer id: ");
      const farmerName = await ask("Enter the farmer name: ");
      farmer = new ChickenFarmer(farmerId, farmerName);
      await farmer.registerCoops();
    } else if (option === "2") {
      if (farmer === null) {
        console.log("First register a farmer (option 1)");
      } else {
        console.log(farmer.toString());
      }
    } else if (option === "3") {
      if (farmer === null) {
        console.log("First register a farmer (option 1)");
      } else {
        saveChickens(farmer.getAllChickens(), JSON_FILE, fileManager.saveJson);
      }
    } else if (option === "4") {
      const loadedChickens = loadChickens(JSON_FILE, fileManager.loadJson);
      showChickens(loadedChickens);
    } else if (option === "5") {
      if (farmer === null) {
        console.log("First register a farmer (option 1)");
      } else {
        saveChickens(farmer.getAllChickens(), CSV_FILE, fileManager.saveCsv);
      }
    } else if (option === "6") {
      const loadedChickens = loadChickens(CSV_FILE, fileManager.loadCsv);
      showChickens(loadedChickens);
    } else if (option === "0") {
      console.log("Bye!");
    } else {
      console.log("Invalid option, try again");
    }
  }

  closeInput();
}

main().catch((error) => {
  console.log(error.message);
  closeInput();
});