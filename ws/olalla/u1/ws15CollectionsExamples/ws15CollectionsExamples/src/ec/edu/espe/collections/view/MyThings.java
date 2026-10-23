package ec.edu.espe.collections.view;

import ec.espe.edu.collections.model.Person;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Julian Olalla, 404 Founders, @ESPE
 */
public class MyThings {
    public static void main(String[] args) {
    System.out.println("================");
    System.out.println("| Collections ws");
    System.out.println("| Julian Olalla");
    System.out.println("================");

    Person person;
    Collection things;
    things = new ArrayList();
    person = new Person(1, "Isabel Espeinosa", 3000.25F);

    System.out.println("size of the collection at the beggining --> " + things.size());
    
    things.add(18000);
    things.add("Hello OOP Programmers from Edison");
    things.add(4073.78F);
    things.add(person);
    
        System.out.println("size of my collection now --> " + things.size());
        System.out.println("my Array elements are --> " + things);
        
        things.remove(4073.78F);
        System.out.println("size of my collection now --> " + things.size());
        System.out.println("my ArrayList elements are --> " + things);
        
        System.out.println("===========");
        
        Collection<Person> persons;
        persons = new ArrayList<>();
        persons.add(person);
        person = new Person(2, "Martin Onate", 4000.35F);
        persons.add(person);
        persons.add(new Person(3, "Erick Revelo", 480.87F));      
        persons.add(new Person(4, "Nestor Olivo", 4480.87F));
        System.out.println("===============");

        System.out.println("persons -- > " + persons);
        System.out.println(" ================= ");

        persons. forEach((p) ->{
        System.out.println("Person -- > " + p);
        });
        
        System.out.println("================");
        for (Person p: persons){
            System.out.println("P --> "+ p);
        }
        
        for (int i=0; i < 10; i++){
            persons.add(new Person(1+i, "Julian" + (i+1), (i+1)*1000));
        }
        
        System.out.println("size of persons ArrayList --> " + persons.size());
        persons.forEach((p) -> {
            System.out.println("Person --> " + p);
        });
        }
        
    }
