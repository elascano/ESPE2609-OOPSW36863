import * as readlineSync from 'readline-sync';
import { Chicken } from '../model/Chicken';
import { Egg } from '../model/Egg';
import { Poop } from '../model/Poop';
import { ChickenCoop } from '../model/ChickenCoop';
import { ChickenFarmer } from '../model/ChickenFarmer';
import { JsonManager } from '../model/JsonManager';
import { CsvManager } from '../model/CsvManager';
import { InputHandler } from '../model/InputHandler';

console.log("Andy Tiban's Chicken Farm");    
console.log("=========================");

let chickens: (Chicken | null)[] = new Array(10).fill(null);

// En TS el mes empieza en 0, así que el mes 4 de Java sigue siendo 4, pero no restamos 1900 al año[cite: 16]
let chicken = new Chicken(2, "Maruja", "white", new Date(2024, 4, 15), false);
let egg = new Egg(1, 'M');
chicken.setAgeInYears();

console.log("my chicken is ->", chicken.toString());
console.log("egg -->", egg.toString());
console.log("egg size-->", egg.getSize());

let localAge = chicken.computeAgeInYears();
console.log(`the age of the chicken ${chicken.getName()} is --> ${localAge}`);
chicken.doStuff();

let poop = new Poop(1, "brown", 'S');
console.log("Poop->", poop.toString());

let chicken1 = new Chicken(1, "Lucy", "brown and white", new Date(2023, 4, 15), true);
chicken1.setAgeInYears();
console.log("chicken ", chicken1.toString());
localAge = chicken1.computeAgeInYears();
console.log(`the age of the chicken ${chicken1.getName()} is --> ${localAge}`);
chicken1.doStuff();

let ageForTheLoop = 0;
for(let i = 3; i < chickens.length; i++){
    ageForTheLoop = 2010 + i;
    chickens[i] = new Chicken(i + 1, `chicken ${i + 1}`, "white", new Date(ageForTheLoop, 3, 3), true);
    chickens[i]!.setAgeInYears(); // El '!' le dice a TS que estamos seguros de que no es nulo aquí
}

chickens[2] = new Chicken(3, "Pepita", "black", new Date(2005, 2, 2), true);
chickens[2]!.setAgeInYears();
chickens[0] = chicken1;
chickens[1] = chicken;

for(let i = 0; i < 10; i++){
    console.log("chickens--->", chickens[i] ? chickens[i]!.toString() : 'null');
}

// Lógica de ChickenCoop[cite: 16]
let chickenCoop1 = new ChickenCoop(1, new Array(10).fill(null)); 
chickenCoop1.add(chicken);  
chickenCoop1.add(chicken1); 

console.log("Taking out of the chicken coop: ", chickenCoop1.next()?.toString());
console.log("taking out of the chicken coop: ", chickenCoop1.next()?.toString());

chickenCoop1.remove(2);

console.log("\n=== Farmer info ===");
let farmer = new ChickenFarmer();
console.log(farmer.toString());
    
// Lógica de Archivos y Consola[cite: 16]
let existingChickens = JsonManager.loadChickens();

let existingCount = 0;
if (existingChickens !== null) {
    for (const c of existingChickens) {
        if (c !== null) existingCount++;
    }
}

console.log("\n=== New Chicken Register ===");
const numberOfChickensToAdd = readlineSync.questionInt("How many chickens do you want to add?: ");

let totalChickens: (Chicken | null)[] = new Array(existingCount + numberOfChickensToAdd).fill(null);
let currentIndex = 0; 

if (existingChickens !== null) {
    for (const c of existingChickens) {
        if (c !== null) {
            totalChickens[currentIndex] = c;
            currentIndex++;
        }
    }
}

for(let i = 0; i < numberOfChickensToAdd; i++) {
    console.log(`\n--- Entering new chicken data N.${i + 1} ---`);
    totalChickens[currentIndex] = InputHandler.createChickenFromConsole(totalChickens);
    currentIndex++; 
}

JsonManager.saveChickens(totalChickens);
CsvManager.saveChickens(totalChickens);

console.log("\n=== Reading chickens from the archive ===");
let loadedChickens = JsonManager.loadChickens();

for (const c of loadedChickens) {
    if (c !== null) {
        c.setAgeInYears();
        console.log(c.toString());
    }
}





/*
====================================================================
CHEAT SHEET - EXAMEN POO (TYPESCRIPT)
====================================================================

PASO 1: CONFIGURAR CARPETA DESDE CERO (Ejecutar en la terminal)
--------------------------------------------------------------------
1. Inicializar Node: 
   npm init -y
   
2. Instalar herramientas y librerías: 
   npm install typescript @types/node readline-sync @types/readline-sync
   
3. Crear archivo tsconfig.json (Arregla rutas de importación): 
   npx tsc --init

PASO 2: SOLUCIONAR ERROR ROJO EN "export" (Solo si aparece)
--------------------------------------------------------------------
1. Abrir el archivo tsconfig.json
2. Buscar la línea: "verbatimModuleSyntax": true
3. Cambiar la palabra true por false (o poner // al inicio de la línea)

PASO 3: COMPILAR Y EJECUTAR (Cada vez que modifiques el código)
--------------------------------------------------------------------
1. Traducir los archivos .ts a .js:
   npx tsc
   
2. Ejecutar el programa final:
   node view/ChickenFarmApp.js
   
====================================================================
*/