package ec.edu.espe.chickenfarm.model;

/**
 *
 * @author Jesus Garcia, @ESPE
 */
public class Egg {
    
    private int id;
    private char size;
    
    public Egg(int id, char size){
        this.id = id;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Egg{" + "id=" + getId() + ", size=" + getSize() + '}';
    }
    
    
    public char getSize(){
        return size;
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
     * @param size the size to set
     */
    public void setSize(char size) {
        this.size = size;
    }
    
    
}
