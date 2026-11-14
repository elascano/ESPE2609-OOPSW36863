
package ec.edu.espe.model;

import java.util.Date;

/**
 *
 * @author Nohemi Tocagon, IV Studio, @ESPE
 */
public class Cow extends FarmAnimal{
    private boolean isProducingMilk;
    private float litersOfMilkPerWeek;

    public Cow(boolean isProducingMilk, float litersOfMilkPerWeek, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.isProducingMilk = isProducingMilk;
        this.litersOfMilkPerWeek = litersOfMilkPerWeek;
    }

    @Override
    public String toString() {
        return "Cow{" +super.toString()+ "isProducingMilk=" + isProducingMilk 
                + ", litersOfMilkPerWeek=" + litersOfMilkPerWeek + '}';
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
    
    public void milk(){
        System.out.println("Milking the Cow");
    }
}
