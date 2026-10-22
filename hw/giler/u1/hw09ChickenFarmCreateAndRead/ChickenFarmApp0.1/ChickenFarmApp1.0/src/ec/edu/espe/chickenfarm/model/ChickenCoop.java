package ec.edu.espe.chickenfarm.model;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class ChickenCoop {
    
    private int id;
    private Chicken[] chickens;
    private int count;
    private int currentIndex;

    public ChickenCoop(int id) {
        this.id = id;
        this.chickens = new Chicken[10];
        this.count = 0;
        this.currentIndex = 0;
    }

    public int getId() {
        return id;
    }

    public Chicken[] getChickens() {
        return chickens;
    }
    
    public int getCount(){
        return count;
    }
    
    public void add(Chicken chicken){
        if (chicken != null && count < chickens.length) {
            this.chickens[count] = chicken;
            this.count++;
        }
    }
    
    public void remove(int chicken){
        for (int i = 0; i < count; i++) {
            if (this.chickens[i].getId() == chicken) {
                for (int j = i; j < count - 1; j++) {
                    this.chickens[j] = this.chickens[j + 1];
                }
                this.chickens[count - 1] = null;
                this.count--;
                break;
            }
        }
    }
    
    public void resetOperation(){
        this.currentIndex = 0;
    }
    
    public Chicken next(){
        if (currentIndex < count) {
            Chicken nextChicken = chickens[currentIndex];
            currentIndex++;
            return nextChicken;
        }
        return null;
    }

    @Override
    public String toString() {
        return "ChickenCoop{" + "id=" + id + ", chickens=" + chickens + ", count=" + count + ", currentIndex=" + currentIndex + '}';
    }
}
