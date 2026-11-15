export class Vehicle {
    // 1. Atributos (propiedades del vehículo)
    private brand: string;
    private model: string;
    private year: number;

    // 2. Constructor (se ejecuta al crear un nuevo vehículo)
    constructor(brand: string, model: string, year: number) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    // 3. Métodos (acciones o comportamientos)
    public getInfo(): string {
        return `${this.brand} ${this.model} (${this.year})`;
    }

    public startEngine(): void {
        console.log(`El motor del ${this.brand} ${this.model} está encendido.`);
    }
}