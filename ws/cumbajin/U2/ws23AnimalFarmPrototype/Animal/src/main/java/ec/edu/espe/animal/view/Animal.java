

package ec.edu.espe.animal.view;

import ec.edu.espe.animal.model.FarmAnimal;
import ec.edu.espe.animal.model.Chicken;
import ec.edu.espe.animal.model.Cow;
import java.util.Date;

/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
public class Animal {

    public static void main(String[] args) {

        System.out.println("Hello This is Dylan's Animal Farm!");

        FarmAnimal farmAnimal;
        Date bornOnDate = new Date(120, 9, 10);

        farmAnimal = new Chicken(0, "palish", bornOnDate, true, 1, true);

        System.out.println("farmAnimal is a --> "+ farmAnimal.getClass());
        System.out.println("my farm animal --> "+ farmAnimal);

        
        Chicken chicken = new Chicken(2, "Paleesh", new Date(), true, 10, true);
        System.out.println("chicken --> " + chicken);

        
        FarmAnimal farmAnimalForFeeding = new Chicken(4, "palish", bornOnDate, true, 10, true);
        System.out.println("farmAnimalForFeeding is a --> " + farmAnimalForFeeding.getClass());
        System.out.println("farmAnimalForFeeding is a --> "+ farmAnimalForFeeding.getClass().getSimpleName());


        farmAnimalForFeeding = new Cow(true, 100.5F, 3, "Holstein",new Date(122, 1, 20));
        System.out.println("farmAnimalForFeeding is a --> "+ farmAnimalForFeeding.getClass().getSimpleName());

       
        farmAnimalForFeeding = new Chicken(0, "palish", bornOnDate, true, 4, true);

        System.out.println("farmAnimalForFeeding is a --> "+ farmAnimalForFeeding.getClass().getSimpleName());
        System.out.println("farmAnimalForFeeding --> "+ farmAnimalForFeeding);

       
        Cow cow = new Cow( true, 100.5F, 3, "Holstein",new Date(122, 1, 20));
        cow.milk();
        

    }
}
