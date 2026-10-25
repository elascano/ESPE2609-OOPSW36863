const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

const askQuestion = (query) => new Promise((resolve) => rl.question(query, resolve));

// --- MODEL CLASSES ---

class Egg {
    constructor(id, size) {
        this.id = id;
        this.size = size;
    }

    getSize() {
        return this.size;
    }

    toString() {
        return `Egg{id=${this.id}, size='${this.size}'}`;
    }
}

class Poop {
    constructor(id, color, consistency) {
        this.id = id;
        this.color = color;
        this.consistency = consistency;
    }

    toString() {
        return `Poop{id=${this.id}, color='${this.color}', consistency='${this.consistency}'}`;
    }
}

class Chicken {
    constructor(id, name, color, bornOnDate, molting) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.bornOnDate = bornOnDate;
        this.molting = molting;
        this.ageInYears = this.computeAgeInYears();
    }

    doStuff() {
        this.#cluck();
        this.#wander();
        this.#eat();
        this.#drink(1.3);
        console.log(`poop --> ${this.#poop()}`);
        console.log(`egg --> ${this.#layAnEgg()}`);
    }

    #cluck() {
        console.log(`The chicken ${this.name} is clucking...`);
    }

    #wander() {
        console.log(`The chicken ${this.name} is wandering...`);
    }

    #eat() {
        console.log(`The chicken ${this.name} is eating...`);
    }

    #drink(amountOfWater) {
        console.log(`The chicken ${this.name} is drinking --> ${amountOfWater} ml of water`);
    }

    #poop() {
        return new Poop(2, "green", "M");
    }

    #layAnEgg() {
        return new Egg(2, "S");
    }

    computeAgeInYears() {
        const today = new Date();
        let age = today.getFullYear() - this.bornOnDate.getFullYear();
        const m = today.getMonth() - this.bornOnDate.getMonth();
        if (m < 0 || (m === 0 && today.getDate() < this.bornOnDate.getDate())) {
            age--;
        }
        return age;
    }

    toString() {
        return `Chicken{id=${this.id}, name='${this.name}', color='${this.color}', bornOnDate=${this.bornOnDate.toISOString().split('T')[0]}, age=${this.ageInYears}, molting=${this.molting}}`;
    }
}

class ChickenCoop {
    constructor(chickenCoopId, chickens = new Array(10).fill(null)) {
        this.chickenCoopId = chickenCoopId;
        this.chickens = chickens;
        this.currentIndex = 0;
    }

    add(chicken) {
        for (let i = 0; i < this.chickens.length; i++) {
            if (this.chickens[i] === null) {
                this.chickens[i] = chicken;
                console.log(`Chicken with ID ${chicken.id} added successfully`);
                return;
            }
        }
        console.log("Error: Coop is full! Couldn't add chicken.");
    }

    remove(chickenId) {
        for (let i = 0; i < this.chickens.length; i++) {
            if (this.chickens[i] !== null && this.chickens[i].id === chickenId) {
                this.chickens[i] = null;
                console.log(`Chicken with ID ${chickenId} was removed from coop`);
                return;
            }
        }
        console.log(`Chicken with ID ${chickenId} was not found in coop`);
    }

    resetIteration() {
        this.currentIndex = 0;
        console.log("Iteration reset to the start of coop");
    }

    next() {
        while (this.currentIndex < this.chickens.length) {
            const current = this.chickens[this.currentIndex];
            this.currentIndex++;
            if (current !== null) {
                console.log(`Next chicken retrieved: ${current.name}`);
                return current;
            }
        }
        console.log("No more chickens available in the coop iteration");
        return null;
    }

    toString() {
        const localChickens = this.chickens
            .filter(c => c !== null)
            .map(c => c.toString())
            .join("\n\t");
        return `ChickenCoop{chickenCoopId=${this.chickenCoopId}, chickens=[\n\t${localChickens}\n]}`;
    }
}

class ChickenFarmer {
    constructor() {
        this.chickenFarmerId = 1;
        this.name = "";
        const chickens = [
            new Chicken(0, "pepita", "black", new Date(), true),
            new Chicken(0, "marujita", "black", new Date(), true)
        ];
        this.coops = [
            new ChickenCoop(0, [...chickens]),
            new ChickenCoop(1, [...chickens])
        ];
    }

    toString() {
        const localCoops = this.coops.map(coop => coop.toString()).join("\n");
        return `ChickenFarmer{chickenFarmerId=${this.chickenFarmerId}, name='${this.name}', coops=[\n${localCoops}\n]}`;
    }
}

// --- MAIN APPLICATION ---

async function main() {
    console.log("Dennis Noboa's Chicken Farm");
    console.log("===========================");

    const chicken = new Chicken(1, "Claudio", "light brown", new Date(1900, 11, 17), true);
    const egg = new Egg(1, 'M');

    console.log(`my chicken is --> ${chicken.toString()}`);
    console.log(`egg --> ${egg.toString()}`);
    console.log(`egg size --> ${egg.getSize()}`);

    const poop = new Poop(1, "brown", 'S');
    console.log(`poop --> ${poop.toString()}`);

    const chicken1 = new Chicken(2, "Lucy", "brown and white", new Date(1970, 11, 17), true);
    console.log(`chicken 1 --> ${chicken1.toString()}`);

    const localAge = chicken.computeAgeInYears();
    console.log(`the age of the chicken --> ${chicken.name}, is --> ${localAge}`);

    chicken.doStuff();

    const chickens = new Array(10).fill(null);
    chickens[0] = new Chicken(3, "Pepita", "black", new Date(2020, 1, 2), true);
    chickens[1] = chicken;

    for (let i = 0; i < 10; i++) {
        console.log(`chickens --> ${chickens[i]}`);
    }

    for (let i = 0; i < chickens.length; i++) {
        chickens[i] = new Chicken(i, `chicken ${i + 1}`, "white", new Date(2020, 2, 3), true);
        chickens[i].ageInYears = i;
    }

    for (let i = 0; i < 10; i++) {
        console.log(`chickens --> ${chickens[i].toString()}`);
    }

    const coop = new ChickenCoop(101, chickens);

    let chickenMenu = 0;
    while (chickenMenu !== 6) {
        console.log("\n--- Dennis Noboa's Chicken Farm App Menu ---");
        console.log("1. Add chicken");
        console.log("2. Remove chicken");
        console.log("3. Reset iteration");
        console.log("4. Next chicken");
        console.log("5. Show chicken list");
        console.log("6. Exit\n");

        const answer = await askQuestion("Choose an option: ");
        chickenMenu = parseInt(answer, 10);
        console.log();

        switch (chickenMenu) {
            case 1:
                console.log("--- ADD CHICKENS TO COOP ---");
                const cId = parseInt(await askQuestion("Insert chicken ID: "), 10);
                const cName = await askQuestion("Insert chicken Name: ");
                const cColor = await askQuestion("Insert chicken Color: ");
                coop.add(new Chicken(cId, cName, cColor, new Date(), true));
                break;
            case 2:
                console.log("--- REMOVE CHICKENS FROM COOP ---");
                const removeId = parseInt(await askQuestion("Insert chicken ID to remove: "), 10);
                coop.remove(removeId);
                break;
            case 3:
                console.log("--- RESET ITERATION ---");
                coop.resetIteration();
                break;
            case 4:
                console.log("--- NEXT CHICKEN ---");
                coop.next();
                break;
            case 5:
                console.log("--- CHICKEN LIST ---");
                for (let i = 0; i < chickens.length; i++) {
                    console.log(`chickens --> ${chickens[i] ? chickens[i].toString() : null}`);
                }
                break;
            case 6:
                console.log("SYSTEM EXIT SUCCESSFULLY...");
                rl.close();
                break;
            default:
                console.log("ERROR: Choose another option");
                break;
        }
    }

    console.log("\n\n==========");
    console.log("2026 10 21");
    const chickenFarmer = new ChickenFarmer();
    console.log(`chicken farmer --> ${chickenFarmer.toString()}`);
}

main();