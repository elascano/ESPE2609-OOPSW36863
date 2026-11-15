import { FarmView } from '../view/FarmView';
import { FarmAnimal } from '../model/FarmAnimal';
import { Chicken } from '../model/Chicken';
import { Cow } from '../model/Cow';
import { Pig } from '../model/Pig';
import { Sheep } from '../model/Sheep';
import { Food } from '../model/Food';
import { Location } from '../model/Location';

export class FarmController {
    private view = new FarmView();
    run(): void {
        let bornOnDate = new Date(2020, 10, 10);
        this.view.printTitle();

        let farmAnimal: FarmAnimal;
        let farmAnimalForFeeding: FarmAnimal;
        let food = new Food("corn");

        farmAnimal = new Chicken(true, 1, true, 0, "Paliish", bornOnDate);
        this.view.printAnimalType("farmAnimal", farmAnimal.constructor.name);
        this.view.printMessage(`My farm animal --> ${farmAnimal}`);

        let chicken = new Chicken(true, 10, true, 2, "Paleesh", bornOnDate);
        this.view.printMessage(`Chicken ---> ${chicken}`);
        chicken.layAnEgg();

        let cow: FarmAnimal = new Cow(true, 100.5, 3, "Holstein", bornOnDate);
        this.view.printAnimalType("cow", cow.constructor.name);

        cow = new Chicken(true, 4, true, 0, "Paliish", bornOnDate);
        this.view.printAnimalType("cow", cow.constructor.name);

        farmAnimalForFeeding = new Chicken(true, 5, true, 0, "Paliish", bornOnDate);
        this.view.printAnimalType("farmAnimalForFeeding", farmAnimalForFeeding.constructor.name);

        farmAnimalForFeeding = new Cow(true, 100.6, 0, "Holstein", bornOnDate);
        this.view.printAnimalType("farmAnimalForFeeding", farmAnimalForFeeding.constructor.name);

        let cow1 = new Cow(true, 10, 5, "Holstein", new Date(2020, 10, 10));
        cow1.milk();

        chicken.feed(food, 2);

        food = new Food("grass");
        cow1.feed(food, 3);

        cow1.milk();
        cow1.milk(3.23);
        cow1.milk(2);
        cow1.milk(1, bornOnDate);

        this.view.printSeparator("Testing Sheep");
        let pasture = new Location(1, "North Pasture");
        let shearingDate = new Date(2023, 5, 15);

        let sheep = new Sheep(4.5, "Fine", shearingDate, 10, "Merino", bornOnDate);
        this.view.printMessage(sheep.toString());
        sheep.graze(pasture);
        let alfalfa = new Food("alfalfa");
        sheep.feed(alfalfa, 3);
        sheep.shearForMarket();

        this.view.printSeparator("Testing Pig");
        let pigForMeat = new Pig(90.0, 110.0, false, 11, "Duroc", bornOnDate);
        let pigBreeder = new Pig(120.0, 150.0, true, 12, "Yorkshire", bornOnDate);

        this.view.printMessage(pigForMeat.toString());

        let scraps = new Food("vegetables and grains");
        pigForMeat.feed(scraps, 10);

        pigForMeat.calculateMeatYield();
        pigForMeat.collectManure();
        pigForMeat.producePiglets();

        this.view.printMessage("\nTesting Breeder Pig:");
        pigBreeder.producePiglets();
    }
}
