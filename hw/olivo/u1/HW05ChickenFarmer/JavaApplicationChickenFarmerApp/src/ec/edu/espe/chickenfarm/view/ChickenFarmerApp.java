
package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.controller.ChickenJsonRepository;
import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.ChickenCoop;
import ec.edu.espe.chickenfarm.controller.ChickenCsvRepository;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeParseException;
import java.util.Scanner;


/**
 *
 * @author Nestor Olivo, Found ERROR 404, @ESPE
 */
public class ChickenFarmerApp {

    private static final int MAX_CHICKENS = 10;
    private static final Scanner KEYBOARD = new Scanner(System.in);
    private static final ChickenCoop CHICKEN_COOP = new ChickenCoop();
    private static final ChickenJsonRepository REPOSITORY = new ChickenJsonRepository();
    private static final ChickenCsvRepository CSV_REPOSITORY = new ChickenCsvRepository();

    public static void main(String[] args) {

        loadChickens();

        boolean controler = true;

        while (controler) {
            showMenu();

            int option = readInteger("Enter the option: ");

            switch (option) {
                case 1 -> addChicken();
                case 2 -> removeChicken();
                case 3 -> showChickens();
                case 4 -> searchChickenById();
                case 5 -> searchChickensByName();
                case 6 -> showChickensByColor();
                case 7 -> showMoltingChickens();
                case 8 -> showChickensByAge();
                case 9 -> showCoopStatistics();
                case 10 ->saveChickensToCsv();
                case 11 -> {
                    saveChickens();
                    controler = false;
                    System.out.println("Goodbye, Chicken Farmer!");
                }
                default -> System.out.println(
                        "Invalid option. Select a number from 1 to 10."
                );
            }

            System.out.println();
        }

        KEYBOARD.close();
    }

    private static void showMenu() {
        System.out.println("=============================================");
        System.out.println("             CHICKEN FARMER APP");
        System.out.println("=============================================");
        System.out.println("1. Add a Chicken");
        System.out.println("2. Remove a Chicken");
        System.out.println("3. Show All Chickens");
        System.out.println("4. Search Chicken by ID");
        System.out.println("5. Search Chickens by Name");
        System.out.println("6. Show Chickens by Color");
        System.out.println("7. Show Molting Chickens");
        System.out.println("8. Show Chickens by Age");
        System.out.println("9. Show Coop Statistics");
        System.out.println("10. Save Chickens to CSV");
        System.out.println("11. Exit");
        System.out.println("=============================================");
    }

    private static void loadChickens() {
        try {
            Chicken[] chickens = REPOSITORY.load();

            if (chickens.length > MAX_CHICKENS) {
                System.out.println(
                        "The JSON file contains more than "
                        + MAX_CHICKENS + " chickens."
                );
                System.out.println(
                        "Please review data/chickens.json before continuing."
                );
                return;
            }

            CHICKEN_COOP.loadChickens(chickens);

            System.out.println(
                    "Chickens loaded: " + CHICKEN_COOP.getCount()
            );

        } catch (IOException | IllegalArgumentException e) {
            System.out.println(
                    "Could not load chickens: " + e.getMessage()
            );
        }
    }

    private static void addChicken() {
        if (CHICKEN_COOP.getCount() >= MAX_CHICKENS) {
            System.out.println("The chicken coop is full.");
            return;
        }

        System.out.println("\n--- Add a Chicken ---");

        String name = readRequiredText("Enter the chicken's name: ");
        String color = readRequiredText("Enter the chicken's color: ");
        LocalDate birthDate = readBirthDate();
        boolean molting = readMoltingStatus();

        Chicken chicken = new Chicken(
                name, color, birthDate, molting
        );

        int previousCount = CHICKEN_COOP.getCount();
        CHICKEN_COOP.add(chicken);

        if (CHICKEN_COOP.getCount() > previousCount) {
            saveChickens();
        }
    }

    private static void removeChicken() {
        if (CHICKEN_COOP.getCount() == 0) {
            System.out.println("There are no chickens to remove.");
            return;
        }

        showChickens();

        int chickenId = readInteger(
                "Enter the ID of the chicken to remove: "
        );

        int previousCount = CHICKEN_COOP.getCount();
        CHICKEN_COOP.remove(chickenId);

        if (CHICKEN_COOP.getCount() < previousCount) {
            saveChickens();
        }
    }

    private static void showChickens() {
        System.out.println("\n--- Chicken Coop ---");

        if (CHICKEN_COOP.getCount() == 0) {
            System.out.println("There are no chickens in the coop.");
            return;
        }

        CHICKEN_COOP.resetIteration();

        for (int i = 0; i < CHICKEN_COOP.getCount(); i++) {
            Chicken chicken = CHICKEN_COOP.next();
            System.out.println(chicken);
        }

        System.out.println(
                "Total chickens: " + CHICKEN_COOP.getCount()
        );
    }

    private static void searchChickenById() {
        if (CHICKEN_COOP.getCount() == 0) {
            System.out.println("There are no chickens to search.");
            return;
        }

        int id = readInteger("Enter the chicken ID: ");
        boolean found = false;

        CHICKEN_COOP.resetIteration();

        for (int i = 0; i < CHICKEN_COOP.getCount(); i++) {
            Chicken chicken = CHICKEN_COOP.next();

            if (chicken.getIdChicken() == id) {
                System.out.println("Chicken found:");
                System.out.println(chicken);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No chicken found with ID " + id);
        }
    }

    private static void searchChickensByName() {
        if (CHICKEN_COOP.getCount() == 0) {
            System.out.println("There are no chickens to search.");
            return;
        }

        String name = readRequiredText(
                "Enter the chicken name to search: "
        );

        int matches = 0;
        CHICKEN_COOP.resetIteration();

        for (int i = 0; i < CHICKEN_COOP.getCount(); i++) {
            Chicken chicken = CHICKEN_COOP.next();

            if (chicken.getName() != null
                    && chicken.getName().toLowerCase()
                            .contains(name.toLowerCase())) {
                System.out.println(chicken);
                matches++;
            }
        }

        showMatchCount(matches, "No chickens matched that name.");
    }

    private static void showChickensByColor() {
        if (CHICKEN_COOP.getCount() == 0) {
            System.out.println("There are no chickens to filter.");
            return;
        }

        String color = readRequiredText(
                "Enter the color to search: "
        );

        int matches = 0;
        CHICKEN_COOP.resetIteration();

        for (int i = 0; i < CHICKEN_COOP.getCount(); i++) {
            Chicken chicken = CHICKEN_COOP.next();

            if (chicken.getColor() != null
                    && chicken.getColor().equalsIgnoreCase(color)) {
                System.out.println(chicken);
                matches++;
            }
        }

        showMatchCount(matches, "No chickens found with that color.");
    }

    private static void showMoltingChickens() {
        if (CHICKEN_COOP.getCount() == 0) {
            System.out.println("There are no chickens in the coop.");
            return;
        }

        int matches = 0;
        CHICKEN_COOP.resetIteration();

        System.out.println("\n--- Molting Chickens ---");

        for (int i = 0; i < CHICKEN_COOP.getCount(); i++) {
            Chicken chicken = CHICKEN_COOP.next();

            if (chicken.isMolting()) {
                System.out.println(chicken);
                matches++;
            }
        }

        showMatchCount(matches, "There are no molting chickens.");
    }

    private static void showChickensByAge() {
        if (CHICKEN_COOP.getCount() == 0) {
            System.out.println("There are no chickens to filter.");
            return;
        }

        int age = readInteger("Enter the age in years: ");

        if (age < 0) {
            System.out.println("Age cannot be negative.");
            return;
        }

        int matches = 0;
        CHICKEN_COOP.resetIteration();

        for (int i = 0; i < CHICKEN_COOP.getCount(); i++) {
            Chicken chicken = CHICKEN_COOP.next();

            if (calculateAge(chicken) == age) {
                System.out.println(chicken);
                matches++;
            }
        }

        showMatchCount(matches, "No chickens found with that age.");
    }

    private static void showCoopStatistics() {
        int total = CHICKEN_COOP.getCount();

        if (total == 0) {
            System.out.println("There are no chickens in the coop.");
            return;
        }

        int moltingCount = 0;
        int totalAge = 0;

        CHICKEN_COOP.resetIteration();

        for (int i = 0; i < total; i++) {
            Chicken chicken = CHICKEN_COOP.next();

            if (chicken.isMolting()) {
                moltingCount++;
            }

            totalAge += calculateAge(chicken);
        }

        int nonMoltingCount = total - moltingCount;
        double averageAge = (double) totalAge / total;

        System.out.println("\n--- Coop Statistics ---");
        System.out.println("Total chickens: " + total);
        System.out.println("Molting chickens: " + moltingCount);
        System.out.println("Non-molting chickens: " + nonMoltingCount);
        System.out.printf("Average age: %.2f years%n", averageAge);
    }

    private static int calculateAge(Chicken chicken) {
        if (chicken.getBornOnDate() == null) {
            return 0;
        }

        return Period.between(
                chicken.getBornOnDate(),
                LocalDate.now()
        ).getYears();
    }

    private static String readRequiredText(String message) {
        String value;

        do {
            System.out.print(message);
            value = KEYBOARD.nextLine().trim();

            if (value.isEmpty()) {
                System.out.println("This field cannot be empty.");
            }
        } while (value.isEmpty());

        return value;
    }

    private static int readInteger(String message) {
        while (true) {
            System.out.print(message);
            String value = KEYBOARD.nextLine().trim();

            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private static LocalDate readBirthDate() {
        while (true) {
            System.out.print(
                    "Enter the birth date (YYYY-MM-DD): "
            );

            String value = KEYBOARD.nextLine().trim();

            try {
                LocalDate date = LocalDate.parse(value);

                if (date.isAfter(LocalDate.now())) {
                    System.out.println(
                            "The birth date cannot be in the future."
                    );
                    continue;
                }

                return date;

            } catch (DateTimeParseException e) {
                System.out.println(
                        "Invalid date. Use the format YYYY-MM-DD."
                );
            }
        }
    }

    private static boolean readMoltingStatus() {
        while (true) {
            System.out.print("Is the chicken molting? (true/false): ");
            String value = KEYBOARD.nextLine().trim();

            if (value.equalsIgnoreCase("true")) {
                return true;
            }

            if (value.equalsIgnoreCase("false")) {
                return false;
            }

            System.out.println("Please enter true or false.");
        }
    }

    private static void showMatchCount(int matches, String emptyMessage) {
        if (matches == 0) {
            System.out.println(emptyMessage);
        } else {
            System.out.println("Chickens found: " + matches);
        }
    }

    private static void saveChickens() {
        try {
            REPOSITORY.save(CHICKEN_COOP.getChickens());
            System.out.println("Chickens saved successfully.");
        } catch (IOException e) {
            System.out.println(
                    "Error saving chickens: " + e.getMessage()
            );
        }
    }
    
    private static void saveChickensToCsv() {
        try {
            CSV_REPOSITORY.save(CHICKEN_COOP.getChickens());

            System.out.println(
                    "Chickens exported to CSV successfully."
            );
            System.out.println(
                    "File location: data/chickens.csv"
            );

        } catch (IOException e) {
            System.out.println(
                    "Error exporting chickens to CSV: " + e.getMessage()
            );
        }
    }
}
