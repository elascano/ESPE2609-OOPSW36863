const Poop = require("./poop");
const Egg = require("./egg");

class Chicken {
    constructor(id, name, color, bornOnDate, molting) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.bornOnDate = bornOnDate;
        this.molting = molting;
    }

    computeAgeInYears() {
        const today = new Date();

        let age =
            today.getFullYear() -
            this.bornOnDate.getFullYear();

        const monthDifference =
            today.getMonth() -
            this.bornOnDate.getMonth();

        if (
            monthDifference < 0 ||
            (
                monthDifference === 0 &&
                today.getDate() <
                this.bornOnDate.getDate()
            )
        ) {
            age--;
        }

        return age;
    }

    doStuff() {
        this.cluck();
        this.wander();
        this.drink(1.3);

        console.log("poop ---> " + this.poop());
        console.log(this.layAnEgg());
    }

    cluck() {
        console.log(
            `The chicken ${this.name} is clucking`
        );
    }

    wander() {
        console.log(
            `The chicken ${this.name} is wandering`
        );
    }

    eat() {
        console.log(
            `The chicken ${this.name} is eating`
        );
    }

    drink(amountOfWater) {
        console.log(
            `The chicken ${this.name} is drinking ${amountOfWater}ml of water`
        );
    }

    poop() {
        return new Poop(2, "green", "M");
    }

    layAnEgg() {
        return new Egg(2, "S");
    }

    toString() {
        return `Chicken{
id=${this.id},
name='${this.name}',
color='${this.color}',
age=${this.computeAgeInYears()},
molting=${this.molting}
}`;
    }
}

module.exports = Chicken;