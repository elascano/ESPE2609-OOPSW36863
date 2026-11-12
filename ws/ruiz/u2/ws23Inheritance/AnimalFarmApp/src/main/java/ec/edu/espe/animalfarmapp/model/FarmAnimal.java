package ec.edu.espe.animalfarmapp.model;

import java.time.LocalDate;

/**
 *
 * @author Verónica Ruiz, Code Crafters, @ESPE
 */
public class FarmAnimal {
    private int id;
    private String breed;
    private LocalDate bornOnDate;

    public FarmAnimal(int id, String breed, LocalDate bornOnDate) {
        this.id = id;
        this.breed = breed;
        this.bornOnDate = bornOnDate;
    }

    @Override
    public String toString() {
        return "id=" + id + ", breed=" + breed + 
                ", bornOnDate=" + bornOnDate.getDayOfMonth() +
                "/" + (bornOnDate.getMonthValue()) + 
                "/" + (bornOnDate.getYear()) + ",";
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
    public LocalDate getBornOnDate() {
        return bornOnDate;
    }

    /**
     * @param bornOnDate the bornOnDate to set
     */
    public void setBornOnDate(LocalDate bornOnDate) {
        this.bornOnDate = bornOnDate;
    }

    
}
