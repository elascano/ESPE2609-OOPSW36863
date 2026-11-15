
package ec.edu.espe.animalfarmapp.model;

import java.util.Date;

/**
 *
 * @author Julian Olalla, 404 Founders, @ESPE
 */
public abstract class FarmAnimal {
    private int id;
    private String breed;
    private Date bornOnDate;
    private int numberOfOffspring;
    
    /**
     * Feed the animal with their own food
     * @param food
     * @param amountOfFood
     * @param unit
     */
    public abstract void feed(Food food, int amountOfFood, String unit);
    
    public abstract void cuts(Cuts cuts);
    
    public int getAgeInMonths(){
        //TODO compute the age in monts
        return 0;
    }
    
    public void giveBirth(int offspring) {
        System.out.println("Number of offspring the " + getClass().getSimpleName() + " gave birth --> " + offspring);
    }

    public FarmAnimal(int id, String breed, Date bornOnDate, int numberOfOffsprings) {
        this.id = id;
        this.breed = breed;
        this.bornOnDate = bornOnDate;
        this.numberOfOffspring = numberOfOffsprings;
    }    
    
    @Override
    public String toString() {
        return  "id=" + getId() + ", breed=" + getBreed() 
                + ", bornOnDate=" + getBornOnDate().getDate() 
                + '/' + (getBornOnDate().getMonth()+1) 
                + "/" + (getBornOnDate().getYear()+1900)
                + ", numberOfOffspring=" + getNumberOfOffspring() + ",";
    }                

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the breed
     */
    public String getBreed() {
        return breed;
    }

    /**
     * @param breed the breed to set
     */
    public void setBreed(String breed) {
        this.breed = breed;
    }

    /**
     * @return the bornOnDate
     */
    public Date getBornOnDate() {
        return bornOnDate;
    }

    /**
     * @param bornOnDate the bornOnDate to set
     */
    public void setBornOnDate(Date bornOnDate) {
        this.bornOnDate = bornOnDate;
    }

    /**
     * @return the numberOfOffspring
     */
    public int getNumberOfOffspring() {
        return numberOfOffspring;
    }

    /**
     * @param numberOfOffspring the numberOfOffspring to set
     */
    public void setNumberOfOffspring(int numberOfOffspring) {
        this.numberOfOffspring = numberOfOffspring;
    }        
}
