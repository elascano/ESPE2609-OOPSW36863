/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.model;

import java.util.Date;

/**
 *
 * @author Jesus Garcia, @ESPE
 */
public class Pig extends FarmAnimal {
    private int numberOfPigletsPerLitter;
    
    @Override
    public void feed(Food food, int amountOfFood) {
        System.out.println("Feeding pig with --> " + food + " amount of fodd --> " + amountOfFood);
    }

    @Override
    public String toString() {
        return "Pig{" + super.toString() + "numberOfPigletsPerLitter = " + numberOfPigletsPerLitter + '}';
    }
    
    
    public void registerLitter(int numberOfPiglets){
        this.setNumberOfPigletsPerLitter(numberOfPiglets);
    }
    
    public Pig(int numberOfPigletsPerLitter, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.numberOfPigletsPerLitter = numberOfPigletsPerLitter;
    }

    /**
     * @return the numberOfPigletsPerLitter
     */
    public int getNumberOfPigletsPerLitter() {
        return numberOfPigletsPerLitter;
    }

    /**
     * @param numberOfPigletsPerLitter the numberOfPigletsPerLitter to set
     */
    public void setNumberOfPigletsPerLitter(int numberOfPigletsPerLitter) {
        this.numberOfPigletsPerLitter = numberOfPigletsPerLitter;
    }

 
    
}
