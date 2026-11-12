import { Chicken } from "../model/Chicken";
import { Cow } from "../model/Cow";
import { FarmAnimal } from "../model/FarmAnimal";
import { Pig } from "../model/Pig";
import { Sheep } from "../model/Sheep";

function main(): void {
  console.log("Hello This is Mateo's Animal Farm!");

  const farmAnimal: FarmAnimal = new FarmAnimal(1, "holstein", new Date());
  console.log("my farm animal ---> " + farmAnimal);

  const chicken = new Chicken(true, 10, true, 2, "Paleesh", new Date());
  console.log("chicken ---> " + chicken);

  const cow: FarmAnimal = new Cow(true, 100.5, 3, "", new Date());
  console.log("cow ---> " + cow);

  const pig: FarmAnimal = new Pig(true, 4, "Duroc", new Date());
  console.log("pig ---> " + pig);

  const sheep: FarmAnimal = new Sheep(new Date(), 15, "Texel", new Date());
  console.log("sheep ---> " + sheep);
}

main();
