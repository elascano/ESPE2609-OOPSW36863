package ec.edu.espe.chickenfarm.model;

import java.util.Arrays;

/**
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class ChickenCoop {
    private int chickenCoopId;
    private Chicken chickens[];
    private int currentIndex;

    public ChickenCoop(int chickenCoopId, Chicken[] chickens) {
        this.chickenCoopId = chickenCoopId;
        this.chickens = chickens;
        this.currentIndex = 0;
    }

    public void add(Chicken chicken) {
        if (currentIndex < chickens.length) {
            chickens[currentIndex] = chicken;
            currentIndex++;
            System.out.println("Chicken added successfully to coop " + chickenCoopId);
        } else {
            System.out.println("Can not add chicken. The coop is full");
        }
    }

    // Método remove que faltaba y que usas en el main
    public void remove(int chickenId) {
        for (int i = 0; i < chickens.length; i++) {
            if (chickens[i] != null && chickens[i].getId() == chickenId) {
                chickens[i] = null;
                System.out.println("Chicken with ID " + chickenId + " removed from coop.");
                break;
            }
        }
    }

    public void resetIteration() {
        currentIndex = 0;
    }

    public Chicken next() {
        if (currentIndex < chickens.length) {
            Chicken chicken = chickens[currentIndex];
            currentIndex++;
            return chicken;
        }
        return null;
    }

    @Override
    public String toString() {
        return "ChickenCoop{chickenCoopId=" + chickenCoopId + ", chickens=" + Arrays.toString(chickens) + "}";
    }

    public int getChickenCoopId() {
        return chickenCoopId;
    }

    public void setChickenCoopId(int chickenCoopId) {
        this.chickenCoopId = chickenCoopId;
    }

    public Chicken[] getChickens() {
        return chickens;
    }

    public void setChickens(Chicken[] chickens) {
        this.chickens = chickens;
    }
}