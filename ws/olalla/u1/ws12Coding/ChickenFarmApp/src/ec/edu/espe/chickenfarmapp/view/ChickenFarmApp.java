package ec.edu.espe.chickenfarmapp.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.ChickenCoop;
import ec.edu.espe.chickenfarm.model.Egg;
import ec.edu.espe.chickenfarm.model.Poop;
import java.util.Date;

/**
 *
 * @author Julian Olalla, 64 wizards, @ESPE
 */
public class ChickenFarmApp {
    public static void main(String args[]){
        System.out.println("Julian Olalla's Chicken Farm App");
        System.out.println("=================================");
        
        Chicken chicken; //declaration
        Chicken chicken1 = null;
        Egg egg;
        Poop poop;
        ChickenCoop coop;
        Chicken[] chickens = new Chicken[10];
        
        chicken = new Chicken(2, "Lucy", "brown and white", new Date(1970, 7, 15), true); //instiation
        chicken.setAgeInYears();
        egg= new Egg(1, 'M');        
        
        System.out.println("my chicken is -->" + chicken);
        System.out.println("Egg -->" + egg);
        
        System.out.println("egg size --> " + egg.getSize());
        
        poop= new Poop(1, "brown", 'S');
        System.out.println("Poop -->" + poop);
        
        System.out.println("chicken 2 -->" + chicken1);
        
        chicken1 = new Chicken(1, "Lucy", "brown and white", new Date(1970,12,17), true); 
        System.out.println("chiken 1 -> "+ chicken1); 
        
        chicken1.setAgeInYears();
        int localAge = chicken.computeAgeInYears();
        System.out.println("the age of the chicken -> " + chicken.getName() + ", is -- > " + localAge);

        chicken.doStuff();        
        chickens[0] = new Chicken(3, "Pepita", "black", new Date(120,2,2), true);
        chickens[1] = chicken;
        
        for (int i = 0; i < 10; i++) {
            System.out.println("chickens --> " + chickens[i]);
        }
        
        @SuppressWarnings("UnusedAssignment")
        int ageForTheLoop=0;
        for (int i = 0; i < chickens.length; i++) {
            ageForTheLoop = 2010 + i;
            chickens[i] = new Chicken(i+1, "chicken" + (i+1), "white", new Date(ageForTheLoop,3,3), true);
            chickens[i].setAgeInYears();
        }
        
        for (int i= 0; i < 10; i++){
            System.out.println("chikens --> " + chickens[i]);
        }
        
    }
}