import * as fs from 'fs'; // Módulo nativo de Node.js para leer/escribir archivos
import { Chicken } from './Chicken';

export class JsonManager {
    private static readonly FILE_PATH = "chickens.json";

    public static saveChickens(chickens: (Chicken | null)[]): void {
        try {
            // JSON.stringify convierte el arreglo a texto. 
            // El 'null, 2' es el equivalente exacto a tu setPrettyPrinting() de GsonBuilder
            const jsonString = JSON.stringify(chickens, null, 2);
            
            // writeFileSync escribe el archivo de forma síncrona
            fs.writeFileSync(this.FILE_PATH, jsonString, 'utf-8');
            console.log(`\n[OK] Data successfully saved in: ${this.FILE_PATH}`);
        } catch (error: any) {
            console.log(`\n[ERROR] The file could not be saved: ${error.message}`);
        }
    }

    public static loadChickens(): (Chicken | null)[] {
        try {
            // Verificamos si el archivo existe antes de leerlo
            if (!fs.existsSync(this.FILE_PATH)) {
                return new Array(10).fill(null); // Retorna arreglo vacío de 10 posiciones
            }

            const fileContent = fs.readFileSync(this.FILE_PATH, 'utf-8');
            const rawData = JSON.parse(fileContent); // Convierte el texto JSON a objetos planos de JS

            // ¡TRUCO DE EXAMEN! JSON.parse no crea objetos de la clase 'Chicken', solo objetos genéricos.
            // Para que tengan los métodos de Chicken (como doStuff o setAgeInYears), debemos instanciarlos de nuevo.
            return rawData.map((data: any) => {
                if (data === null) return null;
                return new Chicken(data.id, data.name, data.color, new Date(data.bornOnDate), data.molting);
            });

        } catch (error: any) {
            console.log(`\n[AVISO] No previous file was found, or an error occurred: ${error.message}`);
            return new Array(10).fill(null);
        }
    }
}