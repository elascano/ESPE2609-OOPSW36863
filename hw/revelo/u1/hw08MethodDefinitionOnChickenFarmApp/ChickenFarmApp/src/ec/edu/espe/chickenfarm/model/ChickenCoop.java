package ec.edu.espe.chickenfarm.model;

import java.util.Date;

/**
 *
 * @author Erick Revelo, Code Crafters, @ESPE
 */
public class ChickenCoop {
    private int chickenCoopId;
    private Chicken chickens[]=new Chicken[10];
    private int currentIndex = 0;
    

    public void add(Chicken chicken) {
        for (int i = 0; i < chickens.length; i++) {
            if (chickens[i] == null) {
                chickens[i] = chicken;
            return;
            }
        }
    }

    public void remove(int chickenId) {
        for (int i = 0; i < chickens.length; i++) {
            if (chickens[i] != null && chickens[i].getId() == chickenId) {
                chickens[i] = null;
            return;
            }
        }
    }

    public Chicken next() {
        if (currentIndex < chickens.length) {
            return chickens[currentIndex++];
        }
        return null;
    }
    
    
    public void resetIteration(){
        currentIndex=0;
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
        return "ChickenCoop{" + "chickenCoopId=" + chickenCoopId + ", chickens=" + chickens + '}';
    }
    
    
    
    
}
