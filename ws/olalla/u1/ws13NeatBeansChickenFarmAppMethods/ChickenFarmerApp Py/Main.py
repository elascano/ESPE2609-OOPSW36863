import os
from datetime import date

import file_manager
from chicken import Chicken
from chicken_coop import ChickenCoop
from chicken_farmer import ChickenFarmer
from helpers import read_int

# the files are saved in the same folder as this main.py
FOLDER = os.path.dirname(os.path.abspath(__file__))
JSON_FILE = os.path.join(FOLDER, "chickens.json")
CSV_FILE = os.path.join(FOLDER, "chickens.csv")


def show_menu():
    print("\n========= MENU =========")
    print("1. Register farmer, coops and chickens (keyboard)")
    print("2. Create a demo farmer (no typing)")
    print("3. Show the farmer")
    print("4. Save the chickens in JSON")
    print("5. Read the chickens from JSON")
    print("6. Save the chickens in CSV")
    print("7. Read the chickens from CSV")
    print("0. Exit")


def create_demo_farmer():
    # farmer with 2 coops and 3 chickens, ready to test the files
    farmer = ChickenFarmer(1, "Julian")

    coop1 = ChickenCoop(1)
    coop1.add(Chicken(1, "Lucy", "brown and white", date(2010, 8, 15), True))
    coop1.add(Chicken(2, "Maruja", 'black, with "spots"', date(2015, 12, 17), False))

    coop2 = ChickenCoop(2)
    coop2.add(Chicken(3, "Pepita", "black", date(2020, 3, 2), True))

    farmer.add(coop1)
    farmer.add(coop2)
    return farmer


def show_chickens(chickens):
    for number, chicken in enumerate(chickens, start=1):
        print(f"chicken {number} --> {chicken}")


def save_chickens(chickens, file_path, save_function):
    try:
        save_function(chickens, file_path)
        print(f"{len(chickens)} chickens saved in {file_path}")
    except OSError as error:
        print("The file could not be saved:", error)


def load_chickens(file_path, load_function):
    try:
        chickens = load_function(file_path)
        print(f"{len(chickens)} chickens read from {file_path}")
        return chickens
    except FileNotFoundError:
        print("The file does not exist yet, save it first")
    except (ValueError, KeyError, TypeError):
        print("The file has a wrong format or wrong data")
    return []


def main():
    print("Julian Olalla's Chicken Farm App")
    print("=================================")

    farmer = None
    option = ""

    while option != "0":
        show_menu()
        option = input("Choose an option: ").strip()

        if option == "1":
            farmer_id = read_int("Enter the farmer id: ")
            farmer_name = input("Enter the farmer name: ")
            farmer = ChickenFarmer(farmer_id, farmer_name)
            farmer.register_coops()
        elif option == "2":
            farmer = create_demo_farmer()
            print("Demo farmer created")
        elif option == "3":
            if farmer is None:
                print("First create a farmer (option 1 or 2)")
            else:
                print(farmer)
        elif option == "4":
            if farmer is None:
                print("First create a farmer (option 1 or 2)")
            else:
                save_chickens(farmer.get_all_chickens(), JSON_FILE, file_manager.save_json)
        elif option == "5":
            loaded_chickens = load_chickens(JSON_FILE, file_manager.load_json)
            show_chickens(loaded_chickens)
        elif option == "6":
            if farmer is None:
                print("First create a farmer (option 1 or 2)")
            else:
                save_chickens(farmer.get_all_chickens(), CSV_FILE, file_manager.save_csv)
        elif option == "7":
            loaded_chickens = load_chickens(CSV_FILE, file_manager.load_csv)
            show_chickens(loaded_chickens)
        elif option == "0":
            print("Bye!")
        else:
            print("Invalid option, try again")


main()