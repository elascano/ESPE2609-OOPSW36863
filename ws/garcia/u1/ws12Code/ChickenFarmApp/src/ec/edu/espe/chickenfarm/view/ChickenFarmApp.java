package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.ChickenCoop;
import ec.edu.espe.chickenfarm.model.Egg;
import ec.edu.espe.chickenfarm.model.Poop;
import java.util.Date;

/**
 *
 * @author Jesus Garcia, @ESPE
 */
public class ChickenFarmApp {
    public static void main(String[] args) {
        System.out.println("Jesus Garcia's Chicken Farms");
        System.out.println("=============================");
        Chicken chicken;
        Egg egg;
        Poop poop;
        Chicken chicken1;
        ChickenCoop coop;
        
        Chicken chickens[];
        chickens = new Chicken[10];
        
        chicken = new Chicken(2, "Maruja", "White", new Date(1970, 8, 15), false);
        chicken.setAgeInYears();
        egg = new Egg(1, 'M');
        
        
        System.out.println("My chicken is --> " + chicken);
        System.out.println("egg --> " + egg);
        
        System.out.println("egg size --> " + egg.getSize());
        
        poop = new Poop(1, "Brown", 'S');
        System.out.println("poop --> " + poop);
        
        chicken1 = new Chicken(1, "Lucy", "brown and white", new Date(), true);
        System.out.println("chicken 1--> " + chicken1);
        chicken1.setAgeInYears();
        int localAge = chicken.computeAgeInYears();
        System.out.println("the age of the chicken --> " + chicken.getName()+ ", is --> " + localAge);
        
        chicken.doStuff();
        chicken1.doStuff();
        
        chickens[0] = new Chicken(3, "Pepita", "Black", new Date(2020,2,2), true);
        chickens[1] = chicken;
        chickens[2] = chicken1;
        
        for (int i=0; i<10; i++){
        System.out.println("chickens --> " + chickens[i]);
    }
        for (int i=0; i<chickens.length; i++){
            chickens[i] = new Chicken(i, "chicken " + (i+1), "white ", new Date(2020, 3, 3), true);
            System.out.println("chickens -->" + chickens[i]);
        }
        
    }
}
