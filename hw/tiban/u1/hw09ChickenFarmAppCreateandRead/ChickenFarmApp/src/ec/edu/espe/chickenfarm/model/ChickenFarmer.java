package ec.edu.espe.chickenfarm.model;

import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author Andy Tiban, IV Studio, @ESPE
 */
public class ChickenFarmer {
    int chickenFarmerId;
    String name;
    ChickenCoop coops[];

    @Override
    public String toString() {
        return "ChickenFarmer{" + "chickenFarmerId=" + chickenFarmerId + ", name=" + name + ", coops=" + Arrays.toString(coops) + '}';
    }

    
    
    
    
    public ChickenFarmer(){
        chickenFarmerId = 1;
        name ="Andy";
        coops = new ChickenCoop[2];
        Chicken chickens[];
        chickens = new Chicken[2];
        chickens[0]= new Chicken(0, "pepita", "black", new Date(2020,10,21), true);

}
    
    
    
}


