// model/ChickenFileManager.js

const fs = require("fs");

class ChickenFileManager {

    static saveAsCSV(chickens) {

        let csv = "ID,Name,Color,Molting\n";

        chickens.forEach(chicken => {

            if (chicken !== null) {

                csv +=
                    `${chicken.id},` +
                    `${chicken.name},` +
                    `${chicken.color},` +
                    `${chicken.molting}\n`;
            }
        });

        fs.writeFileSync("chickens.csv", csv);
    }

    static saveAsJSON(chickens) {

        const validChickens =
            chickens.filter(chicken => chicken !== null);

        fs.writeFileSync(
            "chickens.json",
            JSON.stringify(validChickens, null, 4)
        );
    }
}

module.exports = ChickenFileManager;