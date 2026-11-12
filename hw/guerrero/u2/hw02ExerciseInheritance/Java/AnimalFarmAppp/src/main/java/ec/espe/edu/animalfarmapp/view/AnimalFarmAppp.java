/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.espe.edu.animalfarmapp.view;

import ec.espe.edu.animalfarmapp.model.Chicken;
import ec.espe.edu.animalfarmapp.model.Cow;
import ec.espe.edu.animalfarmapp.model.FarmAnimal;
import java.util.Date;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class AnimalFarmAppp {

    public static void main(String[] args) {
        System.out.println("Hello this is Stalyn's Animal Farm");
        FarmAnimal farmAnimal;
        farmAnimal = new FarmAnimal(1, "holstein", new Date());
        
        System.out.println("My farm animal --> " + farmAnimal);
        
        Chicken chicken = new Chicken(true, 10, true, 2, "Paleesh", new Date());
        System.out.println("Chicken ---> " + chicken);
        
        FarmAnimal cow = new Cow(true, 100.5F, 3, "Holstein", new Date(11/11/2026));
    }
    
    
    
    
}
