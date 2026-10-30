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
 * @author Stalyn Guerrero, CodeX3Team, @ESPE
 */
public class MyThings {
    public static void main(String[] args) {
        System.out.println("===========");
        System.out.println("Collections ws");
        System.out.println("Stalyn Guerrero");
        System.out.println("===========");
    
        Person person;
        person = new Person(1,"Stalyn Guerrero", 3000.25F);
        
        Collection things;
        things = new ArrayList();
        
        System.out.println("Size of my collections at the beginning --> " + things.size());
    
        things.add(18000);
        things.add("Hello OOP Programmers from Stalyn");
        things.add(4074.78F);
        things.add(person);
        
        System.out.println("Size of my collections now  --> " + things.size());
        System.out.println("my ArrayList elements are: -->" + things);
        
        things.remove(4074.78F);
        System.out.println("Size of my collections now  --> " + things.size());
        System.out.println("my ArrayList elements are: -->" + things);
        
        
        System.out.println("===============");
        Collection <Person> persons = new ArrayList <>();
        persons.add(person);
        persons = new ArrayList<>();
        person = new Person(2,"Guerrero", 4000.25F);
        persons.add(person);
        persons.add(new Person(3, "Stalyn", 480.86F));
        persons.add(new Person(4, "Stalyn", 480.86F));
        
        System.out.println("persons --> " + persons);
        
        persons.forEach((p) -> {
            System.out.println("Person --> " + p);
            
    });
    
    System.out.println("==========");
    for (Person p: persons){
        System.out.println("P --> " + p);
        
    }
    
    for (int i= 0; i < 10; i++){
        persons.add(new Person(i+1, "Stalyn" + (i+1), (i+1)*1000));
        
    
    }
        System.out.println("size of persons ArrayList --> " + persons.size());
        persons.forEach((p) -> {
            System.out.println("Person --> " + p);
            
    });
    
    }
}
