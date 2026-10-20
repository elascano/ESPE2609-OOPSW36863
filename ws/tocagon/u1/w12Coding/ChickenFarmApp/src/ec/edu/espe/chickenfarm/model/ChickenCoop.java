package ec.edu.espe.chickenfarm.model;

import java.util.Date;

/**
 *
 * @author Nohemi Tocagon, Uni Helper, @ESPE
 */
public class ChickenCoop {
    private int chickenCoopId;
    private Chicken chickens[]= new Chicken[10];
    private int currentIndex;
    //we need to knoe the maxium, in this case is 10
    //we need to know the index
    //

    public void add(Chicken chicken){
        //algorithm
         // if we have a less than 10 chicknes, we cn add one more else we cant add anymore
        }
    
    public void remove(int chickenId){
        
    }
    public void resetIteration(){
        currentIndex =0;
        
    }
    public Chicken next(){
        return new Chicken(3, "Lucy", "white", new Date(2020,3,3), true);
    }
    
    @Override
    public String toString() {
        return "ChickenCoop{" + "chickenCoopId=" + chickenCoopId + ", chikens=" + chickens + '}';
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
        return chickens;
    }

    /**
     * @param chikens the chikens to set
     */
    public void setChikens(Chicken[] chikens) {
        this.chickens = chikens;
    }
    
    
}
