
package ec.edu.espe.chickenfarm.model;

import java.util.Date;

/**
 *
 * @author Julian Olalla, 64 wizards, @ESPE
 */
public class ChickenFarmer {
  int chickenFarmerId;
  String name;
  ChickenCoop coops[];

    @Override
    public String toString() {
        
        String localCoops;
        localCoops= "";
      for (ChickenCoop coop : coops) {
          localCoops += coop;
          localCoops += "\n";
      }
        return "ChickenFarmer{" + "chickenFarmerId=" + chickenFarmerId + ", name=" + name + ", coops=" + localCoops + '}';
    }
    
    public ChickenFarmer() {
        chickenFarmerId = 1;
        name = "";
        coops = new ChickenCoop[2];
        Chicken chickens[];
        chickens = new Chicken[2];
        chickens[0]= new Chicken(0, "Pepita", "black", new Date(), true);
        chickens[1]= new Chicken(0, "marujita", "black", new Date(), true);
        
        coops[0]= new ChickenCoop(0, chickens);
        coops[1]= new ChickenCoop(1, chickens);
              
    }
}
