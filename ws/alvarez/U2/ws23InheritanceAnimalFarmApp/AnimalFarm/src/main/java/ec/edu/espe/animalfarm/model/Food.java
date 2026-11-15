package ec.edu.espe.animalfarm.model;

/**
 *
 * @author Juan Alvarez, MosQ, @ESPE
 */
public class Food {
    private String description;

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public Food(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
