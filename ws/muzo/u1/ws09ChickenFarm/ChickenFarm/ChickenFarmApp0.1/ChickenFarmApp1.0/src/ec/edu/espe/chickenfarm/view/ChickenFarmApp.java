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
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class ChickenFarmApp {

    private static final String JSON_FILE = "chickens.json";
    private static final String CSV_FILE = "chickens.csv";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        // Base structure from your code
        Chicken chicken;
        Chicken chicken1;
        Egg egg;
        Poop poop;
        ChickenCoop coop;
        ChickenFarmer farmer;
        Chicken chickens[];

        chicken = new Chicken(1, "lucy", "yellow", newDate(), 1, true);
        chicken1 = new Chicken(2, "ariel", "black", newDate(), 1, true);
        egg = new Egg(1, 'M');
        poop = new Poop(1, "brown", 'S');
        coop = new ChickenCoop(101);
        farmer = new ChickenFarmer(1, "Ariel Giler");
        chickens = new Chicken[10];

        do {
            System.out.println("\n==========================================");
            System.out.println("   ARIEL GILER'S CHICKEN FARM SYSTEM     ");
            System.out.println("==========================================");
            System.out.println("1. Run Original Test Demo");
            System.out.println("2. Add Chickens and Save to Files (JSON / CSV)");
            System.out.println("3. Read Previously Saved Chickens");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            option = scanner.nextInt();
            scanner.nextLine(); // Clear scanner buffer

            switch (option) {
                case 1:
                    runOriginalDemo(chicken, chicken1, egg, poop, coop, farmer, chickens);
                    break;
                case 2:
                    addAndSaveChickens(scanner);
                    break;
                case 3:
                    readSavedChickens();
                    break;
                case 4:
                    System.out.println("Exiting system...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 4);
    }

    private static void runOriginalDemo(Chicken chicken, Chicken chicken1, Egg egg, Poop poop,
                                       ChickenCoop coop, ChickenFarmer farmer, Chicken chickens[]) {
        System.out.println("\nAriel Giler's Chicken Farm");
        System.out.println("==========================");

        System.out.println("my chicken is --> " + chicken.getName());
        System.out.println("egg --> ID: " + egg.getId() + " | Size: " + egg.getSize());
        System.out.println("egg size--> " + egg.getSize());
        System.out.println("poop --> ID: " + poop.getId() + " | Color: " + poop.getColor() + " | Consistency: " + poop.getConsistency());
        System.out.println("my chicken is --> " + chicken1.getName());

        chicken.doStuff();

        int localAge = chicken.computeAge();
        System.out.println("Chicken's age: " + localAge);

        chickens[0] = new Chicken(1, "Pepita", "black", newDate(), 1, true);
        chickens[1] = chicken;

        System.out.println("\nFirst loop:");
        for (int i = 0; i < 10; i++) {
            System.out.println("chickens ---> " + chickens[i]);
        }

        for (int i = 0; i < chickens.length; i++) {
            chickens[i] = new Chicken(i + 1, "chicken " + (i + 1), "white", newDate(), 1, true);
        }

        System.out.println("\nSecond loop (filled array):");
        for (int i = 0; i < 10; i++) {
            System.out.println("chickens ---> " + chickens[i]);
        }

        coop.add(chicken);
        coop.add(chicken1);

        farmer.add(coop);

        farmer.resetIteration();
        ChickenCoop currentCoop = farmer.next();

        while (currentCoop != null) {
            System.out.println("Farmer " + farmer.getName() + " manages Coop ID: " + currentCoop.getId());

            currentCoop.resetOperation();
            Chicken currentChicken = currentCoop.next();

            while (currentChicken != null) {
                System.out.println("  --> Chicken ID: " + currentChicken.getId() + " | Name: " + currentChicken.getName());
                currentChicken = currentCoop.next();
            }

            currentCoop = farmer.next();
        }
    }

    private static void addAndSaveChickens(Scanner scanner) {
        System.out.print("\nHow many chickens do you want to enter?: ");
        int amount = scanner.nextInt();
        scanner.nextLine();

        if (amount <= 0) {
            System.out.println("Invalid amount.");
            return;
        }

        // Native array []
        Chicken[] newChickensArray = new Chicken[amount];

        for (int i = 0; i < amount; i++) {
            System.out.println("\n--- Entering Chicken #" + (i + 1) + " ---");

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

            LocalDate bornOnDate = LocalDate.now();

            newChickensArray[i] = new Chicken(id, name, color, bornOnDate, 0, molting);
            newChickensArray[i].computeAge();
        }

        saveToJson(newChickensArray);
        saveToCsv(newChickensArray);

        System.out.println("\nChickens saved successfully in JSON and CSV files!");
    }

    // Save array to JSON format
    private static void saveToJson(Chicken[] chickens) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(JSON_FILE))) {
            writer.println("[");
            for (int i = 0; i < chickens.length; i++) {
                Chicken c = chickens[i];
                writer.println("  {");
                writer.println("    \"id\": " + c.getId() + ",");
                writer.println("    \"name\": \"" + c.getName() + "\",");
                writer.println("    \"color\": \"" + c.getColor() + "\",");
                writer.println("    \"bornOnDate\": \"" + c.getBornOnDate() + "\",");
                writer.println("    \"age\": " + c.getAge() + ",");
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

    // Save array to CSV format
    private static void saveToCsv(Chicken[] chickens) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CSV_FILE))) {
            writer.println("id,name,color,bornOnDate,age,molting");

            for (Chicken c : chickens) {
                if (c != null) {
                    writer.println(
                        c.getId() + "," +
                        c.getName() + "," +
                        c.getColor() + "," +
                        c.getBornOnDate() + "," +
                        c.getAge() + "," +
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
        System.out.println("\n==========================================");
        System.out.println("      READING SAVED CHICKEN FILES         ");
        System.out.println("==========================================");

        // 1. JSON File Reading
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
            System.out.println("JSON file does not exist yet.");
        }

        // 2. CSV File Reading
        System.out.println("\n--- CONTENT FROM CSV FILE ---");
        File fileCsv = new File(CSV_FILE);
        if (fileCsv.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE))) {
                String line;
                boolean isHeader = true;
                while ((line = reader.readLine()) != null) {
                    if (isHeader) {
                        isHeader = false; // Skip header
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
            System.out.println("CSV file does not exist yet.");
        }
    }

    private static LocalDate newDate() {
        return LocalDate.now();
    }
}