import fs from 'fs';

export class CsvManager {
    static FILE_PATH = "chickens.csv";

    static saveChickens(chickens) {
        try {
            let csvContent = "id,name,color,bornOnDate,ageInYears,molting\n";

            const rows = chickens.map(c => {
                // Aseguramos que la fecha se imprima limpia
                const dateStr = c.bornOnDate instanceof Date ? c.bornOnDate.toISOString().split('T')[0] : c.bornOnDate;
                return `${c.id},${c.name},${c.color},${dateStr},${c.ageInYears},${c.molting}`;
            });

            csvContent += rows.join('\n');

            fs.writeFileSync(this.FILE_PATH, csvContent);
            console.log(`[OK] Data successfully saved in: ${this.FILE_PATH}`);
            
        } catch (error) {
            console.log(` Could not save the CSV file: ${error.message}`);
        }
    }
}