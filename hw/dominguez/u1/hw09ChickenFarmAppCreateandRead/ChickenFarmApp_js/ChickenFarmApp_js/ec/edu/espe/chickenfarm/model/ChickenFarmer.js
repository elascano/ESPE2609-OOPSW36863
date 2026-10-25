export class ChickenFarmer {
  constructor(chickenFarmerId, name, coops) {
    this.chickenFarmerId = chickenFarmerId;
    this.name = name;
    this.coops = coops; 
    this.currentIndex = 0;
  }

  add(coop) {
    if (this.currentIndex < this.coops.length) {
      this.coops[this.currentIndex] = coop;
      this.currentIndex++;
      console.log(this.coops[this.currentIndex - 1] + " Added correctly");
    } else {
      console.log("Dont have more space");
    }
  }

  remove(chickenCoopId) {
    for (let i = 0; i < this.coops.length; i++) {
      if (this.coops[i] !== null && this.coops[i].chickenCoopId === chickenCoopId) {
        for (let j = i; j < this.coops.length - 1; j++) {
          this.coops[j] = this.coops[j + 1];
        }
        this.coops[this.coops.length - 1] = null;
        this.currentIndex--;
        return;
      }
    }
  }

  resetIteration() {
    this.currentIndex = 0;
  }

  next() {
    if (this.currentIndex < this.coops.length && this.coops[this.currentIndex] !== null) {
      return this.coops[this.currentIndex++];
    }
    return null;
  }

  toString() {
    return `ChickenFarmer{chickenFarmerId=${this.chickenFarmerId}, name=${this.name}, coops=[${this.coops.map((c) => String(c)).join(", ")}], currentIndex=${this.currentIndex}}`;
  }
}
