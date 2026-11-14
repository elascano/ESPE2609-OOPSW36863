/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmapp.model;

import java.util.Date;

/**
 *the animals
 * @author Andy Tiban, IV Studio, @ESPE
 */
public abstract class FarmAnimal {
    int id;
    String breed;
    Date bornOnDate;
    
    
    /**
     * Feed the animals with their own food
     * @param food 
     * @return nothing
     */
    public abstract void feed(Food food,int amountOfFood);
    
    public int getAgeInMonths(){
        //TODO compute the age in months
        return 0;
        
        
        
    
    }

    @Override
    public String toString() {
        return  "id=" + id + ", breed=" + breed +
                ", bornOnDate=" + bornOnDate.getDate()+
                "/"+ (bornOnDate.getMonth()+1) +
                "/"+ (bornOnDate.getYear()+1900) + ",";
    }

    public FarmAnimal(int id, String breed, Date bornOnDate) {
        this.id = id;
        this.breed = breed;
        this.bornOnDate = bornOnDate;
    }
    
    
}
