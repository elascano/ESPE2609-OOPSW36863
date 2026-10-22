package ec.edu.espe.collections.view;

import ec.edu.espe.collections.model.Person;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Ariel Giler, CodeX3Team, @ESPE
 */
public class MyThings {
    public static void main(String[] args){
        System.out.println("================");
        System.out.println("Collections ws");
        System.out.println("Ariel Giler");
        System.out.println("================");
        
        Person person;
        Collection things;
        things = new ArrayList();
        person = new Person(1, "Ariel Giler", 3000.25F);
        
        System.out.println("size of my collection at the beginning --> "+ things.size());
        
        things.add(18000);
        things.add("Hello OOP Programmers from Ariel");
        things.add(4073.78F);
        things.add(person);
        
        System.out.println("size of my collection now --> "+ things.size());
        System.out.println("my ArrayList elements are --> "+ things);
        
        things.remove(4073.78F);
        System.out.println("size of my collection now --> "+ things.size());
        System.out.println("my ArrayList elements are --> "+ things);
        
        System.out.println("==============");
        
        Collection<Person> persons;
        persons = new ArrayList<>();
        persons.add(person);
        person = new Person(2, "Martin Onate", 4000.23F);
        persons.add(person);
        persons.add(new Person(3, "Erick Revelo", 480.87F));
        persons.add(new Person(4, "Isabel Espinoza", 4480.87F));
        
        System.out.println("====================");
        System.out.println("persons --> "+ persons);
        System.out.println("====================");
        
        persons.forEach((p)->{
            System.out.println("Person --> "+ p);  
        });
        
        System.out.println("====================");
        for(Person p: persons){
            System.out.println("P --> "+ p);
        }
        
        for(int i=0; i < 10; i++){
            persons.add(new Person(i+1, "Ariel"+(i+1), (i+1)*1000));
        }
        
        System.out.println("size of persons ArrayList --> "+ persons.size());
        persons.forEach((p)->{
            System.out.println("Person --> "+ p);  
        });
        
    }
}
