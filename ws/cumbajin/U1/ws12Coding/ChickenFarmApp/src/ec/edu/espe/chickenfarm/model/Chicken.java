
package ec.edu.espe.chickenfarm.model;

import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
public class Chicken {

    private int id;
    private String name;
    private String color;
    private Date bornOnDate;
    private int ageInYears;
    private boolean molting;

    public int computeAgeInYears() {
        if (bornOnDate == null) {
            throw new IllegalStateException("Birth date is required");
        }

        LocalDate birthDate = bornOnDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        LocalDate today = LocalDate.now();

        if (birthDate.isAfter(today)) {
            throw new IllegalArgumentException(
                    "Birth date cannot be in the future");
        }

        ageInYears = Period.between(birthDate, today).getYears();

        return ageInYears;
    }

    public Chicken(int id, String name, String color,
            Date bornOnDate, int ageInYears, boolean molting) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.bornOnDate = bornOnDate;
        this.ageInYears = ageInYears;
        this.molting = molting;
    }

    public Chicken() {
    }

    @Override
    public String toString() {
        return "Chicken{"
                + "id=" + id
                + ", name=" + name
                + ", color=" + color
                + ", bornOnDate=" + bornOnDate
                + ", ageInYears=" + ageInYears
                + ", molting=" + molting
                + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Date getBornOnDate() {
        return bornOnDate;
    }

    public void setBornOnDate(Date bornOnDate) {
        this.bornOnDate = bornOnDate;
    }

    public int getAgeInYears() {
        return ageInYears;
    }

    public void setAgeInYears(int ageInYears) {
        this.ageInYears = ageInYears;
    }

    public boolean isMolting() {
        return molting;
    }

    public void setMolting(boolean molting) {
        this.molting = molting;
    }
}