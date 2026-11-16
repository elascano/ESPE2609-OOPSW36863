package ec.edu.espe.animal.model;

import java.util.Date;

/**
 * chicken
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
public class Chicken extends FarmAnimal {

    private boolean isMolting;
    private int numberOffLatIsMonth;
    private boolean isMeat;

    public Chicken(int id, String bread, Date bornOnDate,
            boolean isMolting, int numberOffLatIsMonth,
            boolean isMeat) {

        super(id, bread, bornOnDate);
        this.isMolting = isMolting;
        this.numberOffLatIsMonth = numberOffLatIsMonth;
        this.isMeat = isMeat;
    }

   @Override
public void feed(Food food, float amountOfFood) {
    System.out.println(
            "Feeding a chicken with --> "
            + amountOfFood + " of " + food
            + " in the month"
    );
}

    @Override
    public String toString() {
        return "Chicken{" + super.toString()
                + ", isMolting=" + isMolting
                + ", numberOffLatIsMonth=" + numberOffLatIsMonth
                + ", isMeat=" + isMeat
                + '}';
    }

    public boolean isIsMolting() {
        return isMolting;
    }

    public void setIsMolting(boolean isMolting) {
        this.isMolting = isMolting;
    }

    public int getNumberOffLatIsMonth() {
        return numberOffLatIsMonth;
    }

    public void setNumberOffLatIsMonth(int numberOffLatIsMonth) {
        this.numberOffLatIsMonth = numberOffLatIsMonth;
    }

    public boolean isIsMeat() {
        return isMeat;
    }

    public void setIsMeat(boolean isMeat) {
        this.isMeat = isMeat;
    }
}