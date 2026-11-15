package ec.edu.espe.animalfarmapp.model;

import java.util.Date;

/**
 *
 * @author Julian Olalla, 404 Founders, @ESPE
 */
public class Pig extends FarmAnimal{
    private boolean isReadyToEat;

    public Pig(boolean isDelicious, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.isReadyToEat = isDelicious;
    }

    @Override
    public String toString() {
        return "Pig{" + super.toString() + "isDelicious=" + isReadyToEat + '}';
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
    
    
}
