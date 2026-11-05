package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.JsonManager;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Alejandro Fuel
 */
public class ChickenFarmApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        System.out.println("Alejandro Fuel's Chicken Farm");
        System.out.println("==========");

        do {
            System.out.println("\n--- MENU PRINCIPAL (JSON) ---");
            System.out.println("1. Agregar una gallina y guardarla en JSON");
            System.out.println("2. Leer y abrir el archivo JSON");
            System.out.println("3. Salir");
            System.out.print("Elija una opcion: ");
            
            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer
            } else {
                System.out.println("Por favor, ingrese un numero valido.");
                scanner.nextLine();
                continue;
            }

            switch (option) {
                case 1:
                    System.out.print("Ingrese ID de la gallina: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    System.out.print("Ingrese nombre de la gallina: ");
                    String name = scanner.nextLine();

                    System.out.print("Ingrese color de la gallina: ");
                    String color = scanner.nextLine();

                    // Creamos la gallina y calculamos su edad
                    Chicken newChicken = new Chicken(id, name, color, new Date(71, 3, 3), true);
                    newChicken.setAgeInYears();

                    // Guardamos en el archivo JSON
                    JsonManager.saveChickenToJson(newChicken);
                    break;

                case 2:
                    // Abre y muestra el contenido del archivo JSON en consola
                    JsonManager.readChickenJSON();
                    break;

                case 3:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;

                default:
                    System.out.println("Opcion invalida. Intente de nuevo.");
            }
        } while (option != 3);

        scanner.close();
    }
}