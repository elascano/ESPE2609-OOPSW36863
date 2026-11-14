
package ec.edu.espe.model;

import java.util.Date;

/**
 *Cow
 * @author Nohemi Tocagon, IV Studio, @ESPE
 */
public class Cow extends FarmAnimal implements grazeAnimal{
    
    @Override
    public void feed(Food food, int amountOfFood) {
        System.out.println("feeding the cow in the stable eith-->"+food);
    }
    
    @Override
    public void graze(Location location) {
        System.out.println("sending the cow to eat grass at-->" + location);
    }
    
    private boolean isProducingMilk;
    private float litersOfMilkPerWeek;
    
    public void milk(int amountOfLiters){
        litersOfMilkPerWeek+= amountOfLiters;
        System.out.println("milking the cow for" + amountOfLiters +" liters");
    }
        
    public void milk(float amountOfLiters){
        litersOfMilkPerWeek+= amountOfLiters;
        System.out.println("milking the cow for" + amountOfLiters +" liters");
    }
    
    public void milk(){
        System.out.println("milking the cow as I need");
    }
    
    public void milk(int amountOfLiters, Date hour){
        System.out.println("milking the cow for "+ amountOfLiters + " liters, at "+ hour.getHours()+ ":"+ hour.getMinutes());
    }

    public Cow(boolean isProducingMilk, float litersOfMilkPerWeek, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.isProducingMilk = isProducingMilk;
        this.litersOfMilkPerWeek = litersOfMilkPerWeek;
    }

    @Override
    public String toString() {
        return "Cow{" +super.toString()+ "isProducingMilk=" + isProducingMilk + ", litersOfMilkPerWeek=" + litersOfMilkPerWeek + '}';
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
