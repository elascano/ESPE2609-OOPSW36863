package ec.edu.espe.animalfarmapp.model;

import java.util.Date;

/**
 *
 * @author Julian Olalla, 404 Founders, @ESPE
 */
public class Pig extends FarmAnimal {

    private float weightInKg;    
    private boolean isReadyToEat;

    @Override
    public void feed(Food food, int amountOfFood, String unit) {
        System.out.println("Feeding a pig with --> " + amountOfFood + unit + " of " + food);
    }

    @Override
    public void cuts(Cuts cuts) {
        System.out.println("Cutting a pig into --> " + cuts);
    }
    
    public void gainWeight(float kg) {
        System.out.println("The currently weight of the pig --> " + kg);
    }

    public void produceManure(float manure, String unit){
        System.out.println("Pig's manure produced --> " + manure + unit);
    }  
    
    public Pig(float weightInKg, int numberOfOffspring, boolean isReadyToEat, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate, numberOfOffspring);
        this.weightInKg = weightInKg;
        this.isReadyToEat = isReadyToEat;
    }

    @Override
    public String toString() {
        return "Pig{" + super.toString() + "weightInKg=" + getWeightInKg() 
                + ", isReadyToEat=" + isIsReadyToEat() + '}';
    }          

    /**
     * @return the isReadyToEat
     */
    public boolean isIsReadyToEat() {
        return isReadyToEat;
    }

    /**
     * @param isReadyToEat the isReadyToEat to set
     */
    public void setIsReadyToEat(boolean isReadyToEat) {
        this.isReadyToEat = isReadyToEat;
    }

    /**
     * @return the weightInKg
     */
    public float getWeightInKg() {
        return weightInKg;
    }

    /**
     * @param weightInKg the weightInKg to set
     */
    public void setWeightInKg(float weightInKg) {
        this.weightInKg = weightInKg;
    }    
}
