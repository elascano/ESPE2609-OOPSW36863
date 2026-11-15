package ec.edu.espe.animalfarmapp.model;

import ec.edu.espe.animalfarmapp.view.AnimalFarmApp;
import java.util.Date;

/**
 *
 * @author Julian Olalla, 404 Founders, @ESPE
 */
public class Sheep extends FarmAnimal{
    private Date lastSheering;

    public Sheep(Date lastSheering, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.lastSheering = lastSheering;
    }        

    @Override
    public String toString() {
        return "Sheep{" + super.toString() + "lastSheering=" + lastSheering + '}';
    }
    
    
    public void sheering(){
        System.out.println("Las sheering in");
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
    
}
