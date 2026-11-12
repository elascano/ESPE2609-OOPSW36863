import { Chicken } from "../model/Chicken";
import { Cow } from "../model/Cow";
import { FarmAnimal } from "../model/FarmAnimal";
import { Pig } from "../model/Pig";
import { Sheep } from "../model/Sheep";

export class AnimalFarm {
    public static main(): void {
        console.log("Welcome to Anthony's Animal Farm!");

        const farmAnimal = new FarmAnimal(1, "holstein", new Date());
        console.log(`Farm animal: ${farmAnimal}`);

        const chicken = new Chicken(true, 10, true, 2, "Paleesh", new Date());
        console.log(`Chicken: ${chicken}`);

        // Matches Java's normalized new Date(222, 20, 20): September 20, 2123.
        const cow: FarmAnimal = new Cow(true, 100.5, 3, "holstein", new Date(2123, 8, 20));
        console.log(`Cow: ${cow}`);

        // Subclasses inherit their ID, breed, and birth date from FarmAnimal.
        const pig: FarmAnimal = new Pig(85.5, 2.5, true, 4, "Yorkshire", new Date());
        console.log(`Pig: ${pig}`);

        const sheep: FarmAnimal = new Sheep(new Date(), 3.2, "White", 5, "Merino", new Date());
        console.log(`Sheep: ${sheep}`);
    }
}
