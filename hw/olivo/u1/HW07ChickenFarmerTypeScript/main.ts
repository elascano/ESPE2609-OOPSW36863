import * as fs from 'fs';
import * as readline from 'readline';
import { ChickenFarmer } from './chicken_farmer';
import { ChickenCoop } from './chicken_coop';
import { Chicken } from './chicken';

const DB_FILE = 'farm_data.json';
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const question = (query: string): Promise<string> => {
    return new Promise((resolve) => rl.question(query, resolve));
};

function saveData(farmers: ChickenFarmer[]): void {
    try {
        const data = farmers.map(f => f.toDict());
        fs.writeFileSync(DB_FILE, JSON.stringify(data, null, 4), 'utf-8');
        console.log("Data successfully saved to JSON!");
    } catch (e) {
        console.error(`Error saving data: ${e}`);
    }
}

function loadData(): ChickenFarmer[] {
    if (!fs.existsSync(DB_FILE)) {
        return [];
    }
    try {
        const fileContent = fs.readFileSync(DB_FILE, 'utf-8');
        const data = JSON.parse(fileContent);
        const farmers = data.map((fData: any) => ChickenFarmer.fromDict(fData));
        console.log(`Data successfully loaded from ${DB_FILE}!`);
        return farmers;
    } catch (e) {
        console.error(`Error loading data: ${e}`);
        return [];
    }
}

function viewChickenFarmers(farmers: ChickenFarmer[]): void {
    if (farmers.length === 0) {
        console.log("No chicken farmers registered yet.");
    } else {
        console.log("\n--- Registered Farmers ---");
        farmers.forEach((farmer, index) => {
            console.log(`${index + 1}. ${farmer.toString()}`);
        });
    }
}

async function validateOptions(message: string = "Choose an option: "): Promise<number | null> {
    const input = await question(message);
    const num = parseInt(input.trim(), 10);
    if (isNaN(num)) {
        console.log("Please enter a valid number.");
        return null;
    }
    return num;
}

async function selectFarmer(farmers: ChickenFarmer[]): Promise<ChickenFarmer | null> {
    if (farmers.length === 0) {
        console.log("No chicken farmers registered yet.");
        return null;
    }
    console.log("\n--- Select Farmer ---");
    viewChickenFarmers(farmers);
    const selection = await validateOptions("Enter the number of the farmer: ");

    if (selection !== null && selection >= 1 && selection <= farmers.length) {
        return farmers[selection - 1];
    }
    console.log("Invalid farmer selection.");
    return null;
}

async function selectCoop(farmer: ChickenFarmer): Promise<ChickenCoop | null> {
    if (farmer.coops.length === 0) {
        console.log(`Farmer ${farmer.name} has no coops yet.`);
        return null;
    }

    console.log(`\n--- Select Coop for ${farmer.name} ---`);
    farmer.coops.forEach((coop, index) => {
        console.log(`${index + 1}. Coop ID: ${coop.id} (Total chickens: ${coop.chickens.length})`);
    });

    const coopIdx = await validateOptions("Enter the number of the coop: ");
    if (coopIdx !== null && coopIdx >= 1 && coopIdx <= farmer.coops.length) {
        return farmer.coops[coopIdx - 1];
    }

    console.log("Invalid coop selection.");
    return null;
}

function viewChickensInCoop(coop: ChickenCoop): void {
    if (coop.chickens.length === 0) {
        console.log(`Coop #${coop.id} has no chickens yet.`);
    } else {
        console.log(`\n--- Chickens in Coop #${coop.id} ---`);
        coop.chickens.forEach((chicken, index) => {
            console.log(`${index + 1}. ${chicken.toString()}`);
        });
    }
}

async function main() {
    const farmers: ChickenFarmer[] = loadData();

    while (true) {
        console.log("\n=================Chicken Farmer App====================");
        console.log("1. Add Chicken Farmer");
        console.log("2. View Chicken Farmers");
        console.log("3. Add Coops");
        console.log("4. Add chickens to the Chicken Coop");
        console.log("5. View chickens in a Chicken Coop");
        console.log("6. Exit");
        console.log("========================================================");

        const opc = await validateOptions();
        if (opc === null) continue;

        switch (opc) {
            case 1: {
                const name = await question("Enter your name: ");
                const newFarmer = new ChickenFarmer(name.trim());
                farmers.push(newFarmer);
                console.log(`Chicken Farmer '${name}' added successfully!`);
                break;
            }
            case 2:
                viewChickenFarmers(farmers);
                break;
            case 3: {
                console.log("Add Coops from Chicken Farmer");
                const farmerSelection = await selectFarmer(farmers);
                if (farmerSelection !== null) {
                    const newCoop = new ChickenCoop();
                    farmerSelection.addCoop(newCoop);
                    console.log(`Coop successfully added to farmer ${farmerSelection.name}!`);
                }
                break;
            }
            case 4: {
                console.log("Add Chickens to a Chicken Coop");
                const farmerSelection = await selectFarmer(farmers);
                if (farmerSelection !== null) {
                    if (farmerSelection.coops.length === 0) {
                        console.log(`Farmer ${farmerSelection.name} has no coops yet. Please add a coop first (Option 3).`);
                    } else {
                        const coopSelection = await selectCoop(farmerSelection);
                        if (coopSelection !== null) {
                            const name = await question("Chicken name: ");
                            const color = await question("Chicken color: ");
                            const bornOnDate = await question("Born on date (YYYY-MM-DD): ");
                            const moltingInput = (await question("Is it molting? (y/n): ")).trim().toLowerCase();
                            const molting = moltingInput === 'y';

                            const newChicken = new Chicken(name.trim(), color.trim(), bornOnDate.trim(), molting);
                            coopSelection.addChicken(newChicken);
                            console.log(`Chicken '${name}' successfully added to Coop #${coopSelection.id}!`);
                        }
                    }
                }
                break;
            }
            case 5: {
                console.log("View Chickens in a Coop");
                const farmerSelection = await selectFarmer(farmers);
                if (farmerSelection !== null) {
                    const coopSelection = await selectCoop(farmerSelection);
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
}

main();