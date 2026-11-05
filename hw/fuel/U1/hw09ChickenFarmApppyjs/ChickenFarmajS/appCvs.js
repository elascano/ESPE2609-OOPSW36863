const readline = require('readline');
const Chicken = require('./chicken');
const CsvManager = require('./csvManager');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function showMenu() {
    console.log("\n--- MAIN MENU (JS - CSV) ---");
    console.log("1. Add a chicken and save to CSV");
    console.log("2. Read and view CSV file");
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
                                    
                                    CsvManager.saveChickenToCsv(chicken);
                                    showMenu();
                                });
                            });
                        });
                    });
                });
                break;

            case 2:
                CsvManager.readChickenCsv();
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

console.log("Alejandro Fuel's Chicken Farm (JavaScript CSV Version)");
console.log("==========");
showMenu();