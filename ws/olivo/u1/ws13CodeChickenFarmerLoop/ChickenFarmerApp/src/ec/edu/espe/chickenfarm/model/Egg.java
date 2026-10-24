
package ec.edu.espe.chickenfarm.model;

/**
 *
 * @author Nestor Olivo, Found ERROR 404, @ESPE
 */
public class Egg {
    private int idEgg;
    private char size;
    
    public Egg(char size){
        this. idEgg++;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Egg{" + "idEgg=" + idEgg + ", size=" + size + '}';
    }

    public int getIdEgg() {
        return idEgg;
    }

    public void setIdEgg(int idEgg) {
        this.idEgg = idEgg;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }
    
}
