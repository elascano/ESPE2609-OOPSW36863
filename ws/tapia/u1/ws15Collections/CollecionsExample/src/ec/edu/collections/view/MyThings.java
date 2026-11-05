package ec.edu.collections.view;

import ec.edu.collections.model.Person;

import java.util.ArrayList;
import java.util.Collection;

public class MyThings {

    public static void main(String[] args) {

        System.out.println("/////////////////////////");
        System.out.println("Collections by Tomas Tapia");

        Person person = new Person(1, "Tomas", 3000.25F);

        Collection<Object> things = new ArrayList<>();

        System.out.println("Size ---> " + things.size());

        things.add(1000);
        things.add("Hello by Tomas");
        things.add(300.2F);
        things.add(person);

        System.out.println("My ArrayList elements are --> " + things);

        System.out.println("Size of my collection now --> " + things.size());

        things.remove(483.78F);

        System.out.println("Size of my collection now --> " + things.size());
        System.out.println("My ArrayList elements are --> " + things);

        System.out.println("=========================");

        Collection<Person> persons = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            persons.add(new Person(
                    i + 1,
                    "Tomas" + (i + 1),
                    (i + 1) * 1000
            ));
        }

        System.out.println("Consumer<Person> action:");

        persons.forEach(p -> {
            System.out.println("Person --> " + p);
        });

        System.out.println("=========================");

        for (Person p : persons) {
            System.out.println("P --> " + p);
        }
    }
}