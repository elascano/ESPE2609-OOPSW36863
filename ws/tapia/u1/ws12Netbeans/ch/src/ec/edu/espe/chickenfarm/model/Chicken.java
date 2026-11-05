package ec.edu.espe.chickenfarm.model;

import java.util.Date;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
/*
 *@author Tomas Tapia, OOP, ESPE
 */
public class Chicken {

    private int id;
    private String name;
    private String color;
    private Date bornOnDate;
    private boolean molting;

    public Chicken(int id, String name, String color, Date bornOnDate, boolean molting) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.bornOnDate = bornOnDate;
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

    public Date getBornOnDate() {
        return bornOnDate;
    }

    public void setBornOnDate(Date bornOnDate) {
        this.bornOnDate = bornOnDate;
    }

    public boolean isMolting() {
        return molting;
    }

    public void setMolting(boolean molting) {
        this.molting = molting;
    }

    public int computeAgeInYears() {
        LocalDate bornDate = bornOnDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();

        return Period.between(bornDate, LocalDate.now()).getYears();
    }


    public void doStuff(){
        cluck();
        wander();
        drink(1.3F);
        System.out.println("poop --->" + poop());
        System.out.println(layAnEgg());
    }
    private void cluck(){
        System.out.println("The chicken " + name +" is clucking");
    }

    private void wander(){
        System.out.println("The chicken " + name +" is wondering");

    }

    private void eat(){
        System.out.println("The chicken " + name +" is eating");

    }

    private void drink(float amountOfWater){
        System.out.println("The chicken " + name +" is drinking " + amountOfWater + "ml of water");

    }
    private Poop poop(){
        Poop poop;
        poop = new Poop(2,"green", 'M');
        return  poop;
    }
    private Egg layAnEgg(){
        Egg egg;
        egg = new Egg(2,'S');
        return egg;
    }
    @Override
    public String toString() {
        return "Chicken{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", age=" + computeAgeInYears() +
                ", molting=" + molting +
                '}' +"\n";
    }

}