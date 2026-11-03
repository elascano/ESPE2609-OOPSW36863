"use strict";
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    var desc = Object.getOwnPropertyDescriptor(m, k);
    if (!desc || ("get" in desc ? !m.__esModule : desc.writable || desc.configurable)) {
      desc = { enumerable: true, get: function() { return m[k]; } };
    }
    Object.defineProperty(o, k2, desc);
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || (function () {
    var ownKeys = function(o) {
        ownKeys = Object.getOwnPropertyNames || function (o) {
            var ar = [];
            for (var k in o) if (Object.prototype.hasOwnProperty.call(o, k)) ar[ar.length] = k;
            return ar;
        };
        return ownKeys(o);
    };
    return function (mod) {
        if (mod && mod.__esModule) return mod;
        var result = {};
        if (mod != null) for (var k = ownKeys(mod), i = 0; i < k.length; i++) if (k[i] !== "default") __createBinding(result, mod, k[i]);
        __setModuleDefault(result, mod);
        return result;
    };
})();
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    function adopt(value) { return value instanceof P ? value : new P(function (resolve) { resolve(value); }); }
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : adopt(result.value).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
Object.defineProperty(exports, "__esModule", { value: true });
const fs = __importStar(require("fs"));
const readline = __importStar(require("readline"));
const chicken_farmer_1 = require("./chicken_farmer");
const chicken_coop_1 = require("./chicken_coop");
const chicken_1 = require("./chicken");
const DB_FILE = 'farm_data.json';
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
const question = (query) => {
    return new Promise((resolve) => rl.question(query, resolve));
};
function saveData(farmers) {
    try {
        const data = farmers.map(f => f.toDict());
        fs.writeFileSync(DB_FILE, JSON.stringify(data, null, 4), 'utf-8');
        console.log("Data successfully saved to JSON!");
    }
    catch (e) {
        console.error(`Error saving data: ${e}`);
    }
}
function loadData() {
    if (!fs.existsSync(DB_FILE)) {
        return [];
    }
    try {
        const fileContent = fs.readFileSync(DB_FILE, 'utf-8');
        const data = JSON.parse(fileContent);
        const farmers = data.map((fData) => chicken_farmer_1.ChickenFarmer.fromDict(fData));
        console.log(`Data successfully loaded from ${DB_FILE}!`);
        return farmers;
    }
    catch (e) {
        console.error(`Error loading data: ${e}`);
        return [];
    }
}
function viewChickenFarmers(farmers) {
    if (farmers.length === 0) {
        console.log("No chicken farmers registered yet.");
    }
    else {
        console.log("\n--- Registered Farmers ---");
        farmers.forEach((farmer, index) => {
            console.log(`${index + 1}. ${farmer.toString()}`);
        });
    }
}
function validateOptions() {
    return __awaiter(this, arguments, void 0, function* (message = "Choose an option: ") {
        const input = yield question(message);
        const num = parseInt(input.trim(), 10);
        if (isNaN(num)) {
            console.log("Please enter a valid number.");
            return null;
        }
        return num;
    });
}
function selectFarmer(farmers) {
    return __awaiter(this, void 0, void 0, function* () {
        if (farmers.length === 0) {
            console.log("No chicken farmers registered yet.");
            return null;
        }
        console.log("\n--- Select Farmer ---");
        viewChickenFarmers(farmers);
        const selection = yield validateOptions("Enter the number of the farmer: ");
        if (selection !== null && selection >= 1 && selection <= farmers.length) {
            return farmers[selection - 1];
        }
        console.log("Invalid farmer selection.");
        return null;
    });
}
function selectCoop(farmer) {
    return __awaiter(this, void 0, void 0, function* () {
        if (farmer.coops.length === 0) {
            console.log(`Farmer ${farmer.name} has no coops yet.`);
            return null;
        }
        console.log(`\n--- Select Coop for ${farmer.name} ---`);
        farmer.coops.forEach((coop, index) => {
            console.log(`${index + 1}. Coop ID: ${coop.id} (Total chickens: ${coop.chickens.length})`);
        });
        const coopIdx = yield validateOptions("Enter the number of the coop: ");
        if (coopIdx !== null && coopIdx >= 1 && coopIdx <= farmer.coops.length) {
            return farmer.coops[coopIdx - 1];
        }
        console.log("Invalid coop selection.");
        return null;
    });
}
function viewChickensInCoop(coop) {
    if (coop.chickens.length === 0) {
        console.log(`Coop #${coop.id} has no chickens yet.`);
    }
    else {
        console.log(`\n--- Chickens in Coop #${coop.id} ---`);
        coop.chickens.forEach((chicken, index) => {
            console.log(`${index + 1}. ${chicken.toString()}`);
        });
    }
}
function main() {
    return __awaiter(this, void 0, void 0, function* () {
        const farmers = loadData();
        while (true) {
            console.log("\n=================Chicken Farmer App====================");
            console.log("1. Add Chicken Farmer");
            console.log("2. View Chicken Farmers");
            console.log("3. Add Coops");
            console.log("4. Add chickens to the Chicken Coop");
            console.log("5. View chickens in a Chicken Coop");
            console.log("6. Exit");
            console.log("========================================================");
            const opc = yield validateOptions();
            if (opc === null)
                continue;
            switch (opc) {
                case 1: {
                    const name = yield question("Enter your name: ");
                    const newFarmer = new chicken_farmer_1.ChickenFarmer(name.trim());
                    farmers.push(newFarmer);
                    console.log(`Chicken Farmer '${name}' added successfully!`);
                    break;
                }
                case 2:
                    viewChickenFarmers(farmers);
                    break;
                case 3: {
                    console.log("Add Coops from Chicken Farmer");
                    const farmerSelection = yield selectFarmer(farmers);
                    if (farmerSelection !== null) {
                        const newCoop = new chicken_coop_1.ChickenCoop();
                        farmerSelection.addCoop(newCoop);
                        console.log(`Coop successfully added to farmer ${farmerSelection.name}!`);
                    }
                    break;
                }
                case 4: {
                    console.log("Add Chickens to a Chicken Coop");
                    const farmerSelection = yield selectFarmer(farmers);
                    if (farmerSelection !== null) {
                        if (farmerSelection.coops.length === 0) {
                            console.log(`Farmer ${farmerSelection.name} has no coops yet. Please add a coop first (Option 3).`);
                        }
                        else {
                            const coopSelection = yield selectCoop(farmerSelection);
                            if (coopSelection !== null) {
                                const name = yield question("Chicken name: ");
                                const color = yield question("Chicken color: ");
                                const bornOnDate = yield question("Born on date (YYYY-MM-DD): ");
                                const moltingInput = (yield question("Is it molting? (y/n): ")).trim().toLowerCase();
                                const molting = moltingInput === 'y';
                                const newChicken = new chicken_1.Chicken(name.trim(), color.trim(), bornOnDate.trim(), molting);
                                coopSelection.addChicken(newChicken);
                                console.log(`Chicken '${name}' successfully added to Coop #${coopSelection.id}!`);
                            }
                        }
                    }
                    break;
                }
                case 5: {
                    console.log("View Chickens in a Coop");
                    const farmerSelection = yield selectFarmer(farmers);
                    if (farmerSelection !== null) {
                        const coopSelection = yield selectCoop(farmerSelection);
                        if (coopSelection !== null) {
                            viewChickensInCoop(coopSelection);
                        }
                    }
                    break;
                }
                case 6:
                    saveData(farmers);
                    console.log("Exiting application. Goodbye!");
                    rl.close();
                    return;
                default:
                    console.log("Invalid option. Please choose between 1 and 6.");
            }
        }
    });
}
main();
