"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.FarmAnimal = void 0;
// @author Anthony Arévalo, MosQ, ESPE
class FarmAnimal {
    #id;
    #breed;
    #bornOnDate;
    constructor(id, breed, bornOnDate) {
        this.#id = id;
        this.#breed = breed;
        this.#bornOnDate = bornOnDate;
    }
    getAgeInMonths() {
        return 0;
    }
    toString() {
        return "id=" + this.#id + ", breed=" + this.#breed
            + ", bornOnDate=" + this.#bornOnDate.getDate()
            + "/" + (this.#bornOnDate.getMonth() + 1)
            + "/" + this.#bornOnDate.getFullYear() + ",";
    }
    getId() {
        return this.#id;
    }
    setId(id) {
        this.#id = id;
    }
    getBreed() {
        return this.#breed;
    }
    setBreed(breed) {
        this.#breed = breed;
    }
    getBornOnDate() {
        return this.#bornOnDate;
    }
    setBornOnDate(bornOnDate) {
        this.#bornOnDate = bornOnDate;
    }
}
exports.FarmAnimal = FarmAnimal;
