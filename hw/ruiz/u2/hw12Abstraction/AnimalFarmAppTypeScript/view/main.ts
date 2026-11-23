import {FarmAnimal} from "../model/FarmAnimal.ts";
import { Chicken } from "../model/Chicken.ts";
import { Cow } from "../model/Cow.ts";
import { Pig } from "../model/Pig.ts";
import { Sheep } from "../model/Sheep.ts";
console.log("Hello This is Veronica's Animal Farm!");

let farmAnimal: FarmAnimal;
farmAnimal = new Chicken(true, 10, false, 1, "holstein", new Date());
console.log("my farm animal ---> ", farmAnimal.toString());
console.log("farmAnimal is a ---> ", farmAnimal.constructor.name);

const chicken = new Chicken(true, 10, true, 2, "Paleesh", new Date());
console.log("chicken ---> ", chicken.toString());
chicken.LayAnEgg();

const cow = new Cow(true, 100.5, 3, "holstein", new Date(2020, 10, 20));
console.log("cow ---> ", cow.toString());
cow.milk();

console.log("cow is a ---> ", cow.constructor.name);
console.log("cow is a ---> ", chicken.constructor.name);

const pig = new Pig(true, 120.0, false, 4, "Yorkshire", new Date());
console.log("pig ---> ", pig.toString());
pig.select();
const sheep = new Sheep(new Date(2025, 11, 11), true, 4.0, 5, "Merino", new Date(2021, 10, 28));
console.log("sheep ---> ", sheep.toString());
sheep.shearn();
