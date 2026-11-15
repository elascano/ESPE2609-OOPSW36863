
from datetime import date

from model.chicken import Chicken
from model.cow import Cow
from model.sheep import Sheep
from model.pig import Pig


def main():

    chicken = Chicken(
        False, 15, True,
        1, "Plymouth Rock", date(2024, 5, 10)
    )

    cow = Cow(
        True, 25.5,
        2, "Holstein", date(2023, 3, 15)
    )

    sheep = Sheep(
        5.5, True,
        3, "Merino", date(2024, 8, 20)
    )

    pig = Pig(
        80.5, False,
        4, "Yorkshire", date(2023, 7, 12)
    )

    print("=== ANIMAL FARM ===")

    print(chicken)
    chicken.lay_egg()

    print(cow)
    cow.milk()

    print(sheep)
    sheep.shear()

    print(pig)
    pig.feed()


if __name__ == "__main__":
    main()
