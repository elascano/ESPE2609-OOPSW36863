package ec.edu.espe.animalfarmapp.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Verónica Ruiz, Code Crafters, @ESPE
 */
public class Cow extends FarmAnimal implements grazeAnimal {
   private boolean isProducingMilk;
   private float litersOfMilkPerWeek;
  
    @Override
    public void graza(Location location) {
        System.out.println("sending the cow to eat grass at ---> " + location);
    }
   
   @Override
    public void feed(Food food, int amountOfFood) {
        System.out.println("feeding a cow with ---> " + amountOfFood + " of " + food );
    }
    
   public void milk(float amountOfLiters){
       litersOfMilkPerWeek += amountOfLiters;
       System.out.println("milking the cow for " + amountOfLiters + " liters, at " + LocalTime.now());
   }
   
   public void milk(int amountOfLiters){
       litersOfMilkPerWeek += amountOfLiters;
       System.out.println("milking the cow for " + amountOfLiters + " liters, at " + LocalTime.now());
   }
   
     public void milk(){
         System.out.println("milking the cow as I need");
   }
     
    public void milk(int amountOfLiters, LocalDate hour){
        System.out.println("milking the cow for " + amountOfLiters + " liters, at " + LocalTime.now());
    }

    public Cow(boolean isProducingMilk, float litersOfMilkPerWeek, int id, String breed, LocalDate bornOnDate) {
        super(id, breed, bornOnDate);
        this.isProducingMilk = isProducingMilk;
        this.litersOfMilkPerWeek = litersOfMilkPerWeek;
    }

    @Override
    public String toString() {
        return "Cow{" + super.toString() + " isProducingMilk=" + isProducingMilk + ", litersOfMilkPerWeek=" + litersOfMilkPerWeek + '}';
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
