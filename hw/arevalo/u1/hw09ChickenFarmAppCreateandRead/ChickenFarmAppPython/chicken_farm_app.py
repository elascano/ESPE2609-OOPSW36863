import os
import sys
from datetime import datetime
from chicken import Chicken
from chicken_coop import ChickenCoop
from json_storage import JsonStorage


class ChickenFarmApp:
    @staticmethod
    def main() -> None:
        jsonFilePath = os.path.abspath("chickens.json")
        csvFilePath = os.path.abspath("chickens.csv")
        print(f"JSON file path: {jsonFilePath}")
        print(f"CSV file path: {csvFilePath}")

        coop = ChickenCoop(1)

        try:
            JsonStorage.loadChickens(coop, jsonFilePath, csvFilePath)
        except Exception as e:
            print(f"Error: Invalid data in storage file ({e}). Terminating without overwriting.")
            sys.exit(1)

        while True:
            print("\n--- Chicken Farm App ---")
            print("1. Add a chicken")
            print("2. Remove a chicken")
            print("3. Find a chicken by ID")
            print("4. Make a chicken do actions")
            print("5. Show all chickens")
            print("6. Exit")
            option = input("Select an option: ").strip()

            if option == "1":
                if len(coop.chickens) >= ChickenCoop.MAX_CHICKENS:
                    print(f"Cannot add more chickens. Limit of {ChickenCoop.MAX_CHICKENS} reached.")
                    continue
                try:
                    idStr = input("chicken ID: ").strip()
                    chickenId = int(idStr)
                    if coop.findById(chickenId) is not None:
                        print("Error: A chicken with that ID already exists.")
                        continue
                    name = input("name: ").strip()
                    if not name:
                        print("Error: Name cannot be empty.")
                        continue
                    color = input("Enter chicken color: ").strip()
                    if not color:
                        print("Error: Color cannot be empty.")
                        continue
                    bornOnDateStr = input("Enter born on date (YYYY-MM-DD): ").strip()
                    bornOnDate = datetime.strptime(bornOnDateStr, "%Y-%m-%d").date()
                    moltingInput = input("Is the chicken molting? (true/false): ").strip().lower()
                    if moltingInput not in ("true", "false"):
                        print("Error: Please enter 'true' or 'false'.")
                        continue
                    molting = moltingInput == "true"

                    newChicken = Chicken(chickenId, name, color, bornOnDate, molting)
                    if coop.add(newChicken):
                        JsonStorage.saveChickens(coop, jsonFilePath, csvFilePath)
                        print("Chicken added and saved.")
                except ValueError:
                    print("Error: Invalid input format. Please check ID or date (YYYY-MM-DD).")

            elif option == "2":
                try:
                    chickenId = int(input("Enter chicken ID to remove: ").strip())
                    if coop.remove(chickenId):
                        JsonStorage.saveChickens(coop, jsonFilePath, csvFilePath)
                        print("Chicken removed and changes saved.")
                    else:
                        print(f"No chicken found with ID {chickenId}.")
                except ValueError:
                    print("Error: Invalid ID.")

            elif option == "3":
                try:
                    chickenId = int(input("Enter chicken ID to find: ").strip())
                    chicken = coop.findById(chickenId)
                    if chicken is not None:
                        print(chicken)
                    else:
                        print(f"No chicken found with ID {chickenId}.")
                except ValueError:
                    print("Error: Invalid ID.")

            elif option == "4":
                try:
                    chickenId = int(input("Enter chicken ID to perform actions: ").strip())
                    chicken = coop.findById(chickenId)
                    if chicken is not None:
                        chicken.doStuff(1)
                    else:
                        print(f"No chicken found with ID {chickenId}.")
                except ValueError:
                    print("Error: Invalid ID.")

            elif option == "5":
                if not coop.chickens:
                    print("The chicken coop is empty.")
                else:
                    print(f"Chickens in coop ({len(coop.chickens)}/{ChickenCoop.MAX_CHICKENS}):")
                    for chicken in coop.chickens:
                        print(chicken)

            elif option == "6":
                print("Exiting Chicken Farm App...")
                break
            else:
                print("Invalid option. Please try again.")