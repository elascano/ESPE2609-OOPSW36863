"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Chicken = void 0;
const FarmAnimal_1 = require("./FarmAnimal");
// @author Alvarez Juan Jose, MosQ, ESPE
class Chicken extends FarmAnimal_1.FarmAnimal {
    #isMolting;
    #numberOfLaidEggInMonth;
    #isMeat;
    constructor(isMolting, numberOfLaidEggInMonth, isMeat, id, breed, bornOnDate) {
        super(id, breed, bornOnDate);
        this.#isMolting = isMolting;
        this.#numberOfLaidEggInMonth = numberOfLaidEggInMonth;
        this.#isMeat = isMeat;
    }
    layAnEgg() {
        console.log("chicken is laying an egg()");
    }
    toString() {
        return "Chicken{" + super.toString()
            + "isMolting=" + this.#isMolting
            + ", numberOfLaidEggInMonth=" + this.#numberOfLaidEggInMonth
            + ", isMeat=" + this.#isMeat + "}";
    }
    isIsMolting() {
        return this.#isMolting;
    }
    setIsMolting(isMolting) {
        this.#isMolting = isMolting;
    }
    getNumberOfLaidEggInMonth() {
        return this.#numberOfLaidEggInMonth;
    }
    setNumberOfLaidEggInMonth(numberOfLaidEggInMonth) {
        this.#numberOfLaidEggInMonth = numberOfLaidEggInMonth;
    }
    isIsMeat() {
        return this.#isMeat;
    }
    setIsMeat(isMeat) {
        this.#isMeat = isMeat;
    }
}
exports.Chicken = Chicken;
