/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmapp.view;

import ec.edu.espe.animalfarmapp.model.Chicken;
import ec.edu.espe.animalfarmapp.model.Cow;
import ec.edu.espe.animalfarmapp.model.FarmAnimal;
import ec.edu.espe.animalfarmapp.model.Food;
import java.util.Date;

/**
 *the animal farm app
 * @author Andy Tiban, IV Studio, @ESPE
 */
public class AnimalFarmApp {
    public static void main(String[] args) {
        Date bornOnDate= new Date(2020,10,10);
        Food food = new Food("grains corn");
        
        System.out.println("hello this is Andy's Animal Farm ! ");
        FarmAnimal farmAnimal;
        farmAnimal= new Chicken(true, 0, true, 0,"Palish", bornOnDate);

        
        farmAnimal = new Chicken(true, 0, true, 0, "Palish", bornOnDate);
        System.out.println("farmAnimal is a -->"+farmAnimal.getClass());
        
        
        
        System.out.println("my farm animal -->"+farmAnimal);
        
        Chicken chicken = new Chicken(true, 10, true, 2, "Paleesh", bornOnDate);
        System.out.println("chicken -->"+ chicken);
        chicken.layAnEgg();
        
        
        FarmAnimal cow= new Cow(true, 100.5F, 5, "holstein", new Date(2022,20,20));
        System.out.println("cow -->"+cow);
        FarmAnimal farmAnimalForFeeding = new Chicken(true, 4, true, 0, "palish", bornOnDate);
        
        Cow cow1=new Cow(true, 0, 0, "Palish", bornOnDate);
        
        
        System.out.println("farmAnimalForFeeding is a --->"+ farmAnimalForFeeding.getClass());
        System.out.println("farmAnimalForFeeding is a --->"+ farmAnimalForFeeding.getClass().getSimpleName());
        
        System.out.println("farmAnimalForFeeding --->"+ cow.getClass().getSimpleName());
        

        System.out.println("farmAnimalForFeeding --->"+farmAnimalForFeeding.getClass().getSimpleName());
        System.out.println("farmAnimalForFeeding -->"+farmAnimalForFeeding);
        cow1.milk(10);
        
        chicken.feed(food, 2);
        food= new Food("hay");
        
        cow1.feed(food, 1);
        
        cow1.milk();
        cow1.milk(3.2F);
        cow1.milk(5);
        cow1.milk(1,bornOnDate);
    
    }
    
}
