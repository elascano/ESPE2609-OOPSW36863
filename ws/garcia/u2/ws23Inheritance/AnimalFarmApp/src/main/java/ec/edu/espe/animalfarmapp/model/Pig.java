/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.animalfarmapp.model;

import java.util.Date;

/**
 *
 * @author Jesus Garcia, @ESPE
 */
public class Pig extends FarmAnimal{
    private float weightKg;
    private boolean isForBreeding;

    public Pig(float weightKg, boolean isForBreeding, int id, String bread, Date bornOnDate) {
        super(id, bread, bornOnDate);
        this.weightKg = weightKg;
        this.isForBreeding = isForBreeding;
    }

    @Override
    public String toString() {
        return "Pig{" + super.toString() + "weightKg=" + weightKg + ", isForBreeding=" + isForBreeding + '}';
    }

    /**
     * @return the weightKg
     */
    public float getWeightKg() {
        return weightKg;
    }

    /**
     * @param weightKg the weightKg to set
     */
    public void setWeightKg(float weightKg) {
        this.weightKg = weightKg;
    }

    /**
     * @return the isForBreeding
     */
    public boolean isIsForBreeding() {
        return isForBreeding;
    }

    /**
     * @param isForBreeding the isForBreeding to set
     */
    public void setIsForBreeding(boolean isForBreeding) {
        this.isForBreeding = isForBreeding;
    }
    
    public void feed(){
        System.out.println("Feeding the pig...");
    }
}
