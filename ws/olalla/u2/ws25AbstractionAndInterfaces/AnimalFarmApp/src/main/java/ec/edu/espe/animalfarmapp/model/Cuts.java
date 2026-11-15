package ec.edu.espe.animalfarmapp.model;


/**
 *
 * @author Julian Olalla, 404 Founders, @ESPE
 */
public class Cuts {    
    private String description;

    public Cuts(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return '{' + description + '}';
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
