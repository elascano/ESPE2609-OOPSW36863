package ec.edu.espe.chickenfarm.model;

import java.util.Arrays;

/**
 *
 * @author Alejandro Fuel
 */
public class ChickenCoop {

    private int id;
    private Chicken[] chickens;
    private int currentChickenIndex;
    private int chickenCount;

    public ChickenCoop(int id, Chicken[] chickens) {
        this.id = id;
        this.chickens = chickens;
        this.chickenCount = chickens.length;
        this.currentChickenIndex = 0;
    }

    public ChickenCoop(int id) {
        this.id = id;
        this.chickens = new Chicken[10];
        this.chickenCount = 0;
        this.currentChickenIndex = 0;
    }

    public void add(Chicken chicken) {
        if (chickenCount < chickens.length) {
            chickens[chickenCount] = chicken;
            chickenCount++;
            System.out.println("Successfully added chicken: " + chicken.getName());
        } else {
            System.out.println("Error: The chicken coop is completely full!");
        }
    }

    public void remove(int chickenId) {
        for (int i = 0; i < chickenCount; i++) {
            if (chickens[i].getId() == chickenId) {
                for (int j = i; j < chickenCount - 1; j++) {
                    chickens[j] = chickens[j + 1];
                }
                chickens[chickenCount - 1] = null;
                chickenCount--;

                if (currentChickenIndex > 1) {
                    currentChickenIndex--;
                }

                System.out.println("Chicken with ID " + chickenId + " has been removed.");
                return;
            }
        }
        System.out.println("Chicken ID not found in the coop.");
    }

    public void resetIteration() {
        currentChickenIndex = 0;
    }

    public Chicken next() {
        if (currentChickenIndex < chickenCount) {
            Chicken current = chickens[currentChickenIndex];
            currentChickenIndex++;
            return current;
        }
        return null;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Chicken[] getChickens() {
        return chickens;
    }

    public void setChickens(Chicken[] chickens) {
        this.chickens = chickens;
        this.chickenCount = chickens.length;
        this.currentChickenIndex = 0;
    }

    @Override
    public String toString() {
        return "ChickenCoop{" + "id=" + id + ", chickens=" + Arrays.toString(chickens) + '}';
    }
}