package ec.edu.espe.animalfarmapp.model;

import java.util.Date;
import java.util.ArrayList;

/**
 *
 * @author Julian Olalla, 404 Founders, @ESPE
 */
public class Cow extends FarmAnimal implements GrazeAnimal {

    private boolean isProducingMilk;
    private float litersOfMilkPerWeek;
    private ArrayList<String> vaccines;

    @Override
    public void graze(Location location) {
        System.out.println("Sending the cow to eat grass at --> " + location);
    }

    @Override
    public void feed(Food food, int amountOfFood, String unit) {
        System.out.println("Feeding a cow with --> " + amountOfFood + unit + " of " + food);
    }

    @Override
    public void cuts(Cuts cuts) {
        System.out.println("Cutting a cow into --> " + cuts);
    }

    public void addVaccine(String vaccine) {
        vaccines.add(vaccine);
        System.out.println("Vaccine added --> " + vaccine);
    }

    public void milk() {
        System.out.println("milking the cow");
    }

    public void milk(float amountOfLiters) {
        setLitersOfMilkPerWeek(getLitersOfMilkPerWeek() + amountOfLiters);
        System.out.println("milk in the cow for " + amountOfLiters + " litters");
    }

    public void milk(int amountOfLiters) {
        setLitersOfMilkPerWeek(getLitersOfMilkPerWeek() + amountOfLiters);
        System.out.println("milk in the cow for " + amountOfLiters + " litters");
    }

    public void milk(int amountOfLiters, Date hour) {
        System.out.println("milk in the cow for " + amountOfLiters + " liters at " + hour.getHours());
    }

    public Cow(boolean isProducingMilk, float litersOfMilkPerWeek, int numberOfOffspring, int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate, numberOfOffspring);
        this.isProducingMilk = isProducingMilk;
        this.litersOfMilkPerWeek = litersOfMilkPerWeek;
        this.vaccines = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "cow{" + super.toString() + "isProducingMilk=" + isIsProducingMilk()
                + ", litersOfMilkPerWeek=" + getLitersOfMilkPerWeek() + '}';
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

    /**
     * @return the vaccines
     */
    public ArrayList<String> getVaccines() {
        return vaccines;
    }

    /**
     * @param vaccines the vaccines to set
     */
    public void setVaccines(ArrayList<String> vaccines) {
        this.vaccines = vaccines;
    }

}
