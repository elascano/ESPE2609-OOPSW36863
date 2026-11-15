
import { Chicken } from "./model/chicken";
import { Cow } from "./model/cow";
import { Sheep } from "./model/sheep";
import { Pig } from "./model/pig";

function main(): void {

    const chicken = new Chicken(
        false, 15, true,
        1, "Plymouth Rock", new Date(2024, 4, 10)
    );

    const cow = new Cow(
        true, 25.5,
        2, "Holstein", new Date(2023, 2, 15)
    );

    const sheep = new Sheep(
        5.5, true,
        3, "Merino", new Date(2024, 7, 20)
    );

    const pig = new Pig(
        80.5, false,
        4, "Yorkshire", new Date(2023, 6, 12)
    );

    console.log("=== ANIMAL FARM ===");

    console.log(chicken.toString());
    chicken.layEgg();

    console.log(cow.toString());
    cow.milk();

    console.log(sheep.toString());
    sheep.shear();

    console.log(pig.toString());
    pig.feed();
}

main();
