import * as fs from 'fs';
import * as readline from 'readline/promises';
import { stdin as input, stdout as output } from 'process';

import { FarmAnimal } from '../model/FarmAnimal';
import { Chicken } from '../model/Chicken';
import { Cow } from '../model/Cow';
import { Sheep } from '../model/Sheep';
import { Pig } from '../model/Pig';
import { Food } from '../model/Food';
import { Medicine } from '../model/Medicine';
import { MedicineRecord } from '../model/MedicineRecord';

const DATA_FILE = "./farm_data.json";
const rl = readline.createInterface({ input, output });

function saveData(animalFarmer: FarmAnimal[], foodInventory: Food[]) {
    const data = {
        food_inventory: foodInventory.map(f => ({ id: f.getId(), name: f.getName() })),
        animals: animalFarmer.map(animal => {
            const base: any = {
                id: animal.getId(),
                type: animal.constructor.name,
                breed: animal.getBreed(),
                born_on_date: animal.getBornOnDate().toISOString().split('T')[0],
                weight_in_kg: animal.getWeightInKg(),
                sex: animal.getSex(),
                is_meat: animal.getIsMeat(),
                medicines_record: animal.getMedicinesRecord().map(r => ({
                    id: r.getId(),
                    date: r.getDate().toISOString().split('T')[0],
                    medicines: r.getMedicine().map(m => ({
                        id: m.getId(),
                        name: m.getName(),
                        description: m.getDescription(),
                        price: m.getPrice()
                    }))
                }))
            };

            if (animal instanceof Chicken) {
                base.is_molting = animal.getIsMolting();
                base.number_of_laid_eggs = animal.getNumberOfLaidEggs();
                base.type_chicken = animal.getTypeChicken();
            } else if (animal instanceof Cow) {
                base.pregnant = animal.getPregnant();
                base.is_producing_milk = animal.getIsProducingMilk();
                base.liters_of_milk_per_week = animal.getLitersOfMilkPerWeek();
            } else if (animal instanceof Sheep) {
                base.pregnant = animal.getPregnant();
                base.last_shearing = animal.getLastShearing().toISOString().split('T')[0];
            } else if (animal instanceof Pig) {
                base.pregnant = animal.getPregnant();
                base.is_market_ready = animal.getIsMarketReady();
            }
            return base;
        })
    };

    try {
        fs.writeFileSync(DATA_FILE, JSON.stringify(data, null, 4));
    } catch (e) {
        console.log(`[Error saving data]: ${e}`);
    }
}

function loadData(): { animalFarmer: FarmAnimal[], foodInventory: Food[] } {
    let animalFarmer: FarmAnimal[] = [];
    let foodInventory: Food[] = [];

    if (!fs.existsSync(DATA_FILE)) {
        return { animalFarmer, foodInventory };
    }

    try {
        const fileContent = fs.readFileSync(DATA_FILE, 'utf-8');
        const data = JSON.parse(fileContent);

        for (const f of (data.food_inventory || [])) {
            foodInventory.push(new Food(f.name, f.id));
        }

        for (const a of (data.animals || [])) {
            const bornDate = new Date(a.born_on_date);
            const medRecords: MedicineRecord[] = [];

            for (const r of (a.medicines_record || [])) {
                const rDate = new Date(r.date);
                const meds = (r.medicines || []).map((m: any) => new Medicine(m.name, m.description, m.price, m.id));
                medRecords.push(new MedicineRecord(meds, rDate, r.id));
            }

            let animal: FarmAnimal;
            if (a.type === "Chicken") {
                animal = new Chicken(a.is_molting, a.number_of_laid_eggs, a.type_chicken, a.breed, bornDate, a.weight_in_kg, a.sex, medRecords, a.is_meat, a.id);
            } else if (a.type === "Cow") {
                animal = new Cow(a.is_producing_milk, a.liters_of_milk_per_week, a.pregnant, a.breed, bornDate, a.weight_in_kg, a.sex, medRecords, a.is_meat, a.id);
            } else if (a.type === "Sheep") {
                const lastShearing = new Date(a.last_shearing);
                animal = new Sheep(lastShearing, a.pregnant, a.breed, bornDate, a.weight_in_kg, a.sex, medRecords, a.is_meat, a.id);
            } else if (a.type === "Pig") {
                animal = new Pig(a.is_market_ready, a.pregnant, a.breed, bornDate, a.weight_in_kg, a.sex, medRecords, a.is_meat, a.id);
            } else {
                continue;
            }
            animalFarmer.push(animal);
        }
        console.log(`[Info] Loaded ${animalFarmer.length} animals and ${foodInventory.length} food types from ${DATA_FILE}.`);
    } catch (e) {
        console.log(`[Error loading data]: ${e}`);
    }

    return { animalFarmer, foodInventory };
}

async function ask(query: string): Promise<string> {
    return await rl.question(query);
}

async function getYesNo(prompt: string): Promise<boolean> {
    const res = await ask(`${prompt} (y/n): `);
    return res.trim().toLowerCase() === 'y';
}

async function getBirthDate(): Promise<Date> {
    console.log("\n--- Enter Birth Date ---");
    while (true) {
        try {
            const day = parseInt(await ask("Day (1-31): "));
            const month = parseInt(await ask("Month (1-12): ")) - 1;
            const year = parseInt(await ask("Year (e.g., 2026): "));
            const date = new Date(year, month, day);
            if (!isNaN(date.getTime())) return date;
        } catch {}
        console.log("[Error] Invalid date values. Please try again.");
    }
}

function findAnimalById(animalFarmer: FarmAnimal[], id: number): FarmAnimal | undefined {
    return animalFarmer.find(a => a.getId() === id);
}

async function main() {
    const { animalFarmer, foodInventory } = loadData();
    let controller = true;

    while (controller) {
        console.log("\n\tMenu Animal Farmer");
        console.log("=========================================");
        console.log("1. View Farmer Animals");
        console.log("2. Add New Farmer Animal");
        console.log("3. View Type Object (Animal Counts)");
        console.log("4. Add Medicine Record");
        console.log("5. Add Type Food");
        console.log("6. View Animal Medical History");
        console.log("0. Exit & Save");
        console.log("=========================================");

        const optionStr = await ask("Select the Option: ");
        const option = parseInt(optionStr);

        if (isNaN(option)) {
            console.log("Please select a correct option.");
            continue;
        }

        if (option === 1) {
            if (animalFarmer.length === 0) {
                console.log("\n[Info] No animals registered in the farm yet.");
            } else {
                console.log("\n--- List of Farm Animals ---");
                animalFarmer.forEach(a => console.log(a.toString()));
            }
        } else if (option === 2) {
            console.log("=========================================");
            console.log("1. Add Chicken");
            console.log("2. Add Cow");
            console.log("3. Add Sheep");
            console.log("4. Add Pig");
            console.log("=========================================");
            const subOpt = parseInt(await ask("Select the Option: "));

            if ([1, 2, 3, 4].includes(subOpt)) {
                console.log("\n--- Enter Common Animal Details ---");
                const breed = await ask("Breed: ");
                const weight = parseFloat(await ask("Weight in kg: "));
                const sex = await ask("Sex (M/F): ");
                const isMeat = await getYesNo("Is meat animal?");
                const bornDate = await getBirthDate();

                let newAnimal: FarmAnimal | undefined;

                if (subOpt === 1) {
                    const isMolting = await getYesNo("Is molting?");
                    const eggs = parseInt(await ask("Number of laid eggs: "));
                    const chickenType = await ask("Type of chicken (e.g., broiler, layer): ");
                    newAnimal = new Chicken(isMolting, eggs, chickenType, breed, bornDate, weight, sex, [], isMeat);
                } else if (subOpt === 2) {
                    const pregnant = await getYesNo("Is pregnant?");
                    const isMilk = await getYesNo("Is producing milk?");
                    const milkLiters = parseFloat(await ask("Liters of milk per week: "));
                    newAnimal = new Cow(isMilk, milkLiters, pregnant, breed, bornDate, weight, sex, [], isMeat);
                } else if (subOpt === 3) {
                    const pregnant = await getYesNo("Is pregnant?");
                    newAnimal = new Sheep(bornDate, pregnant, breed, bornDate, weight, sex, [], isMeat);
                } else if (subOpt === 4) {
                    const pregnant = await getYesNo("Is pregnant?");
                    const marketReady = await getYesNo("Is market ready?");
                    newAnimal = new Pig(marketReady, pregnant, breed, bornDate, weight, sex, [], isMeat);
                }

                if (newAnimal) {
                    animalFarmer.push(newAnimal);
                    console.log("\nSuccessfully added new animal to the farm!");
                }
            } else {
                console.log("\n[Error] Invalid animal choice.");
            }
        } else if (option === 3) {
            if (animalFarmer.length === 0) {
                console.log("\n[Info] No animals registered to count.");
            } else {
                const chickens = animalFarmer.filter(a => a instanceof Chicken).length;
                const cows = animalFarmer.filter(a => a instanceof Cow).length;
                const sheep = animalFarmer.filter(a => a instanceof Sheep).length;
                const pigs = animalFarmer.filter(a => a instanceof Pig).length;

                console.log("\n--- Farm Animal Type Summary ---");
                console.log(`Chickens: ${chickens}`);
                console.log(`Cows: ${cows}`);
                console.log(`Sheep: ${sheep}`);
                console.log(`Pigs: ${pigs}`);
                console.log(`Total Animals: ${animalFarmer.length}`);
            }
        } else if (option === 4) {
            if (animalFarmer.length === 0) {
                console.log("\n[Info] No animals registered. Add an animal first.");
                continue;
            }
            animalFarmer.forEach(a => console.log(a.toString()));
            const idInput = parseInt(await ask("\nEnter the ID of the animal to add medicine record: "));
            const animal = findAnimalById(animalFarmer, idInput);
            if (!animal) {
                console.log(`\n[Error] No animal found with ID ${idInput}.`);
                continue;
            }

            console.log("\n--- Enter Medicine Details ---");
            const medName = await ask("Medicine Name: ");
            const medDesc = await ask("Description: ");
            const medPrice = parseFloat(await ask("Price: "));

            const med = new Medicine(medName, medDesc, medPrice);
            const today = new Date();
            const record = new MedicineRecord([med], today);

            animal.getMedicinesRecord().push(record);
            med.administer();
            const nextDate = animal.computeNextMedicineDate(today);
            console.log(`[Success] Medicine record added! Next scheduled medicine date: ${nextDate.toISOString().split('T')[0]}`);
        } else if (option === 5) {
            console.log("\n--- Add New Food Type ---");
            const foodName = await ask("Enter food name (e.g., Corn, Hay, Pellets): ");
            if (!foodName.trim()) {
                console.log("[Error] Food name cannot be empty.");
                continue;
            }
            const food = new Food(foodName.trim());
            foodInventory.push(food);
            console.log(`[Success] Added food: ${food.toString()}`);

            if (animalFarmer.length > 0 && await getYesNo("Do you want to feed an animal with this food now?")) {
                animalFarmer.forEach(a => console.log(a.toString()));
                const idInput = parseInt(await ask("Enter the ID of the animal to feed: "));
                const animal = findAnimalById(animalFarmer, idInput);
                if (!animal) {
                    console.log(`\n[Error] No animal found with ID ${idInput}.`);
                    continue;
                }
                const amount = parseFloat(await ask("Amount of food in kg: "));
                animal.feed(food, amount);
            }
        } else if (option === 6) {
            if (animalFarmer.length === 0) {
                console.log("\n[Info] No animals registered in the farm yet.");
                continue;
            }
            animalFarmer.forEach(a => console.log(a.toString()));
            const idInput = parseInt(await ask("\nEnter the ID of the animal to view its medical history: "));
            const animal = findAnimalById(animalFarmer, idInput);
            if (!animal) {
                console.log(`\n[Error] No animal found with ID ${idInput}.`);
                continue;
            }

            console.log(`\n--- Medical History for Animal ID: ${animal.getId()} (${animal.constructor.name}) ---`);
            const records = animal.getMedicinesRecord();
            if (records.length === 0) {
                console.log("This animal has no medical records registered.");
            } else {
                records.forEach(r => {
                    const dateStr = r.getDate().toISOString().split('T')[0];
                    console.log(`\nRecord ID: ${r.getId()} | Date: ${dateStr}`);
                    console.log("Medicines administered:");
                    r.getMedicine().forEach(m => {
                        console.log(`  - Name: ${m.getName()} | Description: ${m.getDescription()} | Price: $${m.getPrice()}`);
                    });
                });
            }
        } else if (option === 0) {
            saveData(animalFarmer, foodInventory);
            console.log("\nData saved successfully. Exiting program. Goodbye!");
            controller = false;
        } else {
            console.log("\nInvalid option. Please choose between 0 and 6.");
        }
    }
    rl.close();
}

if (require.main === module) {
    main();
}