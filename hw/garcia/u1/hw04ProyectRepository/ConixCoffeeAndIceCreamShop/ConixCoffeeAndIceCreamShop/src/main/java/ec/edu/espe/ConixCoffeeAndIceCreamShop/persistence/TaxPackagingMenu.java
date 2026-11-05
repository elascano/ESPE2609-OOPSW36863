
package ec.edu.espe.ConixCoffeeAndIceCreamShop.view;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Packaging;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Tax;
import java.util.Scanner;

public class TaxPackagingMenu {

    private final Scanner scanner;
    private Tax tax;
    private Packaging packaging;

    public TaxPackagingMenu(
            Tax tax,
            Packaging packaging,
            Scanner scanner) {

        this.tax = tax;
        this.packaging = packaging;
        this.scanner = scanner;
    }

    public void showMenu() {
        int option;

        do {
            System.out.println("\n===== TAX AND PACKAGING MENU =====");
            System.out.println("1. Configure tax");
            System.out.println("2. Show tax rate");
            System.out.println("3. Configure packaging");
            System.out.println("4. Show packaging cost");
            System.out.println("0. Return to main menu");
            System.out.print("Select an option: ");

            option = readInt();

            switch (option) {
                case 1 -> configureTax();
                case 2 -> showTaxRate();
                case 3 -> configurePackaging();
                case 4 -> showPackagingCost();
                case 0 -> System.out.println(
                        "Returning to main menu...");
                default -> System.out.println("Invalid option.");
            }

        } while (option != 0);
    }

    private void configureTax() {
        System.out.print("Enter tax rate (0-100): ");
        double rate = readDouble();

        try {
            tax = new Tax(rate);
            System.out.println("Tax rate configured successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void showTaxRate() {
        if (tax == null) {
            System.out.println("No tax configuration available.");
            return;
        }

        System.out.println("Current tax rate: "
                + tax.getTaxRate() + "%");
    }

    private void configurePackaging() {
        System.out.print("Enter packaging type: ");
        String type = scanner.nextLine().trim();

        System.out.print("Enter unit cost: ");
        double cost = readDouble();

        System.out.print("Enter quantity: ");
        int quantity = readInt();

        try {
            packaging = new Packaging(type, cost, quantity);
            System.out.println(
                    "Packaging configured successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void showPackagingCost() {
        if (packaging == null) {
            System.out.println(
                    "No packaging configuration available.");
            return;
        }

        System.out.println("Packaging type: "
                + packaging.getPackagingType());

        System.out.println("Unit cost: "
                + packaging.getUnitCost());

        System.out.println("Quantity: "
                + packaging.getQuantity());

        System.out.println("Total packaging cost: "
                + packaging.calculateAdditionalPackagingCost());
    }

    public Tax getTax() {
        return tax;
    }

    public Packaging getPackaging() {
        return packaging;
    }

    private int readInt() {
        while (true) {
            String value = scanner.nextLine().trim();

            try {
                return Integer.parseInt(value);
            } catch (NumberFormatException e) {
                System.out.print("Enter a valid integer: ");
            }
        }
    }

    private double readDouble() {
        while (true) {
            String value = scanner.nextLine()
                    .trim()
                    .replace(',', '.');

            try {
                double number = Double.parseDouble(value);

                if (!Double.isFinite(number)) {
                    System.out.print(
                            "Enter a finite number: ");
                    continue;
                }

                return number;

            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }
}
