package ec.edu.espe.chickenfarm.model;

import java.util.Date;

/**
 *
 * @author Verónica Ruiz, Code Crafters, @ESPE
 */
public class Chicken {
    int id;
    String name;
    String color;
    Date bornOnDate;
    int age;
    boolean molting;
    //encapsulate fields
    //insert a constructor
    
    // insert 

    public Chicken(int id, String name, String color, Date bornOnDate, int age, boolean molting) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.bornOnDate = bornOnDate;
        this.age = age;
        this.molting = molting;
    }

    @Override
    public String toString() {
        return "Chicken{" + "id=" + id + ", name=" + name + ", color=" + color + ", bornOnDate=" + bornOnDate + ", age=" + age + ", molting=" + molting + '}';
    }
    
}
