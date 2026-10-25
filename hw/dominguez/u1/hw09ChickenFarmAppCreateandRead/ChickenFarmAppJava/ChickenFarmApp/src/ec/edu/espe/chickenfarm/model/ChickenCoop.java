package ec.edu.espe.chickenfarm.model;

import java.util.Arrays;

/**
 *
 * @author Mateo Dominguez, Brain Training, @ESPE
 */
public class ChickenCoop {
    private int chickenCoopId;
    private Chicken chickens[]=new Chicken[10];
    private int currentIndex;
    
    public void add(Chicken chicken){
        if (currentIndex < chickens.length) {
            chickens[currentIndex] = chicken;
            currentIndex++;
            System.out.println(chickens[currentIndex-1] + " Added correctly");
        } else {
            System.out.println("Dont have more space");
        }
    }
    
    public void remove(int chickenId){
        for (int i = 0; i < chickens.length; i++){
            if (chickens[i] != null && chickens[i].getChickenId() == chickenId){
                for (int j = i; j < chickens.length - 1; j++){
                    chickens[j] = chickens[j + 1];
                }
                chickens[chickens.length - 1] = null;
                currentIndex--;
                return;
            }
        }
    }
    
    public void resetIteration(){
        currentIndex = 0;
    }
    
    public Chicken next(){
        if (currentIndex < chickens.length && chickens[currentIndex] != null){
            return chickens[currentIndex++];
        }
        return null;
    }
    
    public ChickenCoop(int chickenCoopId, Chicken[] chickens) {
        this.chickenCoopId = chickenCoopId;
        this.chickens = chickens;
        
    }

    @Override
    public String toString() {
        return "ChickenCoop{" + "chickenCoopId=" + chickenCoopId + ", chickens=" + Arrays.toString(chickens) + ", currentIndex=" + currentIndex + '}';
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
