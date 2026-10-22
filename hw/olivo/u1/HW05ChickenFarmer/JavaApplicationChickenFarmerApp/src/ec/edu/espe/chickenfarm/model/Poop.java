
package ec.edu.espe.chickenfarm.model;
/**
 *
 * @author Nestor Olivo, Found ERROR 404, @ESPE
 */
public class Poop {
    private int idPoop = 0;
    private char consisyency; 
    private String color;

    public Poop(char consisyency, String color) {
        this.consisyency = consisyency;
        this.color = color;
        this.idPoop++;
    }

    public int getIdPoop() {
        return idPoop;
    }


    public char getConsisyency() {
        return consisyency;
    }

    public void setConsisyency(char consisyency) {
        this.consisyency = consisyency;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Poop{" + "idPoop=" + idPoop + ", consisyency=" + consisyency + ", color=" + color + '}';
    }
    
}
