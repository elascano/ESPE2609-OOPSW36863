const fs = require('fs');
const readline = require('readline');

class Chicken {
    constructor(id, name, color, bornYear, molting) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.bornYear = bornYear;
        this.molting = molting;
        this.age = this.computeAgeInYears();
    }

    computeAgeInYears() {
        const currentYear = new Date().getFullYear();
        let age = currentYear - this.bornYear;
        return age >= 0 ? age : 0;
    }

    toString() {
        return `Chicken{id=${this.id}, name=${this.name}, color=${this.color}, age=${this.age}, molting=${this.molting}}`;
    }
}

class ChickenCoop {
    constructor(id) {
        this.id = id;
        this.chickens = [];
        this.currentIndex = 0;
    }

    add(chicken) {
        if (this.chickens.length < 10) {
            this.chickens.push(chicken);
        } else {
            console.log("Error: The chicken coop is completely full!");
        }
    }

    remove(chickenId) {
        const index = this.chickens.findIndex(c => c.id === chickenId);
        if (index !== -1) {
            this.chickens.splice(index, 1);
            console.log(`Chicken removed --> ${chickenId}`);
        } else {
            console.log("Chicken not found");
        }
    }

    resetIteration() {
        this.currentIndex = 0;
    }

    next() {
        if (this.currentIndex < this.chickens.length) {
            return this.chickens[this.currentIndex++];
        }
        return null;
    }
}

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const question = (query) => new Promise(resolve => rl.question(query, resolve));

async function main() {
    const coop = new ChickenCoop(1);
    coop.add(new Chicken(2, "Maruja", "White", 1970, false));
    coop.add(new Chicken(1, "Lucy", "Brown and white", new Date().getFullYear(), true));

    let option = '0';
    while (option !== '6') {
        console.log("\n--- MAIN MENU ---");
        console.log("1. Add Chicken\n2. Remove Chicken\n3. List Chickens\n4. Save to CSV\n5. Save to JSON\n6. Exit");
        option = await question("Select an option: ");

        switch (option) {
            case '1':
                const id = parseInt(await question("ID: "));
                const name = await question("Name: ");
                const color = await question("Color: ");
                const year = parseInt(await question("Birth Year: "));
                const molting = (await question("Molting? (true/false): ")).toLowerCase() === 'true';
                coop.add(new Chicken(id, name, color, year, molting));
                break;
            case '2':
                const idToRemove = parseInt(await question("Enter Chicken ID to remove: "));
                coop.remove(idToRemove);
                break;
            case '3':
                console.log("\n--- CHICKENS IN COOP ---");
                coop.resetIteration();
                let c;
                while ((c = coop.next()) !== null) {
                    console.log(c.toString());
                }
                break;
            case '4':
                let csvContent = "ID,Name,Color,Age,Molting\n";
                coop.chickens.forEach(chicken => {
                    csvContent += `${chicken.id},${chicken.name},${chicken.color},${chicken.age},${chicken.molting}\n`;
                });
                fs.writeFileSync('chickens.csv', csvContent);
                console.log("Data saved to chickens.csv successfully!");
                break;
            case '5':
                fs.writeFileSync('chickens.json', JSON.stringify(coop.chickens, null, 4));
                console.log("Data saved to chickens.json successfully!");
                break;
            case '6':
                console.log("Exiting application...");
                rl.close();
                break;
            default:
                console.log("Invalid option.");
        }
    }
}

main();