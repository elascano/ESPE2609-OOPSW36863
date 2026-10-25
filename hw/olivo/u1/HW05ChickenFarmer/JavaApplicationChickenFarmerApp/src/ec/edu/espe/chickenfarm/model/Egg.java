
package ec.edu.espe.chickenfarm.model;
/**
 *
 * @author Nestor Olivo, Found ERROR 404, @ESPE
 */
public class Egg {
    private int idEgg = 0;
    private char size;

    public Egg(char size) {
        this.size = size;
        this.idEgg++;
    }

    public char getSize() {
        return size;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public int getIdEgg() {
        return idEgg;
    }
    
}
