import json
import os
from chicken import Chicken

FILE_NAME = "chickens.json"

class JsonManager:

    @staticmethod
    def save_chicken_to_json(chicken):
        chickens_list = JsonManager.read_chicken_json_list()
        chickens_list.append(chicken.to_dict())

        try:
            with open(FILE_NAME, "w", encoding="utf-8") as file:
                json.dump(chickens_list, file, indent=4, ensure_ascii=False)
            print("--> Chicken saved to JSON file successfully.")
        except Exception as e:
            print(f"Error saving to JSON file: {e}")

    @staticmethod
    def read_chicken_json_list():
        if not os.path.exists(FILE_NAME):
            return []
        
        try:
            with open(FILE_NAME, "r", encoding="utf-8") as file:
                data = json.load(file)
                return data if data else []
        except Exception:
            return []

    @staticmethod
    def read_chicken_json():
        raw_data = JsonManager.read_chicken_json_list()
        print("\n--- JSON FILE CONTENT ---")
        if not raw_data:
            print("The JSON file is empty or does not exist.")
        else:
            for item in raw_data:
                print(f"Chicken --> ID: {item['id']} | Name: {item['name']} | Color: {item['color']} | Age: {item['ageInYears']} | Molting: {item['molting']}")
        print("-------------------------")