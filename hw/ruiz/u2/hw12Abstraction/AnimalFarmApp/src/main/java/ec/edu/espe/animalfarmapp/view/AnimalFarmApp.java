package ec.edu.espe.animalfarmapp.view;

import ec.edu.espe.animalfarmapp.model.Chicken;
import ec.edu.espe.animalfarmapp.model.Cow;
import ec.edu.espe.animalfarmapp.model.FarmAnimal;
import ec.edu.espe.animalfarmapp.model.Pig;
import ec.edu.espe.animalfarmapp.model.Sheep;
import java.time.LocalDate;

/**
 *
 * @author Verónica Ruiz, Code Crafters, @ESPE
 */
public class AnimalFarmApp {

    public static void main(String[] args) {
        System.out.println("Hello This is Veronica's Animal Farm!");
        FarmAnimal farmAnimal;
        farmAnimal = new Chicken(true, 10, false, 1, "holstein", LocalDate.now());
        System.out.println("my farm animal ---> " + farmAnimal);
        System.out.println("farmAnimal is a ---> " + farmAnimal.getClass().getSimpleName());
        
        Chicken chicken = new Chicken(true, 10, true, 2, "Paleesh", LocalDate.now());
        System.out.println("chicken ---> " + chicken);
        chicken.LayAnEgg();
        
        Cow cow = new Cow(true, 100.5F, 3, "holstein", LocalDate.of(2020, 10, 20));
        System.out.println("cow ---> " + cow);
        cow.milk();
        
        System.out.println("cow is a ---> " + cow.getClass().getSimpleName());
        
        FarmAnimal cow1 = new Chicken(true, 4, true, 5, "palish", LocalDate.now());
        System.out.println("cow is a ---> " + chicken.getClass().getSimpleName());
        Pig pig = new Pig(true, 120.0F, false, 6, "Yorkshire", LocalDate.now());
        
        System.out.println("pig ---> " + pig);
        pig.select();
        
        Sheep sheep = new Sheep(LocalDate.of(2025, 11, 11), true, 4.0F, 7,"Merino", LocalDate.of(2021,10,28));
        System.out.println("sheep ---> " + sheep);
        sheep.shear();
        
    }
}
