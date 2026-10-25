class Person {
    constructor(id, name, salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    toString() {
        return `Person{id=${this.id}, name=${this.name}, salary=${this.salary}}`;
    }

    getId() {
        return this.id;
    }
}

function main() {
    console.log("=============");
    console.log("| Collections ws |");
    console.log("| Jesus Garcia   |");
    console.log("==============");

    let things = [];
    let person = new Person(1, "Yisus Garcia", 3000.25);

    console.log("size of my collection at the beginning --> " + things.length);

    things.push(18000);
    things.push("Hello OOP Programmers from Jesus");
    things.push(4073.78);
    things.push(person);

    console.log("size of my collection now --> " + things.length);
    console.log("My ArrayList elements are --> [" + things.map(t => t.toString()).join(", ") + "]");

    const indexToRemove = things.indexOf(4073.78);
    if (indexToRemove > -1) {
        things.splice(indexToRemove, 1);
    }
    
    console.log("size of my collection now --> " + things.length);
    console.log("My ArrayList elements are --> [" + things.map(t => t.toString()).join(", ") + "]");

    console.log("===========");

    let persons = [];
    persons.push(person);
    person = new Person(2, "Martin Onate", 400.35);
    persons.push(person);
    persons.push(new Person(3, "Erick Revelo", 480.87));
    persons.push(new Person(4, "Nestor Olivo", 4480.87));

    console.log("persons --> [" + persons.map(p => p.toString()).join(", ") + "]");
    console.log("============");

    persons.forEach((p) => {
        console.log("Person -->" + p.toString());
    });

    console.log("============");
    
    for (let p of persons) {
        console.log("P --> " + p.toString());
    }

    for (let i = 0; i < 10; i++) {
        persons.push(new Person(i + 1, "Jesus " + (i + 1), (i + 1) * 1000));
    }

    console.log("size of persons ArrayList --> " + persons.length);
    persons.forEach((p) => {
        console.log("Person -->" + p.toString());
    });
}

main();