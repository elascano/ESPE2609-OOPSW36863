import fs from 'fs';

export class JsonManager {
    static FILE_PATH = "chickens.json";

    static saveChickens(chickens) {
        try {
            const jsonString = JSON.stringify(chickens, null, 2);
            
            fs.writeFileSync(this.FILE_PATH, jsonString);
            console.log(`\n[OK] Data successfully saved in: ${this.FILE_PATH}`);
        } catch (error) {
            console.log(`\n[ERROR] The file could not be saved: ${error.message}`);
        }
    }

    static loadChickens() {
        try {
            if (!fs.existsSync(this.FILE_PATH)) {
                return []; 
            }

            const fileData = fs.readFileSync(this.FILE_PATH, 'utf-8');
            return JSON.parse(fileData);
        } catch (error) {
            console.log(`\n[AVISO] No previous file was found, or an error occurred: ${error.message}`);
            return []; 
        }
    }
}