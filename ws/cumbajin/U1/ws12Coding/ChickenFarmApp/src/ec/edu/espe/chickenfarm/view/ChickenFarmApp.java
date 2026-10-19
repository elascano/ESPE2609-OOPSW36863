/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.chickenfarm.view;


import ec.edu.espe.chickenfarm.model.Chicken;
import ec.edu.espe.chickenfarm.model.Egg;
import ec.edu.espe.chickenfarm.model.Poop;
import java.util.Date;
/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */ 
public class ChickenFarmApp {
    public static void main(String[] args) {
        System.out.println("Dylan Cumbajin`s Chicken Farm");
        System.out.println("=============================");
        
        Chicken chicken; //declaration
        Egg egg;
        Poop poop;
        Chicken chicken1;
        Chicken chicken2;
        
        chicken = new Chicken(); //instantiation
        egg = new Egg(1, 'M');
        
        System.out.println("my chicken is -->"+ chicken);
        System.out.println("egg-->"+ egg);
        
        System.out.println("egg size -->"+ egg.getSize());
        
        poop = new Poop(0, "brown", 'S');
        System.out.println("poop -->" + poop);
        
        chicken1 = new Chicken(1, "Lucy", "brown and white", new Date(), 0, true, null);
        System.out.println("chiken 1 -- > " + chicken1);
        chicken2 = new Chicken(2, "Cecil", "brown", new Date(), 0, true, null);
        System.out.println("chiken 2 -- > " + chicken2);
        
        
        
        
        
        
    }
    
}
