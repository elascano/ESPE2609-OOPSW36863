
package ec.edu.espe.chickenfarm.model;

/**
 *
 * @author Julian Olalla, 64 wizards, @ESPE
 */
public class ChickenCoop {
    private int chickenCoopId;
    private Chicken chickens[]= new Chicken[10];
    private int curentIndex;
    
    // we need to know the maximum . in this case 15 10
    // we need to know the index
    
    //Primer funncion añadir chickens a los arreglos
    //Preguntar al usario que datos quiere borrar
    //Corre al index regresa al 0
    //Next toma al pollo siguiente de la lista, si esta en la posicion 0 se va al 1
    
    public void add(Chicken chicken) {
       //algoritmo
       
       //if we hace less tan 10 chickens, we can add more
       //else we cant add any more
        if(chickens.length < 10) {
            
        }
    }
    
    public void remove(int chickenId) {
        
    }
    
    public void resetIteration(){
        
    }
    
    public Chicken next(){
        return new Chicken(3, "Lucy", "White", new Date(2020,3,3), true);
    }

    @Override
    public String toString() {
        return "ChickenCoop{" + "chickenCoopId=" + chickenCoopId + ", chickens=" + chickens + '}';
    }

    public ChickenCoop(int chickenCoopId, Chicken chickens) {
        this.chickenCoopId = chickenCoopId;
        this.chickens = chickens;
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
    public Chicken getChickens() {
        return chickens;
    }

    /**
     * @param chickens the chickens to set
     */
    public void setChickens(Chicken chickens) {
        this.chickens = chickens;
    }
    
    
}
    