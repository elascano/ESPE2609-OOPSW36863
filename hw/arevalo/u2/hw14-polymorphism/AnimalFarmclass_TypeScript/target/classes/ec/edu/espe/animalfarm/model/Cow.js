"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Cow = void 0;
const FarmAnimal_1 = require("./FarmAnimal");
// @author Alvarez Juan Jose, MosQ, ESPE
class Cow extends FarmAnimal_1.FarmAnimal {
    #isProducingMilk;
    #litersOfMilkForWeek;
    constructor(isProducingMilk, litersOfMilkForWeek, id, breed, bornOnDate) {
        super(id, breed, bornOnDate);
        this.#isProducingMilk = isProducingMilk;
        this.#litersOfMilkForWeek = litersOfMilkForWeek;
    }
    milk() {
        console.log("milking the cow");
    }
    toString() {
        return "Cow{" + super.toString()
            + "isProducingMilk=" + this.#isProducingMilk
            + ", litersOfMilkForWeek=" + this.#litersOfMilkForWeek + "}";
    }
    isIsProducingMilk() {
        return this.#isProducingMilk;
    }
    setIsProducingMilk(isProducingMilk) {
        this.#isProducingMilk = isProducingMilk;
    }
    getLitersOfMilkForWeek() {
        return this.#litersOfMilkForWeek;
    }
    setLitersOfMilkForWeek(litersOfMilkForWeek) {
        this.#litersOfMilkForWeek = litersOfMilkForWeek;
    }
}
exports.Cow = Cow;
