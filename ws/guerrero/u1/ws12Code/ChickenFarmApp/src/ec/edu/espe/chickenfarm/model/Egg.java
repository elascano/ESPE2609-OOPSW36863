
package ec.edu.espe.chickenfarm.model;

/**
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class Egg {
    private int id;
    private char size;

    public Egg(int id, char size) {
        this.id = id;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Egg{id=" + id + ", size=" + size + "}";
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}