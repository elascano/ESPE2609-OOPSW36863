
package ec.edu.espe.chickenfarm.model;

import java.util.Date;

/**
 *
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class ChickenCoop {
    private int chickenCoopId;
    private Chicken chikens[] = new Chicken[10];
    private int currentIndex;
    
    //we need to know the maximum in this case is 10
    //we need to know the index
    //En la primera agregar chickens, remover chickens por Id, 
    
    public void add(Chicken chicken){
        
        //if we have less then 10 chickens, we can add one more
        //else we can not add any more
        
    
    }
    
    public remove (int chickendId){
        currentIndex = 0;
    }
    
    public void resetIteration(){
    
    }
    
    public Chicken next(){
    
        return new Chicken(3, "Lucy", "white", new Date(2020, 3,3), true);
    }
    
    public ChickenCoop(int chickenCoopId, Chicken[] chikens) {
        this.chickenCoopId = chickenCoopId;
        this.chikens = chikens;
    }

    @Override
    public String toString() {
        return "ChickenCoop{" + "chickenCoopId=" + chickenCoopId + ", chikens=" + chikens + '}';
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
     * @return the chikens
     */
    public Chicken[] getChikens() {
        return chikens;
    }

    /**
     * @param chikens the chikens to set
     */
    public void setChikens(Chicken[] chikens) {
        this.chikens = chikens;
    }
    
}
