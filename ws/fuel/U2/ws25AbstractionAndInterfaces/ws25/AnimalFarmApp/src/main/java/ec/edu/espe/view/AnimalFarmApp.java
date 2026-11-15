package ec.edu.espe.view;

import ec.edu.espe.model.Chicken;
import ec.edu.espe.model.Cow;
import ec.edu.espe.model.Food;
import ec.edu.espe.model.Location;
import ec.edu.espe.model.Pig;
import ec.edu.espe.model.Sheep;
import java.util.Calendar;
import java.util.Date;

public class AnimalFarmApp {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.OCTOBER, 10);
        Date bornOnDate = calendar.getTime();

        Food food = new Food("Corn");
        Food hay = new Food("Hay");

        Location stable = new Location(1, "Stable");
        Location pasture = new Location(2, "Pasture");

        Chicken chicken = new Chicken(
                false, 20, true, 1, "Broiler", bornOnDate
        );

        Cow cow = new Cow(
                true, 15.5F, 2, "Holstein", bornOnDate
        );

        Sheep sheep = new Sheep(
                true, 8.5F, "White", 3, "Merino", bornOnDate
        );

        Pig pig = new Pig(
                true, 150.0F, "Pork", 4, "Yorkshire", bornOnDate
        );

        System.out.println(" my ANIMAL FARM ");

        System.out.println(chicken);
        chicken.feed(food, 2);
        chicken.layAnEgg();

        System.out.println("\n" + cow);
        cow.feed(hay, 3);
        cow.setFood("Grass");
        cow.graze(stable);
        cow.milk();
        cow.milk(3.2F);
        cow.milk(5);

        System.out.println("\n" + sheep);
        sheep.feed(hay, 2);
        sheep.graze(pasture);
        sheep.shearWool();

        System.out.println("\n" + pig);
        pig.feed(food, 4);
        pig.gainWeight(5.5F);

        System.out.println("\n===== END OF FARM =====");
    }
}