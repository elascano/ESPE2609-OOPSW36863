package ec.edu.espe.chickenfarm.model;

import java.util.Arrays;
import java.util.Date;

public class ChickenCoop {

    private Chicken[] chickens;
    private int chickenCoopId;
    private int currentIndex;

    public ChickenCoop(Chicken[] chickens, int chickenCoopId) {
        this.chickens = chickens;
        this.chickenCoopId = chickenCoopId;
        currentIndex = 0;
    }

    public void add(String name,
                    String color,
                    Date bornOnDate,
                    boolean molting) {

        for (int i = 0; i < chickens.length; i++) {

            if (chickens[i] == null) {

                int id = i + 1;

                chickens[i] = new Chicken(
                        id,
                        name,
                        color,
                        bornOnDate,
                        molting);

                System.out.println(
                        "Chicken added --> "
                                + name
                                + ", ID --> "
                                + id);

                ChickenFileManager.saveAsCSV(chickens);
                ChickenFileManager.saveAsJSON(chickens);

                return;
            }
        }

        System.out.println("The chicken coop is full");
    }

    public void remove(int chickenId) {

        for (int i = 0; i < chickens.length; i++) {

            if (chickens[i] != null &&
                    chickens[i].getId() == chickenId) {

                for (int j = i; j < chickens.length - 1; j++) {
                    chickens[j] = chickens[j + 1];
                }

                chickens[chickens.length - 1] = null;

                reassignIds();

                ChickenFileManager.saveAsCSV(chickens);
                ChickenFileManager.saveAsJSON(chickens);

                System.out.println(
                        "Chicken removed --> "
                                + chickenId);

                return;
            }
        }

        System.out.println("Chicken not found");
    }

    private void reassignIds() {

        for (int i = 0; i < chickens.length; i++) {

            if (chickens[i] != null) {
                chickens[i].setId(i + 1);
            }
        }
    }

    public void resetIteration() {
        currentIndex = 0;
    }

    public Chicken next() {

        while (currentIndex < chickens.length) {

            Chicken chicken = chickens[currentIndex];
            currentIndex++;

            if (chicken != null) {
                return chicken;
            }
        }

        return null;
    }

    public Chicken[] getChickens() {
        return chickens;
    }

    public void setChickens(Chicken[] chickens) {
        this.chickens = chickens;
    }

    public int getChickenCoopId() {
        return chickenCoopId;
    }

    public void setChickenCoopId(int chickenCoopId) {
        this.chickenCoopId = chickenCoopId;
    }

    @Override
    public String toString() {
        return "ChickenCoop{" +
                "chickens=" + Arrays.toString(chickens) +
                ", chickenCoopId=" + chickenCoopId +
                '}';
    }
}