package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.ChickenCoop;
import ec.edu.espe.chickenfarm.model.Egg;
import ec.edu.espe.chickenfarm.model.Poop;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class ChickenFarmApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        
        System.out.println("Ariel Giler's Chicken Farm");
        System.out.println("==========================");
        
        Chicken chicken;
        Chicken chicken1;
        Egg egg;
        Poop poop;
        ChickenCoop coop;
        Chicken chickens[]; 
        
        chicken = new Chicken(1, "lucy", "yellow", newDate(), 1, true);
        chicken1 = new Chicken(1, "ariel", "black", newDate(), 1, true);
        egg = new Egg(1, 'M');
        poop= new Poop(1,"brown",'S');
        chickens = new Chicken[10];
        
        System.out.println("my chicken is --> " + chicken);
        System.out.println("egg --> " + egg);
        System.out.println("egg size--> " + egg.getSize());
        System.out.println("poop --> "+ poop);
        System.out.println("my chicken is --> " + chicken1);
        
        chicken.computeAgeInYears();
        chicken.doStuff();
        
        int localAge = chicken.computeAgeInYears();
        System.out.println("Chicken's age: " + localAge);
        
        chickens[0] = new Chicken(1, "Pepita", "black", newDate(), 1, true);
        chickens[1] =chicken;
        
        for (int i = 0; i < 10; i++) {
            System.out.println("chickens ---> " + chickens[i]);
        }

        for (int i = 0 ; i < chickens.length ; i++){
            chickens[i] = new Chicken(i, "chicken " + (i+1), "white ", newDate(), 1, true);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("chickens ---> " + chickens[i]);
        }
        
        Chicken[] coopChickens = new Chicken[10];
        coop = new ChickenCoop(1, coopChickens);

        int option;

        do {
            System.out.println("\n===== CHICKEN COOP MENU =====");
            System.out.println("1. Add a chicken");
            System.out.println("2. Remove a chicken");
            System.out.println("3. Show chickens");
            System.out.println("4. Exit");

            option = readInt("Choose an option: ");

            switch (option) {
                case 1:
                    addChicken(coop, coopChickens);
                    break;
                case 2:
                    removeChicken(coop);
                    break;
                case 3:
                    showChickens(coop);
                    break;
                case 4:
                    System.out.println("Exiting Chicken Coop...");
                    break;
                default:
                    System.out.println("Invalid option. Choose a number from 1 to 4.");
            }

        } while (option != 4);

        scanner.close();
    }   
    
    private static Date newDate(){
        return new Date();
    }

    private static void addChicken(ChickenCoop chickenCoop, Chicken[] coopChickens) {
        int id = generateUniqueId(coopChickens);

        System.out.println("\nAdding a new chicken");
        System.out.println("Generated chicken ID: " + id);

        String name = readText("Enter chicken name: ");
        String color = readText("Enter chicken color: ");

        LocalDate birthDate = readBirthDate();
        boolean molting = readBoolean("Is the chicken molting? (true/false): ");

        Date date = Date.from(birthDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        Chicken newChicken = new Chicken(id, name, color, date, 1, molting);

        newChicken.computeAgeInYears();
        chickenCoop.add(newChicken);

        System.out.println("Chicken added successfully.");
        System.out.println(newChicken);
    }

    private static int generateUniqueId(Chicken[] chickens) {
        int id;
        boolean repeated;

        do {
            id = random.nextInt(9000) + 1000;
            repeated = false;

            for (Chicken chicken : chickens) {
                if (chicken != null && chicken.getId() == id) {
                    repeated = true;
                    break;
                }
            }
        } while (repeated);

        return id;
    }

    private static void removeChicken(ChickenCoop chickenCoop) {
        int chickenId = readInt("Enter the ID of the chicken to remove: ");
        chickenCoop.remove(chickenId);
    }

    private static void showChickens(ChickenCoop chickenCoop) {
        System.out.println("\n===== CHICKENS IN THE COOP =====");

        chickenCoop.resetIteration();

        Chicken nextChicken;
        boolean found = false;

        while ((nextChicken = chickenCoop.next()) != null) {
            System.out.println(nextChicken);
            found = true;
        }

        if (!found) {
            System.out.println("There are no chickens in the coop.");
        }
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Enter a whole number.");
            }
        }
    }

    private static String readText(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("This field cannot be empty.");
        }
    }

    private static boolean readBoolean(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("true")) {
                return true;
            }
            if (input.equalsIgnoreCase("false")) {
                return false;
            }
            System.out.println("Enter true or false.");
        }
    }

    private static LocalDate readBirthDate() {
        while (true) {
            int year = readInt("Enter birth year: ");
            int month = readInt("Enter birth month (1-12): ");
            int day = readInt("Enter birth day: ");

            try {
                LocalDate birthDate = LocalDate.of(year, month, day);

                if (birthDate.isAfter(LocalDate.now())) {
                    System.out.println("The birth date cannot be in the future.");
                    continue;
                }
                return birthDate;

            } catch (DateTimeException e) {
                System.out.println("Invalid date. Check the year, month and day.");
            }
        }
    }
}
