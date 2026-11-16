package ec.edu.espe.animalfarmapp.view;

import ec.edu.espe.animalfarmapp.model.Chicken;
import ec.edu.espe.animalfarmapp.model.Cow;
import ec.edu.espe.animalfarmapp.model.FarmAnimal;
import ec.edu.espe.animalfarmapp.model.Food;
import ec.edu.espe.animalfarmapp.model.Pig;
import ec.edu.espe.animalfarmapp.model.Sheep;
import java.util.Date;
import java.util.Scanner;


/**
 *
 * @author Mateo Dominguez, Brain Training, @ESPE
 */
public class AnimalFarmApp {
    public static void main(String[] args) {
        Date bornOnDate = new Date(2020,10,10);
        Food foodChicken = new Food("Corn");
        Food foodCow = new Food("Hay");
        Food foodPig = new Food("Barley");
        Food foodSheep = new Food("");
        Scanner sc= new Scanner(System.in);
        int bandera = 1;
        
        System.out.println("Hello This is Mateo´s Animal Farm!");
        System.out.println("----------------------------------");
        while(bandera == 1){
        System.out.println("Select one option:");
        System.out.println("1. Chickens");
        System.out.println("2. Cows");
        System.out.println("3. Sheep");
        System.out.println("4. Pig");
        System.out.println("5. Others (class)");
        System.out.println("6. Exit");        
        
        int option = sc.nextInt();
        
            switch(option){
            case 1 -> {
                Chicken chicken1 = new Chicken(true, 10, true, 2, "Paleesh", new Date());
                System.out.println("chicken ---> " + chicken1);
                chicken1.layAndEgg();
                chicken1.feed(foodChicken, 2);
                
                break;
                }
            
            case 2 -> {
                Cow cow1 = new Cow(true, 100.5F, 8, "", bornOnDate);
                System.out.println("cow ---> " + cow1);
                cow1.milk();
                cow1.milk(10);
                cow1.milk(3.2F);
                cow1.milk(1, new Date());
                cow1.feed(foodCow, 1);
                break;
                }
            
            case 3 -> {
                Sheep sheep1 = new Sheep(new Date(), 10.60f, 1, "Merino", bornOnDate);
                System.out.println("sheep ---> " + sheep1);
                sheep1.sherring(2.3f);
                System.out.println("sheep producing ---> " + sheep1.getWeightWool());
                sheep1.feed(foodSheep, 3);
                break;
                }
            case 4 -> {
                Pig pig1 = new Pig(true, 1, "Yorkshire", bornOnDate);
                System.out.println("pigs ---> " + pig1);
                pig1.wallowing();
                pig1.rooting();
                pig1.feed(foodPig, 5);
                break;
            }
            
            case 5 -> {
                FarmAnimal chicken;
                chicken = new Chicken(true, 21, true, 1, "Paleesh", bornOnDate);
                System.out.println("FarmAnimal is a ---> " + chicken.getClass().getSimpleName());
                System.out.println("my farm animal ---> " + chicken);
                
                FarmAnimal farmAnimalForFeeding = new Cow(true, 100.5F, 3, "", new Date());
                System.out.println("farmAnimalForFeeding  is a ---> " + farmAnimalForFeeding.getClass().getSimpleName());
                break;
            }
            
            case 6 -> {
                System.out.println("Goodbye!!");
                bandera = 0;
                break;
                }   
            
            default -> {
                 System.out.println("Wrong option");
                 break;
                }
            }
        }
    }
}
