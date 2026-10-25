import json
import os
from datetime import date
from model.Chicken import Chicken

class JsonManager:
    FILE_PATH = "chickens.json"

    @staticmethod
    def save_chickens(chickens):
        chicken_data = []
        for c in chickens:
            if c is not None:
                chicken_dict = {
                    "id": c.id,
                    "name": c.name,
                    "color": c.color,
                    "born_on_date": c.born_on_date.isoformat(),#toString
                    "molting": c.molting
                }
                chicken_data.append(chicken_dict)

        try:
            with open(JsonManager.FILE_PATH, 'w') as file:
                json.dump(chicken_data, file, indent=4)
            print(f"\n[OK] Data successfully saved in: {JsonManager.FILE_PATH}")
        except Exception as e:
            print(f"\n[ERROR] The file could not be saved: {e}")

    @staticmethod
    def load_chickens():
        chickens_list = []
        
        if not os.path.exists(JsonManager.FILE_PATH):
            print("\n[AVISO] No previous file was found, creating a new empty list.")
            return chickens_list 

        try:
            with open(JsonManager.FILE_PATH, 'r') as file:
                chicken_data = json.load(file)
                

                for c_dict in chicken_data:
      
                    year, month, day = map(int, c_dict["born_on_date"].split('-'))
                    
                    chicken = Chicken(
                        id=c_dict["id"],
                        name=c_dict["name"],
                        color=c_dict["color"],
                        born_on_date=date(year, month, day),
                        molting=c_dict["molting"]
                    )
                    chickens_list.append(chicken)
            return chickens_list
            
        except Exception as e:
            print(f"\n An error occurred: {e}")
            return []