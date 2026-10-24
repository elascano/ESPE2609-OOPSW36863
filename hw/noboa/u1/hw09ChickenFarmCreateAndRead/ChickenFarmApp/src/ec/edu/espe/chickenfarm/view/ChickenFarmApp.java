package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.controller.ChickenFileReader;
import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.ChickenCoop;
import ec.edu.espe.chickenfarm.model.ChickenFarmer;
import ec.edu.espe.chickenfarm.model.Egg;
import ec.edu.espe.chickenfarm.model.Poop;
import java.util.Scanner;
import java.util.Date;
import java.util.List;


/**
 *
 * @author Dennis Noboa, 404 Founder, @ESPE
 */
public class ChickenFarmApp {
    public static void main(String[] args) {
        System.out.println("Dennis Noboa's Chicken Farm");
        System.out.println("===========================");
        
        Chicken chicken; //declaration
        Egg egg;
        Poop poop;
        Chicken chicken1;
        ChickenCoop coop;
        Chicken chickens[];
        chickens = new Chicken[10];
        ChickenFarmer chickenFarmer;
        
        chicken = new Chicken(1, "Claudio", "light brown", new Date(1900, 11, 17), true); //instantiation
        egg = new Egg(1, 'M');
        
        System.out.println("my chicken is --> " + chicken);
        System.out.println("egg --> " + egg);
        
        System.out.println("egg size --> " + egg.getSize());
        
        poop = new Poop(1, "brown", 'S');
        System.out.println("poop --> " + poop);
        
        chicken1 = new Chicken(2, "Lucy", "brown and white", new Date(1970, 12, 17), true);
        System.out.println("chicken 1 --> " + chicken1);
        
        int localAge = chicken.computeAgeInYears();
        System.out.println("the age of the chicken --> " + chicken.getName() + ", is --> " + localAge);
        
        chicken.doStuff();
        chickens[0] = new Chicken(3, "Pepita", "black", new Date(2020, 2, 2), true);
        chickens[1] = chicken;
        
        for (int i = 0; i < 10; i++) {
            System.out.println("chickens --> " + chickens[i]);   
        }
        
        int ageForTheLoop = 0;
        
        for (int i = 0; i < chickens.length; i++) {
            ageForTheLoop = 2010 + i;
            chickens[i] = new Chicken(i, "chicken " + (i+1), "white", new Date(2020, 3, 3), true);
            chickens[i].setAgeInYears(i);
        }
        
        for (int i = 0; i < 10; i++) {
            System.out.println("chickens --> " + chickens[i]);   
        }
        
        int chickenMenu = 0;
        Scanner scanner = new Scanner(System.in);
        while(chickenMenu != 6) {
            System.out.println("");
            System.out.println("--- Dennis Noboa's Chicken Farm App Menu ---");
            System.out.println("1. Add chicken");
            System.out.println("2. Remove chicken");
            System.out.println("3. Reset iteration");
            System.out.println("4. Next chicken");
            System.out.println("5. Show chicken list");
            System.out.println("6. Exit");
            System.out.println("");
            System.out.print("Choose an option: ");
            chickenMenu = scanner.nextInt();
            System.out.println("");
            
            switch (chickenMenu) {
                case 1:
                    System.out.println("--- ADD CHICKENS TO COOP ---");
                    System.out.print("Insert chicken ID: ");
                    int chickenId = scanner.nextInt();
                    
                    System.out.print("I");
                    break;
                case 2:
                    System.out.println("--- REMOVE CHICKENS FROM COOP ---");
                    break;
                case 3:
                    System.out.println("--- RESET ITERATION ---");
                    break;
                case 4:
                    System.out.println("--- NEXT CHICKEN ---");
                    break;
                case 5:
                    System.out.println("--- CHICKEN LIST ---");
                    for (int i = 0; i < 10; i++) {
                        System.out.println("chickens --> " + chickens[i]);   
                    }
                    break;
                case 6:
                    System.out.println("SYSTEM EXIT SUCCESFULLY...");
                    break;
                default:
                    System.out.println("ERROR: Choose an other option");
                    break;
            }
        }
        System.out.println("\n");
        System.out.println("==========");
        System.out.println("2026 10 21");
        chickenFarmer = new ChickenFarmer();
        
        System.out.println("chicken farmer --> " + chickenFarmer);
        
        System.out.println("PRIMITIVES");
        
        short addend1 = (short) 40000;
        
        System.out.println("addend1 --> " + addend1);
        
        System.out.println("Dennis Noboa's Chicken Farm");
        System.out.println("===========================");

        // Lectura desde JSON
        System.out.println("\n--- LEYENDO DESDE JSON ---");
        List<Chicken> chickensFromJSON = ChickenFileReader.readFromJson("chickens.json");
        for (Chicken ch : chickensFromJSON) {
            System.out.println(ch);
        }

        // Lectura desde CSV
        System.out.println("\n--- LEYENDO DESDE CSV ---");
        List<Chicken> chickensFromCSV = ChickenFileReader.readFromCsv("chickens.csv");
        for (Chicken ch : chickensFromCSV) {
            System.out.println(ch);
        }

        // Agregar las gallinas del CSV al ChickenCoop
        System.out.println("\n--- AGREGANDO GALLINAS DEL CSV AL COOP ---");
        coop = new ChickenCoop(1, new Chicken[10]);
        for (Chicken ch : chickensFromCSV) {
            coop.add(ch);
        }
    } 
}