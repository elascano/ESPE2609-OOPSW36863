
package ec.edu.espe.chickenfarm.model;

/**
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class Poop {
    private int id;
    private String color;
    private char consistency;

    
    public Poop(int id, String color, char consistency) {
        this.id = id;
        this.color = color;
        this.consistency = consistency;
    }

    
    public Poop(int id, String color) {
        this.id = id;
        this.color = color;
        this.consistency = 'M'; // Valor por defecto medium
    }

    @Override
    public String toString() {
        return "Poop{id=" + id + ", color=" + color + ", consistency=" + consistency + "}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getConsistency() {
        return consistency;
    }

    public void setConsistency(char consistency) {
        this.consistency = consistency;
    }
}
