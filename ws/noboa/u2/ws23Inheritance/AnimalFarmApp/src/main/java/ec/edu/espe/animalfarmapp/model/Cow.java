/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmapp.model;

import java.util.Date;

/**
 *
 * @author Dennis Noboa, 404 Founder, @ESPE
 */
public class Cow extends FarmAnimal{
    private boolean isProducingMilk;
    private float litersOfMilkPerWeel;
    
    public void milk(){
        System.out.println("milking the cow ");
    }

    public Cow(boolean isProducingMilk, float litersOfMilkPerWeel, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.isProducingMilk = isProducingMilk;
        this.litersOfMilkPerWeel = litersOfMilkPerWeel;
    }

    @Override
    public String toString() {
        return "Cow{" + super.toString() + "isProducingMilk=" + isProducingMilk + ", litersOfMilkPerWeel=" + litersOfMilkPerWeel + '}';
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
     * @return the litersOfMilkPerWeel
     */
    public float getLitersOfMilkPerWeel() {
        return litersOfMilkPerWeel;
    }

    /**
     * @param litersOfMilkPerWeel the litersOfMilkPerWeel to set
     */
    public void setLitersOfMilkPerWeel(float litersOfMilkPerWeel) {
        this.litersOfMilkPerWeel = litersOfMilkPerWeel;
    }
    
}
