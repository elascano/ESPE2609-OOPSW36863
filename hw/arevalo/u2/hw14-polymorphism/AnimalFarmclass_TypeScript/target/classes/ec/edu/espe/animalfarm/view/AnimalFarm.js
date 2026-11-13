"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.AnimalFarm = void 0;
const Chicken_1 = require("../model/Chicken");
const Cow_1 = require("../model/Cow");
const Pig_1 = require("../model/Pig");
const Sheep_1 = require("../model/Sheep");
// @author Anthony Arévalo, MosQ, ESPE
class AnimalFarm {
    static main(args) {
        console.log("Welcome to Anthony's Animal Farm!");
        const bornOnDate = new Date(2020, 9, 10);
        let farmAnimal = new Chicken_1.Chicken(true, 0, true, 0, "Holstein", bornOnDate);
        console.log("FarmAnimal --> is a " + farmAnimal.constructor.name);
        console.log("my farm animal --->" + farmAnimal);
        farmAnimal = new Cow_1.Cow(true, 0, 0, "Palich", new Date(2022, 9, 20));
        console.log("cow --> " + farmAnimal.constructor.name);
        const chicken = new Chicken_1.Chicken(true, 10, true, 2, "Paleesh", new Date());
        console.log("chicken --->" + chicken);
        let cow = new Cow_1.Cow(true, 100.5, 3, "holstein", new Date(2022, 9, 20));
        console.log("Cow: " + cow);
        cow = new Chicken_1.Chicken(true, 4, true, 0, "paleesh", bornOnDate);
        console.log("FarmAnimal reassigned to Chicken --> " + cow);
        const cow2 = new Cow_1.Cow(true, 2, 4, "Holstein", bornOnDate);
        cow2.milk();
        chicken.layAnEgg();
        // Pig and Sheep inherit their ID, breed, and birth date from FarmAnimal.
        const pig = new Pig_1.Pig(85.5, 2.5, true, 5, "Yorkshire", bornOnDate);
        console.log("Pig: " + pig);
        const sheep = new Sheep_1.Sheep(new Date(), 3.2, "White", 6, "Merino", bornOnDate);
        console.log("Sheep: " + sheep);
    }
}
exports.AnimalFarm = AnimalFarm;
AnimalFarm.main([]);
