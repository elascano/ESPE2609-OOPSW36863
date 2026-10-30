
/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
export class Person {

    private id: number;
    private name: string;
    private salary: number;

    constructor(id: number, name: string, salary: number) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    toString(): string {
        return "id=" + this.id
                + ", name=" + this.name
                + ", salary=" + this.salary;
    }

    getId(): number {
        return this.id;
    }

    setId(id: number): void {
        this.id = id;
    }

    getName(): string {
        return this.name;
    }

    setName(name: string): void {
        this.name = name;
    }

    getSalary(): number {
        return this.salary;
    }

    setSalary(salary: number): void {
        this.salary = salary;
    }
}
