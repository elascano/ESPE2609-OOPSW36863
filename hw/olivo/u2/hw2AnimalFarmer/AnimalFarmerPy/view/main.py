from datetime import datetime
from pathlib import Path
import json
import sys

root_path = Path(__file__).resolve().parent.parent
sys.path.append(str(root_path))

from model.chicken import Chicken
from model.farm_animal import FarmAnimal
from model.cow import Cow
from model.sheep import Sheep
from model.pig import Pig
from model.food import Food
from model.medicine import Medicine
from model.medicine_record import MedicineRecord

DATA_FILE = "farm_data.json"

def main():
    animal_farmer, food_inventory = load_data_from_file()
    controller = True
    while controller:
        print("\n\tMenu Animal Farmer")
        print("=========================================")
        print("1. View Farmer Animals")
        print("2. Add New Farmer Animal")
        print("3. View Type Object (Animal Counts)")
        print("4. Add Medicine Record")
        print("5. Add Type Food")
        print("6. View Animal Medical History")
        print("0. Exit & Save")
        print("=========================================")
        
        option = validate_option_menu()
        
        if option == 1:
            view_animal_farmer(animal_farmer)
        elif option == 2:
            select_animal_farmer(animal_farmer)
        elif option == 3:
            view_type_object(animal_farmer)
        elif option == 4:
            add_medicine_record_menu(animal_farmer)
        elif option == 5:
            add_type_food_menu(food_inventory, animal_farmer)
        elif option == 6:
            view_animal_medical_history(animal_farmer)
        elif option == 0:
            save_data_to_file(animal_farmer, food_inventory)
            print("\nData saved successfully. Exiting program. Goodbye!")
            controller = False
        else:
            print("\nInvalid option. Please choose between 0 and 6.")

def validate_option_menu() -> int:
    while True:
        try:
            return int(input("Select the Option: "))
        except ValueError:
            input("Select The Correct Option. Press Enter to continue...")



def save_data_to_file(animal_farmer: list, food_inventory: list):
    data = {
        "food_inventory": [{"name": f.get_name()} for f in food_inventory],
        "animals": []
    }
    
    for animal in animal_farmer:
        animal_dict = {
            "type": type(animal).__name__,
            "breed": animal.get_breed(),
            "born_on_date": animal.get_born_on_date().strftime('%d-%m-%Y') if animal.get_born_on_date() else None,
            "weight_in_kg": animal.get_weight_in_kg(),
            "sex": animal.get_sex(),
            "is_meat": animal.get_is_meat(),
            "medicines_record": []
        }
        

        for record in animal.get_medicines_record():
            meds_list = []
            for med in record.get_medicine():
                meds_list.append({
                    "name": med.get_name(),
                    "description": med.get_description(),
                    "price": med.get_price()
                })
            animal_dict["medicines_record"].append({
                "date": record.get_date().strftime('%d-%m-%Y') if record.get_date() else None,
                "medicines": meds_list
            })
            

        if isinstance(animal, Chicken):
            animal_dict["is_molting"] = animal.get_is_molting()
            animal_dict["number_of_laid_eggs"] = animal.get_number_of_laid_eggs()
            animal_dict["type_chicken"] = animal.get_type_chicken()
        elif isinstance(animal, Cow):
            animal_dict["pregnant"] = animal.get_pregnant()
            animal_dict["is_producing_milk"] = animal.get_is_producing_milk()
            animal_dict["liters_of_milk_per_week"] = animal.get_liters_of_milk_per_week()
        elif isinstance(animal, Sheep):
            animal_dict["pregnant"] = animal.get_pregnant()
            animal_dict["last_shearing"] = animal.get_last_shearing().strftime('%d-%m-%Y') if animal.get_last_shearing() else None
        elif isinstance(animal, Pig):
            animal_dict["pregnant"] = animal.get_pregnant()
            animal_dict["is_market_ready"] = animal.get_is_market_ready()
            
        data["animals"].append(animal_dict)
        
    try:
        with open(DATA_FILE, "w") as f:
            json.dump(data, f, indent=4)
    except Exception as e:
        print(f"[Error saving data]: {e}")

def load_data_from_file() -> tuple[list, list]:
    animal_farmer = []
    food_inventory = []
    
    if not Path(DATA_FILE).exists():
        return animal_farmer, food_inventory
        
    try:
        with open(DATA_FILE, "r") as f:
            data = json.load(f)
            
        for f_data in data.get("food_inventory", []):
            food_inventory.append(Food(name=f_data["name"]))
            
        for a_data in data.get("animals", []):
            born_date = datetime.strptime(a_data["born_on_date"], '%d-%m-%Y') if a_data["born_on_date"] else datetime.now()

            med_records = []
            for r_data in a_data.get("medicines_record", []):
                r_date = datetime.strptime(r_data["date"], '%d-%m-%Y') if r_data["date"] else datetime.now()
                meds = [Medicine(name=m["name"], description=m["description"], price=m["price"]) for m in r_data["medicines"]]
                med_records.append(MedicineRecord(medicine=meds, date=r_date))
                
            animal_type = a_data["type"]
            if animal_type == "Chicken":
                animal = Chicken(
                    is_molting=a_data["is_molting"],
                    number_of_laid_eggs=a_data["number_of_laid_eggs"],
                    type_chicken=a_data["type_chicken"],
                    breed=a_data["breed"],
                    born_on_date=born_date,
                    weight_in_kg=a_data["weight_in_kg"],
                    sex=a_data["sex"],
                    medicines_record=med_records,
                    is_meat=a_data["is_meat"]
                )
            elif animal_type == "Cow":
                animal = Cow(
                    is_producing_milk=a_data["is_producing_milk"],
                    liters_of_milk_per_week=a_data["liters_of_milk_per_week"],
                    pregnant=a_data["pregnant"],
                    breed=a_data["breed"],
                    born_on_date=born_date,
                    weight_in_kg=a_data["weight_in_kg"],
                    sex=a_data["sex"],
                    medicines_record=med_records,
                    is_meat=a_data["is_meat"]
                )
            elif animal_type == "Sheep":
                last_shearing = datetime.strptime(a_data["last_shearing"], '%d-%m-%Y') if a_data["last_shearing"] else born_date
                animal = Sheep(
                    last_shearing=last_shearing,
                    pregnant=a_data["pregnant"],
                    breed=a_data["breed"],
                    born_on_date=born_date,
                    weight_in_kg=a_data["weight_in_kg"],
                    sex=a_data["sex"],
                    medicines_record=med_records,
                    is_meat=a_data["is_meat"]
                )
            elif animal_type == "Pig":
                animal = Pig(
                    is_market_ready=a_data["is_market_ready"],
                    pregnant=a_data["pregnant"],
                    breed=a_data["breed"],
                    born_on_date=born_date,
                    weight_in_kg=a_data["weight_in_kg"],
                    sex=a_data["sex"],
                    medicines_record=med_records,
                    is_meat=a_data["is_meat"]
                )
            else:
                continue
                
            animal_farmer.append(animal)
        print(f"[Info] Loaded {len(animal_farmer)} animals and {len(food_inventory)} food types from {DATA_FILE}.")
    except Exception as e:
        print(f"[Error loading data]: {e}")
        
    return animal_farmer, food_inventory


def get_yes_no_input(prompt: str) -> bool:
    return input(f"{prompt} (y/n): ").strip().lower() == 'y'

def get_birth_date() -> datetime:
    print("\n--- Enter Birth Date ---")
    while True:
        try:
            day = int(input("Day (1-31): "))
            month = int(input("Month (1-12): "))
            year = int(input("Year (e.g., 2026): "))
            return datetime(year, month, day)
        except ValueError:
            print("[Error] Invalid date values. Please try again.")

def get_common_animal_details():
    print("\n--- Enter Common Animal Details ---")
    breed = input("Breed: ").strip()
    weight = float(input("Weight in kg: "))
    sex = input("Sex (M/F): ").strip()
    is_meat = get_yes_no_input("Is meat animal?")
    born_date = get_birth_date()
    return breed, weight, sex, is_meat, born_date

def find_animal_by_id(animal_farmer: list, animal_id: int) -> FarmAnimal | None:
    for animal in animal_farmer:
        if animal.get_id() == animal_id:
            return animal
    return None

def create_chicken(breed, weight, sex, is_meat, born_date):
    is_molting = get_yes_no_input("Is molting?")
    eggs = int(input("Number of laid eggs: "))
    chicken_type = input("Type of chicken (e.g., broiler, layer): ").strip()
    return Chicken(
        is_molting=is_molting, number_of_laid_eggs=eggs, type_chicken=chicken_type,
        breed=breed, born_on_date=born_date, weight_in_kg=weight, sex=sex,
        medicines_record=[], is_meat=is_meat
    )

def create_cow(breed, weight, sex, is_meat, born_date):
    pregnant = get_yes_no_input("Is pregnant?")
    is_milk = get_yes_no_input("Is producing milk?")
    milk_liters = float(input("Liters of milk per week: "))
    return Cow(
        is_producing_milk=is_milk, liters_of_milk_per_week=milk_liters, pregnant=pregnant,
        breed=breed, born_on_date=born_date, weight_in_kg=weight, sex=sex,
        medicines_record=[], is_meat=is_meat
    )

def create_sheep(breed, weight, sex, is_meat, born_date):
    pregnant = get_yes_no_input("Is pregnant?")
    return Sheep(
        last_shearing=born_date, pregnant=pregnant, breed=breed, born_on_date=born_date,
        weight_in_kg=weight, sex=sex, medicines_record=[], is_meat=is_meat
    )

def create_pig(breed, weight, sex, is_meat, born_date):
    pregnant = get_yes_no_input("Is pregnant?")
    market_ready = get_yes_no_input("Is market ready?")
    return Pig(
        is_market_ready=market_ready, pregnant=pregnant, breed=breed, born_on_date=born_date,
        weight_in_kg=weight, sex=sex, medicines_record=[], is_meat=is_meat
    )

def view_animal_farmer(animal_farmer: list):
    if not animal_farmer:
        print("\n[Info] No animals registered in the farm yet.")
        return
    print("\n--- List of Farm Animals ---")
    for animal in animal_farmer:
        print(animal)

def select_animal_farmer(animal_farmer: list):
    print("=========================================")
    print("1. Add Chicken")
    print("2. Add Cow")
    print("3. Add Sheep")
    print("4. Add Pig")
    print("=========================================")
    option = validate_option_menu()
    
    try:
        if option in [1, 2, 3, 4]:
            breed, weight, sex, is_meat, born_date = get_common_animal_details()
            
            if option == 1:
                new_animal = create_chicken(breed, weight, sex, is_meat, born_date)
            elif option == 2:
                new_animal = create_cow(breed, weight, sex, is_meat, born_date)
            elif option == 3:
                new_animal = create_sheep(breed, weight, sex, is_meat, born_date)
            elif option == 4:
                new_animal = create_pig(breed, weight, sex, is_meat, born_date)

            animal_farmer.append(new_animal)
            print("\nSuccessfully added new animal to the farm!")
        else:
            print("\n[Error] Invalid animal choice.")
    except ValueError:
        print("\n[Error] Invalid input format. Animal creation cancelled.")

def view_type_object(animal_farmer: list):
    if not animal_farmer:
        print("\n[Info] No animals registered to count.")
        return
    
    chickens = sum(1 for a in animal_farmer if isinstance(a, Chicken))
    cows = sum(1 for a in animal_farmer if isinstance(a, Cow))
    sheep = sum(1 for a in animal_farmer if isinstance(a, Sheep))
    pigs = sum(1 for a in animal_farmer if isinstance(a, Pig))
    
    print("\n--- Farm Animal Type Summary ---")
    print(f"Chickens: {chickens}")
    print(f"Cows: {cows}")
    print(f"Sheep: {sheep}")
    print(f"Pigs: {pigs}")
    print(f"Total Animals: {len(animal_farmer)}")

def add_medicine_record_menu(animal_farmer: list):
    if not animal_farmer:
        print("\n[Info] No animals registered. Add an animal first.")
        return

    view_animal_farmer(animal_farmer)
    try:
        animal_id = int(input("\nEnter the ID of the animal to add medicine record: "))
        animal = find_animal_by_id(animal_farmer, animal_id)
        if not animal:
            print(f"\n[Error] No animal found with ID {animal_id}.")
            return

        print("\n--- Enter Medicine Details ---")
        med_name = input("Medicine Name: ").strip()
        med_desc = input("Description: ").strip()
        med_price = float(input("Price: "))

        new_med = Medicine(name=med_name, description=med_desc, price=med_price)
        today = datetime.now()
        new_record = MedicineRecord(medicine=[new_med], date=today)

        animal.get_medicines_record().append(new_record)
        new_med.administer()
        next_date = animal.compute_next_medicine_date(today)
        print(f"[Success] Medicine record added! Next scheduled medicine date: {next_date.strftime('%d-%m-%Y')}")
    except ValueError:
        print("\n[Error] Invalid input format. Operation cancelled.")

def add_type_food_menu(food_inventory: list, animal_farmer: list):
    print("\n--- Add New Food Type ---")
    food_name = input("Enter food name (e.g., Corn, Hay, Pellets): ").strip()
    if not food_name:
        print("[Error] Food name cannot be empty.")
        return

    new_food = Food(name=food_name)
    food_inventory.append(new_food)
    print(f"[Success] Added food: {new_food}")

    if animal_farmer and get_yes_no_input("Do you want to feed an animal with this food now?"):
        view_animal_farmer(animal_farmer)
        try:
            animal_id = int(input("Enter the ID of the animal to feed: "))
            animal = find_animal_by_id(animal_farmer, animal_id)
            if not animal:
                print(f"\n[Error] No animal found with ID {animal_id}.")
                return
            amount = float(input("Amount of food in kg: "))
            animal.feed(new_food, amount)
        except ValueError:
            print("[Error] Invalid input format.")

def view_animal_medical_history(animal_farmer: list):
    if not animal_farmer:
        print("\n[Info] No animals registered in the farm yet.")
        return

    view_animal_farmer(animal_farmer)
    try:
        animal_id = int(input("\nEnter the ID of the animal to view its medical history: "))
        animal = find_animal_by_id(animal_farmer, animal_id)
        
        if not animal:
            print(f"\n[Error] No animal found with ID {animal_id}.")
            return

        print(f"\n--- Medical History for Animal ID: {animal.get_id()} ({type(animal).__name__}) ---")
        records = animal.get_medicines_record()
        
        if not records:
            print("This animal has no medical records registered.")
            return

        for record in records:
            date_str = record.get_date().strftime('%d-%m-%Y') if record.get_date() else "N/A"
            print(f"\nRecord ID: {record.get_id()} | Date: {date_str}")
            print("Medicines administered:")
            for med in record.get_medicine():
                print(f"  - Name: {med.get_name()} | Description: {med.get_description()} | Price: ${med.get_price()}")
                
    except ValueError:
        print("\n[Error] Invalid input format. Please enter a valid numeric ID.")

if __name__ == "__main__":
    main()