

import { FarmAnimal } from "./model/farm_animal";
import { Chicken } from "./model/chicken";
import { Cow } from "./model/cow";
import { Sheep } from "./model/sheep";
import { Pig } from "./model/pig";


function main(): void {

    console.log("Hello, This is Alejandro Animal Farm!");

    const bornOnDate = new Date(2020, 10, 10);

    let farmAnimal: FarmAnimal;

    farmAnimal = new Chicken(
        true, 4, true, 3, "Poultry", bornOnDate
    );

    console.log("farmAnimal is a -->", farmAnimal.constructor.name);
    console.log("My farm animal -->", farmAnimal.toString());

    console.log("\n===== CHICKEN =====");

    const chicken = new Chicken(
        true, 10, true, 2, "Paleesh", new Date()
    );

    console.log("Chicken -->", chicken.toString());
    chicken.layAnEgg();

    console.log("Age in months -->", chicken.getAgeInMonths());

    console.log("\n===== COW =====");

    const cow = new Cow(
        true, 100.5, 3, "Holstein", new Date(2022, 10, 20)
    );

    console.log("Cow -->", cow.toString());
    console.log("Cow is -->", cow.constructor.name);
    cow.milk();

    console.log("Age in months -->", cow.getAgeInMonths());

    console.log("\n===== SHEEP =====");

    const sheep = new Sheep(
        5.5, true, 4, "Merino", new Date()
    );

    console.log("Sheep -->", sheep.toString());
    console.log("Sheep is -->", sheep.constructor.name);
    sheep.shear();

    console.log("Age in months -->", sheep.getAgeInMonths());

    console.log("\n===== PIG =====");

    const pig = new Pig(
        80.5, false, 5, "Yorkshire", new Date()
    );

    console.log("Pig -->", pig.toString());
    console.log("Pig is -->", pig.constructor.name);
    pig.feed();

    console.log("Age in months -->", pig.getAgeInMonths());

    console.log("\n===== POLYMORPHISM =====");

    const farmAnimal1: FarmAnimal = new Sheep(
        6.0, true, 6, "Suffolk", new Date()
    );

    const farmAnimal2: FarmAnimal = new Pig(
        90.0, false, 7, "Duroc", new Date()
    );

    console.log("Animal type -->", farmAnimal1.constructor.name);
    console.log("Animal -->", farmAnimal1.toString());

    console.log("Animal type -->", farmAnimal2.constructor.name);
    console.log("Animal -->", farmAnimal2.toString());
}

main();
