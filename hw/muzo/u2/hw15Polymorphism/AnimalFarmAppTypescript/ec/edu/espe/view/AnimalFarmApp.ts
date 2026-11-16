import { Chicken } from "../model/Chicken";
import { Cow } from "../model/Cow";
import { FarmAnimal } from "../model/FarmAnimal";
import { Food } from "../model/Food";
import { Location } from "../model/Location";
import { Pig } from "../model/Pig";
import { Sheep } from "../model/Sheep";
import { grazeAnimal } from "../model/grazeAnimal";

function main(): void {
    console.log("Hello, This is Lesly's Animal Farm!");

    const bornOnDate = new Date(2020, 10, 10);
    let food = new Food("Corn");

    const farmAnimal: FarmAnimal = new Chicken(true, 4, true, 3, "Poultry", bornOnDate);
    console.log("farmAnimal is a -->", farmAnimal.constructor.name);
    console.log("My farm animal -->", farmAnimal.toString());

    const chicken = new Chicken(true, 10, true, 2, "Paleesh", new Date());
    console.log("Chicken -->", chicken.toString());
    chicken.layAnEgg();
    console.log("farmAnimal is a -->", chicken.constructor.name);
    console.log("farmAnimal is a -->", chicken.constructor.name);

    const cow = new Cow(true, 100.5, 3, "holstein", new Date(2022, 20, 20));
    console.log("Cow -->", cow.toString());
    console.log("Cow is -->", cow.constructor.name);
    console.log("Cow is -->", cow.constructor.name);
    cow.milk();

    const chicken1: FarmAnimal = new Chicken(true, 4, true, 0, "palish", bornOnDate);
    console.log("Chicken -->", chicken1.toString());

    const cow1 = new Cow(true, 0, 0, "Molestein", bornOnDate);
    console.log("Cow is -->", cow.constructor.name);
    cow1.milk(10);

    chicken.feed(food, 1);
    food = new Food("Hay");
    cow1.feed(food, 1);

    cow1.milk();
    cow1.milk(3.2);
    cow1.milk(5);
    cow1.milk(1, bornOnDate);

    const pig = new Pig(0, 3, "Yorkshire", bornOnDate);
    console.log("Pig -->", pig.toString());
    console.log("Pig is -->", pig.constructor.name);
    pig.feed(food, 2);
    pig.registerLitter(8);

    const sheep = new Sheep(10.5, false, 4, "Merino", bornOnDate);
    console.log("Sheep -->", sheep.toString());
    console.log("Sheep is -->", sheep.constructor.name);
    sheep.feed(food, 2);
    sheep.shearWool();

    const location = new Location(1, "Green pasture");
    const grazer1: grazeAnimal = cow1;
    const grazer2: grazeAnimal = sheep;
    grazer1.graze(location);
    grazer2.graze(location);
}

main();
