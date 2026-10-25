/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Beans/Bean.java to edit this template
 */
package ec.edu.espe.collections.view;

import ec.edu.espe.collections.model.Person;
import java.beans.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Anthony Arevalo, MosQ ,@ESPE
 */
public class MyThings {
    public static void main(String[] args) {
        System.out.println("""
                           =======================================
                           |         COLLECTIONS WS               | 
                           |         NESTOR OLIVO                 |
                           =======================================
                            """);
        Collection things;
        Person person;
        things = new ArrayList();
        person = new Person(1, "Jose", 18.50f);
        System.out.println("size of my collection at the beginning: " + things.size());
        things.add(18000);
        things.add("Hi OOP Progrmamers from Nestor");
        things.add(4073.78f);
        things.add(person);
        
        System.out.println("size of my collection at now: " + things.size());
        System.out.println("My ArrayList elements are : " + things);
        
        things.remove(4073.78f);
        System.out.println("size of my collection at now: " + things.size());
        System.out.println("My ArrayList elements are : " + things);
        
        Collection <Person> persons;
        persons = new ArrayList<>();
        persons.add(person);
        person = new Person(2, "Juan", 4000.35F);
        persons.add(person);
        persons.add(new Person(3, "Martin Oñate", 480.3f));
        persons.add(new Person(4, "Veronica Ruiz", 560.8f));
        
        System.out.println("==================");
        System.out.println("persons -> " + persons);
        System.out.println("==================");
        persons.forEach((p) -> {
            System.out.println("Person -> " + p);
        });
        System.out.println("==================");
        for(Person p : persons){
            System.out.println("P--->" + p);
        }
        for (int i = 0; i < 10; i++) {
            persons.add(new Person(i+1, "Anthony" + (i+1), (i+1)*1000));
        }
        System.out.println("size of persons ArrayList: " + persons.size());
        persons.forEach((p) -> {
            System.out.println("Person -> " + p);
        });
        
    }
}
 
  