
package ec.edu.espe.animal.model;

import java.util.Date;

/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
public class Cow extends FarmAnimal {

    private boolean isProducingMilk;
    private float litersOfMilkPerWeek;

    public Cow(boolean isProducingMilk, float litersOfMilkPerWeek,
            int id, String bread, Date bornOnDate) {

        super(id, bread, bornOnDate);
        this.isProducingMilk = isProducingMilk;
        this.litersOfMilkPerWeek = litersOfMilkPerWeek;
    }

    public void milk() {
        System.out.println("Milking the cow");
    }

    @Override
    public String toString() {
        return "Cow{" + super.toString()
                + ", isProducingMilk=" + isProducingMilk
                + ", litersOfMilkPerWeek=" + litersOfMilkPerWeek
                + '}';
    }

    public boolean isIsProducingMilk() {
        return isProducingMilk;
    }

    public void setIsProducingMilk(boolean isProducingMilk) {
        this.isProducingMilk = isProducingMilk;
    }

    public float getLitersOfMilkPerWeek() {
        return litersOfMilkPerWeek;
    }

    public void setLitersOfMilkPerWeek(float litersOfMilkPerWeek) {
        this.litersOfMilkPerWeek = litersOfMilkPerWeek;
    }
}
