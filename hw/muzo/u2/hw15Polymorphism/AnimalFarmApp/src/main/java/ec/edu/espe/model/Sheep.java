package ec.edu.espe.model;

import java.util.Date;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class Sheep extends FarmAnimal implements grazeAnimal{
    private float woolLength;
    private boolean isSheared;

    public Sheep(float woolLength, boolean isSheared, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.woolLength = woolLength;
        this.isSheared = isSheared;
    }

    @Override
    public void graze(Location location) {
        System.out.println("Sending the sheep to eat grass at --> " + location);
    }
    
    @Override
    public String toString() {
        return "Sheep{" + super.toString() + "woolLength = " + woolLength + ", isSheared = " + isSheared + '}';
    }
    
    
    @Override
    public void feed(Food food, int amountOfFood) {
        System.out.println("Feeding sheep with --> " + food + " amount of food --> " + amountOfFood);
    }
    
    public void shearWool(){
        if(!isSheared){
            isSheared = true;
            woolLength = 0;
            System.out.println("Sheep has been sheared successfully");
        }
        else {
            System.out.println("Shee has already been sheared");
        }
    }
    /**
     * @return the woolLength
     */
    public float getWoolLength() {
        return woolLength;
    }

    /**
     * @param woolLength the woolLength to set
     */
    public void setWoolLength(float woolLength) {
        this.woolLength = woolLength;
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

    
}
