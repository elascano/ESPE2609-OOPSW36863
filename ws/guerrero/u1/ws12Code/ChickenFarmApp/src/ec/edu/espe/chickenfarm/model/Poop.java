
package ec.edu.espe.chickenfarm.model;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class Poop {
    private int id;
    private String color;
    private char concistency;

    public Poop(int id, String color, char concistency) {
        this.id = id;
        this.color = color;
        this.concistency = concistency;
    }

    @Override
    public String toString() {
        return "Poop{" + "id=" + id + ", color=" + color + ", concistency=" + concistency + '}';
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
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the concistency
     */
    public char getConcistency() {
        return concistency;
    }

    /**
     * @param concistency the concistency to set
     */
    public void setConcistency(char concistency) {
        this.concistency = concistency;
    }
    
    
    
}
