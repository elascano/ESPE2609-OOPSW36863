"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Person = void 0;
/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
class Person {
    constructor(id, name, salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
    toString() {
        return "id=" + this.id
            + ", name=" + this.name
            + ", salary=" + this.salary;
    }
    getId() {
        return this.id;
    }
    setId(id) {
        this.id = id;
    }
    getName() {
        return this.name;
    }
    setName(name) {
        this.name = name;
    }
    getSalary() {
        return this.salary;
    }
    setSalary(salary) {
        this.salary = salary;
    }
}
exports.Person = Person;
