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
public class Sheep extends FarmAnimal {
    private float woolProductionkg;
    private boolean isSheared;

    public Sheep(float woolProductionkg, boolean isSheared, int id, String bread, Date bornOnDate) {
        super(id, bread, bornOnDate);
        this.woolProductionkg = woolProductionkg;
        this.isSheared = isSheared;
    }

    @Override
    public String toString() {
        return "Sheep{" + super.toString() + "woolProductionkg=" + woolProductionkg + ", isSheared=" + isSheared + '}';
    }

    

    /**
     * @return the woolProductionkg
     */
    public float getWoolProductionkg() {
        return woolProductionkg;
    }

    /**
     * @param woolProductionkg the woolProductionkg to set
     */
    public void setWoolProductionkg(float woolProductionkg) {
        this.woolProductionkg = woolProductionkg;
    }

    /**
     * @return the isSheared
     */
    public boolean isIsSheared() {
        return isSheared;
    }

    /**
     * @param isSheared the isSheared to set
     */
    public void setIsSheared(boolean isSheared) {
        this.isSheared = isSheared;
    }
    
    public void shear(){
        isSheared = true;
        System.out.println("The sheep has been sheared");
    }
    
}
