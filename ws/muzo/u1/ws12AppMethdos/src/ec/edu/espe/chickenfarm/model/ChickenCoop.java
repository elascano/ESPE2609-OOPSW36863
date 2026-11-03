package ec.edu.espe.chickenfarm.model;

/**
 *
 * @author Lesly Muzo, @ESPE
 */
public class ChickenCoop {
    private int chickenCoopId;
    private Chicken chickens[]= new Chicken[10];
    private int currentIndex;

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
        for(int i=0; i< chickens.length;i++){
            if(chickens[i] != null){
                return chickens[i];
            }
        }
        return null;
    }
    
    public void resetIteration(){
        int iterationIndex = 0;
    }
    
    @Override
    public String toString() {
        return "ChickenCoop{" + "chickenCoopId=" + chickenCoopId + ", chickens=" + chickens + '}';
    }

    public int getChickenCoopId() {
        return chickenCoopId;
    }

    public void setChickenCoopId(int chickenCoopId) {
        this.chickenCoopId = chickenCoopId;
    }

    public Chicken[] getChikens() {
        return chickens;
    }

    public void setChikens(Chicken[] chickens) {
        this.chickens = chickens;
    }
}