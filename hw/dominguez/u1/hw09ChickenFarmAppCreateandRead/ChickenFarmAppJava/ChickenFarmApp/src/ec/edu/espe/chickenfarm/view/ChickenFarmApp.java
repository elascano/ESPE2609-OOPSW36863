package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.controller.ChickenFarmCsvController;
import ec.edu.espe.chickenfarm.controller.ChickenFarmJsonController;
import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.ChickenCoop;
import ec.edu.espe.chickenfarm.model.ChickenFarmer;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Mateo Dominguez, Brain Training, @ESPE
 */
public class ChickenFarmApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final ChickenFarmJsonController jsonController = new ChickenFarmJsonController();
    private static final ChickenFarmCsvController csvController = new ChickenFarmCsvController();

    private static ChickenFarmer chickenFarmer = new ChickenFarmer(1, "Mateo", new ChickenCoop[10]);

    private static String askText(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    private static int askInt(String message) {
        while (true) {
            String text = askText(message);
            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                System.out.println("Enter a whole number.");
            }
        }
    }

    private static Date askDate(String message) {
        while (true) {
            String text = askText(message);
            try {
                LocalDate localDate = LocalDate.parse(text);
                return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
            } catch (DateTimeParseException e) {
                System.out.println("Invalid date. Use the format YYYY-MM-DD, for example 2024-09-15.");
            }
        }
    }

    private static boolean askYesNo(String message) {
        while (true) {
            String text = askText(message + " (y/n): ").toLowerCase();
            if (text.equals("y")) {
                return true;
            }
            if (text.equals("n")) {
                return false;
            }
            System.out.println("Enter y or n.");
        }
    }

    private static String askFileName(String defaultName) {
        String text = askText("File name (press Enter for \"" + defaultName + "\"): ");
        return text.isEmpty() ? defaultName : text;
    }

    private static ChickenCoop findCoop(int coopId) {
        for (ChickenCoop coop : chickenFarmer.getCoops()) {
            if (coop != null && coop.getChickenCoopId() == coopId) {
                return coop;
            }
        }
        return null;
    }

    private static Chicken findChicken(ChickenCoop coop, int chickenId) {
        for (Chicken chicken : coop.getChickens()) {
            if (chicken != null && chicken.getId() == chickenId) {
                return chicken;
            }
        }
        return null;
    }

    private static ChickenCoop askExistingCoop() {
        ChickenCoop coop = findCoop(askInt("Coop id: "));
        if (coop == null) {
            System.out.println("There is no coop with that id.");
        }
        return coop;
    }

    private static String formatDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().toString();
    }

    private static void restoreIndexes() {
        chickenFarmer.resetIteration();
        while (chickenFarmer.next() != null) {
        }
        for (ChickenCoop coop : chickenFarmer.getCoops()) {
            if (coop != null) {
                coop.resetIteration();
                while (coop.next() != null) {
                }
            }
        }
    }

    private static void addCoop() {
        int coopId = askInt("New coop id: ");
        if (findCoop(coopId) != null) {
            System.out.println("A coop with that id already exists.");
            return;
        }
        chickenFarmer.add(new ChickenCoop(coopId, new Chicken[10]));
    }

    private static void removeCoop() {
        ChickenCoop coop = askExistingCoop();
        if (coop != null) {
            chickenFarmer.remove(coop.getChickenCoopId());
            System.out.println("Coop removed.");
        }
    }

    private static void addChicken() {
        ChickenCoop coop = askExistingCoop();
        if (coop == null) {
            return;
        }

        int id = askInt("Chicken id: ");
        if (findChicken(coop, id) != null) {
            System.out.println("A chicken with that id already exists in this coop.");
            return;
        }
        String name = askText("Name: ");
        String color = askText("Color: ");
        Date bornOnDate = askDate("Date of birth (YYYY-MM-DD): ");
        boolean molting = askYesNo("Is it molting?");

        coop.add(new Chicken(id, name, color, bornOnDate, molting));
    }

    private static void removeChicken() {
        ChickenCoop coop = askExistingCoop();
        if (coop == null) {
            return;
        }

        int chickenId = askInt("Chicken id: ");
        if (findChicken(coop, chickenId) == null) {
            System.out.println("There is no chicken with that id in this coop.");
            return;
        }
        coop.remove(chickenId);
        System.out.println("Chicken removed.");
    }

    private static void showFarm() {
        System.out.println("\nFarm of " + chickenFarmer.getName() + " (id " + chickenFarmer.getChickenFarmerId() + ")");

        int coopCount = 0;
        chickenFarmer.resetIteration();
        ChickenCoop coop;
        while ((coop = chickenFarmer.next()) != null) {
            coopCount++;
            System.out.println("  Coop " + coop.getChickenCoopId());

            int chickenCount = 0;
            coop.resetIteration();
            Chicken chicken;
            while ((chicken = coop.next()) != null) {
                chickenCount++;
                System.out.println("    - [" + chicken.getId() + "] " + chicken.getName()
                        + " | " + chicken.getColor()
                        + " | born " + formatDate(chicken.getBornOnDate())
                        + " | age " + chicken.computeAgeInYears()
                        + " | molting: " + (chicken.isMolting() ? "yes" : "no"));
            }
            if (chickenCount == 0) {
                System.out.println("    (no chickens)");
            }
        }
        if (coopCount == 0) {
            System.out.println("  (no coops)");
        }
    }

    private static void makeChickenDoStuff() {
        ChickenCoop coop = askExistingCoop();
        if (coop == null) {
            return;
        }

        Chicken chicken = findChicken(coop, askInt("Chicken id: "));
        if (chicken == null) {
            System.out.println("There is no chicken with that id in this coop.");
            return;
        }
        chicken.doStuff();
    }

    private static void saveToJson() {
        jsonController.saveToJson(chickenFarmer, askFileName("chickenfarm.json"));
    }

    private static void loadFromJson() {
        ChickenFarmer loaded = jsonController.loadFromJson(askFileName("chickenfarm.json"));
        if (loaded != null) {
            chickenFarmer = loaded;
            restoreIndexes();
            System.out.println("Farm loaded successfully.");
        }
    }

    private static void saveToCsv() {
        csvController.saveToCsv(chickenFarmer, askFileName("chickenfarm.csv"));
    }

    private static void loadFromCsv() {
        ChickenFarmer loaded = csvController.loadFromCsv(askFileName("chickenfarm.csv"));
        if (loaded != null) {
            chickenFarmer = loaded;
            restoreIndexes();
            System.out.println("Farm loaded successfully.");
        }
    }

    private static void showMenu() {
        System.out.println("\n========== CHICKEN FARM ==========");
        System.out.println(" 1. Add coop");
        System.out.println(" 2. Remove coop");
        System.out.println(" 3. Add chicken to a coop");
        System.out.println(" 4. Remove chicken from a coop");
        System.out.println(" 5. View the farm");
        System.out.println(" 6. Make a chicken do its stuff");
        System.out.println(" 7. Save to JSON");
        System.out.println(" 8. Load from JSON");
        System.out.println(" 9. Save to CSV");
        System.out.println("10. Load from CSV");
        System.out.println(" 0. Exit");
    }

    public static void main(String[] args) {
        System.out.println("Mateo Dominguez´s Chicken Farm");

        try {
            int option = -1;
            while (option != 0) {
                showMenu();
                option = askInt("Choose an option: ");

                switch (option) {
                    case 1:
                        addCoop();
                        break;
                    case 2:
                        removeCoop();
                        break;
                    case 3:
                        addChicken();
                        break;
                    case 4:
                        removeChicken();
                        break;
                    case 5:
                        showFarm();
                        break;
                    case 6:
                        makeChickenDoStuff();
                        break;
                    case 7:
                        saveToJson();
                        break;
                    case 8:
                        loadFromJson();
                        break;
                    case 9:
                        saveToCsv();
                        break;
                    case 10:
                        loadFromCsv();
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("\nProgram ended.");
        }
    }
}
