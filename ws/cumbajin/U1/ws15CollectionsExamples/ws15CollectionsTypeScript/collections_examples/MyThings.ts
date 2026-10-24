
import { Person } from "../model/Person";

/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
class MyThings {

    static main(): void {
        console.log("====================");
        console.log("| Collections ws   |");
        console.log("| Dylan Cumbajin  |");
        console.log("====================");

        let person: Person;
        let things: any[];

        things = [];
        person = new Person(1, "Isabel", 300.25);

        console.log("sizze of my collection at the beginning -->" + things.length);

        things.push(18000);
        things.push("Heloo OOP Programmers from Dylan");
        things.push(4073.78);
        things.push(person);

        console.log("sizze of my collection now -->" + things.length);
        console.log("my ArrayList elemnts are -->", things);

        things.splice(things.indexOf(4073.78), 1);

        console.log("sizze of my collection now -->" + things.length);
        console.log("my ArrayList elemnts are -->", things);

        console.log("===================");

        let persons: Person[];
        persons = [];

        persons.push(person);

        person = new Person(2, "Martin Onate", 4000.35);
        persons.push(person);

        person = new Person(3, "Erick Revelo", 480.87);
        persons.push(person);

        person = new Person(4, "Nestor Olivo", 4480.89);

        console.log("persons -->", persons);
        console.log("==================");

        persons.forEach((p) => {
            console.log("Person --> " + p.toString());
        });

        console.log("==================");

        for (let p of persons) {
            console.log("P --> " + p.toString());
        }

        for (let i = 0; i < 10; i++) {
            persons.push(
                new Person(i + 1, "Edison" + (i + 1), (i + 1) * 1000)
            );
        }

        console.log("size of persons ArrayList -->" + persons.length);

        persons.forEach((p) => {
            console.log("Person --> " + p.toString());
        });
    }
}

MyThings.main();
