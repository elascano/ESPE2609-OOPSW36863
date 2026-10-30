package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.ChickenCoop;
import ec.edu.espe.chickenfarm.model.Egg;
import ec.edu.espe.chickenfarm.model.Poop;
import java.util.Date;

/**
 *
 * @author Verónica Ruiz, Code Crafters, @ESPE
 */
public class ChickenFarmApp {
    public static void main(String[] args) {
        System.out.println("Verónica Ruiz's Chicken Farm");
        System.out.println("============================");
                
        Chicken chicken;//declaration
        Egg egg;
        Poop poop;
        ChickenCoop coop;
        Chicken chickens[];
        
        chickens = new Chicken[10];
        chicken = new Chicken(1, "Laura", "white", new Date(1970, 11, 17), false);
        egg = new Egg(1, 'M');
        
        System.out.println("my chicken is --> " + chicken);
        System.out.println("egg --> " + egg);
        
        System.out.println("egg size --> " + egg.getSize());
        
        poop = new Poop(1, "brown", 'S');
        System.out.println("poop --> " + poop);
        Chicken chicken1 = new Chicken(1, "Lucy", "brown and white", new Date(1970, 12, 17), true);
        System.out.println("chicken 1 --> " + chicken1);
        
        int localAge = chicken.computeAgeInYears();
        System.out.println("the age of the chicken --> " + chicken.getName() + ", is --> " + localAge);
        
        chicken.doStuff();
        chickens[0] = new Chicken(3,"Pepita", "black",new Date(2020, 2, 2), true);
        chickens[1] = chicken;
        
        for (int i = 0; i < 10; i++){
            System.out.println("chickens -->" + chickens[i]);
        }
        
        int ageForTheLoop = 0;
        for(int i = 0; i < chickens.length; i++){
            ageForTheLoop = 2010 + i;
            chickens[i] = new Chicken(i,"chicken " + (i+1), "white" , new Date (2020, 3, 3), true);
            chickens[i].setAgeInYears(i);
          
        }
        for (int i = 0; i < 10; i++){
            System.out.println("chickens -->" + chickens[i]);
        }
    }
}