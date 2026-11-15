package ec.edu.espe.view;

import ec.edu.espe.model.Chicken;
import ec.edu.espe.model.Cow;
import ec.edu.espe.model.FarmAnimal;
import java.util.Date;

/**
 *
 * @author Erick Revelo, Code Crafters, @ESPE
 */
public class AnimalFarmApp {
    
    public static void main(String[] args){
        
        System.out.println("Hello, this is Erick's farm");
        FarmAnimal farmAnimal;
        Date bornOnDate = new Date(2020, 10, 10);
        farmAnimal = new Cow(true, 50.3F, 1, "holstein", bornOnDate);
        
        System.out.println("farmAnimal is a --> " + farmAnimal.getClass());
        
        System.out.println("My farm animal --> " + farmAnimal);
        
        Chicken chicken = new Chicken(true, 10, true, 2, "Paleesh", bornOnDate);        
        System.out.println("Chicken --> " + chicken);
        chicken.layAnEgg();
        
        Cow cow = new Cow(true, 100.5F, 3, "holstein", new Date(2022,11,20));
        System.out.println("Cow --> " + cow);
        cow.milk();
        
        System.out.println("Cow is a -->" + chicken.getClass().getSimpleName());
        System.out.println("Chicken is a -->" + cow.getClass().getSimpleName());
        System.out.println("Farm Animal is a -->" + chicken.getClass().getSimpleName());

    }
}
