package ec.edu.espe.animal.model;

import java.util.Date;

/**
 * Cow
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

    // Overloading: feed with only Food
    public void feed(Food food) {
        System.out.println(
                "Feeding a cow in the stable with --> " + food
        );
    }

    // Overloading: feed with Food and int
    public void feed(Food food, int amountOfFood) {
        System.out.println(
                "Feeding a cow in the stable with --> "
                + amountOfFood + " of " + food
        );
    }

    // Overriding: same method declared in FarmAnimal
    @Override
    public void feed(Food food, float amountOfFood) {
        System.out.println(
                "Sending the cow to eat --> "
                + amountOfFood + " of " + food
        );
    }

    // Overloading: milk with int
    public void milk(int amountOfLiters) {
        litersOfMilkPerWeek += amountOfLiters;

        System.out.println(
                "Milking the cow for --> "
                + amountOfLiters + " liters"
        );
    }

    // Overloading: milk with float
    public void milk(float amountOfLiters) {
        litersOfMilkPerWeek += amountOfLiters;

        System.out.println(
                "Milking the cow for --> "
                + amountOfLiters + " liters"
        );
    }

    // Overloading: milk without parameters
    public void milk() {
        System.out.println("Milking the cow as I need");
    }

    // Overloading: milk with quantity and date
    public void milk(int amountOfLiters, Date hour) {
        litersOfMilkPerWeek += amountOfLiters;

        System.out.println(
                "Milking the cow for --> "
                + amountOfLiters
                + " liters, at --> "
                + hour
        );
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