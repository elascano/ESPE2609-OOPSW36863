class Egg {
  constructor(id, size) {
    this.id = id;
    this.size = size;
  }

  getSize() {
    return this.size;
  }

  toString() {
    return `Egg{id=${this.id}, size=${this.size}}`;
  }
}

module.exports = Egg;