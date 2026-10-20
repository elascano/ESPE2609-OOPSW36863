package ec.edu.espe.chickenfarm.model;

import java.util.Date;

/**
 *
 * @author Andy Tiban, IV Studio, @ESPE
 */
public class ChickenCoop {
    private int chickenCoopId;
    private Chicken chickens[]=new Chicken[10];
    private int currentIndex;
    
    //we need to know the maximun. int this case is 10
    //we need to know the index
    public void add(Chicken chicken){}
    //algorithm
    
    
    public void remove(int chickenId){}//pendiente los metodos
    
    public Chicken next(){
    return new Chicken(3,"Lucy","white",new Date(2020,3,3),true);
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
