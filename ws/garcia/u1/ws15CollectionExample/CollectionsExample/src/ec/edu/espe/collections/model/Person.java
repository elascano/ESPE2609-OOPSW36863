/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.collections.model;

/**
 *
 * @author Jesus Garcia, @ESPE
 */
public class Person {
    private int id;
    private String name;
    private float salary;

    public Person(int id, String name, float salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", salary=" + salary + '}';
    }
    
    /**
     * 
     * @return the id
     */
    public int getId() {
        return id;
    }
}
