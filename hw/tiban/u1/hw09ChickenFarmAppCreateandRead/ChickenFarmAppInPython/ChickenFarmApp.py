from datetime import date
# Importamos todos nuestros moldes y herramientas
from model.Chicken import Chicken
from model.Egg import Egg
from model.Poop import Poop
from model.ChickenCoop import ChickenCoop
from model.ChickenFarmer import ChickenFarmer
from controller.JsonManager import JsonManager
from controller.CsvManager import CsvManager
from view.InputHandler import InputHandler

def main():
    print("Andy Tiban's Chicken Farm")    
    print("=========================")
    

    chicken = Chicken(2, "Maruja", "white", date(2024, 5, 15), False)
    egg = Egg(1, 'M')
    chicken.set_age_in_years()
    
    print(f"my chicken is ->{chicken}")
    print(f"egg -->{egg}")
    print(f"egg size-->{egg.size}") 
    
    local_age = chicken.compute_age_in_years()
    print(f"the age of the chicken {chicken.name} is --> {local_age}")
    chicken.do_stuff()
    
    poop = Poop(1, "brown", 'S')
    print(f"Poop->{poop}")
    
    chicken1 = Chicken(1, "Lucy", "brown and white", date(2023, 5, 15), True)
    chicken1.set_age_in_years()
    
    print(f"chicken {chicken1}")
    local_age = chicken1.compute_age_in_years()
    print(f"the age of the chicken {chicken1.name} is --> {local_age}")
    chicken1.do_stuff()
    
   
    chickens = []
    chickens.append(chicken1) 
    chickens.append(chicken)  
    chickens.append(Chicken(3, "Pepita", "black", date(2005, 3, 2), True)) # Índice 2
    chickens[2].set_age_in_years()
    
    
    for i in range(3, 10):
        age_for_the_loop = 2010 + i
        new_c = Chicken(i + 1, f"chicken {i + 1}", "white", date(age_for_the_loop, 4, 3), True)
        new_c.set_age_in_years()
        chickens.append(new_c)
        
    for i in range(10):
        print(f"chickens--->{chickens[i]}")
        

    chicken_coop1 = ChickenCoop(1) 
    chicken_coop1.add(chicken)  
    chicken_coop1.add(chicken1) 

    print(f"Taking out of the chicken coop: {chicken_coop1.next()}")
    print(f"taking out of the chicken coop: {chicken_coop1.next()}")

    chicken_coop1.remove(2)

    print("\n=== Farmer info ===")
    farmer = ChickenFarmer()
    print(farmer)
    

    existing_chickens = JsonManager.load_chickens()

    print("\n=== New Chicken Register ===")
    
    try:
        number_of_chickens_to_add = int(input("How many chickens do you want to add?: "))
    except ValueError:
        print("[!] Invalid number. Setting to 0.")
        number_of_chickens_to_add = 0


    for i in range(number_of_chickens_to_add):
        print(f"\n--- Entering new chicken data N.{i + 1} ---")
        new_chicken = InputHandler.create_chicken_from_console(existing_chickens)
        existing_chickens.append(new_chicken)

  
    JsonManager.save_chickens(existing_chickens)
    CsvManager.save_chickens(existing_chickens)

    print("\n=== Reading chickens from the archive ===")
    loaded_chickens = JsonManager.load_chickens()
    
    for c in loaded_chickens:
        if c is not None:
            c.set_age_in_years()
            print(c)

# Este bloque final es el equivalente exacto a tu: public static void main(String[] args)
if __name__ == "__main__":
    main()