
package ec.edu.espe.model;

import java.util.Date;

public class Pig extends FarmAnimal {

    private float weight;
    private boolean isBreeding;

    public Pig(float weight, boolean isBreeding,
            int id, String breed, Date bornOnDate) {

        super(id, breed, bornOnDate);

        this.weight = weight;
        this.isBreeding = isBreeding;
    }

    public void feed() {
        System.out.println("Pig is eating ()");
    }

    @Override
    public String toString() {
        return "Pig{" + super.toString()
                + "weight=" + weight
                + ", isBreeding=" + isBreeding + '}';
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean isIsBreeding() {
        return isBreeding;
    }

    public void setIsBreeding(boolean isBreeding) {
        this.isBreeding = isBreeding;
    }
}
