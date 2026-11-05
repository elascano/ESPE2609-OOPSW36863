/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espe.collection.view;

import ec.edu.espe.collection.model.Person;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Asus
 */
public class MyThings {
    public static void main(String[] args) {
        System.out.println("==========");
        System.out.println("|Collections ws|");
        System.out.println("|Nohemi Tocagon|");
        System.out.println("==========");

        Person person;
        Collection things;
        things = new ArrayList();
        person= new Person(1, "Isabel Espinosa", 3000.25F);


        System.out.println("size of my collection at the beginning -->" + things.size());

        things.add(18000);
        things.add("Hello OOP Programmers from Nohemi");
        things.add(4073.78F);
        things.add(person);
    
        System.out.println("size of my collection now -->" + things.size());
        System.out.println("my Arraylist elements are -->" + things);
        
        things.remove(4073.78F);
        System.out.println("size of my collection now -->" + things.size());
        System.out.println("my Arraylist elements are -->" + things);
        
        System.out.println("============");
        Collection<Person> persons;
        persons= new ArrayList<>();
        persons.add(person);
        person= new Person(2, "Martin Onate", 4000.35F);
        persons.add(person);
        persons.add(new Person(3, "Erick Revelo", 480.87F));
        persons.add(new Person(4, "Nestor Olivo", 480.87F));
        System.out.println("============");
        
        System.out.println("persons-->" + persons);
        System.out.println("============");
        
        persons.forEach((p) -> {
            System.out.println("person -->" + p);
            
        });
        System.out.println("============");
         for (Person p: persons){
             System.out.println("P-->" + p);
         }
         
         for(int i=0 ; i<10; i++){
             persons.add(new Person(i+1, "Tocagon Nohemi"+ (i+1), (i+1)*1000));
             
             
         }
         System.out.println("size of persons ArrayList -->"+ persons.size());
         for (Person p: persons){
             System.out.println("P-->" + p);
         }
         
         
    }
}
