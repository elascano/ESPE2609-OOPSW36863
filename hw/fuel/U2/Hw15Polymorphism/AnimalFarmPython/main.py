from datetime import datetime

from model.food import Food
from model.location import Location
from model.chicken import Chicken
from model.cow import Cow
from model.sheep import Sheep
from model.pig import Pig


def main():

    born_on_date = datetime(2020, 10, 10)

    food = Food("Corn")
    hay = Food("Hay")

    stable = Location(1, "Stable")
    pasture = Location(2, "Pasture")

    chicken = Chicken(
        False, 20, True, 1, "Broiler", born_on_date
    )

    cow = Cow(
        True, 15.5, 2, "Holstein", born_on_date
    )

    sheep = Sheep(
        True, 8.5, "White", 3, "Merino", born_on_date
    )

    pig = Pig(
        True, 150.0, "Pork", 4, "Yorkshire", born_on_date
    )

    print("===== ANIMAL FARM =====")

    print(chicken)
    chicken.feed(food, 2)
    chicken.lay_an_egg()

    print("\n" + str(cow))
    cow.feed(hay, 3)
    cow.food = "Grass"
    cow.graze(stable)
    cow.milk()
    cow.milk(3.2)
    cow.milk(5)
    cow.milk(2.1, born_on_date)

    print("\n" + str(sheep))
    sheep.feed(hay, 2)
    sheep.graze(pasture)
    sheep.shear_wool()

    print("\n" + str(pig))
    pig.feed(food, 4)
    pig.gain_weight(5.5)

    print("\n===== END OF FARM =====")


if __name__ == "__main__":
    main()