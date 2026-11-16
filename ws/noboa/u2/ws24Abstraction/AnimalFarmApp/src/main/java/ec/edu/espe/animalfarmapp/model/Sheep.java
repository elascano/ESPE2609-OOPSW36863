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
public class Sheep extends FarmAnimal{
    private Date lastSheering;
    private float kilogramsOfWool;

    public Sheep(Date lastSheering, float kilogramsOfWool, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.lastSheering = lastSheering;
        this.kilogramsOfWool = kilogramsOfWool;
    }

    @Override
    public String toString() {
        return "Sheep{" + super.toString() + 
        "lastSheering=" + lastSheering.getDate() + 
        "/" + (lastSheering.getMonth() + 1) + 
        "/" + (lastSheering.getYear() + 1900) 
        + ", kilogramsOfWool=" + kilogramsOfWool + '}';
    }
    
    public void sheering(){
        System.out.println("This sheep is sheering...");
    }

    /**
     * @return the lastSheering
     */
    public Date getLastSheering() {
        return lastSheering;
    }

    /**
     * @param lastSheering the lastSheering to set
     */
    public void setLastSheering(Date lastSheering) {
        this.lastSheering = lastSheering;
    }

    /**
     * @return the kilogramsOfWool
     */
    public float getKilogramsOfWool() {
        return kilogramsOfWool;
    }

    /**
     * @param kilogramsOfWool the kilogramsOfWool to set
     */
    public void setKilogramsOfWool(float kilogramsOfWool) {
        this.kilogramsOfWool = kilogramsOfWool;
    }
    
}
