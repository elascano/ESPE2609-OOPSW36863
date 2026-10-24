import json
import csv
import os
from datetime import date


# ==============================================================================
# MODEL CLASSES
# ==============================================================================

class Egg:
    def __init__(self, egg_id: int, size: str):
        self.id = egg_id
        self.size = size

    def __str__(self):
        return f"Egg{{id={self.id}, size='{self.size}'}}"


class Poop:
    def __init__(self, poop_id: int, color: str, consistency: str):
        self.id = poop_id
        self.color = color
        self.consistency = consistency

    def __str__(self):
        return f"Poop{{id={self.id}, color='{self.color}', consistency='{self.consistency}'}}"


class Chicken:
    def __init__(self, chicken_id: int, name: str, color: str, born_on_date: date, age: int, molting: bool):
        self.id = chicken_id
        self.name = name
        self.color = color
        self.born_on_date = born_on_date
        self.age = age
        self.molting = molting

    def do_stuff(self):
        self._cluck()
        self._wander()
        self._eat()
        self._drink(13.0)
        self._poop()
        self._lay_an_egg()
        self.compute_age()

    def _cluck(self):
        print(f"The chicken {self.name} is clucking...")

    def _wander(self):
        print(f"The chicken {self.name} is wandering...")

    def _eat(self):
        print(f"The chicken {self.name} is eating...")

    def _drink(self, amount_of_water: float):
        print(f"The chicken {self.name} is drinking {amount_of_water} ml of water")

    def _poop(self) -> Poop:
        return Poop(1, "Brown", 'S')

    def _lay_an_egg(self) -> Egg:
        return Egg(1, 'M')

    def compute_age(self) -> int:
        if self.born_on_date is None:
            return 0
        today = date.today()
        self.age = today.year - self.born_on_date.year - (
            (today.month, today.day) < (self.born_on_date.month, self.born_on_date.day)
        )
        return self.age

    def to_dict(self):
        return {
            "id": self.id,
            "name": self.name,
            "color": self.color,
            "bornOnDate": self.born_on_date.isoformat(),
            "age": self.age,
            "molting": self.molting
        }

    def __str__(self):
        return (f"Chicken{{id={self.id}, name='{self.name}', color='{self.color}', "
                f"bornOnDate={self.born_on_date}, age={self.age}, molting={self.molting}}}")


class ChickenCoop:
    def __init__(self, coop_id: int):
        self.id = coop_id
        self.chickens = [None] * 10
        self.count = 0
        self.current_index = 0

    def add(self, chicken: Chicken):
        if chicken is not None and self.count < len(self.chickens):
            self.chickens[self.count] = chicken
            self.count += 1

    def remove(self, chicken_id: int):
        for i in range(self.count):
            if self.chickens[i].id == chicken_id:
                for j in range(i, self.count - 1):
                    self.chickens[j] = self.chickens[j + 1]
                self.chickens[self.count - 1] = None
                self.count -= 1
                break

    def reset_operation(self):
        self.current_index = 0

    def next(self) -> Chicken:
        if self.current_index < self.count:
            next_chicken = self.chickens[self.current_index]
            self.current_index += 1
            return next_chicken
        return None

    def __str__(self):
        return f"ChickenCoop{{id={self.id}, count={self.count}}}"


class ChickenFarmer:
    def __init__(self, farmer_id: int, name: str):
        self.id = farmer_id
        self.name = name
        self.coops = [None] * 2
        self.count = 0
        self.current_index = 0

    def add(self, coop: ChickenCoop):
        if coop is not None and self.count < len(self.coops):
            self.coops[self.count] = coop
            self.count += 1

    def remove(self, coop_id: int):
        for i in range(self.count):
            if self.coops[i].id == coop_id:
                for j in range(i, self.count - 1):
                    self.coops[j] = self.coops[j + 1]
                self.coops[self.count - 1] = None
                self.count -= 1
                break

    def reset_iteration(self):
        self.current_index = 0

    def next(self) -> ChickenCoop:
        if self.current_index < self.count:
            next_coop = self.coops[self.current_index]
            self.current_index += 1
            return next_coop
        return None

    def __str__(self):
        return f"ChickenFarmer{{id={self.id}, name='{self.name}', count={self.count}}}"


# ==============================================================================
# MAIN APP & PERSISTENCE LOGIC
# ==============================================================================

JSON_FILE = "chickens.json"
CSV_FILE = "chickens.csv"


def main():
    chicken = Chicken(1, "lucy", "yellow", date.today(), 1, True)
    chicken1 = Chicken(2, "ariel", "black", date.today(), 1, True)
    egg = Egg(1, 'M')
    poop = Poop(1, "brown", 'S')
    coop = ChickenCoop(101)
    farmer = ChickenFarmer(1, "Ariel Giler")
    chickens = [None] * 10

    while True:
        print("\n==========================================")
        print("   ARIEL GILER'S CHICKEN FARM SYSTEM     ")
        print("==========================================")
        print("1. Run Original Test Demo")
        print("2. Add Chickens and Save to Files (JSON / CSV)")
        print("3. Read Previously Saved Chickens")
        print("4. Exit")

        try:
            option = int(input("Select an option: "))
        except ValueError:
            print("Invalid input. Please enter a number.")
            continue

        if option == 1:
            run_original_demo(chicken, chicken1, egg, poop, coop, farmer, chickens)
        elif option == 2:
            add_and_save_chickens()
        elif option == 3:
            read_saved_chickens()
        elif option == 4:
            print("Exiting system...")
            break
        else:
            print("Invalid option. Please try again.")


def run_original_demo(chicken, chicken1, egg, poop, coop, farmer, chickens):
    print("\nAriel Giler's Chicken Farm")
    print("==========================")

    print(f"my chicken is --> {chicken.name}")
    print(f"egg --> ID: {egg.id} | Size: {egg.size}")
    print(f"egg size--> {egg.size}")
    print(f"poop --> ID: {poop.id} | Color: {poop.color} | Consistency: {poop.consistency}")
    print(f"my chicken is --> {chicken1.name}")

    chicken.do_stuff()

    local_age = chicken.compute_age()
    print(f"Chicken's age: {local_age}")

    chickens[0] = Chicken(1, "Pepita", "black", date.today(), 1, True)
    chickens[1] = chicken

    print("\nFirst loop:")
    for c in chickens:
        print(f"chickens ---> {c}")

    for i in range(len(chickens)):
        chickens[i] = Chicken(i + 1, f"chicken {i + 1}", "white", date.today(), 1, True)

    print("\nSecond loop (filled array):")
    for c in chickens:
        print(f"chickens ---> {c}")

    coop.add(chicken)
    coop.add(chicken1)

    farmer.add(coop)

    farmer.reset_iteration()
    current_coop = farmer.next()

    while current_coop is not None:
        print(f"Farmer {farmer.name} manages Coop ID: {current_coop.id}")

        current_coop.reset_operation()
        current_chicken = current_coop.next()

        while current_chicken is not None:
            print(f"  --> Chicken ID: {current_chicken.id} | Name: {current_chicken.name}")
            current_chicken = current_coop.next()

        current_coop = farmer.next()


def add_and_save_chickens():
    try:
        amount = int(input("\nHow many chickens do you want to enter?: "))
    except ValueError:
        print("Invalid number.")
        return

    if amount <= 0:
        print("Invalid amount.")
        return

    new_chickens_array = [None] * amount

    for i in range(amount):
        print(f"\n--- Entering Chicken #{i + 1} ---")
        chicken_id = int(input("ID: "))
        name = input("Name: ")
        color = input("Color: ")
        molting_input = input("Is molting? (true/false): ").strip().lower()
        molting = molting_input in ["true", "t", "1", "yes", "y"]

        born_on_date = date.today()

        new_chicken = Chicken(chicken_id, name, color, born_on_date, 0, molting)
        new_chicken.compute_age()
        new_chickens_array[i] = new_chicken

    save_to_json(new_chickens_array)
    save_to_csv(new_chickens_array)

    print("\nChickens saved successfully in JSON and CSV files!")


def save_to_json(chickens):
    data = [c.to_dict() for c in chickens if c is not None]
    try:
        with open(JSON_FILE, "w", encoding="utf-8") as f:
            json.dump(data, f, indent=4)
        print(f"-> JSON file created/updated: {JSON_FILE}")
    except Exception as e:
        print(f"Error saving JSON: {e}")


def save_to_csv(chickens):
    try:
        with open(CSV_FILE, "w", newline="", encoding="utf-8") as f:
            writer = csv.writer(f)
            writer.writerow(["id", "name", "color", "bornOnDate", "age", "molting"])
            for c in chickens:
                if c is not None:
                    writer.writerow([c.id, c.name, c.color, c.born_on_date.isoformat(), c.age, c.molting])
        print(f"-> CSV file created/updated: {CSV_FILE}")
    except Exception as e:
        print(f"Error saving CSV: {e}")


def read_saved_chickens():
    print("\n==========================================")
    print("      READING SAVED CHICKEN FILES         ")
    print("==========================================")

    print("\n--- CONTENT FROM JSON FILE ---")
    if os.path.exists(JSON_FILE):
        try:
            with open(JSON_FILE, "r", encoding="utf-8") as f:
                print(f.read())
        except Exception as e:
            print(f"Error reading JSON: {e}")
    else:
        print("JSON file does not exist yet.")

    print("\n--- CONTENT FROM CSV FILE ---")
    if os.path.exists(CSV_FILE):
        try:
            with open(CSV_FILE, "r", encoding="utf-8") as f:
                reader = csv.reader(f)
                next(reader, None)  # Omitir cabecera
                for row in reader:
                    if row:
                        print(f"ID: {row[0]} | Name: {row[1]} | Color: {row[2]} | Date: {row[3]} | Age: {row[4]} | Molting: {row[5]}")
        except Exception as e:
            print(f"Error reading CSV: {e}")
    else:
        print("CSV file does not exist yet.")


if __name__ == "__main__":
    main()