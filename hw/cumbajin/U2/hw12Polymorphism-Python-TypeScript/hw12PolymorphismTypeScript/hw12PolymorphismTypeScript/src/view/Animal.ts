import { Chicken } from "../model/Chicken";
import { Cow } from "../model/Cow";
import { FarmAnimal } from "../model/FarmAnimal";

function classNameOf(animal: FarmAnimal): string {
    return animal.constructor.name;
}

function main(): void {
    console.log("Hello This is Dylan's Animal Farm!");

    const bornOnDate = new Date(2020, 9, 10);

    let farmAnimal: FarmAnimal = new Chicken(
        0, "palish", bornOnDate, true, 1, true
    );

    console.log(`farmAnimal is a --> ${classNameOf(farmAnimal)}`);
    console.log(`my farm animal --> ${farmAnimal.toString()}`);

    const chicken = new Chicken(
        2, "Paleesh", new Date(), true, 10, true
    );
    console.log(`chicken --> ${chicken.toString()}`);

    // The same FarmAnimal reference points to different subclass objects.
    let farmAnimalForFeeding: FarmAnimal = new Chicken(
        4, "palish", bornOnDate, true, 10, true
    );
    console.log(
        `farmAnimalForFeeding is a --> ${classNameOf(farmAnimalForFeeding)}`
    );

    farmAnimalForFeeding = new Cow(
        true, 100.5, 3, "Holstein", new Date(2022, 1, 20)
    );
    console.log(
        `farmAnimalForFeeding is a --> ${classNameOf(farmAnimalForFeeding)}`
    );

    farmAnimalForFeeding = new Chicken(
        0, "palish", bornOnDate, true, 4, true
    );
    console.log(
        `farmAnimalForFeeding is a --> ${classNameOf(farmAnimalForFeeding)}`
    );
    console.log(`farmAnimalForFeeding --> ${farmAnimalForFeeding.toString()}`);

    const cow = new Cow(
        true, 100.5, 3, "Holstein", new Date(2022, 1, 20)
    );
    cow.milk();
}

main();
