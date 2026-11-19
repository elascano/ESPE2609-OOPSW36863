import { Chicken } from "./model/Chicken";
import { Cow } from "./model/Cow";
import { FarmAnimal } from "./model/FarmAnimal";
import { Food } from "./model/Food";
import { Location } from "./model/Location";
import { Pig } from "./model/Pig";
import { Sheep } from "./model/Sheep";

export class AnimalFarm {
    public static main(): void {
        const bornOnDate: Date = new Date(2020, 10, 10);
        let farmAnimal: FarmAnimal;
        farmAnimal = new Chicken(true, 0, true, 0, "Palish", bornOnDate);
        let food: Food = new Food("grains corn");

        console.log("Hello this is Juan's Animal Farm!");

        farmAnimal = new Chicken(true, 0, true, 0, "Palish", bornOnDate);
        console.log("farmAnimal is a -->class ec.edu.espe.animalfarm.model." + farmAnimal.constructor.name);
        console.log("my farm animal -->" + farmAnimal);

        const chicken: Chicken = new Chicken(true, 10, true, 2, "Paleesh", bornOnDate);
        console.log("chicken -->" + chicken);
        chicken.layAnEgg();

        const cow: FarmAnimal = new Cow(true, 100.5, 5, "holstein", new Date(2022, 20, 20));
        console.log("cow -->" + cow);
        const Cow1: FarmAnimal = new Chicken(true, 4, true, 0, "palish", bornOnDate);

        const cow1: Cow = new Cow(true, 0, 0, "Palish", bornOnDate);

        console.log("Cow is a --->class ec.edu.espe.animalfarm.model." + Cow1.constructor.name);
        console.log("Cow is a --->" + Cow1.constructor.name);
        console.log("Cow is a -->" + cow.constructor.name);
        console.log("Cow is a --->" + Cow1.constructor.name);
        console.log("Cow is a -->" + Cow1);
        cow1.milk(10);

        chicken.feed(food, 2);
        food = new Food("hay");

        cow1.feed(food, 1);

        cow1.milk();
        cow1.milk(3.2);
        cow1.milk(5);
        cow1.milk(1, bornOnDate);

        const location: Location = new Location(1, "North Pasture");
        const sheep: Sheep = new Sheep(new Date(2023, 5, 15), true, 3, "Merino", bornOnDate);
        console.log("sheep -->" + sheep);
        sheep.graze(location);
        sheep.feed(food, 3);
        sheep.shear();

        const pig: Pig = new Pig(85.5, false, 4, "Landrace", bornOnDate);
        console.log("pig -->" + pig);
        pig.feed(new Food("balanced feed"), 5);
        console.log("pig after feeding -->" + pig);
    }
}

AnimalFarm.main();