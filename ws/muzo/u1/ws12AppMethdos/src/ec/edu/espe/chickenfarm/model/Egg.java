package ec.edu.espe.chickenfarm.model;

/**
 *
 * @author Lesly Muzo, @ESPE
 */
public class Egg {
    
    private int eggId;
    private char eggSize;

    public Egg(int eggId, char eggSize){
        this.eggId = eggId;
        this.eggSize = eggSize;
    }

    @Override
    public String toString() {
        return "Egg{" + "id=" + getId() + ", size=" + getSize() + '}';
    }
    
    public char getSize(){
        return eggSize;
    }

    public int getId() {
        return eggId;
    }

    public void setId(int eggId) {
        this.eggId = eggId;
    }

    public void setSize(char eggSize) {
        this.eggSize = eggSize;
    }
}