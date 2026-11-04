"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.ChickenCoop = void 0;
const Chicken_1 = require("./Chicken");
class ChickenCoop {
    chickenCoopId;
    // (Chicken | null)[] significa que el arreglo puede contener objetos Chicken o valores null
    // new Array(10).fill(null) crea el arreglo de tamaño 10 llenándolo de nulos, igual que Java
    chickens = new Array(10).fill(null);
    currentIndex = 0;
    constructor(chickenCoopId, chickens) {
        this.chickenCoopId = chickenCoopId;
        this.chickens = chickens;
    }
    add(chicken) {
        for (let i = 0; i < this.chickens.length; i++) {
            // En TypeScript es mejor usar === para comprobación estricta de igualdad
            if (this.chickens[i] === null) {
                this.chickens[i] = chicken;
                break;
            }
        }
    }
    remove(chickenId) {
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
    next() {
        let nextChicken = null;
        if (this.currentIndex < this.chickens.length) {
            nextChicken = this.chickens[this.currentIndex];
            this.currentIndex++;
        }
        return nextChicken;
    }
    resetIteration() {
        this.currentIndex = 0;
    }
    //  Getters y Setters 
    getChickenCoopId() { return this.chickenCoopId; }
    setChickenCoopId(chickenCoopId) { this.chickenCoopId = chickenCoopId; }
    getChickens() { return this.chickens; }
    setChickens(chickens) { this.chickens = chickens; }
    toString() {
        // En TS, para imprimir un arreglo de objetos sin que salga "[object Object]", es útil mapearlo
        const chickensString = this.chickens.map(c => c ? c.toString() : 'null').join(', ');
        return `ChickenCoop{chickenCoopId=${this.chickenCoopId}, chickens=[${chickensString}], currentIndex=${this.currentIndex}}`;
    }
}
exports.ChickenCoop = ChickenCoop;
//# sourceMappingURL=ChickenCoop.js.map