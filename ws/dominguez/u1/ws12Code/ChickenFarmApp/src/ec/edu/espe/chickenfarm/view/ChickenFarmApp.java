package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.Egg;
import ec.edu.espe.chickenfarm.model.Poop;
import java.util.Date;

/**
 *
 * @author Mateo Dominguez, Brain Training, @ESPE
 */
public class ChickenFarmApp {
    public static void main(String[] args) {
        System.out.println("Mateo Dominguez´s Chicken Farm");
        System.out.println("------------------------------");
        
        Chicken chicken2;
        Egg egg;
        Poop poop;
        Chicken chicken1;
        
        chicken2 = new Chicken(2, "Vale", "white", new Date(), 0, true);
        egg = new Egg(1, 'M');
        
        System.out.println("my chicken is -->" + chicken2);
        System.out.println("egg -->" + egg);
        
        System.out.println("egg size -->" + egg.getSize());
        
        poop = new Poop(1, "brown", 'S');
        System.out.println("poop -->" + poop);
        
        chicken1 = new Chicken(1, "Lucy", "bron and white", new Date(), 0, true);
        System.out.println("chicken 1 -->" + chicken1);
    }
}











