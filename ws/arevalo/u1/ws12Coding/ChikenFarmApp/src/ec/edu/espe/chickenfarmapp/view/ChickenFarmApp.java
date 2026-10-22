package ec.edu.espe.chickenfarmapp.view;

import ec.edu.espe.chickenfarmapp.model.Chicken;
import ec.edu.espe.chickenfarmapp.model.ChickenCoop;
import ec.edu.espe.chickenfarmapp.model.Egg;
import ec.edu.espe.chickenfarmapp.model.Poop;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;

import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


/**
 *
 * @author Anthony Arevalo, MosQ, @ESPE
 */
public class ChickenFarmApp {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showFarmExamples();

        ChickenCoop coop = new ChickenCoop(1);
        boolean isRunning = true;

        while (isRunning) {
            showMenu();
            int option = readInteger("Choose an option: ", 1, 6);

            switch (option) {
                case 1:
                    addChicken(coop);
                    break;

                case 2:
                    removeChicken(coop);
                    break;

                case 3:
                    coop.resetIteration();
                    showMessage("Chicken iteration reset.");
                    break;

                case 4:
                    coop.next();
                    break;

                case 5:
                    showChickenCountAndList(coop);
                    break;

                case 6:
                    showMessage("Program ended.");
                    isRunning = false;
                    break;

                default:
                    showMessage("Invalid option.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n--- Anthony Arevalo's Chicken Farm App ---");
        System.out.println("1. Add chicken");
        System.out.println("2. Remove chicken");
        System.out.println("3. Reset chicken iteration");
        System.out.println("4. Next chicken");
        System.out.println("5. Show chicken count and list");
        System.out.println("6. Exit");
    }

    private static void addChicken(ChickenCoop coop) {
        try {
            int chickenId = readInteger(
                "Chicken ID: ", 1, Integer.MAX_VALUE
            );
            String name = readNonEmptyText("Name: ");
            String color = readNonEmptyText("Color: ");
            LocalDate birthDate = readBirthDate();
            boolean molting = readBoolean(
                "Is the chicken molting? (y/n): "
            );

            Chicken chicken = new Chicken(
                chickenId,
                name,
                color,
                toDate(birthDate),
                molting
            );

            chicken.setAgeInYears();
            coop.add(chicken);
            showMessage("Chicken added.");
        } catch (IllegalArgumentException | IllegalStateException e) {
            showMessage("Error: " + e.getMessage());
        }
    }

    private static void removeChicken(ChickenCoop coop) {
        int chickenId = readInteger(
            "Chicken ID to remove: ", 1, Integer.MAX_VALUE
        );

        try {
            coop.remove(chickenId);
            showMessage("Chicken removed.");
        } catch (IllegalArgumentException e) {
            showMessage("Error: " + e.getMessage());
        }
    }

    private static void showChickenCountAndList(ChickenCoop coop) {
        Chicken[] chickens = coop.getChickens();
        int chickenCount = 0;

        for (Chicken chicken : chickens) {
            if (chicken != null) {
                chickenCount++;
            }
        }

        showMessage("Number of chickens in the coop: " + chickenCount);

        if (chickenCount == 0) {
            showMessage("The coop is empty.");
            return;
        }

        coop.resetIteration();

        for (int i = 0; i < chickenCount; i++) {
            coop.next();
        }
    }

    private static void showFarmExamples() {
        Chicken chicken = new Chicken(
            2,
            "Demian",
            "white",
            toDate(LocalDate.of(1970, 10, 17)),
            false
        );
        chicken.setAgeInYears();

        Egg egg = new Egg(1, 'M');
        Poop poop = new Poop(1, "brown", 'S');

        Chicken secondChicken = new Chicken(
            1,
            "Lucy",
            "brown and white",
            toDate(LocalDate.of(1970, 12, 17)),
            true
        );
        secondChicken.setAgeInYears();

        showMessage("My chicken is: " + chicken);
        showMessage("Egg: " + egg);
        showMessage("Egg size: " + egg.getSize());
        showMessage("Poop: " + poop);
        showMessage("Chicken 1: " + secondChicken);

        int chickenAge = chicken.computeAgeInYears();
        showMessage(
            "The age of " + chicken.getName() + " is " + chickenAge
        );

        chicken.doStuff();

        Chicken[] chickens = new Chicken[10];
        chickens[0] = new Chicken(
            3,
            "Pepita",
            "black",
            toDate(LocalDate.of(2020, 2, 2)),
            true
        );
        chickens[1] = chicken;

        for (int i = 2; i < chickens.length; i++) {
            chickens[i] = new Chicken(
                i + 2,
                "Chicken" + i,
                "white",
                toDate(LocalDate.of(2020, 3, 3)),
                true
            );
        }

        showMessage("Chickens in the example array:");
        for (Chicken currentChicken : chickens) {
            System.out.println(currentChicken);
        }
    }

    private static int readInteger(
            String prompt, int minimum, int maximum) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                int number = Integer.parseInt(input);

                if (number >= minimum && number <= maximum) {
                    return number;
                }
            } catch (NumberFormatException ignored) {
                // Show the validation message below.
            }

            showMessage(
                "Enter a number between " + minimum + " and " + maximum + "."
            );
        }
    }

    private static String readNonEmptyText(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            showMessage("This field cannot be empty.");
        }
    }

    private static LocalDate readBirthDate() {
        while (true) {
            String input = readNonEmptyText(
                "Date of birth (YYYY-MM-DD): "
            );

            try {
                LocalDate birthDate = LocalDate.parse(input);

                if (!birthDate.isAfter(LocalDate.now())) {
                    return birthDate;
                }

                showMessage("The date cannot be in the future.");
            } catch (DateTimeParseException e) {
                showMessage(
                    "Use YYYY-MM-DD format, for example 2020-03-15."
                );
            }
        }
    }

    private static boolean readBoolean(String prompt) {
        while (true) {
            String input = readNonEmptyText(prompt)
                .toLowerCase(Locale.ROOT);

            if (input.equals("y") || input.equals("yes")) {
                return true;
            }

            if (input.equals("n") || input.equals("no")) {
                return false;
            }

            showMessage("Enter y or n.");
        }
    }

    private static Date toDate(LocalDate date) {
        return Date.from(
            date.atStartOfDay(ZoneId.systemDefault()).toInstant()
        );
    }

    private static void showMessage(String message) {
        System.out.println(message);
    }
    
        
}