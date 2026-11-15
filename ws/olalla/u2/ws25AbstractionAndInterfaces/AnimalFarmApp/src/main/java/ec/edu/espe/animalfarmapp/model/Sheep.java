package ec.edu.espe.animalfarmapp.model;

import java.util.Date;

/**
 *
 * @author Julian Olalla, 404 Founders, @ESPE
 */
public class Sheep extends FarmAnimal implements GrazeAnimal {

    private boolean isReadyToShear;
    private Date lastShearing;
    private float woolKgPerShearing;

    @Override
    public void graze(Location location) {
        System.out.println("Sending the sheep to eat grass at --> " + location);
    }

    @Override
    public void feed(Food food, int amountOfFood, String unit) {
        System.out.println("Feeding a sheep with --> " + amountOfFood + unit + " of " + food);
    }
    
    @Override
    public void cuts(Cuts cuts) {
        System.out.println("Cutting a sheep into --> " + cuts);
    }
    
    public void shear() {
        System.out.println("Shearing the sheep...");
    } 
    
    public void woolProducePerMonth(float wool, String unit) {
        System.out.println("Wool produced --> " + wool + unit);
    }        

    public Sheep(boolean isReadyToShear, Date lastShearing, float woolKgPerShearing, int numberOfOffspring, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate, numberOfOffspring);
        this.isReadyToShear = isReadyToShear;
        this.lastShearing = lastShearing;
        this.woolKgPerShearing = woolKgPerShearing;        
    }

    @Override
    public String toString() {
        return "Sheep{" + super.toString() + "isReadyToShear=" + isIsReadyToShear() 
                + ", lastShearing=" + getLastShearing().getDate() 
                + '/' + (getLastShearing().getMonth()+1) 
                + "/" + (getLastShearing().getYear()+1900) 
                + ", woolKgPerShearing=" + getWoolKgPerShearing() + '}';
    }       

    /**
     * @return the lastShearing
     */
    public Date getLastShearing() {
        return lastShearing;
    }

    /**
     * @param lastShearing the lastShearing to set
     */
    public void setLastShearing(Date lastShearing) {
        this.lastShearing = lastShearing;
    }

    public boolean isIsReadyToShear() {
        return isReadyToShear;
    }

    public void setIsReadyToShear(boolean isReadyToShear) {
        this.isReadyToShear = isReadyToShear;
    }

    /**
     * @return the woolKgPerShearing
     */
    public float getWoolKgPerShearing() {
        return woolKgPerShearing;
    }

    /**
     * @param woolKgPerShearing the woolKgPerShearing to set
     */
    public void setWoolKgPerShearing(float woolKgPerShearing) {
        this.woolKgPerShearing = woolKgPerShearing;
    }        
}
