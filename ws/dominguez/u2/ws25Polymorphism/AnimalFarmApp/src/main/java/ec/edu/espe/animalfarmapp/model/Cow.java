package ec.edu.espe.animalfarmapp.model;

import java.util.Date;

/**
 *
 * @author Mateo Dominguez, Brain Training, @ESPE
 */
public class Cow extends FarmAnimal{
    private boolean isProductingMilk;
    private float literOfMilkPerWeek;
    
    @Override
    public void feed(Food food, int amountOfFood) {
        System.out.println("feeding a cow in the stable with "+ amountOfFood + " of "+ food);
    }
    
    public void milk(int amountOfLiters){
        literOfMilkPerWeek += amountOfLiters;
        System.out.println("milking the cow for " + amountOfLiters + " liters");
    }
    public void milk(){
        System.out.println("milking the cow as I need");
    }
    public void milk(float amountOfLiters){
        literOfMilkPerWeek += amountOfLiters;
        System.out.println("milking the cow for " + amountOfLiters + " liters");
    }
    public void milk(int amountOfLiters, Date hour){
        literOfMilkPerWeek += amountOfLiters;
        System.out.println("milking the cow for " + amountOfLiters + " liters, at " + hour.getHours() + ":" + hour.getMinutes());
    }

    public Cow(boolean isProductingMilk, float literOfMilkPerWeek, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.isProductingMilk = isProductingMilk;
        this.literOfMilkPerWeek = literOfMilkPerWeek;
    }

    @Override
    public String toString() {
        return "Cow{" + super.toString() + "isProductingMilk=" + isProductingMilk + ", literOfMilkPerWeek=" + literOfMilkPerWeek + '}';
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
     * @return the literOfMilkPerWeek
     */
    public float getLiterOfMilkPerWeek() {
        return literOfMilkPerWeek;
    }

    /**
     * @param literOfMilkPerWeek the literOfMilkPerWeek to set
     */
    public void setLiterOfMilkPerWeek(float literOfMilkPerWeek) {
        this.literOfMilkPerWeek = literOfMilkPerWeek;
    }
    
    
}
