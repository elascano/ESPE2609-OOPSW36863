import {FarmAnimal} from "../model/FarmAnimal.ts";
import { Chicken } from "../model/Chicken.ts";
import { Cow } from "../model/Cow.ts";
import { Pig } from "../model/Pig.ts";
import { Sheep } from "../model/Sheep.ts";
console.log("Hello This is Veronica's Animal Farm!");

const farmAnimal = new FarmAnimal(1, "holstein", new Date());
console.log("my farm animal ---> ", farmAnimal.toString());

const chicken = new Chicken(true, 10, true, 2, "Paleesh", new Date());
console.log("chicken ---> ", chicken.toString());

const cow = new Cow(true, 100.5, 3, "holstein", new Date(2020, 9, 20));
console.log("cow ---> ", cow.toString());

const pig = new Pig(true, 120.0, false, 4, "Yorkshire", new Date());
console.log("pig ---> ", pig.toString());
const sheep = new Sheep(new Date(2025, 10, 11), true, 4.0, 5, "Merino", new Date(2021, 9, 28));
console.log("sheep ---> ", sheep.toString());
