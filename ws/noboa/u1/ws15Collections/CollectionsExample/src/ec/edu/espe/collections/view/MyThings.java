/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.collections.view;

import ec.edu.espe.collections.model.Person;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Dennis Noboa, 404 Founder, @ESPE
 */
public class MyThings {
    public static void main(String[] args) {
        System.out.println("===================");
        System.out.println("| Collections ws  |");
        System.out.println("| Dennis Noboa    |");
        System.out.println("===================");
        
        Person person;
        Collection things;
        things = new ArrayList();
        person = new Person(1, "Isabel Espinoza", 3000.25F);
        
        System.out.println("Size of my collection at the beginning --> " + things.size());
        
        things.add(18000);
        things.add("Hello OOP Programmers from Dennis");
        things.add(4073.78F);
        things.add(person);
        
        System.out.println("Size of my collection at the beginning --> " + things.size());
        System.out.println("My ArrayList elements are --> " + things);
        
        things.remove(4073.78F);
        
        System.out.println("Size of my collection at the beginning --> " + things.size());
        System.out.println("My ArrayList elements are --> " + things);
        
        System.out.println("========================");
        
        Collection<Person> persons;
        persons = new ArrayList<>();
        persons.add(person);
        person = new Person(2, "Martín Oñate", 400.29F);
        persons.add(person);
        persons.add(new Person(3, "Erick Revelo", 480.87F));
        persons.add(new Person(4, "Nestor Olivo", 4480.87F));

        System.out.println("persons --> " + persons);
        System.out.println("========================================");

        persons.forEach(p -> {
            System.out.println("Person --> " + p);
        });

        System.out.println("========================================");

        for (Person p : persons) {
            System.out.println("P --> " + p);
        }

        for (int i = 0; i < 10; i++) {
            persons.add(new Person(+1,"Edison" + (i+1), (i+1)*1000));
        }  
        
        persons.forEach(p -> {
            System.out.println("Person --> " + p);
        });
        
    }
    
}
