
from datetime import date

from model.chicken import Chicken
from model.cow import Cow
from model.sheep import Sheep
from model.pig import Pig
from model.farm_animal import FarmAnimal


def main():

    print("Hello, This is Alejandro Animal Farm!")

    born_on_date = date(2020, 11, 10)

    farm_animal = Chicken(
        True, 4, True, 3, "Poultry", born_on_date
    )

    print("farmAnimal is a -->", type(farm_animal).__name__)
    print("My farm animal -->", farm_animal)

    print("\n===== CHICKEN =====")

    chicken = Chicken(
        True, 10, True, 2, "Paleesh", date.today()
    )

    print("Chicken -->", chicken)
    chicken.lay_an_egg()
    print("Age in months -->", chicken.get_age_in_months())

    print("\n===== COW =====")

    cow = Cow(
        True, 100.5, 3, "Holstein", date(2022, 11, 20)
    )

    print("Cow -->", cow)
    print("Cow is -->", type(cow).__name__)
    cow.milk()
    print("Age in months -->", cow.get_age_in_months())

    print("\n===== SHEEP =====")

    sheep = Sheep(
        5.5, True, 4, "Merino", date.today()
    )

    print("Sheep -->", sheep)
    print("Sheep is -->", type(sheep).__name__)
    sheep.shear()
    print("Age in months -->", sheep.get_age_in_months())

    print("\n===== PIG =====")

    pig = Pig(
        80.5, False, 5, "Yorkshire", date.today()
    )

    print("Pig -->", pig)
    print("Pig is -->", type(pig).__name__)
    pig.feed()
    print("Age in months -->", pig.get_age_in_months())

    print("\n===== POLYMORPHISM =====")

    farm_animal1: FarmAnimal = Sheep(
        6.0, True, 6, "Suffolk", date.today()
    )

    farm_animal2: FarmAnimal = Pig(
        90.0, False, 7, "Duroc", date.today()
    )

    print("Animal type -->", type(farm_animal1).__name__)
    print("Animal -->", farm_animal1)

    print("Animal type -->", type(farm_animal2).__name__)
    print("Animal -->", farm_animal2)


if __name__ == "__main__":
    main()
