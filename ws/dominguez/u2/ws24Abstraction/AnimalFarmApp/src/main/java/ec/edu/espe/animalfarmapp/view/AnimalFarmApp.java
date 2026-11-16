package ec.edu.espe.animalfarmapp.view;

import ec.edu.espe.animalfarmapp.model.Chicken;
import ec.edu.espe.animalfarmapp.model.Cow;
import ec.edu.espe.animalfarmapp.model.FarmAnimal;
import ec.edu.espe.animalfarmapp.model.Pig;
import ec.edu.espe.animalfarmapp.model.Sheep;
import java.util.Date;


/**
 *
 * @author Mateo Dominguez, Brain Training, @ESPE
 */
public class AnimalFarmApp {
    public static void main(String[] args) {
        System.out.println("Hello This is Mateo´s Animal Farm!");
        Date bornOnDate = new Date(2020,10,10);
        
        FarmAnimal farmAnimal;
        farmAnimal = new Chicken(true, 21, true, 7, "Paleesh", bornOnDate);
        System.out.println("farmAnimal is a ---> " + farmAnimal.getClass());
        System.out.println("my farm animal ---> " + farmAnimal);
        
        Chicken chicken = new Chicken(true, 10, true, 2, "Paleesh", new Date());
        System.out.println("chicken ---> " + chicken);
        chicken.layAndEgg();
        
        FarmAnimal farmAnimalForFeeding = new Cow(true, 100.5F, 3, "", new Date());
        System.out.println("farmAnimalForFeeding  is a ---> " + farmAnimalForFeeding.getClass().getSimpleName());
        farmAnimalForFeeding = new Chicken(true, 5, true, 6, "Roaster", bornOnDate);
        System.out.println("farmAnimalForFeeding  is a ---> " + farmAnimalForFeeding.getClass().getSimpleName());
        farmAnimalForFeeding = new Cow(true, 100.5F, 3, "", new Date());
        System.out.println("farmAnimalForFeeding  is a ---> " + farmAnimalForFeeding.getClass().getSimpleName());
        farmAnimalForFeeding = new Chicken(true, 5, true, 6, "Roaster", bornOnDate);
        System.out.println("farmAnimalForFeeding  is a ---> " + farmAnimalForFeeding.getClass().getSimpleName());
        System.out.println("farmAnimalForFeeding  ---> " + farmAnimalForFeeding);
        
        Cow cow = new Cow(true, 100.5F, 8, "", bornOnDate);
        System.out.println("cow ---> " + cow);
        cow.milk();
                
        FarmAnimal pig = new Pig(true, 4, "Duroc", new Date());
        System.out.println("pig ---> " + pig);
        
        FarmAnimal sheep = new Sheep(new Date(), 8.5F, 8, "Merina", bornOnDate);
        System.out.println("sheep ---> " + sheep);
    }
}
