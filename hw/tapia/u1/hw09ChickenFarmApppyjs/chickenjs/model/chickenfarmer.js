// model/ChickenFarmer.js

class ChickenFarmer {
    constructor(idChickenFarm, name, coops = []) {
        this.idChickenFarm = idChickenFarm;
        this.name = name;
        this.coops = coops;
    }
}

module.exports = ChickenFarmer;