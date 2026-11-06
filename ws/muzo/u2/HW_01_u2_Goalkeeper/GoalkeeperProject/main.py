import json
from pathlib import Path
from goalkeeper import Goalkeeper

JSON_FILE = Path(__file__).with_name("goalkeepers.json")


def read_goalkeepers():
    """Read goalkeeper records from the JSON file into a Python list."""
    if not JSON_FILE.exists():
        return []

    try:
        with JSON_FILE.open("r", encoding="utf-8") as file:
            data = json.load(file)
        return [Goalkeeper.from_dict(item) for item in data]
    except (json.JSONDecodeError, KeyError, TypeError) as error:
        print(f"Error reading the JSON file: {error}")
        return []


def save_goalkeepers(goalkeepers):
    """Write the complete list of goalkeepers to the JSON file."""
    data = [goalkeeper.to_dict() for goalkeeper in goalkeepers]
    with JSON_FILE.open("w", encoding="utf-8") as file:
        json.dump(data, file, indent=4, ensure_ascii=False)


def create_goalkeeper(goalkeepers):
    print("\n--- Register goalkeeper ---")
    goalkeeper_id = input("ID: ").strip()

    if any(g.id == goalkeeper_id for g in goalkeepers):
        print("That ID already exists. Enter a different one..")
        return

    name = input("Name: ").strip()
    team = input("Equipment: ").strip()

    try:
        saves = int(input("Number of saves:"))
        if saves < 0:
            print("Saves cannot be negative..")
            return
    except ValueError:
        print("Enter a whole number for the saves.")
        return

    if not goalkeeper_id or not name or not team:
        print("All fields are mandatory.")
        return

    goalkeepers.append(Goalkeeper(goalkeeper_id, name, team, saves))
    save_goalkeepers(goalkeepers)
    print("Goalkeeper registered and saved to goalkeepers.json.")


def show_goalkeepers(goalkeepers):
    print("\n--- Goalkeepers kept in reserve ---")
    if not goalkeepers:
        print("There are no records.")
        return

    for goalkeeper in goalkeepers:
        print(goalkeeper)


def main():
    goalkeepers = read_goalkeepers()

    while True:
        print("\n===== GOALKEEPERS' MENU =====")
        print("1. Create archer")
        print("2. Create archer from JSON")
        print("3. Go out")

        option = input("Select an option: ").strip()

        if option == "1":
            create_goalkeeper(goalkeepers)
        elif option == "2":
            goalkeepers = read_goalkeepers()
            show_goalkeepers(goalkeepers)
        elif option == "3":
            print("Program completed.")
            break
        else:
            print("Invalid option.")


if __name__ == "__main__":
    main()
