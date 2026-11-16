package ec.edu.espe.animalfarmapp.model;

import java.util.Date;

/**
 *
 * @author Mateo Dominguez, Brain Training, @ESPE
 */
public class Sheep extends FarmAnimal{
    private Date lastSheering;
    private float weightWool;

    public Sheep(Date lastSheering, float weightWool, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.lastSheering = lastSheering;
        this.weightWool = weightWool;
    }
    
    @Override
    public void feed(Food food, int amountOfFood) {
        System.out.println("feeding a sheep with "+ amountOfFood + " of "+ food);
    }
    
    public void sherring(float newWool){
        setWeightWool(getWeightWool() + newWool);
        System.out.println("The sheep produce " + weightWool + "kg of  wool");
        setLastSheering(new Date());
    }

    @Override
    public String toString() {
        return "Sheep{" + "lastSheering=" + lastSheering + ", weightWool=" + weightWool + '}';
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
     * @return the weightWool
     */
    public float getWeightWool() {
        return weightWool;
    }

    /**
     * @param weightWool the weightWool to set
     */
    public void setWeightWool(float weightWool) {
        this.weightWool = weightWool;
    }   
}

