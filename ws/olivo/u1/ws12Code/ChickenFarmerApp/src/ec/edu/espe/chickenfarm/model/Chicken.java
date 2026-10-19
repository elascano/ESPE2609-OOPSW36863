
package ec.edu.espe.chickenfarm.model;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Nestor Olivo, Found ERROR 404, @ESPE
 */
public class Chicken {
    private int id;
    private String name;
    private String color;
    private Date bornOnDay;
    private int ageInYears;
    private boolean  molting;
    
    public void doStuff(){
        this.cluck();
        this.wander();
        this.eat();
        this.layAnEgg();
        this.drink(1.2f);
        System.out.println(this.poop().toString());
        System.out.println(this.layAnEgg().toString());
    }
    private void cluck(){
        System.out.println("The chicken "+this.name+" is clucking...");
    }
    private void wander(){
        System.out.println("The chicken "+this.name+" is wandeing...");
    }
    private void eat(){
        System.out.println("The chicken "+this.name+" is eating...");
    }
    private void drink(float amountOfWater){
        System.out.println("The chicken "+this.name+" is drinking--->"+ amountOfWater +"nl of water");
    }
    private Poop poop(){
        Poop poop = new Poop("green", 'M');
        return poop;
    }
    private Egg layAnEgg(){
        Egg egg = new Egg('s');
        return egg;
    }
    
    public int computeAgeInYear(){
       int age = 0;

        Calendar birth = Calendar.getInstance();
        birth.setTime(bornOnDay);

        Calendar today = Calendar.getInstance();

        age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);

        if (today.get(Calendar.MONTH) < birth.get(Calendar.MONTH)) {
            age--;
        } else if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)
                && today.get(Calendar.DAY_OF_MONTH) < birth.get(Calendar.DAY_OF_MONTH)) {
            age--;
        }

        return age + 1900; 
    }
    
    public Chicken(int id, String name, String color, Date bornOnDay, boolean molting) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.bornOnDay = bornOnDay;
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

    public Date getBornOnDay() {
        return bornOnDay;
    }

    public void setBornOnDay(Date bornOnDay) {
        this.bornOnDay = bornOnDay;
    }

    public int getAgeInYears() {
        return ageInYears;
    }

    public void setAgeInYears() {
        this.ageInYears = computeAgeInYear();
    }

    public boolean isMolting() {
        return molting;
    }

    public void setMolting(boolean molting) {
        this.molting = molting;
    }

    @Override
    public String toString() {
        return "Chicken{" + "id=" + id + ", name=" + name + ", color=" + color + ", bornOnDay=" + bornOnDay + ", age=" + ageInYears + ", molting=" + molting + '}';
    }
    
}
