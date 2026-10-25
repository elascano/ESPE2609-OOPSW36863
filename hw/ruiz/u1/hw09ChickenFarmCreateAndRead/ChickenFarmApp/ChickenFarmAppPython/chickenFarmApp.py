from datetime import date

from chicken import Chicken
from chicken_coop import ChickenCoop
from chicken_farmer import ChickenFarmer
from egg import Egg
from poop import Poop


def main():
    print("")
    print("=============")
    print("2026 10 21")

    chicken_farmer = ChickenFarmer()
    print("chicken farmer --> " + str(chicken_farmer))
    print("")

    chickens_array = [None] * 10
    coop = ChickenCoop(1, chickens_array)

    option = 0

    
    while option != 6:
        print("Verónica Ruiz's Chicken Farm")
        print("============================")
        print("1. Add chicken")
        print("2. Remove chicken")
        print("3. Reset chicken iteration")
        print("4. Next chicken")
        print("5. Show chicken count and list")
        print("6. Exit")

        try:
            option = int(input("Choose an option: "))
        except ValueError:
            print("Invalid option! Please choose a number between 1 and 6.")
            option = 0
            continue

        if option == 1:  
            try:
                id = int(input("Chicken ID: "))
                name = input("Name: ")
                color = input("Color: ")
                date_input = input("Date of birth (YYYY-MM-DD): ")
                
                year, month, day = (int(p) for p in date_input.split("-"))
                born_date = date(year, month, day)
                molting_input = input("Is the chicken molting? (y/n): ")
                is_molting = molting_input.lower() == "y"
            except ValueError:
                print("Invalid data. The chicken was not added.")
                continue

            new_chicken = Chicken(id, name, color, born_date, is_molting)
            coop.add(new_chicken)

        elif option == 2:  
            try:
                id_to_remove = int(input("Enter Chicken ID to remove: "))
            except ValueError:
                print("Invalid ID.")
                continue
            coop.remove(id_to_remove)

        elif option == 3:  
            coop.reset_iteration()
            print("Chicken iteration has been reset.")

        elif option == 4:  
            next_chicken = coop.next()
            if next_chicken is not None:
                print("Next chicken --> " + str(next_chicken))
            else:
                print("No more chickens in the iteration loop (or coop is empty).")

        elif option == 5:  
            print("\n--- Chicken List ---")
            coop.reset_iteration()  
            current = coop.next()
            count = 0
            while current is not None:
                count += 1
                print("   -> " + str(current))
                current = coop.next()
            print(f"Total chickens currently in the coop: {count}")

        elif option == 6:  
            print("Exiting Chicken Farm App. Goodbye!")

        else:
            print("Invalid option! Please choose a number between 1 and 6.")

    
    chickens = [None] * 10
    chicken = Chicken(1, "Laura", "white", date(1970, 12, 17), False)
    egg = Egg(1, "M")

    print("my chicken is --> " + str(chicken))
    print("egg --> " + str(egg))
    print("egg size --> " + egg.get_size())

    poop = Poop(1, "brown", "S")
    print("poop --> " + str(poop))
    chicken1 = Chicken(1, "Lucy", "brown and white", date(1970, 12, 17), True)
    print("chicken 1 --> " + str(chicken1))

    local_age = chicken.compute_age_in_years()
    print(f"the age of the chicken --> {chicken.name}, is --> {local_age}")

    chicken.do_stuff()
    chickens[0] = Chicken(3, "Pepita", "black", date(2020, 2, 2), True)
    chickens[1] = chicken

    for i in range(10):
        print("chickens -->" + str(chickens[i]))

    for i in range(len(chickens)):
        age_for_the_loop = 2010 + i
        chickens[i] = Chicken(i, f"chicken {i + 1}", "white", date(2020, 3, 3), True)
        chickens[i].age_in_years = i

    for i in range(10):
        print("chickens -->" + str(chickens[i]))


if __name__ == "__main__":
    main()