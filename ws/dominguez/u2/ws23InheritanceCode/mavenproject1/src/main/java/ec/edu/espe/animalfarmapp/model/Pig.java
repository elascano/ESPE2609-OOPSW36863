package ec.edu.espe.animalfarmapp.model;

import java.util.Date;

/**
 *
 * @author Mateo Dominguez, Brain Training, @ESPE
 */
public class Pig extends FarmAnimal{
    private boolean isMeat;

    public Pig(boolean isMeat, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.isMeat = isMeat;
    }
    
    @Override
    public String toString() {
        return "Pig{" + super.toString() + "isMeat=" + isMeat + '}';
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
