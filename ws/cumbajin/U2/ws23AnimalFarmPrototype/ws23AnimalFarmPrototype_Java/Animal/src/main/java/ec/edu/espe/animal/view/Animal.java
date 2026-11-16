package ec.edu.espe.animal.view;

import ec.edu.espe.animal.model.Chicken;
import ec.edu.espe.animal.model.Cow;
import ec.edu.espe.animal.model.FarmAnimal;
import ec.edu.espe.animal.model.Food;
import java.util.Date;

/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
public class Animal {

    public static void main(String[] args) {

        System.out.println("Hello! This is Dylan's Animal Farm!");

        Date bornOnDate = new Date(120, 9, 10);
        Food food = new Food("corn");

        FarmAnimal farmAnimal = new Chicken(
                0,
                "Palish",
                bornOnDate,
                true,
                1,
                true
        );

        System.out.println(
                "farmAnimal is a --> "
                + farmAnimal.getClass().getSimpleName()
        );

        System.out.println(
                "my farm animal --> "
                + farmAnimal
        );

        Chicken chicken = new Chicken(
                2,
                "Paleesh",
                new Date(),
                true,
                10,
                true
        );

        System.out.println(
                "chicken --> "
                + chicken
        );

        // Polymorphism
        FarmAnimal farmAnimalForFeeding = new Chicken(
                4,
                "Palish",
                bornOnDate,
                true,
                10,
                true
        );

        System.out.println(
                "farmAnimalForFeeding is a --> "
                + farmAnimalForFeeding.getClass().getSimpleName()
        );

        farmAnimalForFeeding = new Cow(
                true,
                100.5F,
                3,
                "Holstein",
                new Date(122, 1, 20)
        );

        System.out.println(
                "farmAnimalForFeeding is a --> "
                + farmAnimalForFeeding.getClass().getSimpleName()
        );

        farmAnimalForFeeding = new Chicken(
                0,
                "Palish",
                bornOnDate,
                true,
                4,
                true
        );

        System.out.println(
                "farmAnimalForFeeding is a --> "
                + farmAnimalForFeeding.getClass().getSimpleName()
        );

        System.out.println(
                "farmAnimalForFeeding --> "
                + farmAnimalForFeeding
        );

        Cow cow = new Cow(
                true,
                100.5F,
                3,
                "Holstein",
                new Date(122, 1, 20)
        );

        // Calling the overridden feed(Food, float) method
        chicken.feed(food, 2.0F);

        food = new Food("hay");
        cow.feed(food, 1.0F);

        // Calling the overloaded milk() methods
        cow.milk();
        cow.milk(3.2F);
        cow.milk(5);
        cow.milk(5, bornOnDate);
    }
}