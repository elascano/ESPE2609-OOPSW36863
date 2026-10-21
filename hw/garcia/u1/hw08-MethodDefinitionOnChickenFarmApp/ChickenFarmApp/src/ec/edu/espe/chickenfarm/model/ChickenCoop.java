package ec.edu.espe.chickenfarm.model;

/**
 *
 * @author Jesus Garcia, @ESPE
 */
public class ChickenCoop {
    
    private int chickenCoopId;
    private Chicken[] chickens = new Chicken[10];
    private int currentIndex = 0;
    private int chickenCount = 0;

    public ChickenCoop(int chickenCoopId) {
        this.chickenCoopId = chickenCoopId;
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
                
                if (currentIndex > i) {
                    currentIndex--;
                }
                
                System.out.println("Chicken with ID " + chickenId + " has been removed.");
                return;
            }
        }
        System.out.println("Chicken ID not found in the coop.");
    }

    public void resetIteration() {
        currentIndex = 0;
    }

    public Chicken next() {
        if (currentIndex < chickenCount) {
            Chicken current = chickens[currentIndex];
            currentIndex++;
            return current;
        }
        return null;
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

    /**
     * @return the currentIndex
     */
    public int getCurrentIndex() {
        return currentIndex;
    }

    /**
     * @param currentIndex the currentIndex to set
     */
    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }

    /**
     * @return the chickenCount
     */
    public int getChickenCount() {
        return chickenCount;
    }

    /**
     * @param chickenCount the chickenCount to set
     */
    public void setChickenCount(int chickenCount) {
        this.chickenCount = chickenCount;
    }
}