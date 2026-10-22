
package ec.edu.espe.chickenfarm.model;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Nestor Olivo, Found ERROR 404, @ESPE
 */
public final class Chicken {
    private static int nextId = 1;
    private int idChicken;
    private String name;
    private String color;
    private LocalDate bornOnDate;
    private int ageInYears;
    private boolean molting;
    public void doSftuff(){
        
    }
    private void cluck(){
        System.out.println("The chicken "+this.name+" is clucking...");
    }
    private void eat(){
        System.out.println("The chicken "+this.name+" is eating...");
    }
    private void drink(float amountOfWater){
        System.out.println("The chicken "+this.name+" is drinking--->"+ amountOfWater +"nl of water");
    }
    private Poop poop(){
        Poop poop = new Poop('L', "green");
        return poop;
    }
    private Egg layAnEgg(){
        Egg egg = new Egg('s');
        return egg;
    }
    public int computeAgeYear(){
        LocalDate today = LocalDate.now();
        Period period = Period.between(this.bornOnDate, today);
        return period.getYears();
    }
    
    public Chicken(String name, String color, LocalDate bornOnDate, boolean molting) {
        this.name = name;
        this.color = color;
        this.bornOnDate = bornOnDate;
        this.ageInYears = computeAgeYear();
        this.molting = molting;
        this.idChicken = nextId++;
    }

    public int getIdChicken() {
        return idChicken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public LocalDate getBornOnDate() {
        return bornOnDate;
    }

    public void setBornOnDate(LocalDate bornOnDate) {
        this.bornOnDate = bornOnDate;
    }

    public int getAgeInYears() {
        return ageInYears;
    }

    public void setAgeInYears(int ageInYears) {
        this.ageInYears = ageInYears;
    }

    public boolean isMolting() {
        return molting;
    }

    public void setMolting(boolean molting) {
        this.molting = molting;
    }

    @Override
    public String toString() {
        return "Chicken{" + "idChicken=" + idChicken + ", name=" + name + ", color=" + color + ", bornOnDate=" + bornOnDate + ", ageInYears=" + ageInYears + ", molting=" + molting + '}';
    }
    
}
