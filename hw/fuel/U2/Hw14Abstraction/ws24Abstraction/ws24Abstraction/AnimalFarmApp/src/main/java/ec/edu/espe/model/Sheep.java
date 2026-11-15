
package ec.edu.espe.model;

import java.util.Date;

public class Sheep extends FarmAnimal {

    private float woolLength;
    private boolean isProducingWool;

    public Sheep(float woolLength, boolean isProducingWool,
            int id, String breed, Date bornOnDate) {

        super(id, breed, bornOnDate);
        this.woolLength = woolLength;
        this.isProducingWool = isProducingWool;
    }

    public void shear() {
        System.out.println("Shearing the sheep");
    }

    @Override
    public String toString() {
        return "Sheep{" + super.toString()
                + "woolLength=" + woolLength
                + ", isProducingWool=" + isProducingWool + '}';
    }

    public float getWoolLength() {
        return woolLength;
    }

    public void setWoolLength(float woolLength) {
        this.woolLength = woolLength;
    }

    public boolean isIsProducingWool() {
        return isProducingWool;
    }

    public void setIsProducingWool(boolean isProducingWool) {
        this.isProducingWool = isProducingWool;
    }
}
