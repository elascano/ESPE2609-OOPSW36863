
package ec.edu.espe.animalfarmapp.view;

import ec.edu.espe.animalfarmapp.model.FarmAnimal;
import ec.edu.espe.animalfarmapp.model.Chicken;
import ec.edu.espe.animalfarmapp.model.Cow;
import ec.edu.espe.animalfarmapp.model.Pig;
import ec.edu.espe.animalfarmapp.model.Sheep;
import java.util.Date;

/**
 *
 * @author Julian Olalla, 404 Founders, @ESPE
 */
public class AnimalFarmApp {

    public static void main(String[] args) {
        System.out.println("Hello this is Julian's Animal Farm!");
        FarmAnimal farmAnimal;
        farmAnimal = new FarmAnimal(1, "holstein", new Date());
        
        System.out.println("my farm animal -->" + farmAnimal);
        
        Chicken chicken = new Chicken(true, 10, true, 2, "Paleesh", new Date());
        System.out.println("Chicken -->" + chicken); 
        
        FarmAnimal cow = new Cow(true, 100.5F, 3, "holstein", new Date(2022, 20, 20));
        System.out.println("Cow -->" + cow);
        
        FarmAnimal pig = new Pig(true, 3, "Berkshire", new Date(2020, 15, 1));
        System.out.println("Pig -->" + pig);
        
        FarmAnimal sheep = new Sheep(new Date(), 4, "Merino", new Date(2023, 10, 5));
        System.out.println("Sheep -->" + sheep);
    }
}
