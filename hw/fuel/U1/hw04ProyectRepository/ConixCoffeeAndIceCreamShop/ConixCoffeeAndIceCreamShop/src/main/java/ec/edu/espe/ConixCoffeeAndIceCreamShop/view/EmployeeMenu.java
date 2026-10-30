
package ec.edu.espe.ConixCoffeeAndIceCreamShop.view;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Employee;
import java.util.List;
import java.util.Scanner;

public class EmployeeMenu {

    private final List<Employee> employees;
    private final Scanner scanner;

    public EmployeeMenu(List<Employee> employees, Scanner scanner) {
        this.employees = employees;
        this.scanner = scanner;
    }

    public void showMenu() {
        int option;

        do {
            System.out.println("\n===== EMPLOYEE MENU =====");
            System.out.println("1. Register employee");
            System.out.println("2. Log in employee");
            System.out.println("3. Clock in");
            System.out.println("4. Clock out");
            System.out.println("5. List employees");
            System.out.println("0. Return to main menu");
            System.out.print("Select an option: ");

            option = readInt();

            switch (option) {
                case 1 -> registerEmployee();
                case 2 -> logInEmployee();
                case 3 -> clockInEmployee();
                case 4 -> clockOutEmployee();
                case 5 -> listEmployees();
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid option.");
            }

        } while (option != 0);
    }

    private void registerEmployee() {
        System.out.println("\n--- REGISTER EMPLOYEE ---");

        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();

        if (username.isEmpty()) {
            System.out.println("Username cannot be empty.");
            return;
        }

        for (Employee employee : employees) {
            if (employee.getUsername().equalsIgnoreCase(username)) {
                System.out.println("This username already exists.");
                return;
            }
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (password.isBlank()) {
            System.out.println("Password cannot be empty.");
            return;
        }

        Employee employee = new Employee(username, password, false);
        employees.add(employee);

        System.out.println("Employee registered successfully.");
    }

    
    private void logInEmployee() {
        System.out.println("\n--- EMPLOYEE LOGIN ---");

        System.out.print("Enter username: ");
        String username = scanner.nextLine().trim();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Employee employee = null;

        for (Employee currentEmployee : employees) {
            if (currentEmployee.getUsername().equalsIgnoreCase(username)) {
                employee = currentEmployee;
                break;
            }
        }

        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        if (employee.login(username, password)) {
            System.out.println("Login successful. Welcome, "
                    + employee.getUsername() + "!");
        } else {
            System.out.println("Incorrect password.");
        }
    }


    private void clockInEmployee() {
        Employee employee = findEmployee();

        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        if (employee.isClockedIn()) {
            System.out.println("This employee has already clocked in.");
            return;
        }

        employee.clockIn();
        System.out.println("Clock-in registered for "
                + employee.getUsername() + ".");
    }

    private void clockOutEmployee() {
        Employee employee = findEmployee();

        if (employee == null) {
            System.out.println("Employee not found.");
            return;
        }

        if (!employee.isClockedIn()) {
            System.out.println("This employee has not clocked in.");
            return;
        }

        employee.clockOut();
        System.out.println("Clock-out registered for "
                + employee.getUsername() + ".");
    }

    private void listEmployees() {
        System.out.println("\n--- EMPLOYEE LIST ---");

        if (employees.isEmpty()) {
            System.out.println("No employees registered.");
            return;
        }

        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);

            System.out.println((i + 1) + ". Username: "
                    + employee.getUsername());

            System.out.println("   Status: "
                    + (employee.isClockedIn()
                    ? "Clocked in" : "Not clocked in"));
        }
    }

    private Employee findEmployee() {
        System.out.print("Enter employee username: ");
        String username = scanner.nextLine().trim();

        for (Employee employee : employees) {
            if (employee.getUsername().equalsIgnoreCase(username)) {
                return employee;
            }
        }

        return null;
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
}
