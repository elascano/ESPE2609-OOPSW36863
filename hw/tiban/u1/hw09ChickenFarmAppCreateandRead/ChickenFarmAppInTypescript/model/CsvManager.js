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
exports.CsvManager = void 0;
const fs = __importStar(require("fs"));
const Chicken_1 = require("./Chicken");
class CsvManager {
    static FILE_PATH = "chickens.csv";
    static saveChickens(chickens) {
        try {
            // Empezamos con la cabecera del CSV[cite: 10]
            let csvContent = "id,name,color,bornOnDate,ageInYears,molting\n";
            if (chickens !== null) {
                for (const c of chickens) {
                    if (c !== null) {
                        // Usamos template literals para armar la línea separada por comas[cite: 10]
                        csvContent += `${c.getId()},${c.getName()},${c.getColor()},${c.getBornOnDate().toISOString()},${c.getAgeInYears()},${c.isMolting()}\n`;
                    }
                }
            }
            fs.writeFileSync(this.FILE_PATH, csvContent, 'utf-8');
            console.log(`[OK] Data successfully saved in: ${this.FILE_PATH}`);
        }
        catch (error) {
            console.log(`[ERROR] No se pudo guardar el archivo CSV: ${error.message}`);
        }
    }
}
exports.CsvManager = CsvManager;
//# sourceMappingURL=CsvManager.js.map