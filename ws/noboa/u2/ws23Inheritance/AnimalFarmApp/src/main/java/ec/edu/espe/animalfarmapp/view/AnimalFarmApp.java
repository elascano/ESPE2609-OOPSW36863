/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.espe.animalfarmapp.view;

import ec.edu.espe.animalfarmapp.model.Chicken;
import ec.edu.espe.animalfarmapp.model.Cow;
import ec.edu.espe.animalfarmapp.model.FarmAnimal;
import ec.edu.espe.animalfarmapp.model.Pig;
import ec.edu.espe.animalfarmapp.model.Sheep;
import java.util.Date;

/**
 *
 * @author Dennis Noboa, 404 Founder, @ESPE
 */
public class AnimalFarmApp {

    public static void main(String[] args) {
        System.out.println("Hello. This is Dennis's Animal Farm!");
        
        FarmAnimal farmAnimal = new Chicken(true, 15, true, 1, "Brohmo", new Date());
        System.out.println("my farm animal --> " + farmAnimal);
        
        FarmAnimal chicken = new Chicken(true, 10, true, 2, "Paleesh", new Date());
        System.out.println("chicken --> " + chicken);
        
        FarmAnimal cow = new Cow(true, 100.5F, 3, "holstein", new Date(2022, 20, 20));
        System.out.println("cow --> " + cow);
        
        FarmAnimal pig = new Pig(true, 150.3F, 4, "duroc", new Date(2025, 11, 25));
        System.out.println("pig --> " + pig);
        
        FarmAnimal sheep = new Sheep(new Date(2026, 11, 11), 4.2F, 5, "lincoln", new Date(2024, 5, 12));
        System.out.println("sheep --> " + sheep);
    }
}
