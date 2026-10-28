
package ec.edu.espe.ConixCoffeeAndIceCreamShop.view;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.*;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence.ProductJsonManager;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence.ProductFileManager;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ProductMenu {

    private final List<Product> products;
    private final Scanner scanner;
    private final ProductJsonManager productJsonManager;
    private final ProductFileManager productFileManager;

    public ProductMenu(List<Product> products, Scanner scanner) {
    this.products = products;
    this.scanner = scanner;
    this.productJsonManager = new ProductJsonManager();
    this.productFileManager = new ProductFileManager();
    }
    

    public void showMenu() {
        int option;

        do {
            System.out.println("\n--- PRODUCTS ---");
            System.out.println("1. Register product");
            System.out.println("2. List products");
            System.out.println("3. Check profitability");
            System.out.println("0. Return");

            option = readInt("Select an option: ");

            switch (option) {
                case 1:
                    registerProduct();
                    break;
                case 2:
                    listProducts();
                    break;
                case 3:
                    showProductProfit();
                    break;
                case 0:
                    System.out.println("Returning to main menu.");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }

        } while (option != 0);
    }

    private void registerProduct() {
        System.out.println("\n1. General product");
        System.out.println("2. Ice cream");
        System.out.println("3. Beverage");

        int type = readInt("Product type: ");

        if (type < 1 || type > 3) {
            System.out.println("Invalid product type.");
            return;
        }

        int id = products.stream()
                .mapToInt(Product::getId)
                .max()
                .orElse(0) + 1;

        String name = readText("Name: ");
        float price = readNonNegativeFloat("Selling price: ");
        float cost = readNonNegativeFloat("Cost: ");

        Product product;

        switch (type) {
            case 2:
                int portions = readPositiveInt("Number of portions: ");
                float extras = readNonNegativeFloat("Extra cost: ");
                String flavour = readText("Flavor: ");

                product = new IceCream(
                        portions, extras, flavour,
                        id, name, price, cost
                );
                break;

            case 3:
                String sizeInput = readText("Size (S, M or L): ");
                char size = Character.toUpperCase(sizeInput.charAt(0));

                if (size != 'S' && size != 'M' && size != 'L') {
                    System.out.println("Invalid size.");
                    return;
                }

                String temperatureInput =
                        readText("Hot beverage? (Y/N): ");

                if (!temperatureInput.equalsIgnoreCase("Y")
                        && !temperatureInput.equalsIgnoreCase("N")) {
                    System.out.println("Enter Y or N.");
                    return;
                }

                boolean hot = temperatureInput.equalsIgnoreCase("Y");

                product = new Beverage(
                        size, hot, id, name, price, cost
                );
                break;

            default:
                product = new Product(id, name, price, cost);
                break;
        }

        products.add(product);

        try {
            productJsonManager.saveProducts(products);
            productFileManager.saveProducts(products);

            System.out.println(
                    "Product registered and saved successfully.");

        } catch (IOException e) {
            products.remove(product);

            System.out.println(
                    "Error saving product: " + e.getMessage());
        }
    }

    private void listProducts() {
        if (products.isEmpty()) {
            System.out.println("No products registered.");
            return;
        }

        System.out.println("\n--- PRODUCT LIST ---");

        for (Product product : products) {
            System.out.printf(
                    "ID: %d | Name: %s | Price: $%.2f | Cost: $%.2f%n",
                    product.getId(),
                    product.getName(),
                    product.getSellingPrice(),
                    product.getCost()
            );
        }
    }

    private void showProductProfit() {
        if (products.isEmpty()) {
            System.out.println("Register products first.");
            return;
        }

        listProducts();

        int id = readInt("Enter product ID: ");
        Product product = findProduct(id);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.printf(
                "Profit: $%.2f%n",
                product.calculateProfit());

        System.out.printf(
                "Profit margin: %.2f%%%n",
                product.calculateProfitMargin());
    }

    private Product findProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }

        return null;
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
                        scanner.nextLine().trim().replace(',', '.'));

                if (Double.isFinite(value)) {
                    return value;
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }

            System.out.println("The entered value is not valid.");
        }
    }

    private String readText(String message) {
        while (true) {
            System.out.print(message);
            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("This field cannot be empty.");
        }
    }

    private float readNonNegativeFloat(String message) {
        while (true) {
            double value = readDouble(message);

            if (value >= 0 && value <= Float.MAX_VALUE) {
                return (float) value;
            }

            System.out.println("Enter a non-negative value.");
        }
    }

    private int readPositiveInt(String message) {
        while (true) {
            int value = readInt(message);

            if (value > 0) {
                return value;
            }

            System.out.println("Enter a number greater than zero.");
        }
    }
}
