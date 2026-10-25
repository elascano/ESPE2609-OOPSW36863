import * as readline from 'readline/promises';
import { stdin as input, stdout as output } from 'process';
import { Chicken } from '../model/Chicken.js';

export class InputHandler {
    
    static isIdTaken(id, chickens) {
        if (!chickens) return false;
        return chickens.some(c => c.id === id);//.some() only in arrays :)
    }

    static async createChickenFromConsole(currentChickens) {
        const rl = readline.createInterface({ input, output });
        
        console.log("\n=== New Chicken Register ===");
        
        let id;
        while (true) {
            const idInput = await rl.question("Enter the ID: ");
            id = parseInt(idInput, 10);
            
            if (this.isIdTaken(id, currentChickens)) {
                console.log("[!] Error: That ID is already registered. Please enter another one.");
            } else {
                break; 
            }
        }
        
        const name = await rl.question("Enter the name: ");
        const color = await rl.question("Enter the color: ");
        
        const yearInput = await rl.question("Enter the year of birth: ");
        const yearOfBirth = parseInt(yearInput, 10);
        
        const monthInput = await rl.question("Enter the month of birth: ");
        const monthOfBirth = parseInt(monthInput, 10);
        
        const dayInput = await rl.question("Enter the day of birth: ");
        const dayOfBirth = parseInt(dayInput, 10);
        
        const moltingInput = await rl.question("The chicken is molting? (true or false): ");
        const molting = moltingInput.toLowerCase() === 'true';
        
        rl.close();
        
        return new Chicken(id, name, color, new Date(yearOfBirth, monthOfBirth - 1, dayOfBirth), molting);
    }
}