package ec.edu.espe.collections.view;

import ec.edu.espe.collections.model.Person;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Andy Tiban, IV Studio, @ESPE
 */
public class MyThings {
public static void main(String[] args) {
      System.out.println(" ==================");
      System.out.println("| Collections ws |");
      System.out.println("| Andy Tiban     |");
      System.out.println("==================");
      Collection things = new ArrayList();
      Person person = new Person(1, "Isabel Espinosa", 3000.25F);
      System.out.println("size of my collection at the beginning -->" + things.size());
      things.add(18000);
      things.add("Hello OOP Programmers from Andy");
      things.add(4073.78F);
      things.add(person);
      System.out.println("size of my collection now -->" + things.size());
      System.out.println("my Arraylist elements are -->" + String.valueOf(things));
      things.remove(4073.78F);
      System.out.println("size of my collection now -->" + things.size());
      System.out.println("my Arraylist elements are -->" + String.valueOf(things));
      System.out.println("========");
      Collection<Person> persons = new ArrayList();
      persons.add(person);
      person = new Person(2, "Martin Onate", 4000.35F);
      persons.add(person);
      persons.add(new Person(3, "Erick Revelo", 480.87F));
      persons.add(new Person(4, "Nestor Olivo", 4480.87F));
      System.out.println("persons ->" + String.valueOf(persons));
      System.out.println("========");
      persons.forEach((px) -> System.out.println("Person ->> " + String.valueOf(px)));
      System.out.println("========");

      for(Person p : persons) {
         System.out.println("P-->" + String.valueOf(p));
      }

      System.out.println("size of persons ArrayList >" + persons.size());
      persons.forEach((px) -> System.out.println("Person ->" + String.valueOf(px)));
   }
    
  
}
