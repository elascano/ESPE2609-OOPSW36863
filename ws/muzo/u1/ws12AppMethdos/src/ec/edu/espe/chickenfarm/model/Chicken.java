package ec.edu.espe.chickenfarm.model;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Lesly Muzo, ESPE
 */
public class Chicken {
    private int identifier;
    private String chickenName;
    private String featherColor;
    private Date birthDate;
    private int yearsOld;
    private boolean isMolting;
    
    public void executeActions(){
       chirp();
       walk();
       consumeWater(1.4F);
       System.out.println("poop data -->" + generatePoop());
       System.out.println("egg data -->" + produceEgg());
    }
    
    private void chirp(){
        System.out.println("The chicken " + chickenName + " is clucking");
    }
    private void walk(){
        System.out.println("The chicken " + chickenName + " is wandering");
    }
    private void feed(){
        System.out.println("The chicken " + chickenName + " is eating...");
    }
    private void consumeWater(float waterVolume){
        System.out.println("The chicken " + chickenName + " is drinking -->" + waterVolume +"ml of water");
    }
    private Poop generatePoop(){
        Poop currentPoop;
        currentPoop = new Poop(2,"green",'M');
        return currentPoop;
    }
    
    private Egg produceEgg(){
        Egg newEgg;
        newEgg = new Egg(2, 'S');
        return newEgg;
    }
    
    public int computeAgeInYears(){
        int calculatedAge;
        Calendar birthCal = Calendar.getInstance();
        birthCal.setTime(birthDate);

        Calendar currentCal = Calendar.getInstance();

        calculatedAge = currentCal.get(Calendar.YEAR) - birthCal.get(Calendar.YEAR);

        if (currentCal.get(Calendar.MONTH) < birthCal.get(Calendar.MONTH)) {
            calculatedAge--;
        } else if (currentCal.get(Calendar.MONTH) == birthCal.get(Calendar.MONTH)
                && currentCal.get(Calendar.DAY_OF_MONTH) < birthCal.get(Calendar.DAY_OF_MONTH)) {
            calculatedAge--;
        }

        return calculatedAge;
    }

    public Chicken(int identifier, String chickenName, String featherColor, Date birthDate, boolean isMolting) {
        this.identifier = identifier;
        this.chickenName = chickenName;
        this.featherColor = featherColor;
        this.birthDate = birthDate;
        this.yearsOld = computeAgeInYears();
        this.isMolting = isMolting;
    }
  
    @Override
    public String toString() {
        return "Chicken{identifier=" + identifier + ", chickenName=" + chickenName + ", featherColor=" + featherColor + ", birthDate=" + birthDate + ", yearsOld=" + yearsOld + ", isMolting=" + isMolting + "}";
    }

    public int getId() {
        return identifier;
    }

    public void setId(int identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return chickenName;
    }

    public void setName(String chickenName) {
        this.chickenName = chickenName;
    }

    public String getColor() {
        return featherColor;
    }

    public void setColor(String featherColor) {
        this.featherColor = featherColor;
    }

    public Date getBornOnDate() {
        return birthDate;
    }

    public void setBornOnDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge() {
        return yearsOld;
    }

    public void setAge(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public boolean isMolting() {
        return isMolting;
    }

    public void setMolting(boolean isMolting) {
        this.isMolting = isMolting;
    }
}