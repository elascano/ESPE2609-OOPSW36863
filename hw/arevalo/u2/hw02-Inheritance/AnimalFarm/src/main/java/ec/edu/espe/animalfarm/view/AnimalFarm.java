package ec.edu.espe.animalfarm.view;

import ec.edu.espe.animalfarm.model.Chicken;
import ec.edu.espe.animalfarm.model.Cow;
import ec.edu.espe.animalfarm.model.FarmAnimal;
import ec.edu.espe.animalfarm.model.Pig;
import ec.edu.espe.animalfarm.model.Sheep;
import java.util.Date;

/**
 *
 * @author Anthony Arévalo, MosQ, ESPE
 */
public class AnimalFarm {

    public static void main(String[] args) {
        System.out.println("Welcome to Anthony's Animal Farm!");
        FarmAnimal farmAnimal;
        farmAnimal = new FarmAnimal(1, "holstein", new Date());
        
        System.out.println("Farm animal: " + farmAnimal);
        
        Chicken chicken = new Chicken(true, 10, true, 2, "Paleesh", new Date());
        System.out.println("Chicken: " + chicken);
        
        FarmAnimal cow = new Cow(true, 100.5F, 3, "holstein", new Date(222,20,20));
        
        System.out.println("Cow: " + cow);

        // Pig and Sheep inherit their ID, breed, and birth date from FarmAnimal.
        FarmAnimal pig = new Pig(85.5F, 2.5F, true, 4, "Yorkshire", new Date());
        System.out.println("Pig: " + pig);

        FarmAnimal sheep = new Sheep(new Date(), 3.2F, "White", 5, "Merino", new Date());
        System.out.println("Sheep: " + sheep);
    }
}
