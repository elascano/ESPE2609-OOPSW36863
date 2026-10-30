from datetime import date

from ec.edu.espe.chickenfarm.controller.chicken_farm_csv_controller import ChickenFarmCsvController
from ec.edu.espe.chickenfarm.controller.chicken_farm_json_controller import ChickenFarmJsonController
from ec.edu.espe.chickenfarm.model.chicken import Chicken
from ec.edu.espe.chickenfarm.model.chicken_coop import ChickenCoop
from ec.edu.espe.chickenfarm.model.chicken_farmer import ChickenFarmer

json_controller = ChickenFarmJsonController()
csv_controller = ChickenFarmCsvController()

chicken_farmer = ChickenFarmer(1, "Mateo", [None] * 10)


def ask_text(message):
    return input(message).strip()


def ask_int(message):
    while True:
        try:
            return int(ask_text(message))
        except ValueError:
            print("Enter a whole number.")


def ask_date(message):
    while True:
        try:
            return date.fromisoformat(ask_text(message))
        except ValueError:
            print("Invalid date. Use the format YYYY-MM-DD, for example 2024-09-15.")


def ask_yes_no(message):
    while True:
        text = ask_text(message + " (y/n): ").lower()
        if text == "y":
            return True
        if text == "n":
            return False
        print("Enter y or n.")


def ask_file_name(default_name):
    text = ask_text(f'File name (press Enter for "{default_name}"): ')
    return default_name if text == "" else text


# ---------- Functions to search ----------
def find_coop(coop_id):
    for coop in chicken_farmer.coops:
        if coop is not None and coop.chicken_coop_id == coop_id:
            return coop
    return None


def find_chicken(coop, chicken_id):
    for chicken in coop.chickens:
        if chicken is not None and chicken.id == chicken_id:
            return chicken
    return None


def ask_existing_coop():
    coop = find_coop(ask_int("Coop id: "))
    if coop is None:
        print("There is no coop with that id.")
    return coop


def restore_indexes():
    chicken_farmer.reset_iteration()
    while chicken_farmer.next() is not None:
        pass
    for coop in chicken_farmer.coops:
        if coop is not None:
            coop.reset_iteration()
            while coop.next() is not None:
                pass


def add_coop():
    coop_id = ask_int("New coop id: ")
    if find_coop(coop_id) is not None:
        print("A coop with that id already exists.")
        return
    chicken_farmer.add(ChickenCoop(coop_id, [None] * 10))


def remove_coop():
    coop = ask_existing_coop()
    if coop is not None:
        chicken_farmer.remove(coop.chicken_coop_id)
        print("Coop removed.")


def add_chicken():
    coop = ask_existing_coop()
    if coop is None:
        return

    chicken_id = ask_int("Chicken id: ")
    if find_chicken(coop, chicken_id) is not None:
        print("A chicken with that id already exists in this coop.")
        return
    name = ask_text("Name: ")
    color = ask_text("Color: ")
    born_on_date = ask_date("Date of birth (YYYY-MM-DD): ")
    molting = ask_yes_no("Is it molting?")

    coop.add(Chicken(chicken_id, name, color, born_on_date, molting))


def remove_chicken():
    coop = ask_existing_coop()
    if coop is None:
        return

    chicken_id = ask_int("Chicken id: ")
    if find_chicken(coop, chicken_id) is None:
        print("There is no chicken with that id in this coop.")
        return
    coop.remove(chicken_id)
    print("Chicken removed.")


def show_farm():
    print(f"\nFarm of {chicken_farmer.name} (id {chicken_farmer.chicken_farmer_id})")

    coop_count = 0
    chicken_farmer.reset_iteration()
    coop = chicken_farmer.next()
    while coop is not None:
        coop_count += 1
        print(f"  Coop {coop.chicken_coop_id}")

        chicken_count = 0
        coop.reset_iteration()
        chicken = coop.next()
        while chicken is not None:
            chicken_count += 1
            print(f"    - [{chicken.id}] {chicken.name} | {chicken.color} | born {chicken.born_on_date}"
                  f" | age {chicken.compute_age_in_years()} | molting: {'yes' if chicken.molting else 'no'}")
            chicken = coop.next()
        if chicken_count == 0:
            print("    (no chickens)")

        coop = chicken_farmer.next()
    if coop_count == 0:
        print("  (no coops)")


def make_chicken_do_stuff():
    coop = ask_existing_coop()
    if coop is None:
        return

    chicken = find_chicken(coop, ask_int("Chicken id: "))
    if chicken is None:
        print("There is no chicken with that id in this coop.")
        return
    chicken.do_stuff()


def save_file(save_method, default_name):
    save_method(chicken_farmer, ask_file_name(default_name))


def load_file(load_method, default_name):
    global chicken_farmer
    loaded = load_method(ask_file_name(default_name))
    if loaded is not None:
        chicken_farmer = loaded
        restore_indexes()
        print("Farm loaded successfully.")


def show_menu():
    print("\n========== CHICKEN FARM ==========")
    print(" 1. Add coop")
    print(" 2. Remove coop")
    print(" 3. Add chicken to a coop")
    print(" 4. Remove chicken from a coop")
    print(" 5. View the farm")
    print(" 6. Make a chicken do its stuff")
    print(" 7. Save to JSON")
    print(" 8. Load from JSON")
    print(" 9. Save to CSV")
    print("10. Load from CSV")
    print(" 0. Exit")


def main():
    print("Mateo Dominguez´s Chicken Farm")

    actions = {
        1: add_coop,
        2: remove_coop,
        3: add_chicken,
        4: remove_chicken,
        5: show_farm,
        6: make_chicken_do_stuff,
        7: lambda: save_file(json_controller.save_to_json, "chickenfarm.json"),
        8: lambda: load_file(json_controller.load_from_json, "chickenfarm.json"),
        9: lambda: save_file(csv_controller.save_to_csv, "chickenfarm.csv"),
        10: lambda: load_file(csv_controller.load_from_csv, "chickenfarm.csv"),
    }

    option = -1
    while option != 0:
        show_menu()
        option = ask_int("Choose an option: ")

        if option == 0:
            print("Goodbye!")
        elif option in actions:
            actions[option]()
        else:
            print("Invalid option.")


if __name__ == "__main__":
    try:
        main()
    except (EOFError, KeyboardInterrupt):
        print("\nProgram ended.")
