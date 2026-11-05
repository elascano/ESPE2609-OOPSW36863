package ec.edu.espe.chickenfarm.model;

/**
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class ChickenFarmer {
    private int chickenFarmerId;
    private String name;

    public ChickenFarmer(int chickenFarmerId, String name) {
        this.chickenFarmerId = chickenFarmerId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ChickenFarmer{id=" + chickenFarmerId + ", name=" + name + "}";
    }
}
