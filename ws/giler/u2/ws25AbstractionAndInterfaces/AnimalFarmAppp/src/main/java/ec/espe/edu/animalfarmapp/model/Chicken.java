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
public class Chicken extends FarmAnimal{
    private boolean isMolting;
    private int numberOfLaidEggsInMonths;
    private boolean isMeat;

    @Override
    public void feed(Food food, int amountOfFood) {
        System.out.println("feeding a chicken with -->" + amountOfFood + " of " + food);
    }
    
    @Override
    public String toString() {
        return "Chicken{" + super.toString() + "isMolting=" + isMolting + ", numberOfLaidEggsInMonths=" + numberOfLaidEggsInMonths + ", isMeat=" + isMeat + '}';
    }

    public Chicken(boolean isMolting, int numberOfLaidEggsInMonths, boolean isMeat, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.isMolting = isMolting;
        this.numberOfLaidEggsInMonths = numberOfLaidEggsInMonths;
        this.isMeat = isMeat;
    }
    
    public void layAnEgg(){
        System.out.println("Chicken is laying an egg");
    }
    

    /**
     * @return the isMolting
     */
    public boolean isIsMolting() {
        return isMolting;
    }

    /**
     * @param isMolting the isMolting to set
     */
    public void setIsMolting(boolean isMolting) {
        this.isMolting = isMolting;
    }

    /**
     * @return the numberOfLaidEggsInMonths
     */
    public int getNumberOfLaidEggsInMonths() {
        return numberOfLaidEggsInMonths;
    }

    /**
     * @param numberOfLaidEggsInMonths the numberOfLaidEggsInMonths to set
     */
    public void setNumberOfLaidEggsInMonths(int numberOfLaidEggsInMonths) {
        this.numberOfLaidEggsInMonths = numberOfLaidEggsInMonths;
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
}
