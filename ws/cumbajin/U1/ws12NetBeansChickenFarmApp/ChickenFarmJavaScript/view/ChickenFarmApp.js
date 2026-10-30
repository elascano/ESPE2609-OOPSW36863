const Chicken = require("../model/Chicken");
const ChickenCoop = require("../model/ChickenCoop");
const Egg = require("../model/Egg");
const Poop = require("../model/Poop");
const ChickenFileManager = require("../controller/ChickenFileManager");
const readline = require("readline");

/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */

function main() {
  console.log("Dylan Cumbajin's Chicken Farm");
  console.log("=============================");

  let chicken;
  let egg;
  let poop;
  let chicken1;
  let coop;
  let chickens = new Array(10).fill(null);

  chicken = new Chicken(2, "Maruja", "white", new Date(1970, 11, 17), false);
  chicken.setAgeInYears();

  egg = new Egg(1, "M");

  console.log("my chicken is --> " + chicken.toString());
  console.log("egg --> " + egg.toString());
  console.log("egg size --> " + egg.getSize());

  poop = new Poop(0, "brown", "S");
  console.log("poop --> " + poop.toString());

  chicken1 = new Chicken(
    1,
    "Lucy",
    "brown and white",
    new Date(1970, 11, 17),
    true,
  );
  chicken1.setAgeInYears();

  console.log("chicken 1 --> " + chicken1.toString());

  let localAge = chicken.computeAgeInYears();

  console.log(
    "the age of the chicken --> " + chicken.getName() + ", is --> " + localAge,
  );

  chicken.doStuff();

  chickens[0] = new Chicken(3, "Pepita", "black", new Date(2020, 2, 2), true);
  chickens[1] = chicken;

  for (let i = 0; i < 10; i++) {
    console.log(
      "chickens --> " + (chickens[i] != null ? chickens[i].toString() : null),
    );
  }

  let ageForTheLoop = 0;

  for (let i = 0; i < chickens.length; i++) {
    ageForTheLoop = 2010 + i;

    chickens[i] = new Chicken(
      i,
      "chicken " + (i + 1),
      "white",
      new Date(ageForTheLoop, 3, 3),
      true,
    );

    chickens[i].setAgeInYears();
  }

  for (let i = 0; i < 10; i++) {
    console.log("chickens --> " + chickens[i].toString());
  }

  // Testing ChickenCoop methods
  console.log("\n===== CHICKEN COOP TEST =====");

  coop = new ChickenCoop(1, new Array(10).fill(null));

  // Testing add()
  console.log("\n--- ADD CHICKENS ---");
  coop.add(chicken);
  coop.add(chicken1);

  // Testing next()
  console.log("\n--- LIST CHICKENS ---");
  coop.resetIteration();

  let currentChicken = coop.next();

  while (currentChicken != null) {
    console.log(
      "Chicken --> " +
        currentChicken.getName() +
        ", ID --> " +
        currentChicken.getId(),
    );

    currentChicken = coop.next();
  }

  // Testing remove()
  console.log("\n--- REMOVE CHICKEN ---");
  coop.remove(2);

  // Verify remaining chickens
  console.log("\n--- REMAINING CHICKENS ---");
  coop.resetIteration();

  currentChicken = coop.next();

  while (currentChicken != null) {
    console.log(
      "Chicken --> " +
        currentChicken.getName() +
        ", ID --> " +
        currentChicken.getId(),
    );
    currentChicken = coop.next();
  }

  console.log("\n===== TEST COMPLETED =====");

  // Menu
  const scanner = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
  });

  function showMenu() {
    console.log("\n===== CHICKEN FARM APP =====");
    console.log("1. Save Chickens");
    console.log("2. Read Chickens");
    console.log("3. Exit");

    scanner.question("Select an option: ", function (answer) {
      let option = parseInt(answer);

      switch (option) {
        case 1:
          ChickenFileManager.saveJSON(chickens);
          ChickenFileManager.saveCSV(chickens);
          showMenu();
          break;

        case 2:
          console.log("\n--- CHICKENS FROM JSON ---");

          let jsonChickens = ChickenFileManager.readJSON();

          if (jsonChickens != null) {
            for (let i = 0; i < jsonChickens.length; i++) {
              if (jsonChickens[i] != null) {
                console.log(jsonChickens[i].toString());
              }
            }
          }

          console.log("\n--- CHICKENS FROM CSV ---");

          let csvChickens = ChickenFileManager.readCSV();

          for (let i = 0; i < csvChickens.length; i++) {
            if (csvChickens[i] != null) {
              console.log(csvChickens[i].toString());
            }
          }

          showMenu();
          break;

        case 3:
          console.log("Goodbye!");
          scanner.close();
          break;

        default:
          console.log("Invalid option");
          showMenu();
          break;
      }
    });
  }

  showMenu();
}

main();
