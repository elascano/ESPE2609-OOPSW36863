from datetime import datetime

from animalfarmapp.model import Chicken, Cow, FarmAnimal, Food, Pig, Sheep


def main() -> None:
    born_on_date = datetime(2020, 10, 10)
    food_chicken = Food("Corn")
    food_cow = Food("Hay")
    food_pig = Food("Barley")
    food_sheep = Food("")

    print("Hello This is Mateo´s Animal Farm!")
    print("----------------------------------")

    running = True
    while running:
        print("Select one option:")
        print("1. Chickens")
        print("2. Cows")
        print("3. Sheep")
        print("4. Pig")
        print("5. Others (class)")
        print("6. Exit")

        try:
            option = int(input())
        except ValueError:
            print("Wrong option")
            continue

        if option == 1:
            chicken1 = Chicken(True, 10, True, 2, "Paleesh", datetime.now())
            print("chicken ---> " + str(chicken1))
            chicken1.lay_an_egg()
            chicken1.feed(food_chicken, 2)

        elif option == 2:
            cow1 = Cow(True, 100.5, 8, "", born_on_date)
            print("cow ---> " + str(cow1))
            cow1.milk()
            cow1.milk(10)
            cow1.milk(3.2)
            cow1.milk(1, datetime.now())
            cow1.feed(food_cow, 1)

        elif option == 3:
            sheep1 = Sheep(datetime.now(), 10.6, 1, "Merino", born_on_date)
            print("sheep ---> " + str(sheep1))
            sheep1.shearing(2.3)
            print("sheep producing ---> " + str(sheep1.weight_wool))
            sheep1.feed(food_sheep, 3)

        elif option == 4:
            pig1 = Pig(True, 1, "Yorkshire", born_on_date)
            print("pigs ---> " + str(pig1))
            pig1.wallowing()
            pig1.rooting()
            pig1.feed(food_pig, 5)

        elif option == 5:
            chicken: FarmAnimal = Chicken(True, 21, True, 1, "Paleesh", born_on_date)
            print("FarmAnimal is a ---> " + type(chicken).__name__)
            print("my farm animal ---> " + str(chicken))

            farm_animal_for_feeding: FarmAnimal = Cow(True, 100.5, 3, "", datetime.now())
            print("farmAnimalForFeeding  is a ---> " + type(farm_animal_for_feeding).__name__)

        elif option == 6:
            print("Goodbye!!")
            running = False

        else:
            print("Wrong option")


if __name__ == "__main__":
    main()
