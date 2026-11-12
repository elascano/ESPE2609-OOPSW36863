/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.animalfarmapp.view;

import ec.edu.espe.animalfarmapp.model.Chicken;
import ec.edu.espe.animalfarmapp.model.Cow;
import ec.edu.espe.animalfarmapp.model.FarmAnimal;
import ec.edu.espe.animalfarmapp.model.Pig;
import ec.edu.espe.animalfarmapp.model.Sheep;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Jesus Garcia, @ESPE
 */
public class AnimalFarmApp {

    public static void main(String[] args) {
        System.out.println("Hello, This is Jesus Animal Farm!");
        FarmAnimal farmAnimal;
        farmAnimal = new FarmAnimal (1, "holstein", new Date());
        
        System.out.println("My farm animal --> " + farmAnimal);
        
        Chicken chicken = new Chicken(true, 10, true, 2, "Paleesh", new Date());
        System.out.println("Chicken --> " + chicken);
        
        Cow cow = new Cow(true, 100.5F, 3, "holstein", new Date(2022, 20, 20));
        System.out.println("Cow --> " + cow);
        
        ArrayList<FarmAnimal> animals = new ArrayList<>();
        
        animals.add(farmAnimal);
        animals.add(chicken);
        animals.add(cow);
        
        Scanner scanner = new Scanner(System.in);
        int option;
        
        do {
            System.out.println("\n========== ANIMAL FARM MENU ==========");
            System.out.println("1. Register Cow");
            System.out.println("2. Register Chicken");
            System.out.println("3. Register Sheep");
            System.out.println("4. Register Pig");
            System.out.println("5. Show All Animals");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            option = scanner.nextInt();
            
            switch (option) {

                case 1:
                    System.out.println("\n--- Register Cow ---");

                    System.out.print("Enter ID: ");
                    int cowId = scanner.nextInt();

                    System.out.print("Enter breed: ");
                    String cowBreed = scanner.next();

                    System.out.print("Is producing milk?: ");
                    boolean producingMilk = scanner.nextBoolean();

                    System.out.print("Liters of milk per week: ");
                    float liters = scanner.nextFloat();

                    Cow newCow = new Cow(producingMilk, liters, cowId, cowBreed, new Date());

                    animals.add(newCow);
                    System.out.println("Cow registered successfully!");
                    break;

                case 2:
                    System.out.println("\n--- Register Chicken ---");

                    System.out.print("Enter ID: ");
                    int chickenId = scanner.nextInt();

                    System.out.print("Enter breed: ");
                    String chickenBreed = scanner.next();

                    System.out.print("Is molting?: ");
                    boolean molting = scanner.nextBoolean();

                    System.out.print("Number of eggs per month: ");
                    int eggs = scanner.nextInt();

                    System.out.print("Is it for meat?: ");
                    boolean meat = scanner.nextBoolean();

                    Chicken newChicken = new Chicken(molting, eggs, meat, chickenId, chickenBreed, new Date());

                    animals.add(newChicken);
                    System.out.println("Chicken registered successfully!");
                    break;

                case 3:
                    System.out.println("\n--- Register Sheep ---");

                    System.out.print("Enter ID: ");
                    int sheepId = scanner.nextInt();

                    System.out.print("Enter breed: ");
                    String sheepBreed = scanner.next();

                    System.out.print("Wool production in kg: ");
                    float wool = scanner.nextFloat();

                    System.out.print("Is it sheared?: ");
                    boolean sheared = scanner.nextBoolean();

                    Sheep newSheep = new Sheep(wool, sheared, sheepId, sheepBreed, new Date());

                    animals.add(newSheep);
                    System.out.println("Sheep registered successfully!");
                    break;

                case 4:
                    System.out.println("\n--- Register Pig ---");

                    System.out.print("Enter ID: ");
                    int pigId = scanner.nextInt();

                    System.out.print("Enter breed: ");
                    String pigBreed = scanner.next();

                    System.out.print("Weight in kg: ");
                    float weight = scanner.nextFloat();

                    System.out.print("Is it for breeding?: ");
                    boolean breeding = scanner.nextBoolean();

                    Pig newPig = new Pig(weight, breeding, pigId, pigBreed, new Date());

                    animals.add(newPig);
                    System.out.println("Pig registered successfully!");
                    break;

                case 5:
                    System.out.println("\n--- REGISTERED FARM ANIMALS ---");

                    for (FarmAnimal animal : animals) {
                        System.out.println(animal);
                    }
                    break;

                case 0:
                    System.out.println("Exiting Animal Farm. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (option != 0);
        
        scanner.close();
    }
}
