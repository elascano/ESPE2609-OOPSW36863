package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.ChickenCoop;
import ec.edu.espe.chickenfarm.model.Egg;
import ec.edu.espe.chickenfarm.model.Poop;
import java.util.Date;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class ChickenFarmApp {
    public static void main(String[] args) {
        System.out.println("Ariel Giler's Chicken Farm");
        System.out.println("==========================");
        
        Chicken chicken;
        Chicken chicken1;
        Egg egg;
        Poop poop;
        ChickenCoop coop;
        Chicken chickens[]; 
        
        chicken = new Chicken(1, "lucy", "yellow", newDate(), 1, true);
        chicken1 = new Chicken(1, "ariel", "black", newDate(), 1, true);
        egg = new Egg(1, 'M');
        poop= new Poop(1,"brown",'S');
        chickens = new Chicken[10];
        
        System.out.println("my chicken is --> " + chicken);
        System.out.println("egg --> " + egg);
        System.out.println("egg size--> " + egg.getSize());
        System.out.println("poop --> "+ poop);
        System.out.println("my chicken is --> " + chicken1);
        
        chicken.computeAgeInYears();
        chicken.doStuff();
        
        int localAge = chicken.computeAgeInYears();
        System.out.println("Chicken's age: " + localAge);
        
        chickens[0] = new Chicken(1, "Pepita", "black", newDate(), 1, true);
        chickens[1] =chicken;
        
        for (int i = 0; i < 10; i++) {
            System.out.println("chickens ---> " + chickens[i]);
        }

        for (int i = 0 ; i < chickens.length ; i++){
            chickens[i] = new Chicken(i, "chicken " + (i+1), "white ", newDate(), 1, true);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("chickens ---> " + chickens[i]);
        }
    }   
    private static Date newDate(){
        return new Date();
    }
}
