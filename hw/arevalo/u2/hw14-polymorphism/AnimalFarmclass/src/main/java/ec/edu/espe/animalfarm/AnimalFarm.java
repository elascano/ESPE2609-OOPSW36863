package ec.edu.espe.animalfarm;

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
        Date bornOnDate = java.sql.Date.valueOf("2020-10-10");
        farmAnimal = new Chicken (true, 0, true, 0, "Holstein", bornOnDate);
        
        System.out.println("FarmAnimal --> is a " + farmAnimal.getClass().getSimpleName());
        System.out.println("my farm animal --->" + farmAnimal);
        
        farmAnimal = new Cow(true, 0, 0, "Palich", java.sql.Date.valueOf("2022-10-20"));
        System.out.println("cow --> " + farmAnimal.getClass().getSimpleName());
        
        Chicken chicken = new Chicken(true, 10, true, 2, "Paleesh", new Date());
        System.out.println("chicken --->" + chicken);
        
        FarmAnimal cow = new Cow(true, 100.5F, 3, "holstein", java.sql.Date.valueOf("2022-10-20"));
        System.out.println("Cow: " + cow);
        
        cow = new Chicken (true, 4, true, 0, "paleesh", bornOnDate);
        System.out.println("FarmAnimal reassigned to Chicken --> " + cow);
        
        Cow cow2 = new Cow(true, 2, 4, "Holstein", bornOnDate);
        
        cow2.milk();
        chicken.layAnEgg();

        FarmAnimal pig = new Pig(85.5F, 2.5F, true, 5, "Yorkshire", bornOnDate);
        System.out.println("Pig: " + pig);

        FarmAnimal sheep = new Sheep(new Date(), 3.2F, "White", 6, "Merino", bornOnDate);
        System.out.println("Sheep: " + sheep);
    }
}    
