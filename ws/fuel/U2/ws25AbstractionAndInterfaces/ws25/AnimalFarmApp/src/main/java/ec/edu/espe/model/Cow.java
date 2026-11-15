
package ec.edu.espe.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cow extends FarmAnimal implements grazeAnimal {

    private boolean isProducingMilk;
    private float litersOfMilkPerWeek;
    private String food;

    public Cow(boolean isProducingMilk, float litersOfMilkPerWeek,
            int id, String breed, Date bornOnDate) {

        super(id, breed, bornOnDate);
        this.isProducingMilk = isProducingMilk;
        this.litersOfMilkPerWeek = litersOfMilkPerWeek;
    }

    @Override
    public void graze(Location location) {
        System.out.println("Feeding a cow in the stable with ---> " + food);
    }

    public void milk(int amountOfLiters) {
        litersOfMilkPerWeek += amountOfLiters;
        System.out.println("The cow produced " + litersOfMilkPerWeek + " liters of milk per week");
    }

    public void milk(float amountOfLiters) {
        litersOfMilkPerWeek += amountOfLiters;
        System.out.println("The cow produced " + litersOfMilkPerWeek + " liters of milk per week");
    }

    public void milk() {
        System.out.println("Milking the cow as I need");
    }

    public void milk(float amountOfLiters, Date hour) {
        litersOfMilkPerWeek += amountOfLiters;

        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");

        System.out.println("The cow produced " + litersOfMilkPerWeek
                + " liters of milk per week at " + dateFormat.format(hour));
    }

    @Override
    public void feed(Food food, int amountOfFood) {
        System.out.println("Feeding a cow with ---> " + food);
    }

    @Override
    public String toString() {
        return "Cow{" + "isProducingMilk=" + isProducingMilk
                + ", litersOfMilkPerWeek=" + litersOfMilkPerWeek
                + ", food=" + food + "} " + super.toString();
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

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }
}
