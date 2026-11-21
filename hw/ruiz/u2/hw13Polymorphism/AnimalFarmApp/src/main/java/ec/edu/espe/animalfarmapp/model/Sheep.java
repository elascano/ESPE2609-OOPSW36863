package ec.edu.espe.animalfarmapp.model;

import java.time.LocalDate;

/**
 *
 * @author Verónica Ruiz, Code Crafters, @ESPE
 */
public class Sheep extends FarmAnimal {
    private LocalDate lastShearing;
    private boolean isShorn;
    private float kgOfWoolPerShearing;
    
    public void shear(){
        System.out.println("shearning the sheep ");  
    }

    @Override
    public void feed(Food food, int amountOfFood) {
        System.out.println("feeding a sheep with ---> " + amountOfFood + " of " + food );
    }


    public Sheep(LocalDate lastShearing, boolean isShorn, float kgOfWoolPerShearing, int id, String breed, LocalDate bornOnDate) {
        super(id, breed, bornOnDate);
        this.lastShearing = lastShearing;
        this.isShorn = isShorn;
        this.kgOfWoolPerShearing = kgOfWoolPerShearing;
    }
    
    @Override
    public String toString() {
        return "Sheep{" + super.toString() + " lastShearing=" + (getLastShearing().getDayOfMonth()) + "/" + (getLastShearing().getMonthValue()) + "/" + (getLastShearing().getYear()) +  ", isShorn=" + isIsShorn() + ", kgOfWoolPerShearing=" + getKgOfWoolPerShearing() + '}';
    }

    /**
     * @return the lastShearing
     */
    public LocalDate getLastShearing() {
        return lastShearing;
    }

    /**
     * @param lastShearing the lastShearing to set
     */
    public void setLastShearing(LocalDate lastShearing) {
        this.lastShearing = lastShearing;
    }

    /**
     * @return the isShorn
     */
    public boolean isIsShorn() {
        return isShorn;
    }

    /**
     * @param isShorn the isShorn to set
     */
    public void setIsShorn(boolean isShorn) {
        this.isShorn = isShorn;
    }

    /**
     * @return the kgOfWoolPerShearing
     */
    public float getKgOfWoolPerShearing() {
        return kgOfWoolPerShearing;
    }

    /**
     * @param kgOfWoolPerShearing the kgOfWoolPerShearing to set
     */
    public void setKgOfWoolPerShearing(float kgOfWoolPerShearing) {
        this.kgOfWoolPerShearing = kgOfWoolPerShearing;
    }
    
}
