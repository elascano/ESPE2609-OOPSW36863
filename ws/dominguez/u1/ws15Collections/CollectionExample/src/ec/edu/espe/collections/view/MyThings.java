package ec.edu.espe.collections.view;

import ec.edu.espe.collections.model.Person;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Mateo Dominguez, Brain Training, @ESPE
 */
public class MyThings {
    public static void main(String[] args) {
        System.out.println("===================");
        System.out.println("| Collections ws  |");
        System.out.println("| Mateo Dominguez |");
        System.out.println("===================");
        
        Person person;
        Collection things;
        things = new ArrayList();
        person = new Person(1, "Mateo Dominguez", 300.25F);
        
        System.out.println("size of my collection at the beginning --> " + things.size());
        
        things.add(10000);
        things.add("Hello OPP Programmers from Mateo");
        things.add(4073.78F);
        things.add(person);
        
        System.out.println("size of my collection now ---> " + things.size());
        System.out.println("my ArrayList elemets are ---> " + things);
        
        things.remove(4073.78F);
        System.out.println("size of my collection now ---> " + things.size());
        System.out.println("my ArrayList elemets are ---> " + things);
        
        System.out.println("===================================");
        
        Collection<Person> persons;
        persons = new ArrayList<>();
        persons.add(person);
        person = new Person(2, "Cristopher Dominguez", 480.87F);
        persons.add(person);
        person = new Person(3, "Tomas Tapia", 4480.87F);
        person = new Person(4, "Jesus Garcia", 4000.25F);
        
        System.out.println("persons -> " + persons);
        System.out.println(" =====================");

        persons.forEach((p) -> {
            System.out.println("Person -> " + p);
        });
        System.out.println("========================");
        for (Person p: persons){
            System.out.println("p -> "+ p);
        }
        for (int i=0; i < 10;i++){
            persons.add(new Person(i+1, "Mateo" + (i+1), (i+1)*1000));
        }
        System.out.println("size of persons ArrayList --> " + persons.size());
        persons.forEach((p)->{
        System.out.println("Person --> " + p);
        });
    }
}
