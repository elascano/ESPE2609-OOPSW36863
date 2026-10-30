package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.Egg;
import ec.edu.espe.chickenfarm.model.Poop;
import ec.edu.espe.chickenfarm.model.ChickenCoop;
import ec.edu.espe.chickenfarm.model.ChickenFarmer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class ChickenFarmApp {
    public static void main(String[] args) {
        System.out.println("Stalyn Guerrero's Chicken Farm");
        System.out.println("===============================");
        
        
        Chicken chicken; 
        Egg egg;
        Poop poop;
        Chicken chicken1;
        ChickenCoop coop;
        Chicken chickens[];
        ChickenFarmer chickenFarmer; 
        
        chickens = new Chicken[10]; 
        
        chicken = new Chicken(2, "Maruja", "white", new Date(124, 8, 15), false); 
        chicken.setAgeInYears();
        egg = new Egg(1, 'M');
        
        System.out.println("my chicken is --> " + chicken);
        System.out.println("egg --> " + egg);
        System.out.println("egg size --> " + egg.getSize());
        
        poop = new Poop(1, "brown", 'S');
        System.out.println("poop --> " + poop);
        
        chicken1 = new Chicken(1, "Lucy", "brown and white", new Date(), true);
        System.out.println("chicken 1 --> " + chicken1);
        
        int localAge = chicken.computeAgeInYears();
        System.out.println("the age of the chicken --> " + chicken.getName() + " is ---> " + localAge);
        
        chicken.dostuff();
        
        chickens[0] = new Chicken(2, "Pepita", "black", new Date(120,2,2), true);
        chickens[1] = chicken;
        
        int ageForTheLoop = 0;
        for (int i = 0; i < chickens.length; i++){
            ageForTheLoop = 110; 
            chickens[i] = new Chicken (i, "Chicken" + (i+1), "white", new Date(ageForTheLoop, 3, 3), true);
            chickens[i].setAgeInYears();
        }
        
        for (int i = 0; i < 10; i++){
            System.out.println("chickens ---> " + chickens[i]);
        }
        
        System.out.println("============Exercise=========");
        
        coop = new ChickenCoop(1, new Chicken[10]);
        
        chicken1 = new Chicken();
        
        coop.add(new Chicken());
        
        coop.remove(1);
        
        coop.resetIteration();
        Chicken currentChicken;
        
        while ((currentChicken = coop.next()) != null) {
            System.out.println("Chicken found: " + currentChicken);
        }
        
        chickenFarmer = new ChickenFarmer(1, "Stalyn");
        System.out.println("Chicken farmer ---> " + chickenFarmer);
        
        
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        Chicken[] fileChickensArray = new Chicken[3];

        do {
            System.out.println("\n===============================");
            System.out.println("      homework09     ");
            System.out.println("\n===============================");
            System.out.println("1. Enter chickens into array and save to CSV & JSON");
            System.out.println("2. Read chickens from files");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    System.out.println("\n--- ENTERING CHICKENS FOR FILES ---");
                    for (int i = 0; i < fileChickensArray.length; i++) {
                        System.out.println("Chicken #" + (i + 1));
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        
                        System.out.print("Enter Color: ");
                        String color = scanner.nextLine();

                        fileChickensArray[i] = new Chicken(id, name, color, new Date(), false);
                    }

                    saveToCSV(fileChickensArray);
                    saveToJSON(fileChickensArray);
                    break;

                case 2:
                    System.out.println("\n--- READING CSV FILE ---");
                    readFile("chickens.csv");
                    
                    System.out.println("\n--- READING JSON FILE ---");
                    readFile("chickens.json");
                    break;

                case 3:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option, try again.");
            }

        } while (option != 3);

        scanner.close();
    }

    public static void saveToCSV(Chicken[] chickens) {
        try {
            FileWriter writer = new FileWriter("chickens.csv");
            writer.write("ID,Name,Color\n");
            for (int i = 0; i < chickens.length; i++) {
                if (chickens[i] != null) {
                    writer.write(chickens[i].getId() + "," + chickens[i].getName() + "," + chickens[i].getColor() + "\n");
                }
            }
            writer.close();
            System.out.println("CSV file saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving CSV: " + e.getMessage());
        }
    }

    public static void saveToJSON(Chicken[] chickens) {
        try {
            FileWriter writer = new FileWriter("chickens.json");
            writer.write("[\n");
            for (int i = 0; i < chickens.length; i++) {
                if (chickens[i] != null) {
                    writer.write("  {\n");
                    writer.write("    \"id\": " + chickens[i].getId() + ",\n");
                    writer.write("    \"name\": \"" + chickens[i].getName() + "\",\n");
                    writer.write("    \"color\": \"" + chickens[i].getColor() + "\"\n");
                    writer.write("  }\n");
                }
            }
            writer.write("]\n");
            writer.close();
            System.out.println("JSON file saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving JSON: " + e.getMessage());
        }
    }

    public static void readFile(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("The file does not exist yet.");
                return;
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

