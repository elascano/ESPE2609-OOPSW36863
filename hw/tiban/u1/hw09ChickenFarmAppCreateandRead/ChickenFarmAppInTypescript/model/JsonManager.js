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
exports.JsonManager = void 0;
const fs = __importStar(require("fs")); // Módulo nativo de Node.js para leer/escribir archivos
const Chicken_1 = require("./Chicken");
class JsonManager {
    static FILE_PATH = "chickens.json";
    static saveChickens(chickens) {
        try {
            // JSON.stringify convierte el arreglo a texto. 
            // El 'null, 2' es el equivalente exacto a tu setPrettyPrinting() de GsonBuilder
            const jsonString = JSON.stringify(chickens, null, 2);
            // writeFileSync escribe el archivo de forma síncrona
            fs.writeFileSync(this.FILE_PATH, jsonString, 'utf-8');
            console.log(`\n[OK] Data successfully saved in: ${this.FILE_PATH}`);
        }
        catch (error) {
            console.log(`\n[ERROR] The file could not be saved: ${error.message}`);
        }
    }
    static loadChickens() {
        try {
            // Verificamos si el archivo existe antes de leerlo
            if (!fs.existsSync(this.FILE_PATH)) {
                return new Array(10).fill(null); // Retorna arreglo vacío de 10 posiciones
            }
            const fileContent = fs.readFileSync(this.FILE_PATH, 'utf-8');
            const rawData = JSON.parse(fileContent); // Convierte el texto JSON a objetos planos de JS
            // ¡TRUCO DE EXAMEN! JSON.parse no crea objetos de la clase 'Chicken', solo objetos genéricos.
            // Para que tengan los métodos de Chicken (como doStuff o setAgeInYears), debemos instanciarlos de nuevo.
            return rawData.map((data) => {
                if (data === null)
                    return null;
                return new Chicken_1.Chicken(data.id, data.name, data.color, new Date(data.bornOnDate), data.molting);
            });
        }
        catch (error) {
            console.log(`\n[AVISO] No previous file was found, or an error occurred: ${error.message}`);
            return new Array(10).fill(null);
        }
    }
}
exports.JsonManager = JsonManager;
//# sourceMappingURL=JsonManager.js.map