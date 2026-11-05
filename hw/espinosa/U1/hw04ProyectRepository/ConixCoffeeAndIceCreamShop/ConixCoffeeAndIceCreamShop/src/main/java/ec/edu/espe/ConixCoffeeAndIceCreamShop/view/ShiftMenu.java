
package ec.edu.espe.ConixCoffeeAndIceCreamShop.view;

import ec.edu.espe.ConixCoffeeAndIceCreamShop.model.Shift;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ShiftMenu {

    private final List<Shift> shifts;
    private final Scanner scanner;

    public ShiftMenu(List<Shift> shifts, Scanner scanner) {
        this.shifts = shifts;
        this.scanner = scanner;
    }

    public void showMenu() {
        int option;

        do {
            System.out.println("\n===== SHIFT MENU =====");
            System.out.println("1. Register shift");
            System.out.println("2. List shifts");
            System.out.println("0. Return to main menu");
            System.out.print("Select an option: ");

            option = readInt();

            switch (option) {
                case 1 -> registerShift();
                case 2 -> listShifts();
                case 0 -> System.out.println("Returning to main menu...");
                default -> System.out.println("Invalid option.");
            }

        } while (option != 0);
    }

    private void registerShift() {
        System.out.println("\n--- REGISTER SHIFT ---");

        try {
            System.out.print("Enter start time (HH:mm): ");
            LocalTime startTime = LocalTime.parse(scanner.nextLine().trim());

            System.out.print("Enter end time (HH:mm): ");
            LocalTime endTime = LocalTime.parse(scanner.nextLine().trim());

            if (startTime.equals(endTime)) {
                System.out.println(
                        "Start time and end time cannot be equal."
                );
                return;
            }

            Shift shift = new Shift(startTime, endTime);
            shifts.add(shift);

            System.out.println("Shift registered successfully.");

        } catch (DateTimeParseException e) {
            System.out.println(
                    "Invalid time format. Use HH:mm, for example 08:30."
            );
        } catch (IllegalArgumentException e) {
            System.out.println("Could not register shift: "
                    + e.getMessage());
        }
    }

    private void listShifts() {
        System.out.println("\n--- REGISTERED SHIFTS ---");

        if (shifts.isEmpty()) {
            System.out.println("No shifts registered.");
            return;
        }

        for (int i = 0; i < shifts.size(); i++) {
            Shift shift = shifts.get(i);

            System.out.println((i + 1) + ". " + shift);
        }
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
