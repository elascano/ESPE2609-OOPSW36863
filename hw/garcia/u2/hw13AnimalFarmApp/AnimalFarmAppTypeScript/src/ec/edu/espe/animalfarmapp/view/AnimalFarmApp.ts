import * as readline from "readline";
import { Chicken } from "../model/Chicken";
import { Cow } from "../model/Cow";
import { FarmAnimal } from "../model/FarmAnimal";
import { Pig } from "../model/Pig";
import { Sheep } from "../model/Sheep";

export class AnimalFarmApp {
  private static rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
  });

  private static ask(question: string): Promise<string> {
    return new Promise((resolve) => {
      this.rl.question(question, (answer) => resolve(answer.trim()));
    });
  }

  private static async askBoolean(question: string): Promise<boolean> {
    const answer = (await this.ask(question)).toLowerCase();
    return answer === "true" || answer === "1" || answer === "yes" || answer === "y";
  }

  public static async main(): Promise<void> {
    console.log("Hello, This is Jesus Animal Farm!");

    const farmAnimal: FarmAnimal = new FarmAnimal(1, "holstein", new Date());
    console.log("My farm animal --> " + farmAnimal.toString());

    const chicken: Chicken = new Chicken(true, 10, true, 2, "Paleesh", new Date());
    console.log("Chicken --> " + chicken.toString());

    const cow: Cow = new Cow(true, 100.5, 3, "holstein", new Date(2022, 7, 20));
    console.log("Cow --> " + cow.toString());

    const animals: FarmAnimal[] = [farmAnimal, chicken, cow];
    let option: number;

    do {
      console.log("\n========== ANIMAL FARM MENU ==========");
      console.log("1. Register Cow");
      console.log("2. Register Chicken");
      console.log("3. Register Sheep");
      console.log("4. Register Pig");
      console.log("5. Show All Animals");
      console.log("0. Exit");

      option = parseInt(await this.ask("Select an option: "), 10);

      switch (option) {
        case 1: {
          console.log("\n--- Register Cow ---");
          const cowId = parseInt(await this.ask("Enter ID: "), 10);
          const cowBreed = await this.ask("Enter breed: ");
          const producingMilk = await this.askBoolean("Is producing milk?: ");
          const liters = parseFloat(await this.ask("Liters of milk per week: "));

          const newCow = new Cow(producingMilk, liters, cowId, cowBreed, new Date());
          animals.push(newCow);
          console.log("Cow registered successfully!");
          break;
        }

        case 2: {
          console.log("\n--- Register Chicken ---");
          const chickenId = parseInt(await this.ask("Enter ID: "), 10);
          const chickenBreed = await this.ask("Enter breed: ");
          const molting = await this.askBoolean("Is molting?: ");
          const eggs = parseInt(await this.ask("Number of eggs per month: "), 10);
          const meat = await this.askBoolean("Is it for meat?: ");

          const newChicken = new Chicken(molting, eggs, meat, chickenId, chickenBreed, new Date());
          animals.push(newChicken);
          console.log("Chicken registered successfully!");
          break;
        }

        case 3: {
          console.log("\n--- Register Sheep ---");
          const sheepId = parseInt(await this.ask("Enter ID: "), 10);
          const sheepBreed = await this.ask("Enter breed: ");
          const wool = parseFloat(await this.ask("Wool production in kg: "));
          const sheared = await this.askBoolean("Is it sheared?: ");

          const newSheep = new Sheep(wool, sheared, sheepId, sheepBreed, new Date());
          animals.push(newSheep);
          console.log("Sheep registered successfully!");
          break;
        }

        case 4: {
          console.log("\n--- Register Pig ---");
          const pigId = parseInt(await this.ask("Enter ID: "), 10);
          const pigBreed = await this.ask("Enter breed: ");
          const weight = parseFloat(await this.ask("Weight in kg: "));
          const breeding = await this.askBoolean("Is it for breeding?: ");

          const newPig = new Pig(weight, breeding, pigId, pigBreed, new Date());
          animals.push(newPig);
          console.log("Pig registered successfully!");
          break;
        }

        case 5: {
          console.log("\n--- REGISTERED FARM ANIMALS ---");
          for (const animal of animals) {
            console.log(animal.toString());
          }
          break;
        }

        case 0: {
          console.log("Exiting Animal Farm. Goodbye!");
          break;
        }

        default: {
          console.log("Invalid option. Try again.");
        }
      }
    } while (option !== 0);

    this.rl.close();
  }
}

AnimalFarmApp.main();
