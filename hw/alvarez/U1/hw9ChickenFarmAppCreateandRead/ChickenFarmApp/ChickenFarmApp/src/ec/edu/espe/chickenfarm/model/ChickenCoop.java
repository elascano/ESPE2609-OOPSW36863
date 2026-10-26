package ec.edu.espe.chickenfarm.model;

import java.util.Date;

/**
 *
 * @author Juan Alvarez, MosQ, @ESPE
 */
public class ChickenCoop {

    private int chickenCoopId;
    private Chicken chickens[] = new Chicken[10];
    private int currentIndex;

    public void add(Chicken chicken) {
        for (int i = 0; i < chickens.length; i++) {
            if (chickens[i] == null) {
                chickens[i] = chicken;
                break;
            }
        }
    }

    public void remove(int chickenId) {
        for (int i = 0; i < chickens.length; i++) {
            if (chickens[i] != null && chickens[i].getId() == chickenId) {
                chickens[i] = null;
                break;
            }
        }
    }

    public Chicken next() {
        Chicken nextChicken = null;
        if (currentIndex < chickens.length) {
            nextChicken = chickens[currentIndex];
            currentIndex++;
        }
        return nextChicken;
    }

    public void resetIteration() {
        currentIndex = 0;
    }

    /**
     * @return the chickenCoopId
     */
    public int getChickenCoopId() {
        return chickenCoopId;
    }

    public ChickenCoop(int chickenCoopId, Chicken[] chickens) {
        this.chickenCoopId = chickenCoopId;
        this.chickens = chickens;
    }

    /**
     * @param chickenCoopId the chickenCoopId to set
     */
    public void setChickenCoopId(int chickenCoopId) {
        this.chickenCoopId = chickenCoopId;
    }

    /**
     * @return the chickens
     */
    public Chicken[] getChickens() {
        return chickens;
    }

    /**
     * @param chickens the chickens to set
     */
    public void setChickens(Chicken[] chickens) {
        this.chickens = chickens;
    }

    @Override
    public String toString() {
        return "ChickenCoop{" + "chickenCoopId=" + chickenCoopId + ", chickens=" + chickens + ", currentIndex=" + currentIndex + '}';
    }

}
