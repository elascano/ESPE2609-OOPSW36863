// Importamos la clase desde la carpeta model
import { Vehicle } from "../model/Vehicle";

// Creamos instancias (objetos) usando la clase Vehicle
const car1 = new Vehicle("Toyota", "Corolla", 2024);
const car2 = new Vehicle("Mazda", "CX-5", 2025);

// Usamos sus métodos
console.log("--- Lista de Vehículos ---");
console.log(car1.getInfo());
car1.startEngine();

console.log(car2.getInfo());
car2.startEngine();