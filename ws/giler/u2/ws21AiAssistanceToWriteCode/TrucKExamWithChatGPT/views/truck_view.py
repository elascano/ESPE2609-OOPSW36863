class TruckView:
    @staticmethod
    def show_main_menu():
        print("\n--- TRUCK SYSTEM MVC ---")
        print("1. Register new truck")
        print("2. List registered trucks")
        print("3. Exit")
        return input("Select an action: ")

    @staticmethod
    def capture_truck_data():
        print("\n[ Enter truck data ]")
        t_id = input("Truck ID: ")
        brand = input("Brand: ")
        year = input("Model Year: ")
        load = input("Max Load (tons): ")
        return t_id, brand, year, load

    @staticmethod
    def display_trucks(truck_list):
        print("\n[ Truck Inventory ]")
        if not truck_list:
            print("No records found in the JSON file.")
            return
        
        for truck in truck_list:
            print(f"ID: {truck.truck_id} | Brand: {truck.brand} | Year: {truck.model_year} | Load: {truck.max_load}t")