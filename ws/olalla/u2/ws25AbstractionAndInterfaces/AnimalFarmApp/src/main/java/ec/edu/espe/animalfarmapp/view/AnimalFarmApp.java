package ec.edu.espe.animalfarmapp.view;

import ec.edu.espe.animalfarmapp.model.FarmAnimal;
import ec.edu.espe.animalfarmapp.model.Chicken;
import ec.edu.espe.animalfarmapp.model.Cow;
import ec.edu.espe.animalfarmapp.model.Cuts;
import ec.edu.espe.animalfarmapp.model.Food;
import ec.edu.espe.animalfarmapp.model.Pig;
import ec.edu.espe.animalfarmapp.model.Sheep;
import ec.edu.espe.animalfarmapp.model.Location;
import java.util.Date;

/**
 *
 * @author Julian Olalla, 404 Founders, @ESPE
 */
public class AnimalFarmApp {

    public static void main(String[] args) {
        System.out.println("Hello this is Julian's Animal Farm!");
        FarmAnimal farmAnimal;
        Date bornOnDate = new Date(2020 - 1900, 10, 10);
        farmAnimal = new Cow(true, 10, 2, 1, "houlstein", bornOnDate);

        Food foodChicken = new Food("corn");
        Food foodCow = new Food("hay");
        Food foodPig = new Food("Corn and Soy");
        Food foodSheep = new Food("hay");

        Cuts cutsChicken = new Cuts("wings, breast, thighs");
        Cuts cutsCow = new Cuts("sirloin, ribeye, brisket");
        Cuts cutsPig = new Cuts("ribs, ham, bacon");
        Cuts cutsSheep = new Cuts("leg, shoulder, rack");

        Location locationCow = new Location(1, "North pasture");
        Location locationSheep = new Location(2, "Hill pasture");

        System.out.println("farmAnimal is a -->" + farmAnimal.getClass().getSimpleName());

        System.out.println("my farm animal -->" + farmAnimal);

        Chicken chicken = new Chicken(true, 10, true, 0, 2, "Paleesh", bornOnDate);
        System.out.println("Chicken -->" + chicken);
        chicken.layAnEgg();

        FarmAnimal farAnimalForFeeding = new Chicken(true, 20, true, 6, 3, "Paleesh", bornOnDate);

        System.out.println("farAnimalForFeeding is a -->" + farAnimalForFeeding.getClass());
        System.out.println("farAnimalForFeeding is a -->" + farAnimalForFeeding.getClass().getSimpleName());

        farAnimalForFeeding = new Cow(true, 10, 1, 4, "houlstein", bornOnDate);
        System.out.println("farAnimalForFeeding is a -->" + farAnimalForFeeding.getClass().getSimpleName());

        farAnimalForFeeding = new Chicken(true, 25, false, 10, 5, "Paleesh", bornOnDate);
        System.out.println("farAnimalForFeeding is a -->" + farAnimalForFeeding.getClass().getSimpleName());

        System.out.println("Cow -->" + farAnimalForFeeding);

        Cow cow = new Cow(true, 20, 3, 6, "houlstein", bornOnDate);
        cow.milk();

        chicken.feed(foodChicken, 100, "g");

        cow.feed(foodCow, 20, "kg");

        cow.milk();
        cow.milk(3.2F);
        cow.milk(5);
        cow.milk(6, bornOnDate);

        //---------------------Aqui termina lo hecho en clase---------------------
        System.out.println("\n\t----INCLUDING THE REST OF ANIMALS----");

        Chicken chicken2 = new Chicken(false, 0, true, 10, 7, "paleesh", bornOnDate);
        System.out.println("Chicken -->" + chicken2);
        chicken2.feed(foodChicken, 20, "g");
        chicken2.layAnEgg();
        chicken2.giveBirth(2);
        chicken2.cuts(cutsChicken);
        System.out.println("");

        Cow cow2 = new Cow(false, 0, 5, 8, "houlstein", bornOnDate);
        System.out.println("Cow -->" + cow2);
        cow2.addVaccine("Rabies");
        cow2.addVaccine("Foot and Mouth Disease");
        cow2.addVaccine("Brucellosis");

        System.out.println("Cow vaccines --> " + cow2.getVaccines());
        cow2.feed(foodCow, 10, "kg");
        cow2.graze(locationCow);
        cow2.milk();
        cow2.cuts(cutsCow);
        System.out.println("");

        Pig pig = new Pig(25, 5, true, 1, "Berkshire", bornOnDate);
        System.out.println("Pig -->" + pig);
        pig.feed(foodPig, 20, "Kg");
        pig.gainWeight(20);
        pig.isIsReadyToEat();
        pig.cuts(cutsPig);
        System.out.println("");

        Sheep sheep = new Sheep(true, new Date(2020-1900, 10, 23), 5, 3, 1, "Merino", bornOnDate);
        System.out.println("Sheep -->" + sheep);
        sheep.feed(foodSheep, 15, "Kg");
        sheep.graze(locationSheep);
        sheep.shear();
        sheep.woolProducePerMonth(15.60F, "kg");
        sheep.cuts(cutsSheep);
    }
}
