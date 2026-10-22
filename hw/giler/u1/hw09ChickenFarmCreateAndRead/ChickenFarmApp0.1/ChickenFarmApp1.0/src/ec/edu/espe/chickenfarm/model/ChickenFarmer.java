package ec.edu.espe.chickenfarm.model;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class ChickenFarmer {
    private int id;
    private String name;
    private ChickenCoop[] coops;
    private int count;
    private int currentIndex;

    public ChickenFarmer(int id, String name) {
        this.id = id;
        this.name = name;
        this.coops = new ChickenCoop[2];
        this.count = 0;
        this.currentIndex = 0;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ChickenCoop[] getCoops() {
        return coops;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void add(ChickenCoop coop) {
        if (coop != null && count < coops.length) {
            this.coops[count] = coop;
            this.count++;
        }
    }
    
    public void remove(int coop) {
        for (int i = 0; i < count; i++) {
            if (this.coops[i].getId() == coop) {
                for (int j = i; j < count - 1; j++) {
                    this.coops[j] = this.coops[j + 1];
                }
                this.coops[count - 1] = null; 
                this.count--;
                break;
            }
        }
    }
    
    public void resetIteration() {
        this.currentIndex = 0;
    }
    
    public ChickenCoop next() {
        if (currentIndex < count) {
            ChickenCoop nextCoop = coops[currentIndex];
            currentIndex++;
            return nextCoop;
        }
        return null;
    }

    @Override
    public String toString() {
        return "ChickenFarmer{" + "id=" + id + ", name=" + name + ", coops=" + coops + ", count=" + count + ", currentIndex=" + currentIndex + '}';
    }
}
