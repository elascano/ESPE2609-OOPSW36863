/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.view;

import ec.edu.espe.model.Chicken;
import ec.edu.espe.model.Cow;
import ec.edu.espe.model.FarmAnimal;
import ec.edu.espe.model.*;
import java.util.*;

/**
 *
 * @author Jesus Garcia, @ESPE
 */
public class AnimalFarmApp {

    public static void main(String[] args) {
        System.out.println("Hello, This is Jesus's Animal Farm!");
        
        FarmAnimal farmAnimal;
        Date bornOnDate = new Date (2020, 10, 10);
        
        Food food = new Food("Corn");
        
        farmAnimal = new Chicken(true, 4, true, 3, "Poultry", bornOnDate);
        System.out.println("farmAnimal is a --> " + farmAnimal.getClass());
        System.out.println("My farm animal --> " + farmAnimal);
        
        Chicken chicken = new Chicken(true, 10, true, 2, "Paleesh", new Date());
        System.out.println("Chicken --> " + chicken);
        chicken.layAnEgg();
        
        System.out.println("farmAnimal is a --> " + chicken.getClass());
        System.out.println("farmAnimal is a --> " + chicken.getClass().getSimpleName());
        
        Cow cow = new Cow(true, 100.5F, 3, "holstein", new Date(2022, 20, 20));
        System.out.println("Cow --> " + cow);
        System.out.println("Cow is --> " + cow.getClass());
        System.out.println("Cow is --> " + cow.getClass().getSimpleName());
        cow.milk();
        
        FarmAnimal chicken1 = new Chicken(true, 4, true, 0, "palish", bornOnDate);
        System.out.println("Chicken --> " + chicken1);
        
        Cow cow1 = new Cow(true, 0, 0, "Molestein", bornOnDate);
        System.out.println("Cow is --> " + cow.getClass());
        cow1.milk(10);
        
        chicken.feed(food, 1);
        food = new Food("Hay");
        
        cow1.feed(food, 1);
        
        cow1.milk();
        cow1.milk(3.2F);
        cow1.milk(5);
        cow1.milk(1, bornOnDate);
    }
    
}

