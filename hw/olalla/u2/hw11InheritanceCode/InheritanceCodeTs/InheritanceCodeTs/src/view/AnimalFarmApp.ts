import { Chicken } from "../model/Chicken";
import { Cow } from "../model/Cow";
import { Cuts } from "../model/Cuts";
import { Food } from "../model/Food";
import { Pig } from "../model/Pig";
import { Sheep } from "../model/Sheep";

function main(): void {
    const bornOnDate = new Date();
    console.log("Hello this is Julian's Animal Farm!");

    const foodChicken = new Food("corn");
    const foodCow = new Food("hay");
    const foodPig = new Food("Corn and Soy");
    const foodSheep = new Food("hay");

    const cutsChicken = new Cuts("wings, breast, thighs");
    const cutsCow = new Cuts("sirloin, ribeye, brisket");
    const cutsPig = new Cuts("ribs, ham, bacon");
    const cutsSheep = new Cuts("leg, shoulder, rack");

    const chicken = new Chicken(1, "Paleesh", bornOnDate, true, 10, true);
    console.log(chicken.toString());
    chicken.feed(foodChicken, 100, "g");
    chicken.cuts(cutsChicken);
    console.log("\n");

    const cow = new Cow(2, "Holstein", bornOnDate, true, 25);
    console.log(cow.toString());
    cow.feed(foodCow, 20, "kg");
    cow.cuts(cutsCow);    
    console.log("\n");

    const pig = new Pig(3, "Duroc", bornOnDate, 5, 25.0, false);
    console.log(pig.toString());
    pig.feed(foodPig, 100, "Kg");
    pig.cuts(cutsPig);
    pig.gainWeight(4.5);
    pig.produceManure(2.5, "kg");
    pig.giveBirth(8);
    console.log("\n");

    // In JavaScript/TypeScript the months start at 0, so 3 is April
    const sheep = new Sheep(4, "Merino", bornOnDate, 3, true, new Date(2026, 3, 1), 5.0);
    console.log(sheep.toString());
    sheep.feed(foodSheep, 15, "Kg");
    sheep.cuts(cutsSheep);
    sheep.shear();
    sheep.woolProducePerMonth(3.2, "kg");
    sheep.giveBirth(2);
}

main();