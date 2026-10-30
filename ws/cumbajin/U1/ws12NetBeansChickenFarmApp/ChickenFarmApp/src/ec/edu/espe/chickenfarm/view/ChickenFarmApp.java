

package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.controller.ChickenFileManager;
import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.ChickenCoop;
import ec.edu.espe.chickenfarm.model.Egg;
import ec.edu.espe.chickenfarm.model.Poop;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
public class ChickenFarmApp {

    public static void main(String[] args) throws Exception {
        System.out.println("Dylan Cumbajin's Chicken Farm");
        System.out.println("=============================");

        Chicken chicken;
        Egg egg;
        Poop poop;
        Chicken chicken1;
        ChickenCoop coop;
        Chicken chickens[];
        chickens = new Chicken[10];

        chicken = new Chicken(2, "Maruja", "white",
                new Date(70, 11, 17), false);
        chicken.setAgeInYears();

        egg = new Egg(1, 'M');

        System.out.println("my chicken is --> " + chicken);
        System.out.println("egg --> " + egg);
        System.out.println("egg size --> " + egg.getSize());

        poop = new Poop(0, "brown", 'S');
        System.out.println("poop --> " + poop);

        chicken1 = new Chicken(1, "Lucy", "brown and white",
                new Date(70, 11, 17), true);
        chicken1.setAgeInYears();

        System.out.println("chicken 1 --> " + chicken1);

        int localAge = chicken.computeAgeInYears();

        System.out.println("the age of the chicken --> "
                + chicken.getName() + ", is --> " + localAge);

        chicken.doStuff();

        chickens[0] = new Chicken(3, "Pepita", "black",
                new Date(120, 2, 2), true);
        chickens[1] = chicken;

        for (int i = 0; i < 10; i++) {
            System.out.println("chickens --> " + chickens[i]);
        }

        int ageForTheLoop = 0;

        for (int i = 0; i < chickens.length; i++) {
            ageForTheLoop = 2010 + i;

            chickens[i] = new Chicken(i, "chicken " + (i + 1),
                    "white", new Date(ageForTheLoop - 1900, 3, 3), true);

            chickens[i].setAgeInYears();
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("chickens --> " + chickens[i]);
        }

        // Testing ChickenCoop methods
        System.out.println("\n===== CHICKEN COOP TEST =====");

        coop = new ChickenCoop(1, new Chicken[10]);

        // Testing add()
        System.out.println("\n--- ADD CHICKENS ---");
        coop.add(chicken);
        coop.add(chicken1);

        // Testing next()
        System.out.println("\n--- LIST CHICKENS ---");
        coop.resetIteration();

        Chicken currentChicken;

        while ((currentChicken = coop.next()) != null) {
            System.out.println("Chicken --> "
                    + currentChicken.getName()
                    + ", ID --> " + currentChicken.getId());
        }

        // Testing remove()
        System.out.println("\n--- REMOVE CHICKEN ---");
        coop.remove(2);

        // Verify remaining chickens
        System.out.println("\n--- REMAINING CHICKENS ---");
        coop.resetIteration();

        while ((currentChicken = coop.next()) != null) {
            System.out.println("Chicken --> "
                    + currentChicken.getName()
                    + ", ID --> " + currentChicken.getId());
        }

        System.out.println("\n===== TEST COMPLETED =====");

        // Menu
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n===== CHICKEN FARM APP =====");
            System.out.println("1. Save Chickens");
            System.out.println("2. Read Chickens");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");

            option = scanner.nextInt();

            switch (option) {
                case 1:
                    ChickenFileManager.saveJSON(chickens);
                    ChickenFileManager.saveCSV(chickens);
                    break;

                case 2:
                    System.out.println("\n--- CHICKENS FROM JSON ---");

                    Chicken[] jsonChickens = ChickenFileManager.readJSON();

                    if (jsonChickens != null) {
                        for (int i = 0; i < jsonChickens.length; i++) {
                            if (jsonChickens[i] != null) {
                                System.out.println(jsonChickens[i]);
                            }
                        }
                    }

                    System.out.println("\n--- CHICKENS FROM CSV ---");

                    Chicken[] csvChickens = ChickenFileManager.readCSV();

                    for (int i = 0; i < csvChickens.length; i++) {
                        if (csvChickens[i] != null) {
                            System.out.println(csvChickens[i]);
                        }
                    }
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option");
                    break;
            }

        } while (option != 3);
    }
}
