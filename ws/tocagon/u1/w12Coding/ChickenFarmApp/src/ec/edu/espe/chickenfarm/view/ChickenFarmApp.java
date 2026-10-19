package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.Egg;
import ec.edu.espe.chickenfarm.model.Poop;
import java.util.Date;

/**
 *
 * @author Nohemi Tocagon, Uni Helper, @ESPE
 */
public class ChickenFarmApp {
    public static void main(String[] args) {
        System.out.println("Nohemi Tocagon's Chicken Farm");
        System.out.println("=============================");
        
        Chicken chicken; //declaration
        Egg egg;
        Poop poop;
        Chicken chicken1;
        
        chicken = new Chicken(2, "Maruja", "brown", new Date(),0,true); // instantiation
        egg= new Egg(1,'M');
        
        System.out.println("My chicken is -->" + chicken);
        System.out.println("egg -->" + egg);
        
        System.out.println("egg.size -->" + egg.getSize());
        
        poop= new Poop(1,"brown", 'S');
        System.out.println("poop -->" + poop);
        
        chicken1 = new Chicken(1, "Lucy", "brown and white", new Date(), 1, false);
        System.out.println("chicken 1 -->" + chicken1);
        
    }
}
