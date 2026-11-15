package ec.edu.espe.model;

import java.util.Date;

public class Pig extends FarmAnimal {

    private boolean isProducingMeat;
    private float weightInPounds;
    private String meatType;

    public Pig(boolean isProducingMeat, float weightInPounds,
            String meatType, int id, String breed, Date bornOnDate) {

        super(id, breed, bornOnDate);
        this.isProducingMeat = isProducingMeat;
        this.weightInPounds = weightInPounds;
        this.meatType = meatType;
    }

    @Override
    public void feed(Food food, int amountOfFood) {
        System.out.println("Feeding a pig with ---> "
                + amountOfFood + " of " + food);
    }

    public void gainWeight(float amount) {
        weightInPounds += amount;
        System.out.println("The pig's new weight is "
                + weightInPounds + " pounds");
    }

    @Override
    public String toString() {
        return "Pig{" + "isProducingMeat=" + isProducingMeat
                + ", weightInPounds=" + weightInPounds
                + ", meatType=" + meatType + "} " + super.toString();
    }

    public boolean isIsProducingMeat() {
        return isProducingMeat;
    }

    public void setIsProducingMeat(boolean isProducingMeat) {
        this.isProducingMeat = isProducingMeat;
    }

    public float getWeightInPounds() {
        return weightInPounds;
    }

    public void setWeightInPounds(float weightInPounds) {
        this.weightInPounds = weightInPounds;
    }

    public String getMeatType() {
        return meatType;
    }

    public void setMeatType(String meatType) {
        this.meatType = meatType;
    }
}