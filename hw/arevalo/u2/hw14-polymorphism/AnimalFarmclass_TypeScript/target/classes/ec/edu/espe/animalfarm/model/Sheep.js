"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Sheep = void 0;
const FarmAnimal_1 = require("./FarmAnimal");
// @author Anthony Arevalo, MosQ, ESPE
class Sheep extends FarmAnimal_1.FarmAnimal {
    #lastShearing;
    #woolWeightInKg;
    #woolColor;
    constructor(lastShearing, woolWeightInKg, woolColor, id, breed, bornOnDate) {
        super(id, breed, bornOnDate);
        this.#lastShearing = lastShearing;
        this.#woolWeightInKg = woolWeightInKg;
        this.#woolColor = woolColor;
    }
    toString() {
        return "Sheep{" + super.toString()
            + "lastShearing=" + this.#lastShearing
            + ", woolWeightInKg=" + this.#woolWeightInKg
            + ", woolColor=" + this.#woolColor + "}";
    }
    getLastShearing() {
        return this.#lastShearing;
    }
    setLastShearing(lastShearing) {
        this.#lastShearing = lastShearing;
    }
    getWoolWeightInKg() {
        return this.#woolWeightInKg;
    }
    setWoolWeightInKg(woolWeightInKg) {
        this.#woolWeightInKg = woolWeightInKg;
    }
    getWoolColor() {
        return this.#woolColor;
    }
    setWoolColor(woolColor) {
        this.#woolColor = woolColor;
    }
}
exports.Sheep = Sheep;
