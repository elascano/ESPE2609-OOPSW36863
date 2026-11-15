package ec.edu.espe.animalfarm.model;

import java.util.Date;

/**
 *
 * @author Alvarez Juan Jose, MosQ, ESPE
 */
public class Cow extends FarmAnimal implements grazeAnimal {

    private boolean isProducingMilk;
    private float litersOfMilkPerWeek;

    @Override
    public void graze(Location location) {
        System.out.println("sending the cow to eat grass at -->" + location);
    }

    @Override
    public void feed(Food food, int amountOfFood) {
        System.out.println("feeding a cow with -->" + food);
    }

    public void milk(float amountOfLiters) {
        litersOfMilkPerWeek += amountOfLiters;

        System.out.println("milking the cow for " + amountOfLiters + " liters.");
    }

    public void milk(int amountOfLiters) {
        litersOfMilkPerWeek += amountOfLiters;

        System.out.println("milking the cow for " + amountOfLiters + " liters.");
    }

    public void milk(int amountOfLiters, Date hour) {

        System.out.println("milking the cow for" + amountOfLiters + " liters, at " + hour.getHours() + ":" + hour.getMinutes());
    }

    public void milk() {
        System.out.println("milking the cow as I need");
    }

    public Cow(boolean isProducingMilk, float litersOfMilkForWeek, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.isProducingMilk = isProducingMilk;
        this.litersOfMilkPerWeek = litersOfMilkForWeek;
    }

    @Override
    public String toString() {
        return "Cow{" + super.toString() + "isProducingMilk=" + isProducingMilk + ", litersOfMilkForWeek=" + litersOfMilkPerWeek + '}';
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
