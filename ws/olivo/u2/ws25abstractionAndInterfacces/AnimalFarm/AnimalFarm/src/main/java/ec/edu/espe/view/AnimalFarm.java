
package ec.edu.espe.view;

import ec.edu.espe.model.Chicken;
import ec.edu.espe.model.Cow;
import ec.edu.espe.model.FarmAnimal;
import ec.edu.espe.model.Food;
import java.util.Date;

/**
 *
 * @author Nestor Olivo, 404 Founders, @ESPE
 */
public class AnimalFarm {

    public static void main(String[] args) {
        
        Food food;
        Date bornOnDate = new Date(2022,9,12);
        System.out.println("Hello This is Nestor's Animal Farms!");
        FarmAnimal farmAnimal;
        farmAnimal = new Chicken(true, 10, true, 1, "Paleesh", new Date());
        System.out.println("FarmAminal is a ---> " + farmAnimal.getClass());
        System.out.println("farm animal ---> " + farmAnimal );
        Cow cow;
        cow = new Cow(true, 150f, 7, "holsteing", bornOnDate);
        System.out.println("cow is " + cow);
        System.out.println("cow is a  " + cow.getClass().getSimpleName());
        Chicken chicken = new Chicken(true, 20, false, 2, "Paleesh", new Date());
        System.out.println("My Chicken " + chicken);
        chicken.layInEgg();
        FarmAnimal farmAnimalForFeeding; 
        farmAnimalForFeeding = new Chicken(true, 10, true, 5, "Paleesh", new Date());
        System.out.println("cow is a " + farmAnimalForFeeding.getClass().getSimpleName());
        farmAnimalForFeeding= new Cow(true, 100.5F, 3, "holstein", new Date());
        System.out.println("cow is a " + farmAnimalForFeeding.getClass().getSimpleName());
        farmAnimalForFeeding = new Chicken(true, 4, true, 4, "PALEESH", new Date());
        System.out.println("cow is a " + farmAnimalForFeeding.getClass().getSimpleName());
        cow.milk(3.4f);
        
        System.out.println("==============================================================");
        food = new Food("grains");
        chicken.feed(food, 2);
        
        food = new Food("hay");
        cow.feed(food, 1);
        Date hourMilking = new Date();
        cow.milk();
        cow.milk(15.4564848);
        cow.milk(15.35F);
        cow.milk(15, hourMilking);
        
    }
}
