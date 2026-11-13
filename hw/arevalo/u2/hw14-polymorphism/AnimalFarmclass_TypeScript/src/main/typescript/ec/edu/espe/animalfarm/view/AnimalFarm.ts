import { Chicken } from "../model/Chicken";
import { Cow } from "../model/Cow";
import { FarmAnimal } from "../model/FarmAnimal";
import { Pig } from "../model/Pig";
import { Sheep } from "../model/Sheep";

// @author Anthony Arévalo, MosQ, ESPE
export class AnimalFarm {
    public static main(args: string[]): void {
        console.log("Welcome to Anthony's Animal Farm!");
        const bornOnDate = new Date(2020, 9, 10);
        let farmAnimal: FarmAnimal = new Chicken(true, 0, true, 0, "Holstein", bornOnDate);

        console.log("FarmAnimal --> is a " + farmAnimal.constructor.name);
        console.log("my farm animal --->" + farmAnimal);

        farmAnimal = new Cow(true, 0, 0, "Palich", new Date(2022, 9, 20));
        console.log("cow --> " + farmAnimal.constructor.name);

        const chicken = new Chicken(true, 10, true, 2, "Paleesh", new Date());
        console.log("chicken --->" + chicken);

        let cow: FarmAnimal = new Cow(true, 100.5, 3, "holstein", new Date(2022, 9, 20));
        console.log("Cow: " + cow);

        cow = new Chicken(true, 4, true, 0, "paleesh", bornOnDate);
        console.log("FarmAnimal reassigned to Chicken --> " + cow);

        const cow2 = new Cow(true, 2, 4, "Holstein", bornOnDate);
        cow2.milk();
        chicken.layAnEgg();

        // Pig and Sheep inherit their ID, breed, and birth date from FarmAnimal.
        const pig: FarmAnimal = new Pig(85.5, 2.5, true, 5, "Yorkshire", bornOnDate);
        console.log("Pig: " + pig);

        const sheep: FarmAnimal = new Sheep(new Date(), 3.2, "White", 6, "Merino", bornOnDate);
        console.log("Sheep: " + sheep);
    }
}

AnimalFarm.main([]);
