
package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.Egg;
import ec.edu.espe.chickenfarm.model.Poop;
import java.util.Date;

/**
 *
 * @author Nestor Olivo, Found ERROR 404, @ESPE
 */
public class ChickenFarmerApp {
    public static void main(String[] args) {
        System.out.println("Anthony is Chicken Farmer");
        System.out.println("=========================");
        Chicken chicken;
        Poop poop;
        Egg egg;
        Chicken chicken1;
        
        chicken = new Chicken(1, "Maria", "White and borwn",new Date(), 2, true);
        poop = new Poop("Brown", 's');
        chicken1 = new Chicken(2, "Juana", "Borwn", new Date(), 7, true);
        egg = new Egg('G');
        
        System.out.println("Chicken --->" + chicken.toString());
        System.out.println("Chicken1 ---> " + chicken1.toString());
        System.out.println("Poop1---- >" + poop.toString());
        System.out.println("Egg--->" + egg.toString());
    }
}
