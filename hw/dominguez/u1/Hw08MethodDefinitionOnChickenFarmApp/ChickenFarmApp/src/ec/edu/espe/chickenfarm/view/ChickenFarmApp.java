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
        //ChickenCoop coop;
        Chicken chickens[] = new Chicken[10];
        
        chicken1 = new Chicken(1, "Lucy", "bron and white", new Date(2024,8,15), true);
        chicken2 = new Chicken(2, "Vale", "white", new Date(), true);
        egg = new Egg(1, 'M');
        poop = new Poop(1, "brown", 'S');
        int localAge = chicken1.computeAgeInYears();
        chickens[0] = new Chicken(1, "Pepita", "black", new Date(2020,2,2), true);
        chickens[0] = chicken1;
        
        for (int i=0;i <10; i++){
            System.out.println("chickens -->" + chickens[i]);
        }
        int ageForTheLoop;
        for(int i=0; i<chickens.length ; i++){
            ageForTheLoop = 2010 + i;
            chickens[i] = new Chicken(i, "chicken" + (i+1), "white", new Date(ageForTheLoop,3,2), true);
            chickens[i].setAgeInYears(i);
        }
        for(int i=0; i < 10; i++) {
            System.out.println("chickens-->"+chickens[i]);
        }
        
        System.out.println("my chicken 1 is -->" + chicken1);
        System.out.println("my chicken 2 is -->" + chicken2);
        System.out.println("egg -->" + egg);
        System.out.println("egg size -->" + egg.getSize());
        System.out.println("poop -->" + poop);
        System.out.println("the age of the chicken -->" + chicken1.getName() + ", is -->" + localAge);
        chicken1.doStuff();
    }
}











