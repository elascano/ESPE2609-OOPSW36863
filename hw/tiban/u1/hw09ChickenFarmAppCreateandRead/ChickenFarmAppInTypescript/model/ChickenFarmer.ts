import { ChickenCoop } from "./ChickenCoop";
import { Chicken } from "./Chicken";

export class ChickenFarmer {
    // Es buena práctica poner los modificadores de acceso (private/public)
    private chickenFarmerId: number;
    private name: string;
    private coops: (ChickenCoop | null)[];

    constructor() {
        // Inicialización tal como la tienes en tu Java
        this.chickenFarmerId = 1;
        this.name = "Andy";
        this.coops = new Array(2).fill(null);
        
        // En tu código Java creaste este arreglo local dentro del constructor[cite: 9]
        let chickens: (Chicken | null)[] = new Array(2).fill(null);
        // Nota: El mes 10 en Date de TS/JS es Noviembre (los meses van de 0 a 11)
        chickens[0] = new Chicken(0, "pepita", "black", new Date(2020, 10, 21), true);
    }

    public toString(): string {
        // Mapeamos el arreglo para imprimir su contenido como texto
        const coopsString = this.coops.map(c => c ? c.toString() : 'null').join(', ');
        return `ChickenFarmer{chickenFarmerId=${this.chickenFarmerId}, name=${this.name}, coops=[${coopsString}]}`;
    }
}