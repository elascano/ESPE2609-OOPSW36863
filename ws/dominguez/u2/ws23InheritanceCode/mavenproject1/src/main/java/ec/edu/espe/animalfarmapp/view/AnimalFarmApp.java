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
        FarmAnimal farmAnimal;
        farmAnimal = new FarmAnimal(1, "holstein", new Date());
        
        System.out.println("my farm animal ---> " + farmAnimal);
        
        Chicken chicken = new Chicken(true, 10, true, 2, "Paleesh", new Date());
        System.out.println("chicken ---> " + chicken);
        
        FarmAnimal cow = new Cow(true, 100.5F, 3, "", new Date());
        System.out.println("cow ---> " + cow);
        
        FarmAnimal pig = new Pig(true, 4, "Duroc", new Date());
        System.out.println("pig ---> " + pig);
        
        FarmAnimal sheep = new Sheep(new Date(), 15, "Texel", new Date());
        System.out.println("sheep ---> " + sheep);
    }
}
