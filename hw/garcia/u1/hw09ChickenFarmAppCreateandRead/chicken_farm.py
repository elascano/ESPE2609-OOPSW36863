import json
import csv
from datetime import datetime

class Chicken:
    def __init__(self, chicken_id, name, color, born_year, molting):
        self.id = chicken_id
        self.name = name
        self.color = color
        self.born_year = born_year
        self.molting = molting
        self.age = self.compute_age_in_years()

    def compute_age_in_years(self):
        current_year = datetime.now().year
        age = current_year - self.born_year
        return age if age >= 0 else 0

    def to_dict(self):
        return {"ID": self.id, "Name": self.name, "Color": self.color, "Age": self.age, "Molting": self.molting}

    def __str__(self):
        return f"Chicken{{id={self.id}, name={self.name}, color={self.color}, age={self.age}, molting={self.molting}}}"

class ChickenCoop:
    def __init__(self, coop_id):
        self.coop_id = coop_id
        self.chickens = []
        self.current_index = 0

    def add(self, chicken):
        if len(self.chickens) < 10:
            self.chickens.append(chicken)
        else:
            print("Error: The chicken coop is completely full!")

    def remove(self, chicken_id):
        for i, c in enumerate(self.chickens):
            if c.id == chicken_id:
                del self.chickens[i]
                print(f"Chicken removed --> {chicken_id}")
                return
        print("Chicken not found")

    def reset_iteration(self):
        self.current_index = 0

    def next(self):
        if self.current_index < len(self.chickens):
            c = self.chickens[self.current_index]
            self.current_index += 1
            return c
        return None

def main():
    coop = ChickenCoop(1)
    coop.add(Chicken(2, "Maruja", "White", 1970, False))
    coop.add(Chicken(1, "Lucy", "Brown and white", datetime.now().year, True))
    
    while True:
        print("\n--- MAIN MENU ---")
        print("1. Add Chicken\n2. Remove Chicken\n3. List Chickens\n4. Save to CSV\n5. Save to JSON\n6. Exit")
        option = input("Select an option: ")

        if option == '1':
            id_val = int(input("ID: "))
            name = input("Name: ")
            color = input("Color: ")
            year = int(input("Birth Year: "))
            molting = input("Molting? (true/false): ").lower() == 'true'
            coop.add(Chicken(id_val, name, color, year, molting))
        
        elif option == '2':
            id_to_remove = int(input("Enter Chicken ID to remove: "))
            coop.remove(id_to_remove)
        
        elif option == '3':
            print("\n--- CHICKENS IN COOP ---")
            coop.reset_iteration()
            while True:
                c = coop.next()
                if c is None: break
                print(c)
        
        elif option == '4':
            with open('chickens.csv', 'w', newline='') as file:
                writer = csv.writer(file)
                writer.writerow(["ID", "Name", "Color", "Age", "Molting"])
                for c in coop.chickens:
                    writer.writerow([c.id, c.name, c.color, c.age, c.molting])
            print("Data saved to chickens.csv successfully!")
        
        elif option == '5':
            with open('chickens.json', 'w') as file:
                json.dump([c.to_dict() for c in coop.chickens], file, indent=4)
            print("Data saved to chickens.json successfully!")
        
        elif option == '6':
            print("Exiting application...")
            break
        else:
            print("Invalid option.")

if __name__ == "__main__":
    main()