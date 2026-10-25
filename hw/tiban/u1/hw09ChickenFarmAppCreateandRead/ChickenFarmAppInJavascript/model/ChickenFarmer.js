import { Chicken } from './Chicken.js';
import { ChickenCoop } from './ChickenCoop.js';

export class ChickenFarmer {
    constructor() {
        this.chickenFarmerId = 1;
        this.name = "Andy";
        
        this.coops = [];
        let chickens = [];
        
        chickens.push(new Chicken(0, "pepita", "black", new Date(2020, 10, 21), true));
        

    }

    toString() {
        return `ChickenFarmer{chickenFarmerId=${this.chickenFarmerId}, name=${this.name}, coops=${JSON.stringify(this.coops)}}`;
    }
}