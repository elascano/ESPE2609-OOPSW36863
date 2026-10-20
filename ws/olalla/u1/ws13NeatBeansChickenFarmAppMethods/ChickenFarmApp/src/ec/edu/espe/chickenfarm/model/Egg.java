package ec.edu.espe.chickenfarm.model;

/**
 *
 * @author Julian Olalla, 64 wizards, @ESPE
 */
public class Egg {

    int id;
    char size;

    public Egg(int id, char size) {
        this.id = id;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Egg{" + "id=" + id + ", size=" + size + '}';
    }

    public char getSize() {
        return size;
    }
    
}