import { Food } from "./model/Food";
import { Location } from "./model/location";
import { Chicken } from "./model/chicken";
import { Cow } from "./model/cow";
import { Sheep } from "./model/sheep";
import { Pig } from "./model/pig";

function main(): void {

    const bornOnDate = new Date(2020, 9, 10);

    const food = new Food("Corn");
    const hay = new Food("Hay");

    const stable = new Location(1, "Stable");
    const pasture = new Location(2, "Pasture");

    const chicken = new Chicken(
        false, 20, true, 1, "Broiler", bornOnDate
    );

    const cow = new Cow(
        true, 15.5, 2, "Holstein", bornOnDate
    );

    const sheep = new Sheep(
        true, 8.5, "White", 3, "Merino", bornOnDate
    );

    const pig = new Pig(
        true, 150.0, "Pork", 4, "Yorkshire", bornOnDate
    );

    console.log("===== ANIMAL FARM =====");

    console.log(chicken.toString());
    chicken.feed(food, 2);
    chicken.layAnEgg();

    console.log("\n" + cow.toString());
    cow.feed(hay, 3);
    cow.food = "Grass";
    cow.graze(stable);
    cow.milk();
    cow.milk(3.2);
    cow.milk(5);
    cow.milk(2.1, bornOnDate);

    console.log("\n" + sheep.toString());
    sheep.feed(hay, 2);
    sheep.graze(pasture);
    sheep.shearWool();

    console.log("\n" + pig.toString());
    pig.feed(food, 4);
    pig.gainWeight(5.5);

    console.log("\n===== END OF FARM =====");
}

main();