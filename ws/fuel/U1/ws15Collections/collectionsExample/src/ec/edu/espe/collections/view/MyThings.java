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
 * @author Alejandro Fuel
 */
public class MyThings {
    public static void main(String[] args) {
        System.out.println("| Collections ws    |");
        System.out.println("| Alejandro Fuel    |");
        System.out.println("=====================");
            
        Person person;
        Collection things;
        things = new ArrayList();
        person = new Person(1, "Isabel Espinosa", 3000.25F);

        System.out.println("size of my collection at the beginning --> " + things.size());

        things.add(18000);
        things.add("Hello OOP Programmers from Alejandro ");
        things.add(4073.78F);
        things.add(person);
        
        System.out.println("size of my collection now --> " + things.size());
        System.out.println("my ArrayList elements are --> " + things);
        
        things.remove(4073.78F);
        
        System.out.println("size of my collection now --> " + things.size());
        System.out.println("my ArrayList elements are --> " + things);
        
        System.out.println("=============");
        
        Collection<Person> persons;
        persons = new ArrayList<>();
        persons.add(person);
        person = new Person(2, "Martin Onate", 4000.35F);
        persons.add(person);
        persons.add(new Person(3, "Erick Revelo", 480.87F));
        persons.add(new Person(4, "Nestor Oivo", 4480.87F));
        System.out.println("persons --> " + persons);
        
        System.out.println("=============");
        for(Person p: persons){
            System.out.println("P---->" + p);
        }
        
        // CORRECCIÓN: Guardamos el tamaño inicial para evitar bucles infinitos o errores
        int initialSize = persons.size();
        for(int i = 0; i < initialSize; i++){
            persons.add(new Person(i + 1, "Alejandro" + (i + 1), (i + 1) * 1000));
        }
        
        System.out.println("size of persons ArrayList --> " + persons.size());
        persons.forEach((p) -> {
            System.out.println("Person ---> " + p);
        });
    }
}