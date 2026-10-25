const readline = require("readline");

const Chicken = require("./Chicken");
const ChickenCoop = require("./ChickenCoop");
const ChickenFarmer = require("./ChickenFarmer");
const Egg = require("./Egg");
const Poop = require("./Poop");

// Lectura de consola: muestra el mensaje y espera una línea (equivale a Scanner.nextLine)
const rl = readline.createInterface({ input: process.stdin });
const lines = rl[Symbol.asyncIterator]();

async function ask(prompt) {
  process.stdout.write(prompt);
  const { value, done } = await lines.next();
  if (done) {
    console.log("\nEnd of input. Goodbye!");
    process.exit(0);
  }
  return value;
}

async function main() {
  console.log("");
  console.log("=============");
  console.log("2026 10 21");

  const chickenFarmer = new ChickenFarmer();
  console.log("chicken farmer --> " + chickenFarmer);
  console.log("");

  const chickensArray = new Array(10).fill(null);
  const coop = new ChickenCoop(1, chickensArray);

  let option = 0;

  // El bucle while mantiene el menú activo hasta que se elija la opción 6
  while (option !== 6) {
    console.log("Verónica Ruiz's Chicken Farm");
    console.log("============================");
    console.log("1. Add chicken");
    console.log("2. Remove chicken");
    console.log("3. Reset chicken iteration");
    console.log("4. Next chicken");
    console.log("5. Show chicken count and list");
    console.log("6. Exit");

    option = parseInt(await ask("Choose an option: "), 10);

    switch (option) {
      case 1: { // Agregar pollo
        const id = parseInt(await ask("Chicken ID: "), 10);
        const name = await ask("Name: ");
        const color = await ask("Color: ");
        const dateInput = await ask("Date of birth (YYYY-MM-DD): ");
        // Dividimos la fecha por los guiones para extraer año, mes y día
        const [year, month, day] = dateInput.split("-").map((p) => parseInt(p, 10));
        const bornDate = new Date(year, month - 1, day); // en JS los meses empiezan en 0
        const moltingInput = await ask("Is the chicken molting? (y/n): ");
        const isMolting = moltingInput.trim().toLowerCase() === "y";

        if (Number.isNaN(id) || Number.isNaN(bornDate.getTime())) {
          console.log("Invalid data. The chicken was not added.");
          break;
        }
        coop.add(new Chicken(id, name, color, bornDate, isMolting));
        break;
      }

      case 2: { // Quitar pollo
        const idToRemove = parseInt(await ask("Enter Chicken ID to remove: "), 10);
        coop.remove(idToRemove);
        break;
      }

      case 3: // Reiniciar iteración
        coop.resetIteration();
        console.log("Chicken iteration has been reset.");
        break;

      case 4: { // Siguiente pollo
        const nextChicken = coop.next();
        if (nextChicken !== null) {
          console.log("Next chicken --> " + nextChicken);
        } else {
          console.log("No more chickens in the iteration loop (or coop is empty).");
        }
        break;
      }

      case 5: { // Mostrar cantidad y lista
        console.log("\n--- Chicken List ---");
        coop.resetIteration(); // Reiniciamos para listar desde el inicio
        let current = coop.next();
        let count = 0;
        while (current !== null) {
          count++;
          console.log("   -> " + current);
          current = coop.next();
        }
        console.log("Total chickens currently in the coop: " + count);
        break;
      }

      case 6: // Salir
        console.log("Exiting Chicken Farm App. Goodbye!");
        break;

      default:
        console.log("Invalid option! Please choose a number between 1 and 6.");
    }
  }

  rl.close(); // Cerramos la interfaz al terminar el menú

  // ---- Segunda parte del programa original ----
  const chickens = new Array(10).fill(null);
  const chicken = new Chicken(1, "Laura", "white", new Date(1970, 11, 17), false); // 17 dic 1970
  const egg = new Egg(1, "M");

  console.log("my chicken is --> " + chicken);
  console.log("egg --> " + egg);
  console.log("egg size --> " + egg.getSize());

  const poop = new Poop(1, "brown", "S");
  console.log("poop --> " + poop);
  const chicken1 = new Chicken(1, "Lucy", "brown and white", new Date(1970, 11, 17), true);
  console.log("chicken 1 --> " + chicken1);

  const localAge = chicken.computeAgeInYears();
  console.log(`the age of the chicken --> ${chicken.getName()}, is --> ${localAge}`);

  chicken.doStuff();
  chickens[0] = new Chicken(3, "Pepita", "black", new Date(2020, 1, 2), true);
  chickens[1] = chicken;

  for (let i = 0; i < 10; i++) {
    console.log("chickens -->" + chickens[i]);
  }

  for (let i = 0; i < chickens.length; i++) {
    const ageForTheLoop = 2010 + i;
    chickens[i] = new Chicken(i, "chicken " + (i + 1), "white", new Date(2020, 2, 3), true);
    chickens[i].setAgeInYears(i);
  }

  for (let i = 0; i < 10; i++) {
    console.log("chickens -->" + chickens[i]);
  }
}

main();