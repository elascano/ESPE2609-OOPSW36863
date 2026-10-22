package ec.edu.espe.chickenfarm.model;

import java.util.NoSuchElementException;

/**
 *
 * @author Nestor Olivo, Found ERROR 404, @ESPE
 */
public class ChickenCoop {

    private final int MAX_CHICKEN = 10;
    private int idChickenCoop = 0;
    private int currentId = 0;
    private int counter = 0;
    private Chicken chickens[] = new Chicken[MAX_CHICKEN];

    public ChickenCoop() {
        this.idChickenCoop++;
    }

    public void add(Chicken chicken) {
        if (this.currentId < this.chickens.length) {
            this.chickens[this.currentId] = chicken;
            this.currentId++;
        } else {
            System.out.println("The Chicken Coop is full");
        }
    }

    public void remove(int chickenId) {
        for (int i = 0; i < this.currentId; i++) {
            if (this.chickens[i].getIdChicken() == chickenId) {

                for (int j = i; j < this.currentId - 1; j++) {
                    this.chickens[j] = this.chickens[j + 1];
                }

                this.chickens[this.currentId - 1] = null;
                this.currentId--;

                if (this.counter > this.currentId) {
                    this.counter = this.currentId;
                }

                return;
            }
        }

        System.out.println("Chicken not found");
    }

    public void resetIteration() {
        this.counter = 0;
    }

    public Chicken next() {
        if (this.counter < this.currentId) {
            Chicken chicken = this.chickens[this.counter];
            this.counter++;
            return chicken;
        }

        throw new NoSuchElementException("No more chickens");
    }

    public int getCount() {
        return this.currentId;
    }
}