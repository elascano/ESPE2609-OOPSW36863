package ec.edu.espe.model;

import java.util.Date;

/**
 *
 * @author Erick Revelo, Code Crafters, @ESPE
 */
public abstract class FarmAnimal {
   
   //Atributes
   private int id;
   private String breed;
   private Date bornOnDate;

   
   //Methods
   public int getAgeInMonths(){
       return 0;
   }
   
    //toString
    @Override
    public String toString() {
        return "id=" + id + ", breed=" + breed + 
                ", bornOnDate=" + bornOnDate.getDate() + 
                "/" + (bornOnDate.getMonth()+1) +
                "/" + (bornOnDate.getYear()+1900) + ',';
    }   
   
   //Constructor
    public FarmAnimal(int id, String breed, Date bornOnDate) {
        this.id = id;
        this.breed = breed;
        this.bornOnDate = bornOnDate;
    }

    //Encapsulate
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
    
}
