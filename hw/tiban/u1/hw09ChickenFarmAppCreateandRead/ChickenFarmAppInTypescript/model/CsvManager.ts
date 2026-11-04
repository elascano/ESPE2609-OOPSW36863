import * as fs from 'fs';
import { Chicken } from './Chicken';

export class CsvManager {
    private static readonly FILE_PATH = "chickens.csv";

    public static saveChickens(chickens: (Chicken | null)[]): void {
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
        } catch (error: any) {
            console.log(`[ERROR] No se pudo guardar el archivo CSV: ${error.message}`);
        }
    }
}