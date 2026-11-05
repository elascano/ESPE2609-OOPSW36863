from datetime import date
from model.chicken_coop import ChickenCoop


def main():

    chickens = [None] * 10

    chicken_coop = ChickenCoop(
        chickens,
        1
    )

    while True:

        print("\n=== CHICKEN FARM ===")
        print("1. Add Chicken")
        print("2. Remove Chicken")
        print("3. List Chickens")
        print("4. Exit")

        option = int(
            input("Option: ")
        )

        if option == 1:

            name = input("Name: ")

            color = input("Color: ")

            year = int(
                input("Year: ")
            )

            month = int(
                input("Month: ")
            )

            day = int(
                input("Day: ")
            )

            molting = (
                    input(
                        "Molting (true/false): "
                    ).lower()
                    == "true"
            )

            born_on_date = date(
                year,
                month,
                day
            )

            chicken_coop.add(
                name,
                color,
                born_on_date,
                molting
            )

        elif option == 2:

            chicken_id = int(
                input(
                    "Enter Chicken ID to remove: "
                )
            )

            chicken_coop.remove(
                chicken_id
            )

        elif option == 3:

            try:

                with open(
                        "chickens.json",
                        "r",
                        encoding="utf-8"
                ) as file:

                    print(file.read())

            except FileNotFoundError:

                print(
                    "There is no JSON file yet."
                )

        elif option == 4:

            print("Goodbye!")
            break

        else:

            print("Invalid option")


if __name__ == "__main__":
    main()