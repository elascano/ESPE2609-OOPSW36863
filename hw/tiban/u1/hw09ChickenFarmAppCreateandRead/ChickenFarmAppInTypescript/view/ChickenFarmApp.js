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
Object.defineProperty(exports, "__esModule", { value: true });
const readlineSync = __importStar(require("readline-sync"));
const Chicken_1 = require("../model/Chicken");
const Egg_1 = require("../model/Egg");
const Poop_1 = require("../model/Poop");
const ChickenCoop_1 = require("../model/ChickenCoop");
const ChickenFarmer_1 = require("../model/ChickenFarmer");
const JsonManager_1 = require("../model/JsonManager");
const CsvManager_1 = require("../model/CsvManager");
const InputHandler_1 = require("../model/InputHandler");
console.log("Andy Tiban's Chicken Farm");
console.log("=========================");
let chickens = new Array(10).fill(null);
// En TS el mes empieza en 0, así que el mes 4 de Java sigue siendo 4, pero no restamos 1900 al año
let chicken = new Chicken_1.Chicken(2, "Maruja", "white", new Date(2024, 4, 15), false);
let egg = new Egg_1.Egg(1, 'M');
chicken.setAgeInYears();
console.log("my chicken is ->", chicken.toString());
console.log("egg -->", egg.toString());
console.log("egg size-->", egg.getSize());
let localAge = chicken.computeAgeInYears();
console.log(`the age of the chicken ${chicken.getName()} is --> ${localAge}`);
chicken.doStuff();
let poop = new Poop_1.Poop(1, "brown", 'S');
console.log("Poop->", poop.toString());
let chicken1 = new Chicken_1.Chicken(1, "Lucy", "brown and white", new Date(2023, 4, 15), true);
chicken1.setAgeInYears();
console.log("chicken ", chicken1.toString());
localAge = chicken1.computeAgeInYears();
console.log(`the age of the chicken ${chicken1.getName()} is --> ${localAge}`);
chicken1.doStuff();
let ageForTheLoop = 0;
for (let i = 3; i < chickens.length; i++) {
    ageForTheLoop = 2010 + i;
    chickens[i] = new Chicken_1.Chicken(i + 1, `chicken ${i + 1}`, "white", new Date(ageForTheLoop, 3, 3), true);
    chickens[i].setAgeInYears(); // El '!' le dice a TS que estamos seguros de que no es nulo aquí
}
chickens[2] = new Chicken_1.Chicken(3, "Pepita", "black", new Date(2005, 2, 2), true);
chickens[2].setAgeInYears();
chickens[0] = chicken1;
chickens[1] = chicken;
for (let i = 0; i < 10; i++) {
    console.log("chickens--->", chickens[i] ? chickens[i].toString() : 'null');
}
// Lógica de ChickenCoop[cite: 16]
let chickenCoop1 = new ChickenCoop_1.ChickenCoop(1, new Array(10).fill(null));
chickenCoop1.add(chicken);
chickenCoop1.add(chicken1);
console.log("Taking out of the chicken coop: ", chickenCoop1.next()?.toString());
console.log("taking out of the chicken coop: ", chickenCoop1.next()?.toString());
chickenCoop1.remove(2);
console.log("\n=== Farmer info ===");
let farmer = new ChickenFarmer_1.ChickenFarmer();
console.log(farmer.toString());
// Lógica de Archivos y Consola[cite: 16]
let existingChickens = JsonManager_1.JsonManager.loadChickens();
let existingCount = 0;
if (existingChickens !== null) {
    for (const c of existingChickens) {
        if (c !== null)
            existingCount++;
    }
}
console.log("\n=== New Chicken Register ===");
const numberOfChickensToAdd = readlineSync.questionInt("How many chickens do you want to add?: ");
let totalChickens = new Array(existingCount + numberOfChickensToAdd).fill(null);
let currentIndex = 0;
if (existingChickens !== null) {
    for (const c of existingChickens) {
        if (c !== null) {
            totalChickens[currentIndex] = c;
            currentIndex++;
        }
    }
}
for (let i = 0; i < numberOfChickensToAdd; i++) {
    console.log(`\n--- Entering new chicken data N.${i + 1} ---`);
    totalChickens[currentIndex] = InputHandler_1.InputHandler.createChickenFromConsole(totalChickens);
    currentIndex++;
}
JsonManager_1.JsonManager.saveChickens(totalChickens);
CsvManager_1.CsvManager.saveChickens(totalChickens);
console.log("\n=== Reading chickens from the archive ===");
let loadedChickens = JsonManager_1.JsonManager.loadChickens();
for (const c of loadedChickens) {
    if (c !== null) {
        c.setAgeInYears();
        console.log(c.toString());
    }
}
//# sourceMappingURL=ChickenFarmApp.js.map