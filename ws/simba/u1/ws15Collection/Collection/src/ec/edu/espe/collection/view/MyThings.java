package ec.edu.espe.collection.view;

import ec.edu.espe.collection.model.Person;
import java.util.ArrayList;
import java.util.Collection;




/**
 *
 * @author Danilo Simba, @ESPE
 */
public class MyThings {
    public static void main(String[]args){
        System.out.println("=================");
        System.out.println("| Collection ws |");
        System.out.println("| Danilo Simba  |");
        System.out.println("=================");
        
        Person person;
        Collection things;
        things = new ArrayList();
        person = new Person(1, "Isabel Espinosa", 3000.25F);
        
        System.out.println("Size of my collection at the beginning --> " + things.size());
        
        things.add(18000);
        things.add("Hello OOP Programers from Danilo");
        things.add(4073.78F);
        things.add(person);
        
        System.out.println("size of my collection now --> " + things.size());
        System.out.println("my ArrayList elements are --> " +things);
        
        System.out.println("===================");
        
        Collection<Person> persons;
        persons = new ArrayList<>();
        persons.add(person);
        person = new Person(2, "Martin onate", 4000.35F);
        persons.add(person);
        persons.add(new Person(3, "Martin onate", 480.35F));
        persons.add(new Person(4, "Martin onate", 4480.35F));
        
        System.out.println("persons --> " + persons);
        System.out.println("==================");
        
        persons.forEach((p) -> {
            System.out.println("Person -->" + p);
        });
        System.out.println("===================");
        for(Person p: persons){
            System.out.println("P --> " + p);
        }
        
        for(int i= 0; i < persons.size(); i++){
            persons.add(new Person(i + 1, "Danilo" + (i+1), (i+1)*1000));
        }
        
        System.out.println("size of persons ArrayList --> " + persons.size());
        persons.forEach((p) -> {
            System.out.println("Person -->" + p);
        });
    
    
    }
    
}
