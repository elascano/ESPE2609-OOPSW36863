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
    
    //algoritms
       //if we have less tha 10 chickens, we can add one more
       //else we can not add any more
    
    public void add(Chicken chicken){        
        for (int i = 0; i < chickens.length; i++){
            if (chickens[i] == null){
                chickens[i] = chicken;
                System.out.println("Chicken --> " + chickens[i] + "added sucessfully");
                return;
            }
        }
        System.out.println("The coop is full, the chicken can not be added.");    
    }
    public void remove(int chickenId){
        
        for (int i = 0; i < chickens.length; i++) {
            if (chickens[i] == null) {
                continue; 
            }
            if (chickens[i].getId() == chickenId) {
                chickens[i] = null; 
                System.out.println("Chicken with ID " + chickenId + " has been removed.");
                return;
            }
        }
        System.out.println("Chicken with ID " + chickenId + " not found.");
    }
    public void resetIteration(){
    currentIndex = 0;
    }
    
    public Chicken next(){
        while (currentIndex < chickens.length) {
            Chicken chicken = chickens[currentIndex];
            currentIndex++;
            if (chicken != null) {
                return chicken;
            }
        }
        return null;
    }
     

    @Override
    public String toString() {
        String localChickens;
        localChickens = "";
        for(Chicken chicken: chickens){
            localChickens += chicken;
            localChickens += "\n\t";
        }
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
