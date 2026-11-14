/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmapp.model;

import java.util.Date;

/**
 *the cows
 * @author Andy Tiban, IV Studio, @ESPE
 */
public class Cow extends FarmAnimal implements grazeAnimal{
    private boolean isProducingMilk;
    private float litersOfMilkPerWeek;
    
    @Override
    public void graze(Location location) {
        
        System.out.println("sending the cow to eat grass at -->"+location);

    }


    
    @Override
    public void feed(Food food, int amountOfFood) {
           System.out.println("feeding a cow with -->"+ food);
    }
    
    
    public void milk(float amountOfLiters){
        litersOfMilkPerWeek+=amountOfLiters;
        
        System.out.println("milking the cow for "+amountOfLiters+" liters.");
    }
    
    public void milk(int amountOfLiters){
        litersOfMilkPerWeek+=amountOfLiters;
        
        System.out.println("milking the cow for "+amountOfLiters+" liters.");
    }

    public void milk(){
        System.out.println("milking the cow as I need.");
    }   
    
    public void milk(int amountOfLiters, Date hour){

        System.out.println("milking the cow for"+amountOfLiters+" liters, at "+hour.getHours()+":"+hour.getMinutes());
    }    
    

    public Cow(boolean isProducingMilk, float litersOfMilkPerWeek, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.isProducingMilk = isProducingMilk;
        this.litersOfMilkPerWeek = litersOfMilkPerWeek;
    }

    @Override
    public String toString() {
        return "Cow{" +super.toString()+ "isProducingMilk=" + isProducingMilk + ", litersOfMilkPerWeek=" + litersOfMilkPerWeek + '}';
    }

    
    
    /**
     * @return the isProducingMilk
     */
    public boolean isIsProducingMilk() {
        return isProducingMilk;
    }

    /**
     * @param isProducingMilk the isProducingMilk to set
     */
    public void setIsProducingMilk(boolean isProducingMilk) {
        this.isProducingMilk = isProducingMilk;
    }

    /**
     * @return the litersOfMilkPerWeek
     */
    public float getLitersOfMilkPerWeek() {
        return litersOfMilkPerWeek;
    }

    /**
     * @param litersOfMilkPerWeek the litersOfMilkPerWeek to set
     */
    public void setLitersOfMilkPerWeek(float litersOfMilkPerWeek) {
        this.litersOfMilkPerWeek = litersOfMilkPerWeek;
    }


    
    
    
}
