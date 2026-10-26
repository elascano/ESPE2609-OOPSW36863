package ec.edu.espe.collections.view;

import ec.edu.espe.collections.model.Person;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Verónica Ruiz, Code Crafters, @ESPE
 */
public class MyThings {
    public static void main(String[] args) {
        System.out.println("=================");
        System.out.println("| Collection ws |");
        System.out.println("| Verónica Ruiz |");
        System.out.println("==================");
        
        Collection things; 
        things = new ArrayList();
        
        Person person;
        things = new ArrayList();
        person = new Person(1, "Isabel Espinoza", 3000.25F);
        
        
        System.out.println("size of my collection at the begging --> " + things.size());
        
        things.add(18000);
        things.add("Hello OPP Programmers from Verónica");
        things.add(4073.78F);
        things.add(person);
        
        System.out.println("Size of my collection at the beginning --> " + things.size());
        System.out.println("My ArrayList elements are --> " + things);
        
        things.remove(4073.78F);
        
        System.out.println("Size of my collection at the beginning --> " + things.size());
        System.out.println("My ArrayList elements are --> " + things);
        System.out.println("======================");
        
        Collection<Person> persons;
        persons = new ArrayList<>();
        persons.add(person);
        person = new Person(2, "Martin Onate", 4000.35F);
        persons.add(new Person(3, "Erick Revelo", 480.87F));
        persons.add(new Person(4, "Nestor Olivo", 4480.87F));

        System.out.println("persons --> " + persons);
        System.out.println("========================");

        persons.forEach(p -> {
            System.out.println("Person --> " + p);
        });

        System.out.println("========================");

        for (Person p : persons) {
           System.out.println("P --> " + p);
        }

        for (int i = 0; i < 10; i++) {
            persons.add(new Person(+1,"Verónica" + (i+1), (i+1)*1000));
        }  
        
        
        persons.forEach(p -> {
        System.out.println("Person --> " + p);
       });
        }
    
}
