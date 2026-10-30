
package ec.edu.espe.chickenfarm.model;

/**
 *
 * @author Nestor Olivo, Found ERROR 404, @ESPE
 */
public class Poop {
    private int id;
    private String color;
    private char consistenly;

    public Poop(String color, char consistenly) {
        this.id++;
        this.color = color;
        this.consistenly = consistenly;
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

    public char getConsistenly() {
        return consistenly;
    }

    public void setConsistenly(char consistenly) {
        this.consistenly = consistenly;
    }

    @Override
    public String toString() {
        return "Poop{" + "id=" + id + ", color=" + color + ", consistenly=" + consistenly + '}';
    }


    
}
