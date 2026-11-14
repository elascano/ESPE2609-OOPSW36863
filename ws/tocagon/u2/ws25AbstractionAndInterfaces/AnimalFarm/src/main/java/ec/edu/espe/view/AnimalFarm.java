

package ec.edu.espe.view;

import ec.edu.espe.model.*; //IMportar todas las clases
import java.util.Date;

/**
 *the animal farm
 * @author Nohemi Tocagon, IV Studio, @ESPE
 */
public class AnimalFarm {

    public static void main(String[] args) {
        System.out.println("Hello this is Nohemi's Animal Farms!");
        FarmAnimal farmAnimal;
        Date bornOnDate= new Date(2020-1900,10,10);
        Food food= new Food("corn");
        
        farmAnimal = new Chicken(true, 1, true, 0, "Palish", bornOnDate);
        
        System.out.println("farm animal is a-->" +farmAnimal.getClass());
        
        System.out.println("farm animal ---> " + farmAnimal );
        
        Chicken chicken = new Chicken(true, 20, false, 2, "Paleesh", new Date());
        System.out.println("my Chicken " + chicken);
        
        FarmAnimal farmAnimalForFeeding= new Chicken(true, 10, true, 4, "Palish", bornOnDate);
        System.out.println("farmAnimalForFeeding is a -->"+ farmAnimalForFeeding.getClass().getSimpleName());
        
        FarmAnimal cow = new Cow(true, 100.5F, 3, "holstein", new Date());
        System.out.println("my cow -->" + cow);
        System.out.println("farmAnimalForFeeding is a -->"+ cow.getClass().getSimpleName());
        
        
        Cow cow1=new Cow(true, 0, 0, "Palish", new Date());

        farmAnimalForFeeding= new Chicken(true, 4, true, 0, "palish", bornOnDate);
        System.out.println("farmAnimalForFeeding is a -->"+ farmAnimalForFeeding.getClass().getSimpleName());
        
        Chicken chicken1= new Chicken(true, 10, true, 2, "Palish", bornOnDate);
        System.out.println("chicken -->"+ chicken1);
        chicken.layAnEgg();
        cow1.milk(10);
        
        chicken.feed(food, 1);
        food = new Food("hay");
        cow1.feed(food, 1);
        
        cow1.milk();
        cow1.milk(3.2F);
        cow1.milk(5);
        cow1.milk(1, bornOnDate);
        
        System.out.println("hola jose miguelito");
        
    }
}
