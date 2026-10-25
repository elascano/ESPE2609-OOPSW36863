/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package ec.edu.espe.collections.model;

import java.beans.*;
import java.io.Serializable;

/**
 *
 * @author Anthony Arevalo, MosQ ,@ESPE
 */
public class Person {
    private int id;
    private String name;
    private float salary;

    public Person(int id,String name, float salary){
    this.id = id;
    this.name = name;
    this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name=" + name + ", salary=" + salary + '}';
    }

   
    
}