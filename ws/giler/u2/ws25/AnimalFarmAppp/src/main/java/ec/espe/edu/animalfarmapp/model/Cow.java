/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.espe.edu.animalfarmapp.model;

import java.util.Date;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class Cow extends FarmAnimal implements grazeAnimal{
    private boolean isProductingMilk;
    private float litersOfMilkPerWeek;
    
    public void milk(int amountOfLiters){
        litersOfMilkPerWeek += amountOfLiters;
        System.out.println("milking the cow for " + amountOfLiters + " liters");
    }
    
    public void milk(float amountOfLiters){
        litersOfMilkPerWeek += amountOfLiters;
        System.out.println("milking the cow for " + amountOfLiters + " liters");
    }
    
    public void milk(int amountOfLiters, Date hour){
        System.out.println("milking the cow for " + amountOfLiters + " liters, at "+hour.getHours() + ":" +hour.getMinutes());
    }
    
    public void milk(){
        System.out.println("milking the cow as I need");
    }

    public Cow(boolean isProductingMilk, float litersOfMilkPerWeek, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.isProductingMilk = isProductingMilk;
        this.litersOfMilkPerWeek = litersOfMilkPerWeek;
    }
    
    @Override
    public void graze(Location location) {
        System.out.println("Cow is grazing at --> " + location);
    }
    
    @Override
    public void feed(Food food, int amountOfFood) {
         System.out.println("feeding a cow in the stable with --> "+ food);
    }

    @Override
    public String toString() {
        return "Cow{" + super.toString() + "isProductingMilk=" + isProductingMilk + ", litersOfMilkPerWeek=" + litersOfMilkPerWeek + '}';
    }

    
    /**
     * @return the isProductingMilk
     */
    public boolean isIsProductingMilk() {
        return isProductingMilk;
    }

    /**
     * @param isProductingMilk the isProductingMilk to set
     */
    public void setIsProductingMilk(boolean isProductingMilk) {
        this.isProductingMilk = isProductingMilk;
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
