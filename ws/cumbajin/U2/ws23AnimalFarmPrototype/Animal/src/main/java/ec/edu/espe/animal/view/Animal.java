
package ec.edu.espe.animal.view;

import ec.edu.espe.animal.model.Chicken;
import ec.edu.espe.animal.model.Cow;
import ec.edu.espe.animal.model.Pig;
import ec.edu.espe.animal.model.Sheep;
import java.util.Date;
import java.util.Scanner;
import java.util.Locale;

/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
public class Animal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        int option;

        do {
            option = showMenu(scanner);

            switch (option) {
                case 1:
                    Chicken chicken = createChicken(scanner);
                    System.out.println("Chicken -> " + chicken);
                    break;

                case 2:
                    Cow cow = createCow(scanner);
                    System.out.println("Cow -> " + cow);
                    cow.milk();
                    break;

                case 3:
                    Pig pig = createPig(scanner);
                    System.out.println("Pig -> " + pig);
                    break;

                case 4:
                    Sheep sheep = createSheep(scanner);
                    System.out.println("Sheep -> " + sheep);
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }

            System.out.println();

        } while (option != 5);

    }

    // MENU
    public static int showMenu(Scanner scanner) {

        System.out.println("========== FARM ANIMAL MENU ==========");
        System.out.println("1. Create Chicken");
        System.out.println("2. Create Cow");
        System.out.println("3. Create Pig");
        System.out.println("4. Create Sheep");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");

        return scanner.nextInt();
    }

    // CREATE CHICKEN
    public static Chicken createChicken(Scanner scanner) {

        System.out.println("----- ENTER CHICKEN DATA -----");

        int id = readId(scanner);
        String bread = readBread(scanner);
        Date bornOnDate = readDate(scanner, "born date");

        boolean isMolting = readBoolean(scanner,
                "Is molting? (true/false): ");

        System.out.print("Number of eggs this month: ");
        int numberOffLatIsMonth = scanner.nextInt();

        boolean isMeat = readBoolean(scanner,
                "Is meat? (true/false): ");

        return new Chicken(id, bread, bornOnDate,
                isMolting, numberOffLatIsMonth, isMeat);
    }

    // CREATE COW
    public static Cow createCow(Scanner scanner) {

        System.out.println("----- ENTER COW DATA -----");

        int id = readId(scanner);
        String bread = readBread(scanner);
        Date bornOnDate = readDate(scanner, "born date");

        boolean isProducingMilk = readBoolean(scanner,
                "Is producing milk? (true/false): ");

        System.out.print("Liters of milk per week: ");
        float litersOfMilkPerWeek = scanner.nextFloat();

        return new Cow(isProducingMilk, litersOfMilkPerWeek,
                id, bread, bornOnDate);
    }

    // CREATE PIG
    public static Pig createPig(Scanner scanner) {

        System.out.println("----- ENTER PIG DATA -----");

        int id = readId(scanner);
        String bread = readBread(scanner);
        Date bornOnDate = readDate(scanner, "born date");

        return new Pig(id, bread, bornOnDate);
    }

    // CREATE SHEEP
    public static Sheep createSheep(Scanner scanner) {

        System.out.println("----- ENTER SHEEP DATA -----");

        int id = readId(scanner);
        String bread = readBread(scanner);
        Date bornOnDate = readDate(scanner, "born date");
        Date lastSheering = readDate(scanner, "last sheering date");

        return new Sheep(lastSheering, id, bread, bornOnDate);
    }

    // READ ID
    public static int readId(Scanner scanner) {

        System.out.print("Enter id: ");
        return scanner.nextInt();
    }

    // READ BREAD
    public static String readBread(Scanner scanner) {

        System.out.print("Enter bread: ");
        return scanner.next();
    }

    // READ DATE
    public static Date readDate(Scanner scanner, String message) {

        System.out.println("Enter " + message + ":");

        System.out.print("Day: ");
        int day = scanner.nextInt();

        System.out.print("Month: ");
        int month = scanner.nextInt();

        System.out.print("Year: ");
        int year = scanner.nextInt();

        return new Date(year - 1900, month - 1, day);
    }

    // READ BOOLEAN
    public static boolean readBoolean(Scanner scanner, String message) {

        System.out.print(message);
        return scanner.nextBoolean();
    }
}
