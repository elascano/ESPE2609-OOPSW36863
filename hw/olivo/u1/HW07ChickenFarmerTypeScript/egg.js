"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Egg = void 0;
class Egg {
    constructor(size, id) {
        if (id !== undefined) {
            this.id = id;
            if (id > Egg.idCounter) {
                Egg.idCounter = id;
            }
        }
        else {
            Egg.idCounter++;
            this.id = Egg.idCounter;
        }
        this.size = size;
    }
    toDict() {
        return {
            id: this.id,
            size: this.size
        };
    }
    static fromDict(data) {
        return new Egg(data.size, data.id);
    }
    toString() {
        return `Egg [ID: ${this.id}, Size: ${this.size}]`;
    }
}
exports.Egg = Egg;
Egg.idCounter = 0;
