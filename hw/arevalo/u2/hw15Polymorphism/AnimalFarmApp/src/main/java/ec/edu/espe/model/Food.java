
package ec.edu.espe.model;

/**
 *
 * @author Anthony Arévalo, @ESPE
 */
public class Food {
    private String Description;

    @Override
    public String toString() {
        return Description;
    }
    
    public Food(String Description) {
        this.Description = Description;
    }
    
    /**
     * @return the Description
     */
    public String getDescription() {
        return Description;
    }

    /**
     * @param Description the Description to set
     */
    public void setDescription(String Description) {
        this.Description = Description;
    }
    
}
