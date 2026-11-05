const Chicken = require("./chicken");
const ChickenFileManager =
    require("./chicken_filemanager");

class ChickenCoop {

    constructor(chickens, chickenCoopId) {
        this.chickens = chickens;
        this.chickenCoopId = chickenCoopId;
        this.currentIndex = 0;
    }

    add(
        name,
        color,
        bornOnDate,
        molting
    ) {

        for (
            let i = 0;
            i < this.chickens.length;
            i++
        ) {

            if (this.chickens[i] === null) {

                const id = i + 1;

                this.chickens[i] =
                    new Chicken(
                        id,
                        name,
                        color,
                        bornOnDate,
                        molting
                    );

                console.log(
                    `Chicken added --> ${name}, ID --> ${id}`
                );

                ChickenFileManager.saveAsCSV(
                    this.chickens
                );

                ChickenFileManager.saveAsJSON(
                    this.chickens
                );

                return;
            }
        }

        console.log(
            "The chicken coop is full"
        );
    }

    remove(chickenId) {

        for (
            let i = 0;
            i < this.chickens.length;
            i++
        ) {

            if (
                this.chickens[i] !== null &&
                this.chickens[i].id === chickenId
            ) {

                for (
                    let j = i;
                    j < this.chickens.length - 1;
                    j++
                ) {
                    this.chickens[j] =
                        this.chickens[j + 1];
                }

                this.chickens[
                    this.chickens.length - 1
                ] = null;

                this.reassignIds();

                ChickenFileManager.saveAsCSV(
                    this.chickens
                );

                ChickenFileManager.saveAsJSON(
                    this.chickens
                );

                console.log(
                    `Chicken removed --> ${chickenId}`
                );

                return;
            }
        }

        console.log(
            "Chicken not found"
        );
    }

    reassignIds() {

        for (
            let i = 0;
            i < this.chickens.length;
            i++
        ) {

            if (
                this.chickens[i] !== null
            ) {
                this.chickens[i].id =
                    i + 1;
            }
        }
    }

    resetIteration() {
        this.currentIndex = 0;
    }

    next() {

        while (
            this.currentIndex <
            this.chickens.length
        ) {

            const chicken =
                this.chickens[
                    this.currentIndex
                ];

            this.currentIndex++;

            if (
                chicken !== null
            ) {
                return chicken;
            }
        }

        return null;
    }
}

module.exports = ChickenCoop;