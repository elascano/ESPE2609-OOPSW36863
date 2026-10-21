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
    private int size;
    
    public boolean add(Chicken chicken){
        if (size == chickens.length) {
            return false;
        }
        chickens[size++] = chicken;
        return true;
    }
    public boolean remove(int chickenId){
        for (int i = 0; i < size; i++){
            if (chickens[i].getChickenId() == chickenId){
                for (int j=1; j< size - 1; j++){
                    chickens[j] = chickens[j +1];
                }
                chickens[--size] = null;
                return true;
            }
        }
        return false;
    }
    public void resetIteration(){
        currentIndex = 0;
    }
    
    public boolean hasNext(){
        return currentIndex < size;
    }
    
    public Chicken next(){
        if (!hasNext()){
            return null;
        }
        return chickens[currentIndex++];
    }
    
    public ChickenCoop(int chickenCoopId, Chicken[] chickens) {
        this.chickenCoopId = chickenCoopId;
        this.chickens = chickens;
        this.size=0;
        for (Chicken checker : chickens) {
            if (checker != null) size++;
        }
    }

    @Override
    public String toString() {
        return "ChickenCoop{" + "chickenCoopId=" + chickenCoopId + ", chickens=" + Arrays.toString(chickens) + ", currentIndex=" + currentIndex + ", size=" + size + '}';
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
