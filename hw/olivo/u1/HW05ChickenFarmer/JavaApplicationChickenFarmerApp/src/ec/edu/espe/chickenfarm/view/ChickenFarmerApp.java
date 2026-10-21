package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.ChickenCoop;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author Nestor Olivo, Found ERROR 404, @ESPE
 */
public class ChickenFarmerApp {

    public static void main(String[] args) {
        boolean controler = true;
        String date;
        int option;
        int chickenId;
        String name;
        String color;
        LocalDate bornOnDay;
        boolean molting;
        Scanner keyboard = new Scanner(System.in);
        ChickenCoop chickenCoop = new ChickenCoop();
        Chicken chicken;
        while (controler) {
            System.out.println("Hello Chicken Farmer App");
            System.out.println("Nestor Is Chicken Farmer");
            System.out.println("===========================================");
            System.out.println("""
                           1. Add a Chicken to the Chicken Coop 
                           2. To Remove a Chicken from the Chicken coop
                           3. See all the chickens
                           4. Exit
                           =============================================
                           Enter the Option:
                            """);
            option = keyboard.nextInt();
            keyboard.nextLine();
            switch (option) {
                case 1 -> {
                    System.out.println("Add a Chicken to the Chicken Coop ");
                    System.out.println("Enter the name of the Chicken: ");
                    name = keyboard.nextLine();
                    System.out.println("Enter the color of the chicken");
                    color = keyboard.nextLine();
                    System.out.println("Enter the Hen's Date of Birth (\"YYY-MM-DD\")");
                    date = keyboard.nextLine();
                    bornOnDay = LocalDate.parse(date);
                    System.out.print("Is the chicken molting? (true/false): ");
                    molting = keyboard.nextBoolean();
                    chicken = new Chicken(name, color, bornOnDay, molting);
                    chickenCoop.add(chicken);
                    System.out.println("Chicken added successfully!");
                }
                case 2 -> {
                    System.out.print("Enter the ID of the chicken to remove: ");
                    chickenId = keyboard.nextInt();
                    chickenCoop.remove(chickenId);
                }
                case 3 -> {
                    chickenCoop.resetIteration();

                    if (chickenCoop.getCount() == 0) {
                        System.out.println("There are no chickens in the coop.");
                    } else {
                        for (int i = 0; i < chickenCoop.getCount(); i++) {
                            chicken = chickenCoop.next();
                            System.out.println(chicken);
                        }
                    }
                }
                default ->
                    controler = false;
            }
        }
    }

}
