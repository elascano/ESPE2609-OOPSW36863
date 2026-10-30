package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.ChickenCoop;
import ec.edu.espe.chickenfarm.model.ChickenFarmer;
import ec.edu.espe.chickenfarm.model.Egg;
import ec.edu.espe.chickenfarm.model.Poop;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author Verónica Ruiz, Code Crafters, @ESPE
 */
public class ChickenFarmApp {
    public static void main(String[] args) {
       
        System.out.println("Verónica Ruiz's Chicken Farm");
        System.out.println("============================");
        
        Chicken chicken;//declaration
        Egg egg;
        Poop poop;
        ChickenCoop coop;
        Chicken chickens[];
        ChickenFarmer chickenFarmer;
        
        chickens = new Chicken[10];
        chicken = new Chicken(1, "Laura", "white", new Date(1970, 11, 17), false);
        egg = new Egg(1, 'M');
        
        System.out.println("my chicken is --> " + chicken);
        System.out.println("egg --> " + egg);
        
        System.out.println("egg size --> " + egg.getSize());
        
        poop = new Poop(1, "brown", 'S');
        System.out.println("poop --> " + poop);
        Chicken chicken1 = new Chicken(1, "Lucy", "brown and white", new Date(1970, 12, 17), true);
        System.out.println("chicken 1 --> " + chicken1);
        
        int localAge = chicken.computeAgeInYears();
        System.out.println("the age of the chicken --> " + chicken.getName() + ", is --> " + localAge);
        
        chicken.doStuff();
        chickens[0] = new Chicken(3,"Pepita", "black",new Date(2020, 2, 2), true);
        chickens[1] = chicken;
        
        for (int i = 0; i < 10; i++){
            System.out.println("chickens --> " + chickens[i]);
        }
        
        int ageForTheLoop = 0;
        for(int i = 0; i < chickens.length; i++){
            ageForTheLoop = 2010 + i;
            chickens[i] = new Chicken(i,"chicken " + (i+1), "white" , new Date (2020, 3, 3), true);
            chickens[i].setAgeInYears(i);
          
        }
        
        for (int i = 0; i < 10; i++){
            System.out.println("chickens --> " + chickens[i]);
        }
        
        
        System.out.println("PRIMITIVES");
        float addend1 = 40000;
        System.out.println("addend1 --> " + addend1);
       
        System.out.println("");
        System.out.println("Add New Chicken");
        System.out.println("===============");
        coop = new ChickenCoop(1, new Chicken[10]);
        coop.add(chicken);
        coop.add(chicken1);
        coop.add(new Chicken(4, "Claudio", "gray", new Date(2021, 5, 5), true));
              
        System.out.println("");
        System.out.println("=============");
        System.out.println("2026 10 21");
       
        chickenFarmer = new ChickenFarmer();
        System.out.println("chicken farmer --> " + chickenFarmer);
        System.out.println("");
        
        Scanner scanner = new Scanner(System.in);
        Chicken[] chickensArray = new Chicken[10];
        new ChickenCoop(1, chickensArray);
        
        int option = 0;
        
        while (option != 6) {
            System.out.println("");
            System.out.println("Verónica Ruiz's Chicken Farm");
            System.out.println("============================");
            System.out.println("1. Add chicken");
            System.out.println("2. Remove chicken");
            System.out.println("3. Reset chicken iteration");
            System.out.println("4. Next chicken");
            System.out.println("5. Show chicken count and list");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            
        option = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (option) {
                case 1:
                    System.out.print("Chicken ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Color: ");
                    String color = scanner.nextLine();
                    
                    System.out.print("Date of birth (YYYY-MM-DD): ");
                    String dateInput = scanner.nextLine();
                    String[] dateParts = dateInput.split("-");
                    int year = Integer.parseInt(dateParts[0]);
                    int month = Integer.parseInt(dateParts[1]);
                    int day = Integer.parseInt(dateParts[2]);
                    Date bornDate = new Date(year, month, day);
                    
                    System.out.print("Is the chicken molting? (y/n): ");
                    String moltingInput = scanner.nextLine();
                    boolean isMolting = moltingInput.equalsIgnoreCase("y");
                    
                   
                    Chicken newChicken = new Chicken(id, name, color, bornDate, isMolting);
                    coop.add(newChicken);
                    break;
                    
                case 2: 
                    System.out.print("Enter Chicken ID to remove: ");
                    int idToRemove = scanner.nextInt();
                    scanner.nextLine(); 
                    coop.remove(idToRemove);
                    break;
                    
                case 3:
                    coop.resetIteration();
                    System.out.println("Chicken iteration has been reset.");
                    break;
                    
                case 4: 
                    Chicken nextChicken = coop.next();
                    if (nextChicken != null) {
                        System.out.println("Next chicken --> " + nextChicken);
                    } else {
                        System.out.println("No more chickens in the iteration loop (or coop is empty).");
                    }
                    break;
                    
                case 5: 
                    System.out.println("\n=== Chicken List ===");
                    coop.resetIteration();
                    Chicken current = coop.next();
                    int count = 0;
                    
                    while (current != null) {
                        count++;
                        System.out.println("   -> " + current);
                        current = coop.next();
                    }
                    System.out.println("Total chickens currently in the coop: " + count);
                    break;
                    
                case 6: 
                    System.out.println("Exiting Chicken Farm App. Goodbye!");
                    break;
                    
                default:
                    System.out.println("Invalid option! Please choose a number between 1 and 6.");
            }
        }
        
    }

}