/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.collections;

import java.util.ArrayList;
import java.util.Collection;
import ec.edu.espe.model.Person;

/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
public class MyThings {
    public static void main(String[] args) {
        System.out.println("====================");
        System.out.println("| Collections ws   |");
        System.out.println("| Dylan Cumbajin  |");
        System.out.println("====================");
        
        Person person;
        Collection things;
        things = new ArrayList();
        person = new Person(1, "Isabel", 300.25F);
        
        System.out.println("sizze of my collection at the beginning -->"+things.size());
        
        things.add(18000);
        things.add("Heloo OOP Programmers from Dylan");
        things.add(4073.78F);
        things.add(person);
         
        System.out.println("sizze of my collection now -->"+things.size());
        System.out.println("my ArrayList elemnts are --> " + things);
        
        things.remove(4073.78F);
        System.out.println("sizze of my collection now -->"+things.size());
        System.out.println("my ArrayList elemnts are --> " + things);
        
        System.out.println("===================");
        
        Collection<Person> persons;
        persons = new ArrayList<>();
        persons.add(person);
        person = new Person(2, "Martin Onate", 4000.35F);
        persons.add(person);
        person = new Person(3, "Erick Revelo", 480.87F);
        
        persons.add(person);
        person = new Person(4, "Nestor Olivo", 4480.89F);
        
                System.out.println("persons --> " + persons);
        System.out.println("==================");

        persons.forEach((p) -> {
            System.out.println("Person --> " + p);
        });

        System.out.println("==================");
        for (Person p : persons) {
            System.out.println("P --> " + p);
        }

        for (int i = 0; i < 10; i++) {
            persons.add(new Person(i + 1, "Edison" + (i + 1), (i + 1) * 1000));
        }

        System.out.println("size of persons ArrayList --> " + persons.size());
        persons.forEach((p) -> {
            System.out.println("Person --> " + p);
        });
        
    }
    
}
