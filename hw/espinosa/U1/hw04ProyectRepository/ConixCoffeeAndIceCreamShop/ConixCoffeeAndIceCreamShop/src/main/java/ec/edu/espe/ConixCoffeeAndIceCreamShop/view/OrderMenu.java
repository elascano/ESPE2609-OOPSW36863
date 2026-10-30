
package ec.edu.espe.ConixCoffeeAndIceCreamShop.view;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.*;
import java.util.List;
import java.util.Scanner;

public class OrderMenu {

    private final List<Product> products;
    private final List<Customer> customers;
    private final List<Order> orders;
    private final Scanner scanner;

    private Tax tax;
    private Packaging packaging;

    public OrderMenu(
            List<Product> products,
            List<Customer> customers,
            List<Order> orders,
            Scanner scanner,
            Tax tax,
            Packaging packaging) {

        this.products = products;
        this.customers = customers;
        this.orders = orders;
        this.scanner = scanner;
        this.tax = tax;
        this.packaging = packaging;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public void setPackaging(Packaging packaging) {
        this.packaging = packaging;
    }

    public void showMenu() {
        int option;

        do {
            System.out.println("\n--- ORDERS ---");
            System.out.println("1. Create order");
            System.out.println("2. Add product to order");
            System.out.println("3. Apply general discount");
            System.out.println("4. View order and total");
            System.out.println("5. List orders");
            System.out.println("0. Return");

            option = readInt("Select an option: ");

            switch (option) {
                case 1 -> createOrder();
                case 2 -> addProductToOrder();
                case 3 -> applyOrderDiscount();
                case 4 -> showOrder();
                case 5 -> listOrders();
                case 0 -> System.out.println("Returning to main menu.");
                default -> System.out.println("Invalid option.");
            }
        } while (option != 0);
    }

    private void createOrder() {
        if (customers.isEmpty()) {
            System.out.println("Register a customer first.");
            return;
        }

        listCustomers();
        int customerNumber = readInt("Customer number: ");

        if (customerNumber < 1 || customerNumber > customers.size()) {
            System.out.println("Invalid customer.");
            return;
        }

        Order order = new Order();
        order.setTax(tax);

        if (packaging != null) {
            order.setPackaging(packaging);
        }

        orders.add(order);
        customers.get(customerNumber - 1).placeOrder(order);

        System.out.println(
                "Order created. Order number: " + orders.size()
        );
    }

    private void addProductToOrder() {
        if (orders.isEmpty() || products.isEmpty()) {
            System.out.println(
                    "You need to register products and create an order first."
            );
            return;
        }

        listOrders();
        int orderNumber = readInt("Order number: ");

        if (orderNumber < 1 || orderNumber > orders.size()) {
            System.out.println("Invalid order.");
            return;
        }

        listProducts();
        int productId = readInt("Product ID: ");
        Product product = findProduct(productId);

        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        int quantity = readPositiveInt("Quantity: ");

        try {
            OrderDetail detail = new OrderDetail(
                    product,
                    quantity,
                    product.getSellingPrice()
            );

            orders.get(orderNumber - 1).addOrderDetail(detail);
            System.out.println("Product added to order.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void applyOrderDiscount() {
        if (orders.isEmpty()) {
            System.out.println("There are no orders.");
            return;
        }

        listOrders();
        int number = readInt("Order number: ");

        if (number < 1 || number > orders.size()) {
            System.out.println("Invalid order.");
            return;
        }

        Order order = orders.get(number - 1);
        double subtotal = order.calculateOrderSubtotal();

        System.out.printf("Subtotal: $%.2f%n", subtotal);
        double discount = readDouble("Discount in dollars: ");

        try {
            order.setDiscount(discount);
            System.out.println("Discount applied.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void showOrder() {
        if (orders.isEmpty()) {
            System.out.println("There are no orders.");
            return;
        }

        listOrders();
        int number = readInt("Order number: ");

        if (number < 1 || number > orders.size()) {
            System.out.println("Invalid order.");
            return;
        }

        Order order = orders.get(number - 1);

        System.out.println("\n--- ORDER DETAILS ---");

        for (OrderDetail detail : order.getOrderDetails()) {
            System.out.printf(
                    "%s | Quantity: %d | Total: $%.2f%n",
                    detail.getProduct().getName(),
                    detail.getQuantity(),
                    detail.calculateTotal()
            );
        }

        System.out.printf(
                "Subtotal: $%.2f%n",
                order.calculateOrderSubtotal()
        );

        System.out.printf(
                "General discount: $%.2f%n",
                order.applyDiscount()
        );

        System.out.printf("Tax: $%.2f%n", order.addTaxTotal());

        System.out.printf(
                "Packaging: $%.2f%n",
                order.addPackagingTotalCost()
        );

        System.out.printf(
                "TOTAL: $%.2f%n",
                order.calculateOrderTotal()
        );

        System.out.printf(
                "Items: %d%n",
                order.calculateTotalItemsSold()
        );
    }

    private void listOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders registered.");
            return;
        }

        System.out.println("\n--- ORDER LIST ---");

        for (int i = 0; i < orders.size(); i++) {
            System.out.printf(
                    "Order %d | Items: %d | Total: $%.2f%n",
                    i + 1,
                    orders.get(i).calculateTotalItemsSold(),
                    orders.get(i).calculateOrderTotal()
            );
        }
    }

    private void listCustomers() {
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

    private void listProducts() {
        System.out.println("\n--- PRODUCT LIST ---");

        for (Product product : products) {
            System.out.printf(
                    "ID: %d | Name: %s | Price: $%.2f%n",
                    product.getId(),
                    product.getName(),
                    product.getSellingPrice()
            );
        }
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
