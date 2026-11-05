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
 * @author Nohemi Tocagon, Uni Helper, @ESPE
 */
public class ChickenFarmApp {
    public static void main(String[] args) {
        System.out.println("Nohemi Tocagon's Chicken Farm");
        System.out.println("=============================");
        
        Chicken chicken; //declaration
        Egg egg;
        Poop poop;
        Chicken chicken1;
        ChickenCoop coop;
        Chicken chickens[];
        
        chickens = new Chicken[10];
        coop= new ChickenCoop(0, chickens);
        
        chicken = new Chicken(2, "Maruja", "white", new Date(2024, 8, 15),false); // instantiation
        egg= new Egg(1,'M');
        
        System.out.println("My chicken is -->" + chicken);
        System.out.println("egg -->" + egg);
        
        System.out.println("egg.size -->" + egg.getSize());
        
        poop= new Poop(1,"brown", 'S');
        System.out.println("poop -->" + poop);
        
        chicken1 = new Chicken(1, "Lucy", "brown and white", new Date(), false);
        System.out.println("chicken 1 -->" + chicken1);
        
        int localAge = chicken.computeAgeInYears();
        System.out.println("the age of the chicken --> " + chicken.getName() + ", is --> " + localAge);
        
        chicken.doStuff();
        chickens[0]= new Chicken(3, "Pepita", "black", new Date(2020, 2, 2), true);
        chickens[1]= chicken;
        
        for (int i=0; i<10; i++){
            System.out.println("chicken -->" + chickens[i]);
        }
        for (int i=0; i < chickens.length ; i++){
            chickens[i]= new Chicken(i, "chicken" + (i+1), "white", new Date(2020, 3, 3), true);
        }
        for (int i=0; i<10; i++){
            System.out.println("chickens -->" +chickens[i]);
        }
        coop.add(chicken);
        coop.add(chicken1);
        System.out.println("New chicken add -->" + chicken1);
        
        System.out.println("--- BEFORE ---");
        Chicken[] inside = coop.getChikens();
        for (int i = 0; i < inside.length; i++) {
            if (inside[i] != null) {
            System.out.println(inside[i]);
            }
        }

        coop.remove(2);
        
        System.out.println("--- AFTER ---");
        inside = coop.getChikens();
        for (int i = 0; i < inside.length; i++) {
            if (inside[i] != null) {
            System.out.println(inside[i]);
            }
        }
        
        
        /*chickenFarmer = new ChickenFarmer();
        
        System.out.println("chicken farmer -->" + chickenFarmer);
        System.out.println("PRIMITIVES");
        
        short addent1= (short) 40000;
        System.out.println("addent1 -->" + addent1); */
        int option=0;
        Scanner sc = new Scanner(System.in);
        int posicion = 0;
        
        do{
            System.out.println("=====CHICKENFARM APP MENU=====");
            System.out.println("1. Add chicken ");
            System.out.println("2. Remove chicken ");
            System.out.println("3. Next chicken ");
            System.out.println("4. Convert file into JSON ");
            System.out.println("5. Convert file into CVS ");
            System.out.println("6. Exit");
            System.out.println("Choose an option(1-6)!!");

            System.out.println("Option: ");
            option = Integer.parseInt(sc.nextLine());
            
            switch(option){
                case 1:
                    coop.add(sc);
                    break;
                case 2:
                    System.out.print("ID to remove: ");
                    int removeId = Integer.parseInt(sc.nextLine());
                    coop.remove(removeId);     
                    break;
                case 3:
                    Chicken c = coop.next(posicion);
                    if (c != null) {
                        System.out.println(c.toJson());
                        posicion++;
                    } else {
                        System.out.println("There's no more chickens");
                        posicion = 0;
                    }
                    break;
                case 4:
                    chicken.toJson();
                    String texto = chicken.toJson();
                    System.out.println("CONTENT FROM JSON");
                    System.out.println(texto);
                    break;
                case 5:
                    chicken.toCVS();
                    String texto1 = chicken.toCVS();
                    System.out.println("CONTENT FROM CVS");
                    System.out.println(texto1);
                    break;
                case 6:
                    System.out.println("Leaving...");
                    break;
                default:
                    System.out.println("Error, is necesary to choose one option!!");
            }
        }while(option !=6);
                
    }
}
