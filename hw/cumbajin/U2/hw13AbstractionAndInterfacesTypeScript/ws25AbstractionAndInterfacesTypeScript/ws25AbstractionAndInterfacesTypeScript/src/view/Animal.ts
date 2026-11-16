import { Chicken } from "../model/Chicken";
import { Cow } from "../model/Cow";
import { FarmAnimal } from "../model/FarmAnimal";
import { Food } from "../model/Food";
import { GrazeAnimal } from "../model/GrazeAnimal";
import { Location } from "../model/Location";
import { Sheep } from "../model/Sheep";

function showAnimalType(animal: FarmAnimal): void {
  console.log(`farmAnimalForFeeding is a --> ${animal.constructor.name}`);
}

function sendToGraze(animal: GrazeAnimal, location: Location): void {
  animal.graze(location);
}

function main(): void {
  console.log("Hello! This is Dylan's Animal Farm!");

  const bornOnDate = new Date(2020, 9, 10);
  let food = new Food("corn");

  const farmAnimal: FarmAnimal = new Chicken(
    0,
    "Palish",
    bornOnDate,
    true,
    1,
    true
  );

  console.log(`farmAnimal is a --> ${farmAnimal.constructor.name}`);
  console.log(`my farm animal --> ${farmAnimal.toString()}`);

  const chicken = new Chicken(2, "Paleesh", new Date(), true, 10, true);
  console.log(`chicken --> ${chicken.toString()}`);

  // Polymorphism through the abstract FarmAnimal type.
  let farmAnimalForFeeding: FarmAnimal = new Chicken(
    4,
    "Palish",
    bornOnDate,
    true,
    10,
    true
  );
  showAnimalType(farmAnimalForFeeding);

  farmAnimalForFeeding = new Cow(
    true,
    100.5,
    3,
    "Holstein",
    new Date(2022, 1, 20)
  );
  showAnimalType(farmAnimalForFeeding);

  farmAnimalForFeeding = new Chicken(
    0,
    "Palish",
    bornOnDate,
    true,
    4,
    true
  );
  showAnimalType(farmAnimalForFeeding);
  console.log(`farmAnimalForFeeding --> ${farmAnimalForFeeding.toString()}`);

  const cow = new Cow(true, 100.5, 3, "Holstein", new Date(2022, 1, 20));

  chicken.feed(food, 2);
  food = new Food("hay");
  cow.feed(food, 1);

  // Method overloading.
  cow.milk();
  cow.milk(3.2);
  cow.milk(5);
  cow.milk(5, bornOnDate);

  // Interface implementation.
  const pasture = new Location(1, "North pasture");
  sendToGraze(cow, pasture);

  const sheep = new Sheep(
    new Date(2026, 8, 1),
    5,
    "Merino",
    new Date(2021, 3, 15)
  );
  sendToGraze(sheep, pasture);
}

main();
