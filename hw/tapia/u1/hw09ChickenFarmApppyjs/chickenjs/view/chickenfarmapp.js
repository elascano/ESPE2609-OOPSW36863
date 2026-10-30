const readline =
    require("readline-sync");

const fs =
    require("fs");

const ChickenCoop =
    require("../model/chicken_coop");

const chickens =
    new Array(10).fill(null);

const chickenCoop =
    new ChickenCoop(
        chickens,
        1
    );

let option;

do {

    console.log(
        "\n=== CHICKEN FARM ==="
    );

    console.log(
        "1. Add Chicken"
    );

    console.log(
        "2. Remove Chicken"
    );

    console.log(
        "3. List Chickens"
    );

    console.log(
        "4. Exit"
    );

    option = parseInt(
        readline.question(
            "Option: "
        )
    );

    switch (option) {

        case 1:

            const name =
                readline.question(
                    "Name: "
                );

            const color =
                readline.question(
                    "Color: "
                );

            const year =
                parseInt(
                    readline.question(
                        "Year: "
                    )
                );

            const month =
                parseInt(
                    readline.question(
                        "Month: "
                    )
                );

            const day =
                parseInt(
                    readline.question(
                        "Day: "
                    )
                );

            const molting =
                readline.question(
                    "Molting (true/false): "
                ) === "true";

            const bornOnDate =
                new Date(
                    year,
                    month - 1,
                    day
                );

            chickenCoop.add(
                name,
                color,
                bornOnDate,
                molting
            );

            break;

        case 2:

            const chickenId =
                parseInt(
                    readline.question(
                        "Enter Chicken ID to remove: "
                    )
                );

            chickenCoop.remove(
                chickenId
            );

            break;

        case 3:

            try {

                const json =
                    fs.readFileSync(
                        "chickens.json",
                        "utf8"
                    );

                console.log(
                    "\n" + json
                );

            } catch {

                console.log(
                    "There is no JSON file yet."
                );
            }

            break;

        case 4:

            console.log(
                "Goodbye!"
            );

            break;

        default:

            console.log(
                "Invalid option"
            );
    }

} while (option !== 4);