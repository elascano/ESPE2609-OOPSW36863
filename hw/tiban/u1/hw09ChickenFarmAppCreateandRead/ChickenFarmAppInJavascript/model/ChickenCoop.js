export class ChickenCoop {
    constructor(chickenCoopId) {
        this.chickenCoopId = chickenCoopId;
        this.chickens = []; 
        this.currentIndex = 0;
    }

    add(chicken) {
        this.chickens.push(chicken);
    }

    remove(chickenId) {
        const index = this.chickens.findIndex(c => c.id === chickenId);
        
        if (index !== -1) {
            this.chickens.splice(index, 1);
        }
    }

    next() {
        let nextChicken = null;
        if (this.currentIndex < this.chickens.length) {
            nextChicken = this.chickens[this.currentIndex];
            this.currentIndex++;
        }
        return nextChicken;
    }

    resetIteration() {
        this.currentIndex = 0;
    }

    toString() {
        return `ChickenCoop{chickenCoopId=${this.chickenCoopId}, chickensCount=${this.chickens.length}, currentIndex=${this.currentIndex}}`;
    }
}