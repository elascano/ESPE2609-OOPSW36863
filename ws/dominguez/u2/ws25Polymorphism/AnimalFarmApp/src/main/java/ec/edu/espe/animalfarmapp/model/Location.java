package ec.edu.espe.animalfarmapp.model;

/**
 *
 * @author Mateo Dominguez, Brain Training, @ESPE
 */
public class Location {
    private int current;
    private String description;

    public Location(int current, String description) {
        this.current = current;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Location{" + "current=" + current + ", description=" + description + '}';
    }

    /**
     * @return the current
     */
    public int getCurrent() {
        return current;
    }

    /**
     * @param current the current to set
     */
    public void setCurrent(int current) {
        this.current = current;
    }

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
    
    
}
