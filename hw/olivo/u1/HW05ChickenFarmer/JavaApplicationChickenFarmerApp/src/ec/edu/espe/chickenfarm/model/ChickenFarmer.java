
package ec.edu.espe.chickenfarm.model;

/**
 *
 * @author Nestor Olivo, Found ERROR 404, @ESPE
 */
public class ChickenFarmer {
    private static int idCounter = 1;
    private int idChickenFarmer;
    private String name;
    private ChickenCoop coops[];

    public ChickenFarmer(String name, ChickenCoop[] coops) {
        this.name = name;
        this.coops = coops;
        this.idChickenFarmer = idCounter++;
    }

    @Override
    public String toString() {
        return "ChickenFarmer{" + "idChickenFarmer=" + idChickenFarmer + ", name=" + name + ", coops=" + coops + '}';
    }
    
    
    
}
