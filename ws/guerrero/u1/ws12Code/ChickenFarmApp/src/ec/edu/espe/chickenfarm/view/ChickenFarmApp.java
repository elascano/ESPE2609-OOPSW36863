
package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.Egg;
import ec.edu.espe.chickenfarm.model.Poop;
import ec.edu.espe.chickenfarm.model.ChickenCoop;
import java.util.Date;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class ChickenFarmApp {
    public static void main(String[] args) {
        System.out.println("Stalyn Guerrero's Chicken Farm");
        System.out.println("===============================");
        
        Chicken chicken;//declaration
        Egg egg;
        Poop poop;
        Chicken chicken1;
        ChickenCoop coop;
        Chicken chickens[];
        
        chickens = new Chicken[10]; 
        
        chicken = new Chicken(2, "Maruja", "white", new Date(2024, 8, 15), false); //instantiation
        chicken.setAgeInYears();
        egg = new Egg(1, 'M');
        
        System.out.println("my chicken is --> " + chicken);
        System.out.println("egg --> " + egg);
        System.out.println("egg size --> " + egg.getSize());
        
        poop = new Poop(1, "brown", 'S');
        System.out.println("poop --> " + poop);
        
        chicken1 = new Chicken(1, "Lucy", "brown and white", new Date(), true);
        System.out.println("chicken 1 --> " + chicken1);
        
        int localAge = chicken.computeAgeInYears();
        System.out.println("the age of the chicken --> " + chicken.getName() + "is ---> " + localAge);
        
        chicken.dostuff();
        
        chickens[0] = new Chicken(2, "Pepita", "black", new Date(2020,2,2), true);
        chickens[1] = chicken;
        
        
        int ageForTheLoop = 0;
        for (int i = 0; i < chickens.length; i++){
            ageForTheLoop = 2010 + 1;
            chickens[i] = new Chicken (i, "Chicken" + (i+1), "while", new Date(ageForTheLoop, 3, 3), true);
            chickens[i].setAgeInYears();
        
        }
        for (int i = 0; i < 10; i++){
            System.out.println("chickens ---> " + chickens[i]);
        }
        
    }
    
}

