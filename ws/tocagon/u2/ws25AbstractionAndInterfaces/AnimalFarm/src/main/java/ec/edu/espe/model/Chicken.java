
package ec.edu.espe.model;

import java.util.Date;

/**
 *chicken
 * @author Nohemi Tocagon, IV Studio, @ESPE
 */
public class Chicken extends FarmAnimal{
    
    /**
     * Feeding chicken with grains
     * @param food
     * @param amountOfFood 
     */
    @Override
    public void feed(Food food, int amountOfFood) {
        System.out.println("Feeding the chicken with-->"+ amountOfFood+"of"+food);
    }
    
    
    private boolean isMolting;
    private int numberOfLaidEggsInAMonth;
    private boolean isMeat;

    public Chicken(boolean isMolting, int numberOfLaidEggsInAMonth, boolean isMeat, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.isMolting = isMolting;
        this.numberOfLaidEggsInAMonth = numberOfLaidEggsInAMonth;
        this.isMeat = isMeat;
    }
    
    
    public void layAnEgg(){
        numberOfLaidEggsInAMonth++;
        System.out.println("chicken is laying an egg()");
    }

    @Override
    public String toString() {
        return "Chicken{" +super.toString()
                + "isMolting=" + isMolting 
                + ", numberOfLaidEggsInAMonth=" + numberOfLaidEggsInAMonth 
                + ", isMeat=" + isMeat + '}';
    }
    
    
    public boolean isIsMolting() {
        return isMolting;
    }

    public void setIsMolting(boolean isMolting) {
        this.isMolting = isMolting;
    }

    public int getNumberOfLaidEggsInAMonth() {
        return numberOfLaidEggsInAMonth;
    }

    public void setNumberOfLaidEggsInAMonth(int numberOfLaidEggsInAMonth) {
        this.numberOfLaidEggsInAMonth = numberOfLaidEggsInAMonth;
    }

    public boolean isIsMeat() {
        return isMeat;
    }

    public void setIsMeat(boolean isMeat) {
        this.isMeat = isMeat;
    }

    
    
}
