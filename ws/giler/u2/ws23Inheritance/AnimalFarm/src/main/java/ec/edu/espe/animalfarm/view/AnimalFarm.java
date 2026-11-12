package ec.edu.espe.animalfarm.view;

import ec.edu.espe.animalfarm.model.Chicken;
import ec.edu.espe.animalfarm.model.Cow;
import ec.edu.espe.animalfarm.model.FarmAnimal;
import java.util.Date;

/**
 *
 * @author Giler Ariel, CodeX3Team, @ESPE
 */
public class AnimalFarm {

    public static void main(String[] args) {
        System.out.println("Hello This is Juan's Anima Farm");
        FarmAnimal farmAnimal;
        farmAnimal = new FarmAnimal(1, "holstein", new Date());
        
        System.out.println("my farm animal --->" + farmAnimal);
        
        Chicken chicken = new Chicken(true, 10, true, 2, "Paleesh", new Date());
        System.out.println("chicken --->" + chicken);
        
        FarmAnimal cow = new Cow(true, 100.5F, 3, "holstein", new Date(222,20,20));
        
        System.out.println("cow --> " + cow);
    }
}
