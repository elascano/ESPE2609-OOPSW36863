import { Chicken } from "../model/Chicken";
import { Cow } from "../model/Cow";
import { FarmAnimal } from "../model/FarmAnimal";

function main(): void {
    console.log("Hello, This is Jesus Animal Farm!");

    let farmAnimal: FarmAnimal;
    const bornOnDate = new Date(2020, 10, 10);
    farmAnimal = new Chicken(true, 4, true, 3, "Poultry", bornOnDate);
    console.log("farmAnimal is a -->", farmAnimal.constructor.name);
    console.log("My farm animal -->", farmAnimal.toString());

    const chicken = new Chicken(true, 10, true, 2, "Paleesh", new Date());
    console.log("Chicken -->", chicken.toString());
    chicken.layAnEgg();

    console.log("farmAnimal is a -->", chicken.constructor);
    console.log("farmAnimal is a -->", chicken.constructor.name);

    const cow = new Cow(true, 100.5, 3, "holstein", new Date(2022, 20, 20));
    console.log("Cow -->", cow.toString());
    console.log("Cow is -->", cow.constructor);
    console.log("Cow is -->", cow.constructor.name);
    cow.milk();

    const chicken1: FarmAnimal = new Chicken(true, 4, true, 0, "palish", bornOnDate);
    console.log("Chicken -->", chicken1.toString());

    const cow1 = new Cow(true, 0, 0, "Molestein", bornOnDate);
    console.log("Cow is -->", cow.constructor.name);
    cow1.milk();
}

main();
