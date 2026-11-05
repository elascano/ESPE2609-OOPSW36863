const fs = require('fs');

const FILE_NAME = 'chickens.csv';

class CsvManager {
    static saveChickenToCsv(chicken) {
        const fileExists = fs.existsSync(FILE_NAME);

        try {
            // Si el archivo no existe, escribimos la cabecera primero
            if (!fileExists) {
                fs.writeFileSync(FILE_NAME, 'ID,Name,Color,BornOnDate,AgeInYears,Molting\n', 'utf-8');
            }

            // Construimos la línea CSV con los datos
            const line = `${chicken.id},${chicken.name},${chicken.color},${chicken.bornOnDate},${chicken.ageInYears},${chicken.molting}\n`;

            // Agregamos la línea al archivo
            fs.appendFileSync(FILE_NAME, line, 'utf-8');
            console.log("--> Chicken saved to CSV file successfully.");
        } catch (e) {
            console.log("Error saving to CSV file:", e.message);
        }
    }

    static readChickenCsv() {
        console.log("\n--- CSV FILE CONTENT ---");
        if (!fs.existsSync(FILE_NAME)) {
            console.log("The CSV file is empty or does not exist.");
            console.log("------------------------");
            return;
        }

        try {
            const data = fs.readFileSync(FILE_NAME, 'utf-8');
            const lines = data.trim().split('\n');

            if (lines.length <= 1) {
                console.log("The CSV file only contains headers or is empty.");
            } else {
                // Omitimos la primera línea (cabecera)
                for (let i = 1; i < lines.length; i++) {
                    const parts = lines[i].split(',');
                    if (parts.length >= 6) {
                        console.log(`Chicken --> ID: ${parts[0]} | Name: ${parts[1]} | Color: ${parts[2]} | Born: ${parts[3]} | Age: ${parts[4]} | Molting: ${parts[5]}`);
                    }
                }
            }
        } catch (e) {
            console.log("Error reading CSV file:", e.message);
        }
        console.log("------------------------");
    }
}

module.exports = CsvManager;