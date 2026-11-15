import json
import os
from models.truck_model import Truck
from views.truck_view import TruckView

class TruckController:
    def __init__(self):
        self.file_path = 'data/trucks_data.json'
        self.view = TruckView()
        self.truck_list = self.load_from_json()

    def load_from_json(self):
        if not os.path.exists(self.file_path):
            return []
        with open(self.file_path, 'r', encoding='utf-8') as file:
            try:
                data = json.load(file)
                return [Truck.from_dictionary(item) for item in data]
            except json.JSONDecodeError:
                return []

    def save_to_json(self):
        os.makedirs(os.path.dirname(self.file_path), exist_ok=True)
        with open(self.file_path, 'w', encoding='utf-8') as file:
            json.dump([truck.to_dictionary() for truck in self.truck_list], file, indent=4)

    def start(self):
        while True:
            option = self.view.show_main_menu()
            if option == '1':
                t_id, brand, year, load = self.view.capture_truck_data()
                new_truck = Truck(t_id, brand, year, load)
                self.truck_list.append(new_truck)
                self.save_to_json()
                print("-> Truck saved successfully.")
            elif option == '2':
                self.view.display_trucks(self.truck_list)
            elif option == '3':
                print("Closing the system...")
                break
            else:
                print("Invalid option. Please try again.")