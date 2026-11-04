import * as readlineSync from 'readline-sync'; // Reemplazo directo de Scanner en TS/Node
import { Chicken } from './Chicken';

export class InputHandler {
    
    private static isIdTaken(id: number, chickens: (Chicken | null)[]): boolean {
        if (chickens === null) return false;
        for (const c of chickens) {
            // Si encuentra una gallina que no es nula y tiene el mismo ID, retorna true
            if (c !== null && c.getId() === id) {
                return true; 
            }
        }
        return false;
    }

    public static createChickenFromConsole(currentChickens: (Chicken | null)[]): Chicken {
        console.log("\n=== New Chicken Register ===");
         
        let id: number;
        while (true) {
            // questionInt() reemplaza a scanner.nextInt()
            id = readlineSync.questionInt("Enter the ID: ");
            
            if (this.isIdTaken(id, currentChickens)) {
                console.log("[!] Error: That ID is already registered. Please enter another one.");
            } else {
                break; 
            }
        }
        
        // question() reemplaza a scanner.nextLine()
        const name = readlineSync.question("Enter the name: ");
        const color = readlineSync.question("Enter de color: ");
        const yearOfBirth = readlineSync.questionInt("Enter the year of birth: ");
        const monthOfBirth = readlineSync.questionInt("Enter the month of birth: ");
        const dayOfBirth = readlineSync.questionInt("Enter the day of birth: ");
        
        const moltingInput = readlineSync.question("The chicken is molting? (true or false): ");
        const molting = moltingInput.toLowerCase() === 'true';
        
        // En TS no hace falta restar 1900 al año como en Java
        return new Chicken(id, name, color, new Date(yearOfBirth, monthOfBirth, dayOfBirth), molting);
    }
}