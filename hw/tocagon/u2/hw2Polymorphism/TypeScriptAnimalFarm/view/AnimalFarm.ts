import { FarmAnimal } from "../models/FarmAnimal";
import { Chicken } from "../models/Chicken";
import { Cow } from "../models/Cow";
import { Pig } from "../models/Pig";
import { Sheep } from "../models/Sheep";

export function main(): void{
    console.log("Hello this is Nohemi's Animal Farms!");

    const bornOnDate = new Date(2020, 10, 10);

    let farmAnimal: FarmAnimal;

    farmAnimal = new Chicken(true, 1, true, 0, "Palish", bornOnDate);

    console.log("farm animal is a -->", farmAnimal.constructor.name);

    console.log("farm animal --->", farmAnimal.toString());

    const chicken = new Chicken(true, 20, false, 2, "Paleesh", new Date());

    console.log("my Chicken", chicken.toString());

    let farmAnimalForFeeding: FarmAnimal = new Chicken(true, 10, true, 4, "Palish", bornOnDate);

    console.log("farmAnimalForFeeding is a -->", farmAnimalForFeeding.constructor.name);

    const cow: FarmAnimal = new Cow(true, 100.5, 3, "holstein", new Date());

    console.log("my cow -->", cow.toString());

    console.log("farmAnimalForFeeding is a -->", cow.constructor.name);

    const cow1 = new Cow(true, 0, 0, "Palish", bornOnDate);

    farmAnimalForFeeding = new Chicken(true, 4, true, 0, "palish", bornOnDate);

    console.log("farmAnimalForFeeding is a -->", farmAnimalForFeeding.constructor.name);

    const chicken1 = new Chicken(true, 10, true, 2, "Palish", bornOnDate);

    console.log("chicken -->", chicken1.toString());

    chicken.layAnEgg();

    cow1.milk();

    console.log("New Animals");
    const pig= new Pig(55.5, true, 15, 1, "Pietrain", bornOnDate);
    console.log("Pig-->", pig.toString());
    pig.checkHealth();

    const sheep= new Sheep("white", 5.5, false, 1, "Lincoln", bornOnDate );
    console.log("sheep-->", sheep.toString());
    sheep.shearWool();
    
}