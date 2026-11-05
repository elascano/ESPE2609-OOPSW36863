import { Chicken } from "./Chicken";

export class ChickenCoop {
    private chickenCoopId: number;
    // (Chicken | null)[] significa que el arreglo puede contener objetos Chicken o valores null
    // new Array(10).fill(null) crea el arreglo de tamaño 10 llenándolo de nulos, igual que Java
    private chickens: (Chicken | null)[] = new Array(10).fill(null);
    private currentIndex: number = 0;

    constructor(chickenCoopId: number, chickens: (Chicken | null)[]) {
        this.chickenCoopId = chickenCoopId;
        this.chickens = chickens;
    }

    public add(chicken: Chicken): void {
        for (let i = 0; i < this.chickens.length; i++) {
            // En TypeScript es mejor usar === para comprobación estricta de igualdad
            if (this.chickens[i] === null) {
                this.chickens[i] = chicken;
                break;
            }
        }
    }

    public remove(chickenId: number): void {
        for (let i = 0; i < this.chickens.length; i++) {
            const currentChicken = this.chickens[i];
            // Validamos que no sea null ANTES de llamar a getId(), igual que en tu Java
            if (currentChicken !== null && currentChicken.getId() === chickenId) {
                this.chickens[i] = null;
                break;
            }
        }
    }

    // El tipo de retorno es (Chicken | null) porque next() puede devolver un espacio vacío
    public next(): Chicken | null {
        let nextChicken: Chicken | null = null;
        if (this.currentIndex < this.chickens.length) {
            nextChicken = this.chickens[this.currentIndex];
            this.currentIndex++; 
        }
        return nextChicken;   
    }

    public resetIteration(): void {
        this.currentIndex = 0;
    }

    //  Getters y Setters 
    public getChickenCoopId(): number { return this.chickenCoopId; }
    public setChickenCoopId(chickenCoopId: number): void { this.chickenCoopId = chickenCoopId; }

    public getChickens(): (Chicken | null)[] { return this.chickens; }
    public setChickens(chickens: (Chicken | null)[]): void { this.chickens = chickens; }

    public toString(): string {
        // En TS, para imprimir un arreglo de objetos sin que salga "[object Object]", es útil mapearlo
        const chickensString = this.chickens.map(c => c ? c.toString() : 'null').join(', ');
        return `ChickenCoop{chickenCoopId=${this.chickenCoopId}, chickens=[${chickensString}], currentIndex=${this.currentIndex}}`;
    }
}