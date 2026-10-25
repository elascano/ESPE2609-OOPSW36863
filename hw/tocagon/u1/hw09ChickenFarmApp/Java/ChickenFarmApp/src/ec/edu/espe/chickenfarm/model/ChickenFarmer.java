package ec.edu.espe.chickenfarm.model;

import java.util.Date;

/**
 *
 * @author Nohemi Tocagon, Uni Helper, @ESPE
 */
public class ChickenFarmer {
    int chickenFarmerId;
    String name;
    ChickenCoop coops[];

    @Override
    public String toString() {
        
        String localCoops;
        localCoops="";
        for(int i=0; i< coops.length; i++){
            localCoops += coops[i];
            localCoops += "\n";
        }
        return "ChikenFarmer{" + "chickenFarmerId=" + chickenFarmerId + ", name=" + name + ", coops=" + coops + '}';
    }

    public ChickenFarmer(int chickenFarmerId, String name, ChickenCoop[] coops) {
        this.chickenFarmerId = chickenFarmerId;
        this.name = name;
        this.coops = coops;
    }
    
    
    public ChickenFarmer(){
        chickenFarmerId = 1;
        name ="";
        coops = new ChickenCoop[2];
        Chicken chickens[];
        chickens= new Chicken[2];
        chickens[0] = new Chicken(0, "Pepita", "black", new Date(), true);
        chickens[0] = new Chicken(0, "Marujita", "black", new Date(), true);
        
        coops[0]=new ChickenCoop(0, chickens);
        coops[1]=new ChickenCoop(1, chickens);
    }
    
    
}
