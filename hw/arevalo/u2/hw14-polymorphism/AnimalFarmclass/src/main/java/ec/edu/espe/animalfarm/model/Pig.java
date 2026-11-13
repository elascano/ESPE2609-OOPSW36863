
package ec.edu.espe.animalfarm.model;

import java.util.Date;

/**
 *
 * @author Anthony Arevalo, MosQ ,@ESPE
 */
public class Pig extends FarmAnimal {
    private float weightInKg;
    private float dailyFoodIntakeInKg;
    private boolean isCastrated;

    public Pig(float weightInKg, float dailyFoodIntakeInKg, boolean isCastrated,
            int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.weightInKg = weightInKg;
        this.dailyFoodIntakeInKg = dailyFoodIntakeInKg;
        this.isCastrated = isCastrated;
    }

    @Override
    public String toString() {
        return "Pig{" + super.toString() + "weightInKg=" + weightInKg
                + ", dailyFoodIntakeInKg=" + dailyFoodIntakeInKg
                + ", isCastrated=" + isCastrated + '}';
    }

    public float getWeightInKg() {
        return weightInKg;
    }

    public void setWeightInKg(float weightInKg) {
        this.weightInKg = weightInKg;
    }

    public float getDailyFoodIntakeInKg() {
        return dailyFoodIntakeInKg;
    }

    public void setDailyFoodIntakeInKg(float dailyFoodIntakeInKg) {
        this.dailyFoodIntakeInKg = dailyFoodIntakeInKg;
    }

    public boolean isCastrated() {
        return isCastrated;
    }

    public void setCastrated(boolean isCastrated) {
        this.isCastrated = isCastrated;
    }
}
