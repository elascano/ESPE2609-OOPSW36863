package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.Egg;
import ec.edu.espe.chickenfarm.model.Poop;
import java.util.Date;

/**
 *
 * @author Andy Tiban, IV Studio, @ESPE
 */
public class ChickenFarmApp {
    public static void main(String[] args) {
        System.out.println("Andy Tiban's Chicken Farm");    
        System.out.println("=========================");
        
        Chicken chicken;
        Egg egg;
        Poop poop;
        Chicken chicken1;
        
        chicken = new Chicken(2,"Maruja","white",new Date(),1,false);
        egg= new Egg(1,'M');
        System.out.println("my chicken is ->"+chicken);
        System.out.println("egg -->"+egg);
        
        System.out.println("egg size-->"+egg.getSize());
        
        poop= new Poop(1,"brown",'S');
        System.out.println("Poop->"+ poop);
        
        chicken1= new Chicken(1,"Lucy","brown and white",new Date(),0,true);
        System.out.println("chicken"+chicken1   );
    }
    
}
