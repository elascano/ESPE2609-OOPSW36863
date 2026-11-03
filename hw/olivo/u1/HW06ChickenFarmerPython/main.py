import json
import os
from ChickenFarmer import ChickenFarmer
from ChickenCoop import ChickenCoop
from Chicken import Chicken

DB_FILE = "farm_data.json"


def save_data(farmers):
    data = [farmer.to_dict() for farmer in farmers]
    try:
        with open(DB_FILE, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4, ensure_ascii=False)
        print("Data successfully saved to JSON!")
    except Exception as e:
        print(f"Error saving data: {e}")


def load_data():
    if not os.path.exists(DB_FILE):
        return []
    try:
        with open(DB_FILE, "r", encoding="utf-8") as f:
            data = json.load(f)
            farmers = [ChickenFarmer.from_dict(f_data) for f_data in data]
            print(f"Data successfully loaded from {DB_FILE}!")
            return farmers
    except Exception as e:
        print(f"Error loading data: {e}")
        return []


def view_chickens_farmers(farmers):
    if not farmers:
        print("No chicken farmers registered yet.")
    else:
        print("\n--- Registered Farmers ---")
        for i, farmer in enumerate(farmers, start=1):
            print(f"{i}. {farmer}")


def validate_options(mensaje="Choose an option: "):
    try:
        opc = int(input(mensaje))
        return opc
    except ValueError:
        print("Please enter a valid number.")
        return None


def select_farmer(farmers):
    if not farmers:
        print("No chicken farmers registered yet.")
        return None
    print("\n--- Select Farmer ---")
    view_chickens_farmers(farmers)
    selection = validate_options("Enter the number of the farmer: ")

    if selection is not None and 1 <= selection <= len(farmers):
        return farmers[selection - 1]
    print("Invalid farmer selection.")
    return None


def select_coop(farmer):
    if not farmer.coops:
        print(f"Farmer {farmer.name} has no coops yet.")
        return None

    print(f"\n--- Select Coop for {farmer.name} ---")
    for i, coop in enumerate(farmer.coops, start=1):
        print(f"{i}. Coop ID: {coop.id} (Total chickens: {len(coop.chickens)})")

    coop_idx = validate_options("Enter the number of the coop: ")
    if coop_idx is not None and 1 <= coop_idx <= len(farmer.coops):
        return farmer.coops[coop_idx - 1]

    print("Invalid coop selection.")
    return None


def view_chickens_in_coop(coop):
    if not coop.chickens:
        print(f"Coop #{coop.id} has no chickens yet.")
    else:
        print(f"\n--- Chickens in Coop #{coop.id} ---")
        for i, chicken in enumerate(coop.chickens, start=1):
            print(f"{i}. {chicken}")


def main():
    farmers = load_data()

    while True:
        print("\n=================Chicken Farmer App====================")
        print("1. Add Chicken Farmer")
        print("2. View Chicken Farmers")
        print("3. Add Coops")
        print("4. Add chickens to the Chicken Coop")
        print("5. View chickens in a Chicken Coop")
        print("6. Exit")
        print("========================================================")

        opc = validate_options()
        if opc is None:
            continue

        match opc:
            case 1:
                name = input("Enter your name: ")
                new_farmer = ChickenFarmer(name)
                farmers.append(new_farmer)
                print(f"Chicken Farmer '{name}' added successfully!")

            case 2:
                view_chickens_farmers(farmers)

            case 3:
                print("Add Coops from Chicken Farmer")
                farmer_selection = select_farmer(farmers)
                if farmer_selection is not None:
                    new_coop = ChickenCoop()
                    farmer_selection.add_coop(new_coop)
                    print(f"Coop successfully added to farmer {farmer_selection.name}!")

            case 4:
                print("Add Chickens to a Chicken Coop")
                farmer_selection = select_farmer(farmers)

                if farmer_selection is not None:
                    if not farmer_selection.coops:
                        print(f"Farmer {farmer_selection.name} has no coops yet. Please add a coop first (Option 3).")
                    else:
                        coop_selection = select_coop(farmer_selection)
                        if coop_selection is not None:
                            print("\n--- Enter Chicken Details ---")
                            name = input("Chicken name: ")
                            color = input("Chicken color: ")
                            born_on_date = input("Born on date (YYYY-MM-DD): ")
                            molting_input = input("Is it molting? (y/n): ").lower()
                            molting = True if molting_input == 'y' else False
                            new_chicken = Chicken(name, color, born_on_date, molting)
                            coop_selection.add_chicken(new_chicken)
                            print(f"Chicken '{name}' successfully added to Coop #{coop_selection.id}!")

            case 5:
                print("View Chickens in a Coop")
                farmer_selection = select_farmer(farmers)
                if farmer_selection is not None:
                    coop_selection = select_coop(farmer_selection)
                    if coop_selection is not None:
                        view_chickens_in_coop(coop_selection)

            case 6:
                save_data(farmers)
                print("Exiting application. Goodbye!")
                break

            case _:
                print("Invalid option. Please choose between 1 and 6.")


if __name__ == "__main__":
    main()