package ec.edu.espe.chickenfarm.model;

import java.util.Arrays;

/**
 *
 * @author Mateo Dominguez, Brain Training, @ESPE
 */
public class ChickenFarmer {
    private int chickenFarmerId;
    private String name;
    private ChickenCoop coops[] = new ChickenCoop[10];
    private int currentIndex;

    public ChickenFarmer(int chickenFarmerId, String name, ChickenCoop[] coops) {
        this.chickenFarmerId = chickenFarmerId;
        this.name = name;
        this.coops = coops;
    }

    public void add(ChickenCoop coop){
        if (currentIndex < coops.length) {
            coops[currentIndex] = coop;
            currentIndex++;
            System.out.println(coops[currentIndex - 1] + " Added correctly");
        } else {
            System.out.println("Dont have more space");
        }
    }

    public void remove(int chickenCoopId){
        for (int i = 0; i < coops.length; i++){
            if (coops[i] != null && coops[i].getChickenCoopId() == chickenCoopId){
                for (int j = i; j < coops.length - 1; j++){
                    coops[j] = coops[j + 1];
                }
                coops[coops.length - 1] = null;
                currentIndex--;
                return;
            }
        }
    }

    public void resetIteration(){
        currentIndex = 0;
    }

    public ChickenCoop next(){
        if (currentIndex < coops.length && coops[currentIndex] != null){
            return coops[currentIndex++];
        }
        return null;
    }

    @Override
    public String toString() {
        return "ChickenFarmer{" + "chickenFarmerId=" + chickenFarmerId + ", name=" + name + ", coops=" + Arrays.toString(coops) + ", currentIndex=" + currentIndex + '}';
    }

    /**
     * @return the chickenFarmerId
     */
    public int getChickenFarmerId() {
        return chickenFarmerId;
    }

    /**
     * @param chickenFarmerId the chickenFarmerId to set
     */
    public void setChickenFarmerId(int chickenFarmerId) {
        this.chickenFarmerId = chickenFarmerId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the coops
     */
    public ChickenCoop[] getCoops() {
        return coops;
    }

    /**
     * @param coops the coops to set
     */
    public void setCoops(ChickenCoop[] coops) {
        this.coops = coops;
    }
}
