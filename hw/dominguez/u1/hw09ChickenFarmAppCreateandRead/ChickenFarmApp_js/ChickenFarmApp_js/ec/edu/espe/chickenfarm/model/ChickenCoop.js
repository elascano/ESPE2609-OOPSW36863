export class ChickenCoop {
  constructor(chickenCoopId, chickens) {
    this.chickenCoopId = chickenCoopId;
    this.chickens = chickens; 
    this.currentIndex = 0;
  }

  add(chicken) {
    if (this.currentIndex < this.chickens.length) {
      this.chickens[this.currentIndex] = chicken;
      this.currentIndex++;
      console.log(this.chickens[this.currentIndex - 1] + " Added correctly");
    } else {
      console.log("Dont have more space");
    }
  }

  remove(chickenId) {
    for (let i = 0; i < this.chickens.length; i++) {
      if (this.chickens[i] !== null && this.chickens[i].id === chickenId) {
        for (let j = i; j < this.chickens.length - 1; j++) {
          this.chickens[j] = this.chickens[j + 1];
        }
        this.chickens[this.chickens.length - 1] = null;
        this.currentIndex--;
        return;
      }
    }
  }

  resetIteration() {
    this.currentIndex = 0;
  }

  next() {
    if (this.currentIndex < this.chickens.length && this.chickens[this.currentIndex] !== null) {
      return this.chickens[this.currentIndex++];
    }
    return null;
  }

  toString() {
    return `ChickenCoop{chickenCoopId=${this.chickenCoopId}, chickens=[${this.chickens.map((c) => String(c)).join(", ")}], currentIndex=${this.currentIndex}}`;
  }
}
