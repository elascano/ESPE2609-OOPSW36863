package ec.edu.espe.chickenfarm.model;

/**
 *
 * @author Erick Revelo, Code Crafters, @ESPE
 */
public class ChickenCoop {
    private int chickenCoopid;
    private Chicken chickens[] = new Chicken[10];
    
    public void add(Chicken chicken){
        
    }
    public ChickenCoop(int chickenCoopid, Chicken[] chickens) {
        this.chickenCoopid = chickenCoopid;
        this.chickens = chickens;
    }

    public int getChickenCoopid() {
        return chickenCoopid;
    }

    public void setChickenCoopid(int chickenCoopid) {
        this.chickenCoopid = chickenCoopid;
    }

    public Chicken[] getChickens() {
        return chickens;
    }

    public void setChickens(Chicken[] chickens) {
        this.chickens = chickens;
    }

    @Override
    public String toString() {
        return "ChickenCoop{" + "chickenCoopid=" + chickenCoopid + ", chickens=" + chickens + '}';
    }
   
}
