package ec.edu.espe.animalfarmapp.model;

import java.util.Date;

/**
 *
 * @author Julian Olalla, 404 Founders, @ESPE
 */
public class Pig extends FarmAnimal{
    private boolean isDelicious;

    public Pig(boolean isDelicious, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.isDelicious = isDelicious;
    }

    @Override
    public String toString() {
        return "Pig{" + super.toString() + "isDelicious=" + isDelicious + '}';
    }    
    
    /**
     * @return the isDelicious
     */
    public boolean isIsDelicious() {
        return isDelicious;
    }

    /**
     * @param isDelicious the isDelicious to set
     */
    public void setIsDelicious(boolean isDelicious) {
        this.isDelicious = isDelicious;
    }
    
    
}
