package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.ChickenCoop;
import ec.edu.espe.chickenfarm.model.ChickenFarmer;
import ec.edu.espe.chickenfarm.model.Egg;
import ec.edu.espe.chickenfarm.model.Poop;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Verónica Ruiz, Code Crafters, @ESPE
 */
public class ChickenFarmApp {
    
    private static final String CsvFile = "chickens.csv";
    private static final String JsonFile = "chickens.json";
    private static final SimpleDateFormat formatDate = new SimpleDateFormat("yyyy/MM/dd");
    
    
    public static void main(String[] args) {
        
        Chicken chicken;//declaration
        Egg egg;
        Poop poop;
        Chicken chickens[];
        ChickenFarmer chickenFarmer;
        
        
        System.out.println("");
        System.out.println("=============");
        System.out.println("2026 10 21");
       
        chickenFarmer = new ChickenFarmer();
        System.out.println("chicken farmer --> " + chickenFarmer);
        System.out.println("");
        
        Scanner scanner = new Scanner(System.in);
        Chicken[] chickensArray = new Chicken[10];
        ChickenCoop coop = new ChickenCoop(1, chickensArray);
        
        int option = 0;
        
        
        while (option != 9) {
            System.out.println("");
            System.out.println("Verónica Ruiz's Chicken Farm");
            System.out.println("============================");
            System.out.println("1. Add chicken");
            System.out.println("2. Remove chicken");
            System.out.println("3. Reset chicken iteration");
            System.out.println("4. Next chicken");
            System.out.println("5. Show chicken count and list");
            System.out.println("6. Read chickens from CSV file");
            System.out.println("7. Read chickens from JSON file");
            System.out.println("9. Exit");
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
                    System.out.println("\n=== Reading from " + CsvFile + " ===");
                    try (BufferedReader br = new BufferedReader(new FileReader(CsvFile))) {
                        String linea;
                        int added = 0;
                        while ((linea = br.readLine()) != null) {
                            if (linea.trim().isEmpty() || linea.trim().toLowerCase().startsWith("id")) {
                                    continue;
                            }
                            String[] campos = linea.split(",");
                            int csvId = Integer.parseInt(campos[0].trim());
                            String csvName = campos[1].trim();
                            String csvColor = campos[2].trim();
                            Date csvDate = formatDate.parse(campos[3].trim());
                            boolean csvMolting = Boolean.parseBoolean(campos[4].trim());
 
                            Chicken csvChicken = new Chicken(csvId, csvName, csvColor, csvDate, csvMolting);
                            coop.add(csvChicken); {
                                added++;
                            }
                        }
                        System.out.println("Chickens added from CSV: " + added );
                    } catch (Exception e) {
                        System.out.println("Error reading CSV file: " + e.getMessage());
                    }
                    break;
                    
                case 7:
                    System.out.println("\n--- Reading from " + JsonFile + " ---");
                    int addedFromJson = loadFromJsonFile(coop);
                    System.out.println("Chickens added from JSON: " + addedFromJson);
                    break;
                    
                case 8: 
                    System.out.println("Exiting Chicken Farm App. Goodbye!");
                    break;
                    
                default:
                    System.out.println("Invalid option! Please choose a number between 1 and 9.");
            }
        }
       
        
        scanner.close(); 
    

        System.out.println("");
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
            System.out.println("chickens -->" + chickens[i]);
        }
        
        int ageForTheLoop = 0;
        for(int i = 0; i < chickens.length; i++){
            ageForTheLoop = 2010 + i;
            chickens[i] = new Chicken(i,"chicken " + (i+1), "white" , new Date (2020, 3, 3), true);
            chickens[i].setAgeInYears(i);
          
        }
        for (int i = 0; i < 10; i++){
            System.out.println("chickens -->" + chickens[i]);
        }
    }

    private static int loadFromJsonFile(ChickenCoop coop) {
        int added = 0;
        File file = new File(JsonFile);
        if (!file.exists()) {
            System.out.println("The file JSON '" + JsonFile + "' not found.");
            return 0;
        }
        try (FileReader reader = new FileReader(file)) {
            Gson gson = new GsonBuilder().setDateFormat("yyyy/MM/dd").create();
            Type listType = new TypeToken<ArrayList<Chicken>>(){}.getType();
            ArrayList<Chicken> jsonChickens = gson.fromJson(reader, listType);
            if (jsonChickens != null) {
                for (Chicken c : jsonChickens) {
                    coop.add(c); {
                        added++;
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error processing the JSON file: " + e.getMessage());
        }
        return added;
    }  
}