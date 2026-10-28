
package ec.edu.espe.chickenfarm.model;

/**
 *
 * @author Alejandro Fuel
 */
public class Egg {

    private int id;
    private char size;

    // Constructor
    public Egg(int id, char size) {
        this.id = id;
        this.size = size;
    }

    // Getter de id
    public int getId() {
        return id;
    }

    // Setter de id
    public void setId(int id) {
        this.id = id;
    }

    // Getter de size
    public char getSize() {
        return size;
    }

    // Setter de size
    public void setSize(char size) {
        this.size = size;
    }

    // Método toString
    @Override
    public String toString() {
        return "Egg{" +
                "id=" + id +
                ", size=" + size +
                '}';
    }
}
