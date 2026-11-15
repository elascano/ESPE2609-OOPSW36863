package ec.edu.espe.animalfarm.model;

import java.util.Date;

/**
 *
 * @author Alvarez Juan Jose, MosQ, ESPE
 */
public class Chicken extends FarmAnimal {

    private boolean isMolting;
    private int numberOfLaidEggsInAMonth;
    private boolean isMeat;

    /**
     * feeding chickens with grains
     *
     * @param food
     * @param amountOfFood
     */
    @Override
    public void feed(Food food, int amountOfFood) {
        System.out.println("feeding a chicken with -->" + amountOfFood + " of " + food);
    }

    public Chicken(boolean isMolting, int numberOfLaidEggsInAMonth, boolean isMeat, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.isMolting = isMolting;
        this.numberOfLaidEggsInAMonth = numberOfLaidEggsInAMonth;
        this.isMeat = isMeat;
    }

    public void layAnEgg() {
        numberOfLaidEggsInAMonth++;
        System.out.println("chicken is laying an egg() ");
    }

    @Override
    public String toString() {
        return "Chicken{" + super.toString() + "isMolting=" + isMolting + ", numberOfLaidEggsInAMonth=" + numberOfLaidEggsInAMonth + ", isMeat=" + isMeat + '}';
    }

    /**
     * @return the isMolting
     */
    public boolean isIsMolting() {
        return isMolting;
    }

    /**
     * @param isMolting the isMolting to set
     */
    public void setIsMolting(boolean isMolting) {
        this.isMolting = isMolting;
    }

    /**
     * @return the numberOfLaidEggInMonth
     */
    public int getNumberOfLaidEggInMonth() {
        return numberOfLaidEggsInAMonth;
    }

    /**
     * @param numberOfLaidEggInMonth the numberOfLaidEggInMonth to set
     */
    public void setNumberOfLaidEggInMonth(int numberOfLaidEggInMonth) {
        this.numberOfLaidEggsInAMonth = numberOfLaidEggInMonth;
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
