package ec.edu.espe.animalfarmapp.model;

import java.time.LocalDate;

/**
 *
 * @author Verónica Ruiz, Code Crafters, @ESPE
 */
public class Pig extends FarmAnimal {
    private boolean isMeat;
    private float weightInKg;
    private boolean isPregnant;

    public Pig(boolean isMeat, float weightInKg, boolean isPregnant, int id, String breed, LocalDate bornOnDate) {
        super(id, breed, bornOnDate);
        this.isMeat = isMeat;
        this.weightInKg = weightInKg;
        this.isPregnant = isPregnant;
    }

    @Override
    public String toString() {
        return "Pig{" + super.toString() + "isMeat=" + isMeat + ", weightInKg=" + weightInKg + ", isPregnant=" + isPregnant + '}';
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

    /**
     * @return the isPregnant
     */
    public boolean isIsPregnant() {
        return isPregnant;
    }

    /**
     * @param isPregnant the isPregnant to set
     */
    public void setIsPregnant(boolean isPregnant) {
        this.isPregnant = isPregnant;
    }
    
    
}
