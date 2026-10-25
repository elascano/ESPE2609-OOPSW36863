const readline = require("readline/promises");
const Chicken = require("./model/Chicken");
const ChickenCoop = require("./model/ChickenCoop");
const Egg = require("./model/Egg");
const Poop = require("./model/Poop");


async function main() {
  const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
  });

  console.log("Nohemi Tocagon's Chicken Farm");
  console.log("=============================");



  const chicken = new Chicken(2, "Maruja", "white", new Date(2024, 7, 15), false);
  const egg = new Egg(1, "M");
  console.log(`My chicken is --> ${chicken}`);
  console.log(`egg --> ${egg}`);
  console.log(`egg.size --> ${egg.size}`);

  const poop = new Poop(1, "brown", "S");
  console.log(`poop --> ${poop}`);

  const chicken1 = new Chicken(1, "Lucy", "brown and white", new Date(), false);
  console.log(`chicken 1 --> ${chicken1}`);

  console.log(`the age of the chicken --> ${chicken.name}, is --> ${chicken.computeAgeInYears()}`);
  chicken.doStuff();

  coop.add(chicken);
  coop.add(chicken1);

  console.log("--- BEFORE ---");
  for (const c of coop.chickens) {
    console.log(String(c));
  }

  coop.remove(2);

  console.log("--- AFTER ---");
  for (const c of coop.chickens) {
    console.log(String(c));
  }

  let position = 0;
  let option = 0;

  while (option !== 6) {
    console.log("=====CHICKENFARM APP MENU=====");
    console.log("1. Add chicken");
    console.log("2. Remove chicken");
    console.log("3. Next chicken");
    console.log("4. Convert file into JSON");
    console.log("5. Convert file into CSV");
    console.log("6. Exit");
    option = parseInt(await rl.question("Option (1-6): "));

    switch (option) {
      case 1:
        await coop.addFromInput(rl);
        break;
      case 2:
        coop.remove(parseInt(await rl.question("ID to remove: ")));
        break;
      case 3: {
        const c = coop.next(position);
        if (c !== null) {
          console.log(c.toJson());
          position++;
        } else {
          console.log("There's no more chickens");
          position = 0;
        }
        break;
      }
      case 4:
        console.log("CONTENT FROM JSON");
        console.log(chicken.toJson());
        break;
      case 5:
        console.log("CONTENT FROM CSV");
        console.log(chicken.toCsv());
        break;
      case 6:
        console.log("Leaving...");
        break;
      default:
        console.log("Error, it is necessary to choose one option!!");
    }
  }

  rl.close();
}

main();