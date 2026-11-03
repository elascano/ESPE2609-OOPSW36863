package ec.edu.espe.chickenfarm.model;

/**
 *
 * @author Lesly Muzo, @ESPE
 */
public class Poop {
    private int poopId;
    private String poopColor;
    private char poopConsistency;

    public Poop(int poopId, String poopColor, char poopConsistency) {
        this.poopId = poopId;
        this.poopColor = poopColor;
        this.poopConsistency = poopConsistency;
    }

    @Override
    public String toString() {
        return "Poop{" + "id=" + poopId + ", color=" + poopColor + ", consistency=" + poopConsistency + '}';
    }

    /**
     * @return the id
     */
    public int getId() {
        return poopId;
    }

    /**
     * @param poopId the id to set
     */
    public void setId(int poopId) {
        this.poopId = poopId;
    }

    /**
     * @return the color
     */
    public String getColor() {
        return poopColor;
    }

    /**
     * @param poopColor the color to set
     */
    public void setColor(String poopColor) {
        this.poopColor = poopColor;
    }

    /**
     * @return the consistency
     */
    public char getConsistency() {
        return poopConsistency;
    }

    /**
     * @param poopConsistency the consistency to set
     */
    public void setConsistency(char poopConsistency) {
        this.poopConsistency = poopConsistency;
    }
    
}