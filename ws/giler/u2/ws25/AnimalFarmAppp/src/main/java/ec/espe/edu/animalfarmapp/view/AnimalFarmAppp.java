/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.espe.edu.animalfarmapp.view;

import ec.espe.edu.animalfarmapp.model.Chicken;
import ec.espe.edu.animalfarmapp.model.Cow;
import ec.espe.edu.animalfarmapp.model.FarmAnimal;
import ec.espe.edu.animalfarmapp.model.Food;
import java.util.Date;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public abstract class AnimalFarmAppp {

    public static void main(String[] args) {
        Date bornOnDate = new Date(2020,10,10);
        System.out.println("Hello this is Ariel's Animal Farm - Abstraction Exercise");
        FarmAnimal farmAnimal;
        FarmAnimal farmAnimalForFeeding;
        Food food = new Food("corn");
        
        farmAnimal = new Cow(true, 1, 10, "Holstein", bornOnDate);
        
        farmAnimal = new Chicken(true, 1, true, 0, "Paliish", bornOnDate);
        
        System.out.println("farmAnimal is a --> " + farmAnimal.getClass().getSimpleName());
        
        System.out.println("My farm animal --> " + farmAnimal);
        
        Chicken chicken = new Chicken(true, 10, true, 2, "Paleesh", bornOnDate);
        System.out.println("Chicken ---> " + chicken);
        chicken.layAnEgg();
        
        FarmAnimal cow = new Cow(true, 100.5F, 3, "Holstein", bornOnDate);
        
        System.out.println("cow is a --> " + cow.getClass().getSimpleName());
        
        cow = new Chicken(true, 4, true, 0, "Paliish", bornOnDate);
        System.out.println("cow is a --> " + chicken.getClass().getSimpleName());
        
        farmAnimalForFeeding = new Chicken(true, 5, true, 0, "Paliish", bornOnDate);
        System.out.println("farmAnimalForFeeding is a --> " + farmAnimalForFeeding.getClass());
        System.out.println("farmAnimalForFeeding is a --> " + farmAnimalForFeeding.getClass().getSimpleName());
        
        farmAnimalForFeeding = new Cow(true, 100.6F, 0, "Holstein", bornOnDate);
        System.out.println("farmAnimalForFeeding is a --> " + farmAnimalForFeeding.getClass().getSimpleName());
        
        Cow cow1 = new Cow(true, 10, 5, "Holstein", new Date(10/10/2020));
        cow1.milk();
        
        chicken.feed(food,2);
        
        food = new Food("grass");
        cow1.feed(food, 3);
        
        cow1.milk();
        cow1.milk(3.23F);
        cow1.milk(2);
        cow1.milk(1, bornOnDate);

    }
}
