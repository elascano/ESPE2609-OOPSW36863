
package ec.edu.espe.chickenfarmapp.model;

import java.util.Arrays;

/**
 *
 * @author Anthony Arevalo, MosQ, @ESPE
 */
public class ChickenCoop {
    private int chickenCoopId;
    private Chicken chickens[]= new Chicken[10];
     private int currentIndex;
    
    public ChickenCoop(int chickenCoopId) {
        this.chickenCoopId = chickenCoopId;
        this.currentIndex = 0;
    }

    public void add(Chicken chicken) {
          if (chicken == null) {
        throw new IllegalArgumentException("Chicken cannot be null.");
    }

    for (Chicken currentChicken : chickens) {
        if (currentChicken != null
                && currentChicken.getId() == chicken.getId()) {
            throw new IllegalArgumentException(
                "A chicken with that ID already exists."
            );
        }
    }

    for (int i = 0; i < chickens.length; i++) {
        if (chickens[i] == null) {
            chickens[i] = chicken;
            return;
        }
    }

    throw new IllegalStateException("The coop is full.");   
    }

    public void remove(int chickenId) {
        if (chickenId <= 0) {
        throw new IllegalArgumentException(
            "Chicken ID must be greater than zero."
        );
    }

    for (int i = 0; i < chickens.length; i++) {
        if (chickens[i] != null
                && chickens[i].getId() == chickenId) {
            for (int j = i; j < chickens.length - 1; j++) {
                chickens[j] = chickens[j + 1];
            }

            chickens[chickens.length - 1] = null;
            resetIteration();
            return;
        }  
    }    
    throw new IllegalArgumentException(
        "No chicken found with that ID."
    );
    }

    public void resetIteration() {
         currentIndex = 0;
      
    }

   public void next() {
    while (currentIndex < chickens.length
            && chickens[currentIndex] == null) {
        currentIndex++;
    }

    if (currentIndex >= chickens.length) {
        System.out.println("No more chickens.");
        return;
    }

    System.out.println(chickens[currentIndex]);
    currentIndex++;
    }
    
    
    public ChickenCoop(int chickenCoopId, Chicken[] chickens) {
        this.chickenCoopId = chickenCoopId;
        this.chickens = chickens;
    }

    @Override
    public String toString() {
      
        return "ChickenCoop{" + "chickenCoopId=" + getChickenCoopId() + ", chickens=" + Arrays.toString(getChickens()) + '}';
    }

    /**
     * @return the chickenCoopId
     */
    public int getChickenCoopId() {
        return chickenCoopId;
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

    
    
}
