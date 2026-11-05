package ec.edu.espe.chickenfarm.model;

import java.util.Date;

/**
 *
 * @author Alejandro Fuel
 */
public class Chicken {
    private int id;
    private String name;
    private String color;
    private Date bornOnDate;
    private int ageInYears;
    private boolean molting;

    // Constructor de 5 parámetros corregido
    public Chicken(int id, String name, String color, Date date, boolean molting) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.bornOnDate = date;
        this.molting = molting;
        this.ageInYears = computeAgeInYears();
    }
    
    public void doStuff(){
        cluck();
        wander();
        drink(1.3F);
        System.out.println("poop --> " + poop());
        System.out.println("egg --> " + layAnEgg()); 
    }
    
    private void cluck(){
        System.out.println("The chicken " + name + " is clucking..." );
    }
    
    private void wander(){
        System.out.println("The chicken " + name + " is wandering..." );
    }
    
    private void eat(){
        System.out.println("The chicken " + name + " is eating..." );
    }
    
    private void drink(float amountOfWater){
        System.out.println("The chicken " + name + " is drinking --> " + amountOfWater + "ml of water" );
    }
    
    private Poop poop(){
        Poop poop = new Poop(2, "green", 'M'); 
        return poop;
    }
    
    private Egg layAnEgg(){
        Egg egg = new Egg(1, 'M'); 
        return egg;
    }
    
    public int computeAgeInYears() {
        int age = 0;
        if (bornOnDate != null) {
            long diffInMillis = new Date().getTime() - bornOnDate.getTime();
            age = (int) (diffInMillis / (1000L * 60 * 60 * 24 * 365));
        }
        this.ageInYears = age; 
        return age;
    }
     
    // Constructor de 6 parámetros
    public Chicken(int id, String name, String color, Date bornOnDate, int ageInYears, boolean molting) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.bornOnDate = bornOnDate;
        this.ageInYears = ageInYears;
        this.molting = molting;
    }

    // Getter y Setter de id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter y Setter de name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter y Setter de color
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Getter y Setter de bornOnDate
    public Date getBornOnDate() {
        return bornOnDate;
    }

    public void setBornOnDate(Date bornOnDate) {
        this.bornOnDate = bornOnDate;
    }

    // Getter y Setter de ageInYears
    public int getAgeInYears() {
        return ageInYears;
    }

    public void setAgeInYears() {
        this.ageInYears = computeAgeInYears();
    }

    // Getter genérico de edad corregido
    public int getAge() {
        return ageInYears;
    }

    // Getter y Setter de molting
    public boolean isMolting() {
        return molting;
    }

    public void setMolting(boolean molting) {
        this.molting = molting;
    }

    // Método toString
    @Override
    public String toString() {
        return "Chicken{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", bornOnDate=" + bornOnDate +
                ", age=" + ageInYears +
                ", molting=" + molting +
                '}';
    }
}