"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Poop = void 0;
class Poop {
    constructor(color, consistency, id) {
        if (id !== undefined) {
            this.id = id;
            if (id > Poop.counterId) {
                Poop.counterId = id;
            }
        }
        else {
            Poop.counterId++;
            this.id = Poop.counterId;
        }
        this.color = color;
        this.consistency = consistency;
    }
    toDict() {
        return {
            id: this.id,
            color: this.color,
            consistency: this.consistency
        };
    }
    static fromDict(data) {
        return new Poop(data.color, data.consistency, data.id);
    }
    toString() {
        return `Poop [ID: ${this.id}, Color: ${this.color}, Consistency: ${this.consistency}]`;
    }
}
exports.Poop = Poop;
Poop.counterId = 0;
