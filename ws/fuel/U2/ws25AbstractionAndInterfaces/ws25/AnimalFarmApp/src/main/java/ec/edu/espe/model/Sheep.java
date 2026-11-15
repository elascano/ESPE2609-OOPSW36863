package ec.edu.espe.model;

import java.util.Date;

public class Sheep extends FarmAnimal implements grazeAnimal {

    private boolean isProducingWool;
    private float woolInPounds;
    private String woolColor;

    public Sheep(boolean isProducingWool, float woolInPounds,
            String woolColor, int id, String breed, Date bornOnDate) {

        super(id, breed, bornOnDate);
        this.isProducingWool = isProducingWool;
        this.woolInPounds = woolInPounds;
        this.woolColor = woolColor;
    }

    @Override
    public void feed(Food food, int amountOfFood) {
        System.out.println("Feeding a sheep with ---> "
                + amountOfFood + " of " + food);
    }

    @Override
    public void graze(Location location) {
        System.out.println("The sheep is grazing at ---> " + location);
    }

    public void shearWool() {
        System.out.println("Shearing the sheep...");
    }

    @Override
    public String toString() {
        return "Sheep{" + "isProducingWool=" + isProducingWool
                + ", woolInPounds=" + woolInPounds
                + ", woolColor=" + woolColor + "} " + super.toString();
    }

    public boolean isIsProducingWool() {
        return isProducingWool;
    }

    public void setIsProducingWool(boolean isProducingWool) {
        this.isProducingWool = isProducingWool;
    }

    public float getWoolInPounds() {
        return woolInPounds;
    }

    public void setWoolInPounds(float woolInPounds) {
        this.woolInPounds = woolInPounds;
    }

    public String getWoolColor() {
        return woolColor;
    }

    public void setWoolColor(String woolColor) {
        this.woolColor = woolColor;
    }
}