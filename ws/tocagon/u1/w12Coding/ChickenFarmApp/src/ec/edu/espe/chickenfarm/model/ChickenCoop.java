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
        if(currentIndex < chickens.length ){
            chickens[currentIndex] = chicken;
            currentIndex++;
        }else{
            System.out.println("Maxium!!");
        }
    }
    
    public void remove(int chickenId){
        int index = -1;
        for (int i=0; i< currentIndex; i++){
            if(chickens[i].getId()== chickenId) {
                index= i;
                break;
            }
        }
        if(index== -1){
            System.out.println("No chicken was found with the ID -->" + chickenId);
            return;
        }
        for (int i=index; i<currentIndex -1;i++){
            chickens[i]= chickens[i+1];
        }
        chickens[currentIndex -1] = null;
        currentIndex--;
    }
    
    public Chicken next(){
        //return new Chicken(3, "Lucy", "white", new Date(2020,3,3), true);
        for(int i=0; i< chickens.length;i++){
            if(chickens[i] != null){
                return chickens[i];
            }
        }
        return null;
    }
    
    public void resetIteration(){
        int iterationIndex =0;
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
