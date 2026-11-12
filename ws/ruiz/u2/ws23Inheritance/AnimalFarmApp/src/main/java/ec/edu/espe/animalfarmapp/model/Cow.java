package ec.edu.espe.animalfarmapp.model;

import java.time.LocalDate;

/**
 *
 * @author Verónica Ruiz, Code Crafters, @ESPE
 */
public class Cow extends FarmAnimal {
   private boolean isProducingMilk;
   private float litersOfMilkPerWeek;
   
   public void milk(){
       System.out.println("milking the cow");
   }

    public Cow(boolean isProducingMilk, float litersOfMilkPerWeek, int id, String breed, LocalDate bornOnDate) {
        super(id, breed, bornOnDate);
        this.isProducingMilk = isProducingMilk;
        this.litersOfMilkPerWeek = litersOfMilkPerWeek;
    }

    @Override
    public String toString() {
        return "Cow{" + super.toString() + "isProducingMilk=" + isProducingMilk + ", litersOfMilkPerWeek=" + litersOfMilkPerWeek + '}';
    }

    /**
     * @return the isProducingMilk
     */
    public boolean isIsProducingMilk() {
        return isProducingMilk;
    }

    /**
     * @param isProducingMilk the isProducingMilk to set
     */
    public void setIsProducingMilk(boolean isProducingMilk) {
        this.isProducingMilk = isProducingMilk;
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
