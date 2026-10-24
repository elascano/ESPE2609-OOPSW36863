package ec.edu.espe.chickenfarm.model;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class Chicken {
    
    private int id;
    private String name;
    private String color;
    private LocalDate bornOnDate;
    private int age;
    private boolean molting;

    public Chicken(int id, String name, String color, LocalDate bornOnDate, int age, boolean molting) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.bornOnDate = bornOnDate;
        this.age = age;
        this.molting = molting;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        this.age = computeAge();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isMolting() {
        return molting;
    }

    public void setMolting(boolean molting) {
        this.molting = molting;
    }
    
    public void doStuff(){
        cluck();
        wander();
        eat();
        drink(13.0F);
        poop();
        layAnEgg();
        computeAge();
    }
    
    private void cluck(){
        System.out.println("The chicken "+name+" is clucking...");
    }
    
    private void wander(){
        System.out.println("The chicken "+name+" is wandering...");
    }
    
    private void eat(){
        System.out.println("The chicken "+name+" is eating...");
    }
    
    private void drink(float amountOfWater){
        System.out.println("The chicken "+name+" is dinking "+amountOfWater+" ml of water");
    }
    
    private Poop poop(){
        Poop poop;
        poop = new Poop(1, "Brown", 'S');
        return poop;
    }
    
    private Egg layAnEgg(){
        Egg egg;
        egg = new Egg(1, 'M');
        return egg;
    }
    
    public int computeAge(){
        if(this.bornOnDate == null){
            return 0;
        }
        
        LocalDate today = LocalDate.now();
        
        this.age = Period.between(this.bornOnDate, today).getYears();
        
        return this.age;
    }

    @Override
    public String toString() {
        return "Chicken{" + "id=" + id + ", name=" + name + ", color=" + color + ", bornOnDate=" + bornOnDate + ", age=" + age + ", molting=" + molting + '}';
    }
}
