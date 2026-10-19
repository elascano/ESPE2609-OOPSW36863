
package ec.edu.espe.chickenfarm.model;

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
    private int age;
    private boolean  molting;

    public Chicken(int id, String name, String color, Date bornOnDay, int age, boolean molting) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.bornOnDay = bornOnDay;
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

    public Date getBornOnDay() {
        return bornOnDay;
    }

    public void setBornOnDay(Date bornOnDay) {
        this.bornOnDay = bornOnDay;
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

    @Override
    public String toString() {
        return "Chicken{" + "id=" + id + ", name=" + name + ", color=" + color + ", bornOnDay=" + bornOnDay + ", age=" + age + ", molting=" + molting + '}';
    }
    
}
