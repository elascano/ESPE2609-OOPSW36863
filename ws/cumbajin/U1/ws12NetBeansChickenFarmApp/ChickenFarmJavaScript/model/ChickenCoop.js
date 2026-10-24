/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
class ChickenCoop {
  constructor(chickenCoopId, chickens) {
    this.chickenCoopId = chickenCoopId;
    this.chickens = chickens;
    this.currentIndex = 0;
  }

  // Add a chicken
  add(chicken) {
    if (chicken == null) {
      return;
    }

    for (let i = 0; i < this.chickens.length; i++) {
      if (this.chickens[i] == null) {
        this.chickens[i] = chicken;
        console.log("Chicken added --> " + chicken.getName());
        return;
      }
    }

    console.log("The chicken coop is full");
  }

  // Remove a chicken
  remove(chickenId) {
    for (let i = 0; i < this.chickens.length; i++) {
      if (this.chickens[i] != null && this.chickens[i].getId() == chickenId) {
        for (let j = i; j < this.chickens.length - 1; j++) {
          this.chickens[j] = this.chickens[j + 1];
        }

        this.chickens[this.chickens.length - 1] = null;

        if (this.currentIndex > i) {
          this.currentIndex--;
        }

        console.log("Chicken removed --> " + chickenId);
        return;
      }
    }

    console.log("Chicken not found");
  }

  // Reset iteration
  resetIteration() {
    this.currentIndex = 0;
  }

  // Get the next chicken
  next() {
    while (this.currentIndex < this.chickens.length) {
      let chicken = this.chickens[this.currentIndex];
      this.currentIndex++;

      if (chicken != null) {
        return chicken;
      }
    }

    return null;
  }

  toString() {
    return (
      "ChickenCoop{" +
      "chickenCoopId=" +
      this.chickenCoopId +
      ", chickens=" +
      this.chickens +
      "}"
    );
  }

  getChickenCoopId() {
    return this.chickenCoopId;
  }

  setChickenCoopId(chickenCoopId) {
    this.chickenCoopId = chickenCoopId;
  }

  getChickens() {
    return this.chickens;
  }

  setChickens(chickens) {
    this.chickens = chickens;
  }
}

module.exports = ChickenCoop;
