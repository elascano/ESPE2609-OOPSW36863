package ec.edu.espe.chickenfarm.model;

import java.util.Date;

/**
 *
 * @author Verónica Ruiz, Code Crafters, @ESPE
 */
public class ChickenCoop {
    private int chickenCoopId;
    private Chicken chickens[] = new Chicken[10];
    private int currentIndex;
    
    //we need to know the maxium. in this case is 10
    //we need to know thye index
    
    public void add(Chicken chicken){        
        if(chickens.length < 10){
            //algoritms
       
       //if we have less tha 10 chickens, we can add one more
       //else we can not add any more
        }
            
    }
    public void remove(int chicken){
        
    }
    public void resetIteration(){
    currentIndex = 0;
    }
    
    public Chicken next(){
        return new Chicken(3, "Lucy", "white", new Date(2020, 3, 3), true);
    }

    @Override
    public String toString() {
        return "ChickenCoop{" + "chickenCoopId=" + getChickenCoopId() + ", chickens=" + getChickens() + '}';
    }

    public ChickenCoop(int chickenCoopId, Chicken[] chickens) {
        this.chickenCoopId = chickenCoopId;
        this.chickens = chickens;
    }    /**


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
