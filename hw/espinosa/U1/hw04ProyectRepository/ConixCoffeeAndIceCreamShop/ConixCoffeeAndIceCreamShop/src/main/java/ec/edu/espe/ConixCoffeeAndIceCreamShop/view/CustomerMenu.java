
package ec.edu.espe.ConixCoffeeAndIceCreamShop.view;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Customer;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence.CustomerJsonManager;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class CustomerMenu {

    private final List<Customer> customers;
    private final Scanner scanner;
    private final CustomerJsonManager customerJsonManager;

    public CustomerMenu(List<Customer> customers, Scanner scanner) {
        this.customers = customers;
        this.scanner = scanner;
        this.customerJsonManager = new CustomerJsonManager();
    }

    public void showMenu() {
        int option;

        do {
            System.out.println("\n--- CUSTOMERS ---");
            System.out.println("1. Register customer");
            System.out.println("2. List customers");
            System.out.println("0. Return");

            option = readInt("Select an option: ");

            switch (option) {
                case 1:
                    registerCustomer();
                    break;
                case 2:
                    listCustomers();
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

    private void registerCustomer() {
        String name = readText("Name: ");
        String phone = readText("Phone: ");
        String email = readText("Email: ");

        Customer customer = new Customer(name, phone, email);
        customers.add(customer);

        try {
            customerJsonManager.saveCustomers(customers);

            System.out.println(
                    "Customer registered and saved successfully.");

        } catch (IOException e) {
            customers.remove(customer);

            System.out.println(
                    "Error saving customer: " + e.getMessage());
        }
    }

    private void listCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers registered.");
            return;
        }

        System.out.println("\n--- CUSTOMER LIST ---");

        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);

            System.out.printf(
                    "%d. %s | Phone: %s | Email: %s%n",
                    i + 1,
                    customer.getName(),
                    customer.getPhone(),
                    customer.getEmail()
            );
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
}
