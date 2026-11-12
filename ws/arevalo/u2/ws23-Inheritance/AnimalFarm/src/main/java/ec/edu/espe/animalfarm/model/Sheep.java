
package ec.edu.espe.animalfarm.model;

import java.util.Date;

/**
 *
 * @author Anthony Arevalo, MosQ ,@ESPE
 */
public class Sheep extends FarmAnimal {
    private Date lastShearing;
    private float woolWeightInKg;
    private String woolColor;

    public Sheep(Date lastShearing, float woolWeightInKg, String woolColor,
            int id, String breed, Date bornOnDate) {
        super(id, breed, bornOnDate);
        this.lastShearing = lastShearing;
        this.woolWeightInKg = woolWeightInKg;
        this.woolColor = woolColor;
    }

    @Override
    public String toString() {
        return "Sheep{" + super.toString() + "lastShearing=" + lastShearing
                + ", woolWeightInKg=" + woolWeightInKg
                + ", woolColor=" + woolColor + '}';
    }

    public Date getLastShearing() {
        return lastShearing;
    }

    public void setLastShearing(Date lastShearing) {
        this.lastShearing = lastShearing;
    }

    public float getWoolWeightInKg() {
        return woolWeightInKg;
    }

    public void setWoolWeightInKg(float woolWeightInKg) {
        this.woolWeightInKg = woolWeightInKg;
    }

    public String getWoolColor() {
        return woolColor;
    }

    public void setWoolColor(String woolColor) {
        this.woolColor = woolColor;
    }
}
 
