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
        farmAnimal = new FarmAnimal(1, "holstein", LocalDate.now());
        
        System.out.println("my farm animal ---> " + farmAnimal);
        
        Chicken chicken = new Chicken(true, 10, true, 2, "Paleesh", LocalDate.now());
        System.out.println("chicken ---> " + chicken);
        
        FarmAnimal cow = new Cow(true, 100.5F, 3, "holstein", LocalDate.of(2020, 10, 20));
        System.out.println("cow ---> " + cow);
        
        FarmAnimal pig = new Pig(true, 120.0F, false, 4, "Yorkshire", LocalDate.now());
        System.out.println("pig ---> " + pig);
        
        FarmAnimal sheep = new Sheep(LocalDate.of(2025, 11, 11), true, 4.0F, 5,"Merino", LocalDate.of(2021,10,28));
        System.out.println("sheep ---> " + sheep);
    }
}
