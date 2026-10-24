package ec.edu.espe.chickenfarm.model;

import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Andy Tiban, IV Studio, @ESPE
 */
public class InputHandler {
    
    private static boolean isIdTaken(int id, Chicken[] chickens) {
        if (chickens == null) return false;
        for (Chicken c : chickens) {
            // Si encuentra una gallina que no es nula y tiene el mismo ID, retorna true
            if (c != null && c.getId() == id) {
                return true; 
            }
        }
        return false;
    }

    
    public static Chicken createChickenFromConsole(Chicken[] currentChickens) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n=== New Chicken Register ===");
         
        int id;
        while (true) {
            System.out.print("Enter the ID: ");
            id = scanner.nextInt();
            scanner.nextLine(); 
            if (isIdTaken(id, currentChickens)) {
                System.out.println("[!] Error: That ID is already registered. Please enter another one.");
            } else {
                break; 
            }
        }
        System.out.print("Enter the name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter de color: ");
        String color = scanner.nextLine();
        
        System.out.print("Enter the year of birth: ");
        int yearOfBirth= scanner.nextInt();
        
        System.out.print("Enter the month of birth: ");
        int monthOfBirth= scanner.nextInt();        
 
        System.out.print("Enter the day of birth: ");
        int dayOfBirth= scanner.nextInt();
        
        System.out.print("The chicken is molting? (true or false): ");
        boolean molting = scanner.nextBoolean();
        
        
        return new Chicken(id, name, color, new Date(yearOfBirth-1900,monthOfBirth,dayOfBirth), molting);
    }
    
    
    
    
    
}
