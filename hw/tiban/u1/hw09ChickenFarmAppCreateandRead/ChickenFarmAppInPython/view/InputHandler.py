from datetime import date
from model.Chicken import Chicken

class InputHandler:
    
    @staticmethod
    def is_id_taken(id, chickens):
        if not chickens:
            return False
        
        for c in chickens:
            if c is not None and c.id == id:
                return True
        return False

    @staticmethod
    def create_chicken_from_console(current_chickens):
        print("\n=== New Chicken Register ===")
         
        while True:
            try:
                id = int(input("Enter the ID: "))
                if InputHandler.is_id_taken(id, current_chickens):
                    print("[!] Error: That ID is already registered. Please enter another one.")
                else:
                    break 
            except ValueError:
                print("[!] Error: Please enter a valid number.")
        
        name = input("Enter the name: ")
        color = input("Enter the color: ") 
        
        year_of_birth = int(input("Enter the year of birth: "))
        month_of_birth = int(input("Enter the month of birth: "))
        day_of_birth = int(input("Enter the day of birth: "))
        
        molting_input = input("The chicken is molting? (true or false): ").strip().lower()
        molting = molting_input == 'true'
        
      
        return Chicken(id, name, color, date(year_of_birth, month_of_birth, day_of_birth), molting)