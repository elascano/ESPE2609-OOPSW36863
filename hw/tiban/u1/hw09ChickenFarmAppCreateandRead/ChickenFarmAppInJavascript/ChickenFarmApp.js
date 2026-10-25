import * as readline from 'readline/promises';
import { stdin as input, stdout as output } from 'process';

import { Chicken } from './model/Chicken.js';
import { ChickenCoop } from './model/ChickenCoop.js';
import { ChickenFarmer } from './model/ChickenFarmer.js';
import { Egg } from './model/Egg.js';
import { Poop } from './model/Poop.js';
import { JsonManager } from './controller/JsonManager.js';
import { CsvManager } from './controller/CsvManager.js';
import { InputHandler } from './view/InputHandler.js';

async function runApp() {
    console.log("Andy Tiban's Chicken Farm");
    console.log("=========================");
    
    const chicken = new Chicken(2, "Maruja", "white", new Date(2024, 4, 15), false);
    const egg = new Egg(1, 'M');
    chicken.setAgeInYears();
    console.log(`my chicken is -> ${chicken.toString()}`);
    console.log(`egg --> ${egg.toString()}`);
    console.log(`egg size--> ${egg.size}`);
    
    let localAge = chicken.computeAgeInYears();
    console.log(`the age of the chicken ${chicken.name} is --> ${localAge}`);
    chicken.doStuff();
    
    const poop = new Poop(1, "brown", 'S');
    console.log(`Poop-> ${poop.toString()}`);
    
    const chicken1 = new Chicken(1, "Lucy", "brown and white", new Date(2023, 4, 15), true);
    chicken1.setAgeInYears();
    console.log(`chicken ${chicken1.toString()}`);
    localAge = chicken1.computeAgeInYears();
    console.log(`the age of the chicken ${chicken1.name} is --> ${localAge}`);
    chicken1.doStuff();
    
    const chickens = [];
    chickens[0] = chicken1;
    chickens[1] = chicken;
    chickens[2] = new Chicken(3, "Pepita", "black", new Date(2005, 2, 2), true);
    chickens[2].setAgeInYears();
    
    for (let i = 3; i < 10; i++) {
        let ageForTheLoop = 2010 + i;
        const newC = new Chicken(i + 1, `chicken ${i + 1}`, "white", new Date(ageForTheLoop, 3, 3), true);
        newC.setAgeInYears();
        chickens.push(newC);
    }
    
    for (let i = 0; i < chickens.length; i++) {
        console.log(`chickens---> ${chickens[i].toString()}`);
    }
    
    const chickenCoop1 = new ChickenCoop(1);
    chickenCoop1.add(chicken);
    chickenCoop1.add(chicken1);
    
    console.log(`Taking out of the chicken coop: ${chickenCoop1.next().toString()}`);
    console.log(`taking out of the chicken coop: ${chickenCoop1.next().toString()}`);
    chickenCoop1.remove(2);
    
    console.log("\n=== Farmer info ===");
    const farmer = new ChickenFarmer();
    console.log(farmer.toString());
    

    let totalChickens = JsonManager.loadChickens();
    
    const rl = readline.createInterface({ input, output });
    const numInput = await rl.question("\nHow many chickens do you want to add?: ");
    const numberOfChickensToAdd = parseInt(numInput, 10);
    rl.close(); 
    
    for (let i = 0; i < numberOfChickensToAdd; i++) {
        console.log(`\n--- Entering new chicken data N.${i + 1} ---`);
        const newChicken = await InputHandler.createChickenFromConsole(totalChickens);
        totalChickens.push(newChicken);
    }
    
    JsonManager.saveChickens(totalChickens);
    CsvManager.saveChickens(totalChickens);
    
    console.log("\n=== Reading chickens from the archive ===");
    const loadedRawData = JsonManager.loadChickens();
    
    for (const data of loadedRawData) {
        const c = new Chicken(data.id, data.name, data.color, new Date(data.bornOnDate), data.molting);
        c.setAgeInYears();
        console.log(c.toString());
    }
}

runApp();