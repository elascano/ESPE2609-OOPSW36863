package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.ChickenCoop;
import ec.edu.espe.chickenfarm.model.ChickenFarmer;
import ec.edu.espe.chickenfarm.model.Egg;
import ec.edu.espe.chickenfarm.model.Poop;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Erick Revelo, Code Crafters, @ESPE
 */
public class ChickenFarmApp {

    private static final String JSON_FILE = "chickens.json";
    private static final String CSV_FILE = "chickens.csv";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("\n=====================================");
            System.out.println("  ERICK REVELO'S CHICKEN FARM SYSTEM ");
            System.out.println("=====================================");
            System.out.println("1. Original Test Demo");
            System.out.println("2. Add Chickens and Save to Files (JSON / CSV)");
            System.out.println("3. Read Saved Chickens");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println("Error. Enter a NUMBER.");
                scanner.nextLine();
                continue;
            }

            switch (option) {
                case 1 -> runOriginalDemo();
                case 2 -> addAndSaveChickens(scanner);
                case 3 -> readSavedChickens();
                case 4 -> System.out.println("\nExiting system...");
                default -> System.out.println("\nError. Try again.");
            }
        } while (option != 4);

        scanner.close();
    }

    private static void runOriginalDemo() {
        System.out.println("\nErick Revelo's Chicken Farm");    
        System.out.println("===========================");
        
        Chicken chicken;
        Egg egg;
        Poop poop;
        Chicken chicken1;
        Chicken chickens[];
        chickens = new Chicken[10];
        
        chicken = new Chicken(2, "Maruja", "white", new Date(2024 - 1900, 4, 15), false);
        egg = new Egg(1, 'M');
        chicken.setAgeInYears();
        System.out.println("my chicken is -->" + chicken);
        System.out.println("egg -->" + egg);
        System.out.println("egg size-->" + egg.getSize());
        int localAge = chicken.computeAgeInYears();
        System.out.println("the age of the chicken " + chicken.getName() + " is --> " + localAge);
        chicken.doStuff();
        
        poop = new Poop(1, "brown", 'S');
        System.out.println("Poop->" + poop);
        
        chicken1 = new Chicken(1, "Piruja", "brown and white", new Date(2021 - 1900, 7, 10), true);
        chicken1.setAgeInYears();
        System.out.println("chicken " + chicken1);
        localAge = chicken1.computeAgeInYears();
        System.out.println("the age of the chicken " + chicken1.getName() + " is --> " + localAge);
        chicken1.doStuff();
        
        int ageForTheLoop = 0;
        for (int i = 3; i < chickens.length; i++) {
            ageForTheLoop = 2010 + i;
            chickens[i] = new Chicken(i + 1, "chicken " + (i + 1), "white", new Date(ageForTheLoop - 1900, 3, 3), true);
            chickens[i].setAgeInYears();
        }
        
        chickens[2] = new Chicken(3, "Pepita", "black", new Date(2005 - 1900, 2, 2), true);
        chickens[2].setAgeInYears();
        chickens[0] = chicken1;
        chickens[1] = chicken;
        
        for (int i = 0; i < 10; i++) {
            System.out.println("chickens--->" + chickens[i]);
        }
        
        ChickenCoop chickenCoop1 = new ChickenCoop(1, new Chicken[10]); 

        chickenCoop1.add(chicken);  
        chickenCoop1.add(chicken1); 

        System.out.println("Removing from Chicken Coop: " + chickenCoop1.next());
        System.out.println("Removing from Chicken Coop: " + chickenCoop1.next());

        chickenCoop1.remove(2);
    }
    
    private static void addAndSaveChickens(Scanner scanner) {
        System.out.print("\nHow many chickens do you want to enter?: ");
        int amount = scanner.nextInt();
        scanner.nextLine();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        Chicken[] newChickensArray = new Chicken[amount];

        for (int i = 0; i < amount; i++) {
            System.out.println("\n=== Getting Chicken " + (i + 1) + " ===");

            System.out.print("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Color: ");
            String color = scanner.nextLine();

            System.out.print("Is molting? (true/false): ");
            boolean molting = scanner.nextBoolean();
            scanner.nextLine();

            Date bornOnDate = new Date();

            newChickensArray[i] = new Chicken(id, name, color, bornOnDate, 0, molting);
            newChickensArray[i].computeAge();
        }

        saveToJson(newChickensArray);
        saveToCsv(newChickensArray);

        System.out.println("\nChickens saved successfully in JSON and CSV files!");
    }

    private static void saveToJson(Chicken[] chickens) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(JSON_FILE))) {
            writer.println("[");
            for (int i = 0; i < chickens.length; i++) {
                Chicken c = chickens[i];
                writer.println("  {");
                writer.println("    \"id\": " + c.getId() + ",");
                writer.println("    \"name\": \"" + c.getName() + "\",");
                writer.println("    \"color\": \"" + c.getColor() + "\",");
                writer.println("    \"bornOnDate\": \"" + (new java.text.SimpleDateFormat("yyyy-MM-dd").format(c.getBornOnDate())) + "\",");
                writer.println("    \"age\": " + c.getAgeInYears() + ",");
                writer.println("    \"molting\": " + c.isMolting());
                if (i < chickens.length - 1) {
                    writer.println("  },");
                } else {
                    writer.println("  }");
                }
            }
            writer.println("]");
            System.out.println("-> JSON file created/updated: " + JSON_FILE);
        } catch (IOException e) {
            System.out.println("Error saving JSON: " + e.getMessage());
        }
    }

    private static void saveToCsv(Chicken[] chickens) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE))) {
            writer.println("id,name,color,bornOnDate,age,molting");

            for (Chicken c : chickens) {
                if (c != null) {
                    String formattedDate = new java.text.SimpleDateFormat("yyyy-MM-dd").format(c.getBornOnDate());
                    writer.println(
                        c.getId() + "," +
                        c.getName() + "," +
                        c.getColor() + "," +
                        formattedDate + "," +
                        c.getAgeInYears() + "," +
                        c.isMolting()
                    );
                }
            }
            System.out.println("-> CSV file created/updated: " + CSV_FILE);
        } catch (IOException e) {
            System.out.println("Error saving CSV: " + e.getMessage());
        }
    }

    private static void readSavedChickens() {
        System.out.println("\n=================================");
        System.out.println("   READING SAVED CHICKEN FILES   ");
        System.out.println("=================================");

        System.out.println("\n--- CONTENT FROM JSON FILE ---");
        File fileJson = new File(JSON_FILE);
        if (fileJson.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(JSON_FILE))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error reading JSON: " + e.getMessage());
            }
        } else {
            System.out.println("JSON file does not found.");
        }

        System.out.println("\n=== INFORMATION FROM CSV FILE ===");
        File fileCsv = new File(CSV_FILE);
        if (fileCsv.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
                String line;
                boolean isHeader = true;
                while ((line = reader.readLine()) != null) {
                    if (isHeader) {
                        isHeader = false;
                        continue;
                    }
                    String[] data = line.split(",");
                    System.out.println("ID: " + data[0] + " | Name: " + data[1] +
                            " | Color: " + data[2] + " | Date: " + data[3] +
                            " | Age: " + data[4] + " | Molting: " + data[5]);
                }
            } catch (IOException e) {
                System.out.println("Error reading CSV: " + e.getMessage());
            }
        } else {
            System.out.println("CSV file does not found.");
        }
    }
}
