package ec.edu.espe.chickenfarm.view;
import java.nio.file.Files;
import java.nio.file.Paths;
import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.ChickenCoop;

import java.util.Date;
import java.util.Scanner;

public class ChickenFarmApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Chicken[] chickens = new Chicken[10];

        ChickenCoop chickenCoop =
                new ChickenCoop(chickens, 1);

        int option;

        do {

            System.out.println("\n=== CHICKEN FARM ===");
            System.out.println("1. Add Chicken");
            System.out.println("2. Remove Chicken");
            System.out.println("3. List Chickens");
            System.out.println("4. Exit");

            System.out.print("Option: ");
            option = scanner.nextInt();

            switch (option) {

                case 1:

                    scanner.nextLine();

                    System.out.print("Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Color: ");
                    String color = scanner.nextLine();

                    System.out.print("Year: ");
                    int year = scanner.nextInt();

                    System.out.print("Month: ");
                    int month = scanner.nextInt();

                    System.out.print("Day: ");
                    int day = scanner.nextInt();

                    System.out.print("Molting (true/false): ");
                    boolean molting = scanner.nextBoolean();

                    Date bornOnDate =
                            new Date(
                                    year - 1900,
                                    month - 1,
                                    day);

                    chickenCoop.add(
                            name,
                            color,
                            bornOnDate,
                            molting);

                    break;

                case 2:

                    System.out.print(
                            "Enter Chicken ID to remove: ");

                    int chickenId =
                            scanner.nextInt();

                    chickenCoop.remove(chickenId);

                    break;

                case 3:

                    try {

                        java.nio.file.Path path =
                                java.nio.file.Paths.get("chickens.json");

                        String json =
                                java.nio.file.Files.readString(path);

                        System.out.println(json);

                    } catch (Exception e) {

                        System.out.println(
                                "There is no JSON file yet.");
                    }

                    break;
                case 4:

                    System.out.println("Goodbye!");
                    break;

                default:

                    System.out.println(
                            "Invalid option");
            }

        } while (option != 4);
    }
}