

package ec.edu.espe.view;

import ec.edu.espe.model.Chicken;
import ec.edu.espe.model.Cow;
import ec.edu.espe.model.FarmAnimal;
import java.util.Date;

/**
 *
 * @author Nestor Olivo, 404 Founders, @ESPE
 */
public class AnimalFarm {

    public static void main(String[] args) {
        System.out.println("Hello This is Nestor's Animal Farms!");
        FarmAnimal farmAnimal;
        farmAnimal = new FarmAnimal(1, "HOLSTEIN", new Date());
        System.out.println("farm animal ---> " + farmAnimal );
        
        Chicken chicken = new Chicken(true, 20, false, 2, "Paleesh", new Date());
        System.out.println("My Chicken " + chicken);
        
        FarmAnimal cow = new Cow(true, 100.5F, 3, "holstein", new Date());
    }
}
