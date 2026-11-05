const fs = require('fs');
const Chicken = require('./chicken');

const FILE_NAME = 'chickens.json';

class JsonManager {
    static saveChickenToJson(chicken) {
        let chickens = JsonManager.readChickenJsonList();
        chickens.push(chicken);

        try {
            fs.writeFileSync(FILE_NAME, JSON.stringify(chickens, null, 4), 'utf-8');
            console.log("--> Chicken saved to JSON file successfully.");
        } catch (e) {
            console.log("Error saving to JSON file:", e.message);
        }
    }

    static readChickenJsonList() {
        if (!fs.existsSync(FILE_NAME)) {
            return [];
        }
        try {
            const data = fs.readFileSync(FILE_NAME, 'utf-8');
            return data ? JSON.parse(data) : [];
        } catch (e) {
            return [];
        }
    }

    static readChickenJson() {
        const chickens = JsonManager.readChickenJsonList();
        console.log("\n--- JSON FILE CONTENT ---");
        if (chickens.length === 0) {
            console.log("The JSON file is empty or does not exist.");
        } else {
            chickens.forEach(c => {
                console.log(`Chicken --> ID: ${c.id} | Name: ${c.name} | Color: ${c.color} | Age: ${c.ageInYears} | Molting: ${c.molting}`);
            });
        }
        console.log("-------------------------");
    }
}

module.exports = JsonManager;