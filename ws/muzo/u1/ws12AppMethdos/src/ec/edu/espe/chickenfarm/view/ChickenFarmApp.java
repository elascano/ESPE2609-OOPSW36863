package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.ChickenCoop;
import ec.edu.espe.chickenfarm.model.Egg;
import ec.edu.espe.chickenfarm.model.Poop;
import java.util.Date;

/**
 *
 * @author Lesly Muzo, @ESPE
 */
public class ChickenFarmApp {
    public static void main(String[] args) {
        System.out.println("Lesly Muzo's Chicken Farm");
        System.out.println("=============================");
        
        Chicken myChicken;
        Egg currentEgg;
        Poop currentPoop;
        Chicken alternativeChicken;
        ChickenCoop myCoop;
        Chicken chickenArray[];
        
        chickenArray = new Chicken[10];
        myCoop = new ChickenCoop();
        
        myChicken = new Chicken(2, "Maru", "white", new Date(2024, 8, 15), false);
        currentEgg = new Egg(1, 'M');
        
        System.out.println("My chicken is -->" + myChicken);
        System.out.println("egg -->" + currentEgg);
        
        System.out.println("egg.size -->" + currentEgg.getSize());
        
        currentPoop = new Poop(1, "brown", 'S');
        System.out.println("poop -->" + currentPoop);
        
        alternativeChicken = new Chicken(1, "Luc", "brown and white", new Date(), false);
        System.out.println("chicken 1 -->" + alternativeChicken);
        
        int localAge = myChicken.computeAgeInYears();
        System.out.println("the age of the chicken --> " + myChicken.getName() + ", is --> " + localAge);
        
        myChicken.executeActions();
        chickenArray[0] = new Chicken(3, "Pepi", "black", new Date(2020, 2, 2), true);
        chickenArray[1] = myChicken;
        
        for (int i = 0; i < 10; i++){
            System.out.println("chicken -->" + chickenArray[i]);
        }
        for (int i = 0; i < chickenArray.length; i++){
            chickenArray[i] = new Chicken(i, "chicken" + (i + 1), "white", new Date(2020, 3, 3), true);
        }
        for (int i = 0; i < 10; i++){
            System.out.println("chickens -->" + chickenArray[i]);
        }
        myCoop.add(myChicken);
        myCoop.add(alternativeChicken);
        System.out.println("New chicken add -->" + alternativeChicken);
        
        System.out.println("--- BEFORE ---");
        Chicken[] inside = myCoop.getChikens();
        for (int i = 0; i < inside.length; i++) {
            if (inside[i] != null) {
                System.out.println(inside[i]);
            }
        }

        myCoop.remove(2);
        
        System.out.println("--- AFTER ---");
        inside = myCoop.getChikens();
        for (int i = 0; i < inside.length; i++) {
            if (inside[i] != null) {
                System.out.println(inside[i]);
            }
        }
    }
}