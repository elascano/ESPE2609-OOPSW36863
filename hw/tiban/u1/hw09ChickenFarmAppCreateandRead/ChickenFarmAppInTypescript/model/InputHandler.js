"use strict";
var __createBinding = (this && this.__createBinding) || (Object.create ? (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    var desc = Object.getOwnPropertyDescriptor(m, k);
    if (!desc || ("get" in desc ? !m.__esModule : desc.writable || desc.configurable)) {
      desc = { enumerable: true, get: function() { return m[k]; } };
    }
    Object.defineProperty(o, k2, desc);
}) : (function(o, m, k, k2) {
    if (k2 === undefined) k2 = k;
    o[k2] = m[k];
}));
var __setModuleDefault = (this && this.__setModuleDefault) || (Object.create ? (function(o, v) {
    Object.defineProperty(o, "default", { enumerable: true, value: v });
}) : function(o, v) {
    o["default"] = v;
});
var __importStar = (this && this.__importStar) || (function () {
    var ownKeys = function(o) {
        ownKeys = Object.getOwnPropertyNames || function (o) {
            var ar = [];
            for (var k in o) if (Object.prototype.hasOwnProperty.call(o, k)) ar[ar.length] = k;
            return ar;
        };
        return ownKeys(o);
    };
    return function (mod) {
        if (mod && mod.__esModule) return mod;
        var result = {};
        if (mod != null) for (var k = ownKeys(mod), i = 0; i < k.length; i++) if (k[i] !== "default") __createBinding(result, mod, k[i]);
        __setModuleDefault(result, mod);
        return result;
    };
})();
Object.defineProperty(exports, "__esModule", { value: true });
exports.InputHandler = void 0;
const readlineSync = __importStar(require("readline-sync")); // Reemplazo directo de Scanner en TS/Node
const Chicken_1 = require("./Chicken");
class InputHandler {
    static isIdTaken(id, chickens) {
        if (chickens === null)
            return false;
        for (const c of chickens) {
            // Si encuentra una gallina que no es nula y tiene el mismo ID, retorna true
            if (c !== null && c.getId() === id) {
                return true;
            }
        }
        return false;
    }
    static createChickenFromConsole(currentChickens) {
        console.log("\n=== New Chicken Register ===");
        let id;
        while (true) {
            // questionInt() reemplaza a scanner.nextInt()
            id = readlineSync.questionInt("Enter the ID: ");
            if (this.isIdTaken(id, currentChickens)) {
                console.log("[!] Error: That ID is already registered. Please enter another one.");
            }
            else {
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
        return new Chicken_1.Chicken(id, name, color, new Date(yearOfBirth, monthOfBirth, dayOfBirth), molting);
    }
}
exports.InputHandler = InputHandler;
//# sourceMappingURL=InputHandler.js.map