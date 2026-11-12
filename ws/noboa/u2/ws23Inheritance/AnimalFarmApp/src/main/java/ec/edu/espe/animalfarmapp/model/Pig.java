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
public class Pig extends FarmAnimal{
    private boolean isMeat;
    private float kilogramsOfWeigth;

    public Pig(boolean isMeat, float kilogramsOfWeigth, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.isMeat = isMeat;
        this.kilogramsOfWeigth = kilogramsOfWeigth;
    }
    
    public void verifyIsMeat(){
        System.out.println("is ready for meat");
    }

    @Override
    public String toString() {
        return "Pig{" + super.toString() + "isMeat=" + isMeat + ", weigth=" + kilogramsOfWeigth + '}';
    }
    
    /**
     * @return the isMeat
     */
    public boolean isIsMeat() {
        return isMeat;
    }

    /**
     * @param isMeat the isMeat to set
     */
    public void setIsMeat(boolean isMeat) {
        this.isMeat = isMeat;
    }

    /**
     * @return the kilogramsOfWeigth
     */
    public float getKilogramsOfWeigth() {
        return kilogramsOfWeigth;
    }

    /**
     * @param kilogramsOfWeigth the kilogramsOfWeigth to set
     */
    public void setKilogramsOfWeigth(float kilogramsOfWeigth) {
        this.kilogramsOfWeigth = kilogramsOfWeigth;
    }
    
}
