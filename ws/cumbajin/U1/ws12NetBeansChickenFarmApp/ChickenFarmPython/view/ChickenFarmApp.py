
from datetime import datetime
from model.Chicken import Chicken
from model.ChickenCoop import ChickenCoop
from model.Egg import Egg
from model.Poop import Poop
from controller.ChickenFileManager import ChickenFileManager

"""
@author Dylan Cumbajin, MosQ, @ESPE
"""

def main():
    print("Dylan Cumbajin's Chicken Farm")
    print("=============================")

    chickens = [None] * 10

    chicken = Chicken(2, "Maruja", "white",
                      datetime(1970, 12, 17), False)
    chicken.setAgeInYears()

    egg = Egg(1, "M")

    print("my chicken is -->", chicken)
    print("egg -->", egg)
    print("egg size -->", egg.getSize())

    poop = Poop(0, "brown", "S")
    print("poop -->", poop)

    chicken1 = Chicken(1, "Lucy", "brown and white",
                       datetime(1970, 12, 17), True)
    chicken1.setAgeInYears()

    print("chicken 1 -->", chicken1)

    localAge = chicken.computeAgeInYears()

    print("the age of the chicken -->",
          chicken.getName(), ", is -->", localAge)

    chicken.doStuff()

    chickens[0] = Chicken(3, "Pepita", "black",
                          datetime(2020, 3, 2), True)
    chickens[1] = chicken

    for i in range(10):
        print("chickens -->", chickens[i])

    ageForTheLoop = 0

    for i in range(len(chickens)):
        ageForTheLoop = 2010 + i

        chickens[i] = Chicken(
            i, "chicken " + str(i + 1),
            "white", datetime(ageForTheLoop, 4, 3), True
        )

        chickens[i].setAgeInYears()

    for i in range(10):
        print("chickens -->", chickens[i])

    # Testing ChickenCoop methods
    print("\n===== CHICKEN COOP TEST =====")

    coop = ChickenCoop(1, [None] * 10)

    # Testing add()
    print("\n--- ADD CHICKENS ---")
    coop.add(chicken)
    coop.add(chicken1)

    # Testing next()
    print("\n--- LIST CHICKENS ---")
    coop.resetIteration()

    currentChicken = coop.next()

    while currentChicken is not None:
        print("Chicken -->", currentChicken.getName(),
              ", ID -->", currentChicken.getId())
        currentChicken = coop.next()

    # Testing remove()
    print("\n--- REMOVE CHICKEN ---")
    coop.remove(2)

    # Verify remaining chickens
    print("\n--- REMAINING CHICKENS ---")
    coop.resetIteration()

    currentChicken = coop.next()

    while currentChicken is not None:
        print("Chicken -->", currentChicken.getName(),
              ", ID -->", currentChicken.getId())
        currentChicken = coop.next()

    print("\n===== TEST COMPLETED =====")

    # Menu
    option = 0

    while option != 3:
        print("\n===== CHICKEN FARM APP =====")
        print("1. Save Chickens")
        print("2. Read Chickens")
        print("3. Exit")

        option = int(input("Select an option: "))

        if option == 1:
            ChickenFileManager.saveJSON(chickens)
            ChickenFileManager.saveCSV(chickens)

        elif option == 2:
            print("\n--- CHICKENS FROM JSON ---")

            jsonChickens = ChickenFileManager.readJSON()

            if jsonChickens is not None:
                for i in range(len(jsonChickens)):
                    if jsonChickens[i] is not None:
                        print(jsonChickens[i])

            print("\n--- CHICKENS FROM CSV ---")

            csvChickens = ChickenFileManager.readCSV()

            for i in range(len(csvChickens)):
                if csvChickens[i] is not None:
                    print(csvChickens[i])

        elif option == 3:
            print("Goodbye!")

        else:
            print("Invalid option")


if __name__ == "__main__":
    main()
