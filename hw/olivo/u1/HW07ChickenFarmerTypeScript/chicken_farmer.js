"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.ChickenFarmer = void 0;
const chicken_coop_1 = require("./chicken_coop");
class ChickenFarmer {
    constructor(name, coops, id) {
        this.iteratorIndex = 0;
        if (id !== undefined) {
            this.id = id;
            if (id > ChickenFarmer.idCounter) {
                ChickenFarmer.idCounter = id;
            }
        }
        else {
            ChickenFarmer.idCounter++;
            this.id = ChickenFarmer.idCounter;
        }
        this.name = name;
        this.coops = coops !== undefined ? coops : [];
    }
    addCoop(coop) {
        this.coops.push(coop);
        console.log(`Farmer ${this.name} added Coop #${coop.id}`);
    }
    removeCoop(coopId) {
        const index = this.coops.findIndex(c => c.id === coopId);
        if (index !== -1) {
            this.coops.splice(index, 1);
            console.log(`Farmer ${this.name} removed Coop #${coopId}`);
            return true;
        }
        console.log(`Coop with ID ${coopId} not found`);
        return false;
    }
    resetIteration() {
        this.iteratorIndex = 0;
    }
    next() {
        if (this.iteratorIndex < this.coops.length) {
            const coop = this.coops[this.iteratorIndex];
            this.iteratorIndex++;
            return coop;
        }
        return null;
    }
    toDict() {
        return {
            id: this.id,
            name: this.name,
            coops: this.coops.map(coop => coop.toDict())
        };
    }
    static fromDict(data) {
        const coops = data.coops.map((coopData) => chicken_coop_1.ChickenCoop.fromDict(coopData));
        return new ChickenFarmer(data.name, coops, data.id);
    }
    toString() {
        return `ChickenFarmer [ID: ${this.id}, Name: ${this.name}, Coops: ${this.coops.length}]`;
    }
}
exports.ChickenFarmer = ChickenFarmer;
ChickenFarmer.idCounter = 0;
