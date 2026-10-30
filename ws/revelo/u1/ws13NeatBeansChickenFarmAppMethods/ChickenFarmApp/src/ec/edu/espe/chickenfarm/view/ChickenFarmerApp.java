package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.ChickenCoop;
import ec.edu.espe.chickenfarm.model.Egg;
import ec.edu.espe.chickenfarm.model.Poop;
import java.util.Date;

/**
 *
 * @author erick
 */
public class ChickenFarmerApp {
    public static void main(String[] args) {
        System.out.println("Erick Revelo's Chicken Farmer");
        System.out.println("============================");
        Chicken chicken;
        ChickenCoop coop;
        Poop poop;
        Egg egg;
        Chicken chicken1;
        Chicken chickens [] = new Chicken[10];
        chicken = new Chicken(1, "Maruja", "White",new Date(2023, 11, 25), true);
        poop = new Poop("Brown", 's');
        chicken1 = new Chicken(2, "Piruja", "Borwn", new Date(), true);
        

        egg = new Egg('G');
        int age = chicken.computeAgeInYear();
        System.out.println(age);
        System.out.println("Chicken --->" + chicken.toString());
        System.out.println("Chicken1 ---> " + chicken1.toString());
        System.out.println("Poop1---- >" + poop.toString());
        System.out.println("Egg--->" + egg.toString());
        
        poop = new Poop("Brown", 's');
        
        
        chicken.doStuff();
        chicken1.doStuff();
        
        for (int i = 0; i < chickens.length; i++) {
            chickens[i] = new Chicken(i, "Chicken" + i +" j", "White", new Date(2016+i,0+i,i), true);
            chickens[i].setAgeInYears();
            System.out.println(chickens[i].toString());
        }
    }
}