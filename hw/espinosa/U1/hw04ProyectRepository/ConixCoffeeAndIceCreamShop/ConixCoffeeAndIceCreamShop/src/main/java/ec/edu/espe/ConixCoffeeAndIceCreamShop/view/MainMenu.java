
package ec.edu.espe.ConixCoffeeAndIceCreamShop.view;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Customer;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Employee;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Order;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Packaging;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Product;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Promotion;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Shift;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Tax;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence.CustomerJsonManager;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence.EmployeeJsonManager;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence.OrderJsonManager;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence.PackagingJsonManager;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence.ProductFileManager;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence.ProductJsonManager;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence.PromotionJsonManager;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence.ShiftJsonManager;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence.TaxJsonManager;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence.ProductReportManager;
import ec.edu.espe.ConixCoffeeAndIceCreamShop.persistence.CustomerReportManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

    private final Scanner scanner = new Scanner(System.in);

    private final List<Product> products = new ArrayList<>();
    private final List<Customer> customers = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();
    private final List<Employee> employees = new ArrayList<>();
    private final List<Promotion> promotions = new ArrayList<>();
    private final List<Shift> shifts = new ArrayList<>();
    private final ProductJsonManager productJsonManager = new ProductJsonManager();
    private final CustomerJsonManager customerJsonManager =new CustomerJsonManager();  
    private final OrderJsonManager orderJsonManager =new OrderJsonManager();
    private final PromotionJsonManager promotionJsonManager =new PromotionJsonManager();
    private final EmployeeJsonManager employeeJsonManager = new EmployeeJsonManager();
    private final ShiftJsonManager shiftJsonManager =new ShiftJsonManager();    
    private final TaxJsonManager taxJsonManager =new TaxJsonManager();  
    private final PackagingJsonManager packagingJsonManager =new PackagingJsonManager();  
    private final ProductFileManager productFileManager =new ProductFileManager(); 
    private final ProductReportManager productReportManager =new ProductReportManager();        
    private final CustomerReportManager customerReportManager =new CustomerReportManager();      
    private Tax tax = new Tax(15);
    private Packaging packaging;

    private ProductMenu productMenu;
    private CustomerMenu customerMenu;
    private OrderMenu orderMenu;
    private PromotionMenu promotionMenu;
    private EmployeeMenu employeeMenu;
    private ShiftMenu shiftMenu;
    private TaxPackagingMenu taxPackagingMenu;

    public static void main(String[] args) {
        MainMenu menu = new MainMenu();
        menu.start();
    }

    public void start() {
        loadProducts();
        loadCustomers();
        loadOrders();
        loadPromotions();
        loadEmployees();
        loadShifts();
        loadTax();
        loadPackaging();

        initializeMenus();
        runMainMenu();
    }

    private void loadProducts() {
        try {
            List<Product> savedProducts = productJsonManager.loadProducts();

            if (savedProducts.isEmpty()) {
                savedProducts = productFileManager.loadProducts();

                if (!savedProducts.isEmpty()) {
                    productJsonManager.saveProducts(savedProducts);
                    System.out.println(
                            "Existing products imported from CSV to JSON.");
                }
            }

            products.addAll(savedProducts);
            System.out.println("Products loaded: " + products.size());

        } catch (IOException e) {
            System.out.println(
                    "Error loading products: " + e.getMessage());
            products.addAll(productFileManager.loadProducts());
        }
    }

    private void loadCustomers() {
        try {
            customers.addAll(customerJsonManager.loadCustomers());
            System.out.println("Customers loaded: " + customers.size());

        } catch (IOException | IllegalArgumentException e) {
            System.out.println(
                    "Error loading customers: " + e.getMessage());
        }
    }

   
    private void loadOrders() {
        try {
            orders.addAll(orderJsonManager.loadOrders(products));
            System.out.println("Orders loaded: " + orders.size());

        } catch (IOException | IllegalArgumentException e) {
            System.out.println(
                    "Error loading orders: " + e.getMessage());
        }
    }


    private void loadPromotions() {
        try {
            promotions.addAll(promotionJsonManager.loadPromotions());
            System.out.println("Promotions loaded: " + promotions.size());

        } catch (IOException | IllegalArgumentException e) {
            System.out.println(
                    "Error loading promotions: " + e.getMessage());
        }
    }

    private void loadEmployees() {
        try {
            employees.addAll(employeeJsonManager.loadEmployees());
            System.out.println("Employees loaded: " + employees.size());

        } catch (IOException | IllegalArgumentException e) {
            System.out.println(
                    "Error loading employees: " + e.getMessage());
        }
    }

    private void loadShifts() {
        try {
            shifts.addAll(shiftJsonManager.loadShifts());
            System.out.println("Shifts loaded: " + shifts.size());

        } catch (IOException | IllegalArgumentException e) {
            System.out.println(
                    "Error loading shifts: " + e.getMessage());
        }
    }

    private void loadTax() {
        try {
            Tax savedTax = taxJsonManager.loadTax();

            if (savedTax != null) {
                tax = savedTax;
            }

            System.out.println("Tax rate loaded: " + tax.getTaxRate() + "%");

        } catch (IOException | IllegalArgumentException e) {
            System.out.println(
                    "Error loading tax: " + e.getMessage());
        }
    }

    private void loadPackaging() {
        try {
            Packaging savedPackaging =
                    packagingJsonManager.loadPackaging();

            if (savedPackaging != null) {
                packaging = savedPackaging;
            }

            if (packaging != null) {
                System.out.println(
                        "Packaging loaded: " + packaging.getPackagingType());
            } else {
                System.out.println("No packaging data found.");
            }

        } catch (IOException | IllegalArgumentException e) {
            System.out.println(
                    "Error loading packaging: " + e.getMessage());
        }
    }

    private void initializeMenus() {
        productMenu = new ProductMenu(products, scanner);
        customerMenu = new CustomerMenu(customers, scanner);

        orderMenu = new OrderMenu(
                products, customers, orders, scanner, tax, packaging);

        promotionMenu = new PromotionMenu(promotions, scanner);
        employeeMenu = new EmployeeMenu(employees, scanner);
        shiftMenu = new ShiftMenu(shifts, scanner);

        taxPackagingMenu = new TaxPackagingMenu(tax, packaging, scanner);
    }

    private void runMainMenu() {
        int option;

        do {
            System.out.println("\n======================================");
            System.out.println("  CONIX COFFEE AND ICE CREAM SHOP");
            System.out.println("======================================");
            System.out.println("1. Manage products");
            System.out.println("2. Manage customers");
            System.out.println("3. Manage orders");
            System.out.println("4. Manage promotions");
            System.out.println("5. Manage employees");
            System.out.println("6. Manage shifts");
            System.out.println("7. Taxes and packaging");
            System.out.println("0. Exit");

            option = readInt("Select an option: ");

            switch (option) {
                
                case 1 -> productMenu.showMenu();

                case 2 -> customerMenu.showMenu();

                case 3 -> orderMenu.showMenu();

                case 4 -> promotionMenu.showMenu();

                case 5 -> employeeMenu.showMenu();

                case 6 -> shiftMenu.showMenu();

                case 7 -> {
                    taxPackagingMenu.showMenu();

                    tax = taxPackagingMenu.getTax();
                    packaging = taxPackagingMenu.getPackaging();

                    orderMenu.setTax(tax);
                    orderMenu.setPackaging(packaging);
                }

                case 0 -> saveDataAndExit();

                default -> System.out.println("Invalid option.");
            }

        } while (option != 0);
    }   

    private void saveDataAndExit() {
    try {
        orderJsonManager.saveOrders(orders);
        promotionJsonManager.savePromotions(promotions);
        employeeJsonManager.saveEmployees(employees);
        shiftJsonManager.saveShifts(shifts);
        taxJsonManager.saveTax(tax);

        if (packaging != null) {
            packagingJsonManager.savePackaging(packaging);
        }

        System.out.println("All data saved successfully.");

    } catch (IOException e) {
        System.out.println(
                "Error saving data: " + e.getMessage());
    }

    try {
        productReportManager.generateReport(products);
        customerReportManager.generateReport(customers);

        System.out.println("CSV reports generated successfully.");

    } catch (IOException e) {
        System.out.println(
                "Error generating CSV reports: " + e.getMessage());
    }

    System.out.println("Tax saved: " + tax.getTaxRate() + "%");
    System.out.println(
            "Thank you for visiting Conix Coffee and Ice Cream Shop!");
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
}
