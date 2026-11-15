
package ec.edu.espe.view;

import ec.edu.espe.model.Chicken;
import ec.edu.espe.model.Cow;
import ec.edu.espe.model.FarmAnimal;
import ec.edu.espe.model.Sheep;
import ec.edu.espe.model.Pig;
import java.util.Date;

public class AnimalFarmApp {

    public static void main(String[] args) {

        System.out.println("Hello, This is Alejandro Animal Farm!");

        FarmAnimal farmAnimal;
        Date bornOnDate = new Date(120, 10, 10);

        farmAnimal = new Chicken(true, 4, true, 3, "Poultry", bornOnDate);

        System.out.println("farmAnimal is a --> " + farmAnimal.getClass());
        System.out.println("My farm animal --> " + farmAnimal);

        Chicken chicken = new Chicken(true, 10, true, 2, "Paleesh", new Date());

        System.out.println("Chicken --> " + chicken);
        chicken.layAnEgg();

        System.out.println("farmAnimal is a --> " + chicken.getClass());
        System.out.println("farmAnimal is a --> " + chicken.getClass().getSimpleName());

        Cow cow = new Cow(true, 100.5F, 3, "holstein", new Date(122, 10, 20));

        System.out.println("Cow --> " + cow);
        System.out.println("Cow is --> " + cow.getClass());
        System.out.println("Cow is --> " + cow.getClass().getSimpleName());
        cow.milk();

        FarmAnimal chicken1 = new Chicken(true, 4, true, 0, "palish", bornOnDate);

        System.out.println("Chicken --> " + chicken1);

        Cow cow1 = new Cow(true, 0, 0, "Molestein", bornOnDate);

        System.out.println("Cow is --> " + cow1.getClass());
        cow1.milk();

        System.out.println("\n===== SHEEP =====");

        Sheep sheep = new Sheep(5.5F, true, 4, "Merino", new Date());

        System.out.println("Sheep --> " + sheep);
        System.out.println("Sheep is --> " + sheep.getClass());
        System.out.println("Sheep is --> " + sheep.getClass().getSimpleName());
        sheep.shear();

        System.out.println("\n===== PIG =====");

        Pig pig = new Pig(80.5F, false, 5, "Yorkshire", new Date());

        System.out.println("Pig --> " + pig);
        System.out.println("Pig is --> " + pig.getClass());
        System.out.println("Pig is --> " + pig.getClass().getSimpleName());
        pig.feed();

        System.out.println("\n===== POLYMORPHISM =====");

        FarmAnimal farmAnimal1 = new Sheep(6.0F, true, 6, "Suffolk", new Date());
        FarmAnimal farmAnimal2 = new Pig(90.0F, false, 7, "Duroc", new Date());

        System.out.println("Animal type --> " + farmAnimal1.getClass().getSimpleName());
        System.out.println("Animal --> " + farmAnimal1);

        System.out.println("Animal type --> " + farmAnimal2.getClass().getSimpleName());
        System.out.println("Animal --> " + farmAnimal2);
    }
}
