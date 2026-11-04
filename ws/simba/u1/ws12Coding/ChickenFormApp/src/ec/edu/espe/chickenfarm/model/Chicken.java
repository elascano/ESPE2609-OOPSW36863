package ec.edu.espe.chickenfarm.model;

import java.util.Calendar;
import java.util.Date;


/**
 *
 * @author DANILO SIMBA
 */
public class Chicken {
    private int id;
    private String name;
    private String color;
    private Date bornOnDate;
    private int ageInYears;
    private boolean molting;

    
    
   
    public void doStuff(){
        cluck();
        eat();
        wander();
        drink(1.3F);
        System.out.println("poop -->" + poop());
        System.out.println("egg -->" + layAnEgg());
        
    }
    
    private void cluck(){
        System.out.println("the chicken " + name + "is clucking...");
    }
    
    private void wander(){
        System.out.println("The cicken" + name + "is wandering ...");
    }
    
    private void eat(){
        System.out.println("The cicken" + name + "is eating ...");
    }
    
    private void drink(float amountOfWater){
        System.out.println("The cicken" + name + "is drinking --> " + amountOfWater + "ml fo water");
    }
    
    private Poop poop(){
        Poop poop;
        poop = new Poop(2,"green", 'M');
        return poop;
    }
    
    private Egg layAnEgg(){
        Egg  egg;
        egg = new Egg(2,'M');
        return egg;
    }
    
    public int computeAgeInYears(){
       int age;

        Calendar birth = Calendar.getInstance();
        birth.setTime(bornOnDate);

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

    
    
    public Chicken(int id, String name, String color, Date borOnDate, boolean molting){
        this.id = id;
        this.name = name;
        this.color = color;
        this.bornOnDate = borOnDate;
        this.ageInYears = computeAgeInYears();
        this.molting = molting;
    }

    @Override
    public String toString() {
        return "Chicken{" + "id=" + getId() + ", name=" + getName() + ", color=" + getColor() + ", borOnDate=" + getBorOnDate() + ", age=" + getAgeInYears() + ", molting=" + isMolting() + '}';
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
     * @return the color
     */
    public String getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * @return the borOnDate
     */
    public Date getBorOnDate() {
        return bornOnDate;
    }

    /**
     * @param borOnDate the borOnDate to set
     */
    public void setBorOnDate(Date borOnDate) {
        this.bornOnDate = borOnDate;
    }

    /**
     * @return the ageInYears
     */
    public int getAgeInYears() {
        return ageInYears;
    }

    /**
     * @param ageInYears the ageInYears to set
     */
    public void setAgeInYears(int ageInYears) {
        this.ageInYears = computeAgeInYears();
    }

    /**
     * @return the molting
     */
    public boolean isMolting() {
        return molting;
    }

    /**
     * @param molting the molting to set
     */
    public void setMolting(boolean molting) {
        this.molting = molting;
    }
}