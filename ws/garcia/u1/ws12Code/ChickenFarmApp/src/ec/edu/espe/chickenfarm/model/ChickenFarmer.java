package ec.edu.espe.chickenfarm.model;

/**
 *
 * @author Jesus Garcia, @ESPE
 */
public class ChickenFarmer {
    private int chickenFarmerId;
    private String name;
    private ChickenCoop[] coops;

    public ChickenFarmer(int chickenFarmerId, String name) {
        this.chickenFarmerId = chickenFarmerId;
        this.name = name;
        this.coops = new ChickenCoop[5];
    }

    public void addCoop(ChickenCoop coop, int index) {
        if (index >= 0 && index < coops.length) {
            this.coops[index] = coop;
        }
    }

    @Override
    public String toString() {
        return "ChickenFarmer{" + "chickenFarmerId=" + chickenFarmerId + ", name=" + name + '}';
    }
}

