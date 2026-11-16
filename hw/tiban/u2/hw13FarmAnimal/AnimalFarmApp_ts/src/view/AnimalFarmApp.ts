import { Chicken, Cow, FarmAnimal, Food } from "../model";

function main(): void {
  const bornOnDate = new Date(2020, 10, 10); // 10/11/2020
  let food = new Food("grains corn");

  console.log("hello this is Andy's Animal Farm ! ");
  let farmAnimal: FarmAnimal = new Chicken(true, 0, true, 0, "Palish", bornOnDate);

  farmAnimal = new Chicken(true, 0, true, 0, "Palish", bornOnDate);
  console.log(`farmAnimal is a -->${farmAnimal.constructor.name}`);

  console.log(`my farm animal -->${farmAnimal}`);

  const chicken = new Chicken(true, 10, true, 2, "Paleesh", bornOnDate);
  console.log(`chicken -->${chicken}`);
  chicken.layAnEgg();

  const cow: FarmAnimal = new Cow(true, 100.5, 5, "holstein", new Date(2022, 8, 20));
  console.log(`cow -->${cow}`);
  const farmAnimalForFeeding: FarmAnimal = new Chicken(true, 4, true, 0, "palish", bornOnDate);

  const cow1 = new Cow(true, 0, 0, "Palish", bornOnDate);

  console.log(`farmAnimalForFeeding is a --->${farmAnimalForFeeding.constructor.name}`);
  console.log(`farmAnimalForFeeding --->${cow.constructor.name}`);
  console.log(`farmAnimalForFeeding --->${farmAnimalForFeeding.constructor.name}`);
  console.log(`farmAnimalForFeeding -->${farmAnimalForFeeding}`);
  cow1.milk(10);

  chicken.feed(food, 2);
  food = new Food("hay");

  cow1.feed(food, 1);

  cow1.milk();
  cow1.milk(3.2);
  cow1.milk(5);
  cow1.milk(1, bornOnDate);
}

main();
