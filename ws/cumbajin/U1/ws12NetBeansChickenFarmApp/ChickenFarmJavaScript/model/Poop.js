/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
class Poop {
  constructor(id, color, consistency) {
    this.id = id;
    this.color = color;
    this.consistency = consistency;
  }

  toString() {
    return (
      "Poop{" +
      "id=" +
      this.id +
      ", color=" +
      this.color +
      ", consistency=" +
      this.consistency +
      "}"
    );
  }

  getId() {
    return this.id;
  }

  setId(id) {
    this.id = id;
  }

  getColor() {
    return this.color;
  }

  setColor(color) {
    this.color = color;
  }

  getConsistency() {
    return this.consistency;
  }

  setConsistency(consistency) {
    this.consistency = consistency;
  }
}

module.exports = Poop;
