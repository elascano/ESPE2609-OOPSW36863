/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.animalfarmapp.view;

import ec.edu.espe.animalfarmapp.model.Chicken;
import ec.edu.espe.animalfarmapp.model.Cow;
import ec.edu.espe.animalfarmapp.model.FarmAnimal;
import ec.edu.espe.animalfarmapp.model.Food;
import ec.edu.espe.animalfarmapp.model.Pig;
import ec.edu.espe.animalfarmapp.model.Sheep;
import java.util.Date;

/**
 *
 * @author Dennis Noboa, 404 Founder, @ESPE
 */
public class AnimalFarmApp {

    public static void main(String[] args) {        
        System.out.println("Hello. This is Dennis's Animal Farm!");
        Date bornOnDate = new Date(2020, 10, 10);
        Food food =  new Food("corn");
        
        FarmAnimal farmAnimal = new Chicken(true, 0, true, 1, "palish", bornOnDate);
        
        System.out.println("farmAnimal is a --> " + farmAnimal.getClass());
        
        System.out.println("my farm animal --> " + farmAnimal);
        
        Chicken chicken = new Chicken(true, 10, true, 2, "Paleesh", new Date());
        System.out.println("chicken --> " + chicken);
        chicken.layAnEgg();
        
        FarmAnimal farmAnimalForFeeding = new Chicken(true, 10, true, 4, "palish", bornOnDate);
        
        System.out.println("farmAnimalForFeeding is a --> " + farmAnimalForFeeding.getClass());
        
        System.out.println("farmAnimalForFeeding is a --> " + farmAnimalForFeeding.getClass().getSimpleName());
        
        farmAnimalForFeeding = new Cow(true, 100.5F, 3, "holstein", new Date(2022, 20, 20));
        
        System.out.println("farmAnimalForFeeding is a --> " + farmAnimalForFeeding.getClass().getSimpleName());
        
        farmAnimalForFeeding = new Chicken(true, 4, true, 0, "palish", bornOnDate);
        
        System.out.println("farmAnimalForFeeding is a --> " + farmAnimalForFeeding.getClass().getSimpleName());
        
        System.out.println("farmAnimalForFeeding --> " + farmAnimalForFeeding);
        
        /*
        FarmAnimal pig = new Pig(true, 150.3F, 4, "duroc", new Date(2025, 11, 25));
        System.out.println("pig --> " + pig);
        
        FarmAnimal sheep = new Sheep(new Date(2026, 11, 11), 4.2F, 5, "lincoln", new Date(2024, 5, 12));
        System.out.println("sheep --> " + sheep);
        */
        
        Cow cow1 = new Cow(true, 0, 3, "holstein", new Date());
        cow1.milk(10);
        
        chicken.feed(food, 2);
        
        food = new Food("hay");
        cow1.feed(food, 1);
        
        cow1.milk();
        cow1.milk(3.2F);
        cow1.milk(5);
        cow1.milk(1, bornOnDate);
    }
}
