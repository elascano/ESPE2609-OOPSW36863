package ec.edu.espe.view;

import ec.edu.espe.model.Chicken;
import ec.edu.espe.model.Cow;
import ec.edu.espe.model.FarmAnimal;
import ec.edu.espe.model.Sheep;
import ec.edu.espe.model.Pig;
import java.util.*;

/**
 *
 * @author LABS-ESPE
 */
public class AnimalFarmApp {

    public static void main(String[] args) {
        System.out.println("Hello, This is Alejandro Animal Farm!");
        FarmAnimal farmAnimal;
        farmAnimal = new FarmAnimal (1, "holstein", new Date());
        
        System.out.println("My farm animal --> " + farmAnimal);
        
        Chicken chicken = new Chicken(true, 10, true, 2, "Paleesh", new Date());
        System.out.println("Chicken --> " + chicken);
        
        Cow cow = new Cow(true, 100.5F, 3, "holstein", new Date(2022, 20, 20));
        System.out.println("Cow --> " + cow);
        
        Sheep sheep = new Sheep(5.5F, true, 4, "Merino", new Date());
        System.out.println("Sheep --> " + sheep);
        sheep.shear();

        Pig pig = new Pig(80.5F, false, 5, "Yorkshire", new Date());
        System.out.println("Pig --> " + pig);
        pig.feed();
    }
}
