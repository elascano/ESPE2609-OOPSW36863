package ec.espe.edu.animalfarmapp.model;

import java.util.Date;

/**
 *
 * @author Lesly Muzo, CodeX3Team, @ESPE
 */
public class Cow extends FarmAnimal{
    private boolean isProductingMilk;
    private float litersOfMilkPerWeek;
    
    public void milk(){
        System.out.println("milking the cow");
    }

    public Cow(boolean isProductingMilk, float litersOfMilkPerWeek, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.isProductingMilk = isProductingMilk;
        this.litersOfMilkPerWeek = litersOfMilkPerWeek;
    }

    @Override
    public String toString() {
        return "Cow{" + super.toString() + "isProductingMilk=" + isProductingMilk + ", litersOfMilkPerWeek=" + litersOfMilkPerWeek + '}';
    }

    
    /**
     * @return the isProductingMilk
     */
    public boolean isIsProductingMilk() {
        return isProductingMilk;
    }

    /**
     * @param isProductingMilk the isProductingMilk to set
     */
    public void setIsProductingMilk(boolean isProductingMilk) {
        this.isProductingMilk = isProductingMilk;
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
