const readline = require('readline');
const Chicken = require('./chicken');
const JsonManager = require('./jsonManager');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function showMenu() {
    console.log("\n--- MAIN MENU (JS - JSON) ---");
    console.log("1. Add a chicken and save to JSON");
    console.log("2. Read and view JSON file");
    console.log("3. Exit");
    
    rl.question("Choose an option: ", (answer) => {
        const option = parseInt(answer.trim());

        switch (option) {
            case 1:
                rl.question("Enter chicken ID: ", (idStr) => {
                    const id = parseInt(idStr);
                    rl.question("Enter chicken name: ", (name) => {
                        rl.question("Enter chicken color: ", (color) => {
                            rl.question("Enter birth date (YYYY-MM-DD): ", (bornDate) => {
                                rl.question("Is it molting? (y/n): ", (moltingAns) => {
                                    const molting = moltingAns.trim().toLowerCase() === 'y';
                                    const chicken = new Chicken(id, name, color, bornDate, molting);
                                    JsonManager.saveChickenToJson(chicken);
                                    showMenu();
                                });
                            });
                        });
                    });
                });
                break;

            case 2:
                JsonManager.readChickenJson();
                showMenu();
                break;

            case 3:
                console.log("Exiting the program. Goodbye!");
                rl.close();
                break;

            default:
                console.log("Invalid option. Please try again.");
                showMenu();
                break;
        }
    });
}

console.log("Alejandro Fuel's Chicken Farm (JavaScript Version)");
console.log("==========");
showMenu();