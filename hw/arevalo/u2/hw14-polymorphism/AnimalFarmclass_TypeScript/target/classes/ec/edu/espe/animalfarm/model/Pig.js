"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Pig = void 0;
const FarmAnimal_1 = require("./FarmAnimal");
// @author Anthony Arevalo, MosQ, ESPE
class Pig extends FarmAnimal_1.FarmAnimal {
    #weightInKg;
    #dailyFoodIntakeInKg;
    #isCastrated;
    constructor(weightInKg, dailyFoodIntakeInKg, isCastrated, id, breed, bornOnDate) {
        super(id, breed, bornOnDate);
        this.#weightInKg = weightInKg;
        this.#dailyFoodIntakeInKg = dailyFoodIntakeInKg;
        this.#isCastrated = isCastrated;
    }
    toString() {
        return "Pig{" + super.toString()
            + "weightInKg=" + this.#weightInKg
            + ", dailyFoodIntakeInKg=" + this.#dailyFoodIntakeInKg
            + ", isCastrated=" + this.#isCastrated + "}";
    }
    getWeightInKg() {
        return this.#weightInKg;
    }
    setWeightInKg(weightInKg) {
        this.#weightInKg = weightInKg;
    }
    getDailyFoodIntakeInKg() {
        return this.#dailyFoodIntakeInKg;
    }
    setDailyFoodIntakeInKg(dailyFoodIntakeInKg) {
        this.#dailyFoodIntakeInKg = dailyFoodIntakeInKg;
    }
    isCastrated() {
        return this.#isCastrated;
    }
    setCastrated(isCastrated) {
        this.#isCastrated = isCastrated;
    }
}
exports.Pig = Pig;
