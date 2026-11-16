import * as readline from "node:readline/promises";
import { stdin as input, stdout as output } from "node:process";
import { Chicken } from "../model/Chicken";
import { Cow } from "../model/Cow";
import { FarmAnimal } from "../model/FarmAnimal";
import { Food } from "../model/Food";
import { Pig } from "../model/Pig";
import { Sheep } from "../model/Sheep";

async function main(): Promise<void> {
  const bornOnDate = new Date(2020, 9, 10); // en JS los meses van de 0 a 11
  const foodChicken = new Food("Corn");
  const foodCow = new Food("Hay");
  const foodPig = new Food("Barley");
  const foodSheep = new Food("");

  const rl = readline.createInterface({ input, output, terminal: false });
  const lines = rl[Symbol.asyncIterator]();

  console.log("Hello This is Mateo´s Animal Farm!");
  console.log("----------------------------------");

  let running = true;
  while (running) {
    console.log("Select one option:");
    console.log("1. Chickens");
    console.log("2. Cows");
    console.log("3. Sheep");
    console.log("4. Pig");
    console.log("5. Others (class)");
    console.log("6. Exit");

    const next = await lines.next();
    if (next.done) break;
    const option = Number.parseInt(next.value.trim(), 10);

    switch (option) {
      case 1: {
        const chicken1 = new Chicken(true, 10, true, 2, "Paleesh", new Date());
        console.log("chicken ---> " + chicken1);
        chicken1.layAnEgg();
        chicken1.feed(foodChicken, 2);
        break;
      }
      case 2: {
        const cow1 = new Cow(true, 100.5, 8, "", bornOnDate);
        console.log("cow ---> " + cow1);
        cow1.milk();
        cow1.milk(10);
        cow1.milk(3.2);
        cow1.milk(1, new Date());
        cow1.feed(foodCow, 1);
        break;
      }
      case 3: {
        const sheep1 = new Sheep(new Date(), 10.6, 1, "Merino", bornOnDate);
        console.log("sheep ---> " + sheep1);
        sheep1.shearing(2.3);
        console.log("sheep producing ---> " + sheep1.weightWool);
        sheep1.feed(foodSheep, 3);
        break;
      }
      case 4: {
        const pig1 = new Pig(true, 1, "Yorkshire", bornOnDate);
        console.log("pigs ---> " + pig1);
        pig1.wallowing();
        pig1.rooting();
        pig1.feed(foodPig, 5);
        break;
      }
      case 5: {
        const chicken: FarmAnimal = new Chicken(true, 21, true, 1, "Paleesh", bornOnDate);
        console.log("FarmAnimal is a ---> " + chicken.constructor.name);
        console.log("my farm animal ---> " + chicken);

        const farmAnimalForFeeding: FarmAnimal = new Cow(true, 100.5, 3, "", new Date());
        console.log("farmAnimalForFeeding  is a ---> " + farmAnimalForFeeding.constructor.name);
        break;
      }
      case 6: {
        console.log("Goodbye!!");
        running = false;
        break;
      }
      default:
        console.log("Wrong option");
    }
  }
  rl.close();
}

main();
