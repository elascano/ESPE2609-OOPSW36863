"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.ChickenCoop = void 0;
const chicken_1 = require("./chicken");
class ChickenCoop {
    constructor(chickens, id) {
        this.iteratorIndex = 0;
        if (id !== undefined) {
            this.id = id;
            if (id > ChickenCoop.idCounter) {
                ChickenCoop.idCounter = id;
            }
        }
        else {
            ChickenCoop.idCounter++;
            this.id = ChickenCoop.idCounter;
        }
        this.chickens = chickens !== undefined ? chickens : [];
    }
    addChicken(chicken) {
        this.chickens.push(chicken);
        console.log(`Added ${chicken.toString()}`);
    }
    removeChicken(chickenId) {
        const index = this.chickens.findIndex(c => c.id === chickenId);
        if (index !== -1) {
            const removed = this.chickens.splice(index, 1)[0];
            console.log(`Removed ${removed.toString()}`);
            return true;
        }
        console.log(`Chicken with ID ${chickenId} not found`);
        return false;
    }
    getChicken(chickenId) {
        return this.chickens.find(c => c.id === chickenId) || null;
    }
    resetOperation() {
        this.iteratorIndex = 0;
    }
    next() {
        if (this.iteratorIndex < this.chickens.length) {
            const chicken = this.chickens[this.iteratorIndex];
            this.iteratorIndex++;
            return chicken;
        }
        return null;
    }
    toDict() {
        return {
            id: this.id,
            chickens: this.chickens.map(c => c.toDict())
        };
    }
    static fromDict(data) {
        const chickens = data.chickens.map((cData) => chicken_1.Chicken.fromDict(cData));
        return new ChickenCoop(chickens, data.id);
    }
    toString() {
        return `ChickenCoop [ID: ${this.id}, Total Chickens: ${this.chickens.length}]`;
    }
}
exports.ChickenCoop = ChickenCoop;
ChickenCoop.idCounter = 0;
