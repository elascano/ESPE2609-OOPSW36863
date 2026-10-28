
package ec.edu.espe.ConixCoffeeAndIceCreamShop.view;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Promotion;
import java.util.List;
import java.util.Scanner;

public class PromotionMenu {

    private final List<Promotion> promotions;
    private final Scanner scanner;

    public PromotionMenu(List<Promotion> promotions, Scanner scanner) {
        this.promotions = promotions;
        this.scanner = scanner;
    }

    public void showMenu() {
        int option;

        do {
            System.out.println("\n--- PROMOTIONS ---");
            System.out.println("1. Register promotion");
            System.out.println("2. Calculate discount");
            System.out.println("0. Return");

            option = readInt("Select an option: ");

            switch (option) {
                case 1 -> registerPromotion();
                case 2 -> calculatePromotion();
                case 0 -> System.out.println("Returning to main menu.");
                default -> System.out.println("Invalid option.");
            }
        } while (option != 0);
    }

    private void registerPromotion() {
        double percentage = readDouble("Discount percentage: ");

        try {
            Promotion promotion = new Promotion(true, percentage);
            promotions.add(promotion);
            System.out.println("Promotion registered.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void calculatePromotion() {
        if (promotions.isEmpty()) {
            System.out.println("No promotions registered.");
            return;
        }

        for (int i = 0; i < promotions.size(); i++) {
            System.out.printf(
                    "%d. Discount: %.2f%%%n",
                    i + 1,
                    promotions.get(i).getDiscountPercentage()
            );
        }

        int number = readInt("Select a promotion: ");

        if (number < 1 || number > promotions.size()) {
            System.out.println("Invalid promotion.");
            return;
        }

        double amount = readDouble("Purchase amount: ");

        try {
            double discount = promotions.get(number - 1)
                    .computeDiscount(amount);

            System.out.printf("Discount: $%.2f%n", discount);
            System.out.printf(
                    "Amount after discount: $%.2f%n",
                    amount - discount
            );
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private int readInt(String message) {
        while (true) {
            System.out.print(message);

            try {
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }

    private double readDouble(String message) {
        while (true) {
            System.out.print(message);

            try {
                double value = Double.parseDouble(
                        scanner.nextLine().trim().replace(',', '.')
                );

                if (Double.isFinite(value)) {
                    return value;
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }

            System.out.println("The entered value is not valid.");
        }
    }
}
