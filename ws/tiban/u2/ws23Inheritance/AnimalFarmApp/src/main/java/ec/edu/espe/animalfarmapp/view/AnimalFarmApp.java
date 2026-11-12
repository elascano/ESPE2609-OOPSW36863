/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmapp.view;

import ec.edu.espe.animalfarmapp.model.Chicken;
import ec.edu.espe.animalfarmapp.model.Cow;
import ec.edu.espe.animalfarmapp.model.FarmAnimal;
import java.util.Date;

/**
 *
 * @author Andy Tiban, IV Studio, @ESPE
 */
public class AnimalFarmApp {
    public static void main(String[] args) {
        System.out.println("hello this is Andy's Animal Farm ! ");
        FarmAnimal farmAnimal;
        farmAnimal= new FarmAnimal(1,"holstein",new Date());
        
        System.out.println("my farm animal -->"+farmAnimal);
        
        Chicken chicken = new Chicken(true, 10, true, 2, "Paleesh", new Date());
        System.out.println("chicken -->"+ chicken);
        
        FarmAnimal cow= new Cow(true, 100.5F, 5, "holstein", new Date(2022,20,20));
        System.out.println("cow -->"+cow);
    }
    
}
