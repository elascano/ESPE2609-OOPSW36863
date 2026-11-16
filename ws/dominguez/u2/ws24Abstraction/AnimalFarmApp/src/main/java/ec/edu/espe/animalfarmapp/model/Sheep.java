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
    
    public void sherring(float newWool){
        setWeightWool(getWeightWool() + newWool);
        System.out.println("The total of wood producing of the sheep is " + weightWool);
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
