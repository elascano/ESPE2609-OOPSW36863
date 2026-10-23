/**
 *
 * @author Dylan Cumbajin, MosQ, @ESPE
 */
class Egg {
  // Constructor
  constructor(id, size) {
    this.id = id;
    this.size = size;
  }

  toString() {
    return "Egg{" + "id=" + this.id + ", size=" + this.size + "}";
  }

  getSize() {
    return this.size;
  }

  getId() {
    return this.id;
  }

  setId(id) {
    this.id = id;
  }
}

module.exports = Egg;
