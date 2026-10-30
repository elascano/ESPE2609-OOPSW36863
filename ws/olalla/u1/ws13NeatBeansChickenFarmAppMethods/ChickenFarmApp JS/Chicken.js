const { formatDate } = require("./helpers");

class Chicken {
  constructor(id, name, color, bornOnDate, molting) {
    this.id = id;
    this.name = name;
    this.color = color;
    this.bornOnDate = bornOnDate; // a Date
    this.molting = molting;       // true or false
  }

  // age in years, calculated from bornOnDate
  computeAge() {
    const today = new Date();
    let age = today.getFullYear() - this.bornOnDate.getFullYear();

    if (today.getMonth() < this.bornOnDate.getMonth()) {
      age--;
    } else if (today.getMonth() === this.bornOnDate.getMonth()
               && today.getDate() < this.bornOnDate.getDate()) {
      age--;
    }
    return age;
  }

  toString() {
    return `Chicken(id=${this.id}, name=${this.name}, color=${this.color}, `
         + `bornOnDate=${formatDate(this.bornOnDate)}, age=${this.computeAge()}, `
         + `molting=${this.molting})`;
  }
}

module.exports = Chicken;