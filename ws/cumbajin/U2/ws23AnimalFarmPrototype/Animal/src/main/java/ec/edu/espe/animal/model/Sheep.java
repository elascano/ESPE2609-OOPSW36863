package ec.edu.espe.animal.model;

import java.util.Date;

/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
public class Sheep extends FarmAnimal {

    private Date lastSheering;

    public Sheep(Date lastSheering, int id, String bread, Date bornOnDate) {
        super(id, bread, bornOnDate);
        this.lastSheering = lastSheering;
    }

    @Override
    public String toString() {
        return "Sheep{" + super.toString()
                + ", lastSheering=" + (lastSheering.getYear() + 1900)
                + '}';
    }

    public Date getLastSheering() {
        return lastSheering;
    }

    public void setLastSheering(Date lastSheering) {
        this.lastSheering = lastSheering;
    }

}