
package ec.edu.espe.chickenfarm.model;

/**
 *
 * @author Usuario
 */
public class Poop {
  private int id;
  private char color;
  private char consistency;

    @Override
    public String toString() {
        return "Poop{" + "id=" + id + ", color=" + color + ", consistency=" + consistency + '}';
    }

    public Poop(int id, String brown, char color) {
        this.id = id;
        this.color = color;
        this.consistency = consistency;
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
    public char getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(char color) {
        this.color = color;
    }

    /**
     * @return the consistency
     */
    public char getConsistency() {
        return consistency;
    }

    /**
     * @param consistency the consistency to set
     */
    public void setConsistency(char consistency) {
        this.consistency = consistency;
    }
  
  
}
