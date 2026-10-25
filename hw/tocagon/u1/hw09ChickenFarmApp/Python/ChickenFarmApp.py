from datetime import date
from model.chicken import Chicken
from model.chicken_coop import ChickenCoop
from model.egg import Egg
from model.poop import Poop


def main():
    print("Nohemi Tocagon's Chicken Farm")
    print("=============================")

    coop = ChickenCoop(0)

    chicken = Chicken(2, "Maruja", "white", date(2024, 8, 15), False)
    egg = Egg(1, "M")
    print("My chicken is -->", chicken)
    print("egg -->", egg)
    print("egg.size -->", egg.size)

    poop = Poop(1, "brown", "S")
    print("poop -->", poop)

    chicken1 = Chicken(1, "Lucy", "brown and white", date.today(), False)
    print("chicken 1 -->", chicken1)

    print(f"the age of the chicken --> {chicken.name}, is --> {chicken.compute_age_in_years()}")
    chicken.do_stuff()

    coop.add(chicken)
    coop.add(chicken1)

    print("--- BEFORE ---")
    for c in coop.chickens:
        print(c)

    coop.remove(2)

    print("--- AFTER ---")
    for c in coop.chickens:
        print(c)

    position = 0
    option = 0
    while option != 6:
        print("=====CHICKENFARM APP MENU=====")
        print("1. Add chicken")
        print("2. Remove chicken")
        print("3. Next chicken")
        print("4. Convert file into JSON")
        print("5. Convert file into CSV")
        print("6. Exit")
        option = int(input("Option (1-6): "))

        if option == 1:
            coop.add_from_input()
        elif option == 2:
            coop.remove(int(input("ID to remove: ")))
        elif option == 3:
            c = coop.next(position)
            if c is not None:
                print(c.to_json())
                position += 1
            else:
                print("There's no more chickens")
                position = 0
        elif option == 4:
            print("CONTENT FROM JSON")
            print(chicken.to_json())
        elif option == 5:
            print("CONTENT FROM CSV")
            print(chicken.to_csv())
        elif option == 6:
            print("Leaving...")
        else:
            print("Error, it is necessary to choose one option!!")


if __name__ == "__main__":
    main()