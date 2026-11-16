package ec.edu.espe.model;

import java.util.Date;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class Cow extends FarmAnimal {
    private boolean IsProducingMilk;
    private float litersOfMilkPerWeek;
    
    
    public Cow(boolean IsProducingMilk, float litersOfMilkPerWeek, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.IsProducingMilk = IsProducingMilk;
        this.litersOfMilkPerWeek = litersOfMilkPerWeek;
    }

    @Override
    public String toString() {
        return "Cow{" + super.toString() + "IsProducingMilk=" + IsProducingMilk + ", litersOfMilkPerWeek=" + litersOfMilkPerWeek + '}';
    }
    
    
    
    public void milk(){
        System.out.println("Milking the cow ");
    }

    /**
     * @return the IsProducingMilk
     */
    public boolean isIsProducingMilk() {
        return IsProducingMilk;
    }

    /**
     * @param IsProducingMilk the IsProducingMilk to set
     */
    public void setIsProducingMilk(boolean IsProducingMilk) {
        this.IsProducingMilk = IsProducingMilk;
    }

    /**
     * @return the litersOfMilkPerWeek
     */
    public float getLitersOfMilkPerWeek() {
        return litersOfMilkPerWeek;
    }

    /**
     * @param litersOfMilkPerWeek the litersOfMilkPerWeek to set
     */
    public void setLitersOfMilkPerWeek(float litersOfMilkPerWeek) {
        this.litersOfMilkPerWeek = litersOfMilkPerWeek;
    }
    
    
}
