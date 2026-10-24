package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.ChickenCoop;
import ec.edu.espe.chickenfarm.model.Egg;
import ec.edu.espe.chickenfarm.model.Poop;
import java.util.Date;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author Jesus Garcia, @ESPE
 */
public class ChickenFarmApp {
    public static void main(String[] args) throws Exception {
        System.out.println("Jesus Garcia's Chicken Farms");
        System.out.println("=============================");
        Chicken chicken;
        Egg egg;
        Poop poop;
        Chicken chicken1;
        ChickenCoop coop;
        
        Chicken chickens[];
        chickens = new Chicken[10];
        
        chicken = new Chicken(2, "Maruja", "White", new Date(1970, 8, 15), false);
        chicken.setAgeInYears();
        egg = new Egg(1, 'M');
        
        
        System.out.println("My chicken is --> " + chicken);
        System.out.println("egg --> " + egg);
        
        System.out.println("egg size --> " + egg.getSize());
        
        poop = new Poop(1, "Brown", 'S');
        System.out.println("poop --> " + poop);
        
        chicken1 = new Chicken(1, "Lucy", "brown and white", new Date(), true);
        System.out.println("chicken 1--> " + chicken1);
        chicken1.setAgeInYears();
        int localAge = chicken.computeAgeInYears();
        System.out.println("the age of the chicken --> " + chicken.getName()+ ", is --> " + localAge);
        
        chicken.doStuff();
        chicken1.doStuff();
        
        coop = new ChickenCoop(1);
        
        System.out.println("\n--- ADDING CHICKENS TO THE COOP ---");
        coop.add(new Chicken(3, "Pepita", "Black", new Date(2020, 2, 2), true));
        coop.add(chicken);
        coop.add(chicken1);
        
        for (int i = 4; i <= 10; i++){
            coop.add(new Chicken(i, "chicken " + i, "white", new Date(2022, 3, 3), true));
        }
        
        System.out.println("\n--- LISTING CHICKENS ---");
        coop.resetIteration();
        Chicken current;
        while ((current = coop.next()) != null) {
            System.out.println("Chicken in coop --> " + current);
        }
        
        System.out.println("\n--- REMOVING CHICKEN ID 2 ---");
        coop.remove(2);
        
        System.out.println("\n--- LISTING REMAINING CHICKENS ---");
        coop.resetIteration();
        while ((current = coop.next()) != null) {
            System.out.println("Chicken in coop --> " + current);
        }
        
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 6) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Add Chicken");
            System.out.println("2. Remove Chicken");
            System.out.println("3. List Chickens");
            System.out.println("4. Save to CSV");
            System.out.println("5. Save to JSON");
            System.out.println("6. Exit");
            System.out.print("Select an option: ");
            
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Color: ");
                    String color = scanner.nextLine();
                    System.out.print("Birth Year: ");
                    int year = scanner.nextInt();
                    System.out.print("Molting? (true/false): ");
                    boolean molting = scanner.nextBoolean();
                    coop.add(new Chicken(id, name, color, new Date(year - 1900, 0, 1), molting));
                    break;
                    
                case 2:
                    System.out.print("Enter Chicken ID to remove: ");
                    int idToRemove = scanner.nextInt();
                    coop.remove(idToRemove);
                    break;

                case 3:
                    System.out.println("\n--- CHICKENS IN COOP ---");
                    coop.resetIteration();
                    Chicken temp;
                    while ((temp = coop.next()) != null) {
                        System.out.println(temp);
                    }
                    break;

                case 4: 
                    FileWriter csvWriter = new FileWriter("chickens.csv");
                    csvWriter.write("ID,Name,Color,Age,Molting\n"); 
                    coop.resetIteration();
                    Chicken cCsv;
                    while ((cCsv = coop.next()) != null) {
                        csvWriter.write(cCsv.getId() + "," + cCsv.getName() + "," + cCsv.getColor() + "," + 
                                     cCsv.getAgeInYears() + "," + cCsv.isMolting() + "\n");
                    }
                    csvWriter.close();
                    System.out.println("Data saved to chickens.csv successfully!");
                    break;

                case 5: 
                    FileWriter jsonWriter = new FileWriter("chickens.json");
                    Gson gson = new GsonBuilder().setPrettyPrinting().create();
                    
                    coop.resetIteration();
                    int count = 0;
                    Chicken cJson;
                    while ((cJson = coop.next()) != null) count++;
                    
                    Chicken[] validChickens = new Chicken[count];
                    coop.resetIteration();
                    for (int i = 0; i < count; i++) {
                        validChickens[i] = coop.next();
                    }
                    
                    gson.toJson(validChickens, jsonWriter);
                    jsonWriter.close();
                    System.out.println("Data saved to chickens.json successfully!");
                    break;

                case 6:
                    System.out.println("Exiting application...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
        scanner.close();
    }
    1
}
