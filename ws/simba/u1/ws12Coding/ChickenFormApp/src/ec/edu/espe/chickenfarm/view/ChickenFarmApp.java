package ec.edu.espe.chickenfarm.view;

import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.ChickenCoop;
import ec.edu.espe.chickenfarm.model.ChickenFarmer;
import ec.edu.espe.chickenfarm.model.Egg;
import ec.edu.espe.chickenfarm.model.Poop;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author DANILO SIMBA
 */
public class ChickenFarmApp {
    public static void main(String[] args) {
        System.out.println("Danilo Simba´s Chicken Farm");
        System.out.println("=========================");
        
        Chicken chicken; //declaration
        Egg egg;
        Poop poop;
        Chicken chicken1;
        ChickenCoop coop;
        Chicken[] chickens = new Chicken[10];
        ChickenFarmer chickenFarmer;
        
        chicken = new Chicken(2, "Maruja", "white", new Date(2021,3,2), false); //instantiation
        egg = new Egg(1, 'M');
        
        
        System.out.println("my chicken is -->" + chicken);
        System.out.println("egg -->" + egg);
        
        System.out.println("egg size -->" + egg.getSize());
        
        poop = new Poop(1, "brown", 'S');
        System.out.println("poop -->" + poop);
        
        chicken1 = new Chicken(1, "Lucy", "brown and white", new Date (), true);
        System.out.println("chicken 1 -->" + chicken1);
        
        int localAge = chicken.computeAgeInYears();
        System.out.println("the age of the chicken" + chicken.getName() + ", is -->" + localAge);
        
        chicken.doStuff();
        chickens[0] = new Chicken(3, "Pepita", "black", new Date(2020,2,2), true);
        chickens[1] = chicken;
        
 
        int ageForTheLoop;
        for (int i = 0 ; i < chickens.length ; i++){
            ageForTheLoop = 2010 + i;
            chickens[i] = new Chicken(i, "chicken" + (i+1), "white", new Date(2020,3,3), true);
            chickens[i].setAgeInYears(ageForTheLoop);
        }
        for (int i = 0; i< 10; i++){
            System.out.println("chickens -->" + chickens[i]);
        }
        
        
        coop = new ChickenCoop(10, chickens);
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int opcion = 0;
        
         do{
            System.out.println("=====Chihcken Coop=====");
            System.out.println("1. Add Chicken");
            System.out.println("2. Remove Chicken");
            System.out.println("3. Next Chicken");
            System.out.println("4. Save to CSV");
            System.out.println("5. Save to JSON");
            System.out.println("6. Exit");
            System.out.println("Select an option");
            opcion = scanner.nextInt();
            
            switch (opcion){
                case 1: 
                    System.out.println("Enter the chick's ID: ");
                    int id = scanner.nextInt();
                    
                    System.out.println("Enter the chick's name: ");
                    String name = scanner.next();
                    
                    Chicken newChicken = new Chicken (id, name, "white", new Date(), true);
                    coop.add(newChicken);
                    break;
                case 2:
                    System.out.println("Enter the ID of the chick you wish to remove: ");
                    int removeId = scanner.nextInt();
                    coop.remove(removeId);
                    break;
                case 3:
                    Chicken next = coop.next();
                    if(next != null){
                        System.out.println("Next chicken " + next.getName() + ", ID: " + next.getId());
                    } else {
                        System.out.println("The end of the henhouse was reached, and the index has been reset to 0.");
                    }
                    break;
                case 4:
                    coop.saveToCSV("Chickens.json");
                    break;
                case 5:
                    coop.saveToJSON("Chickens.csv");
                    break;
                case 6:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;    
            } 
        }while (opcion != 6);
       
    }  
}
