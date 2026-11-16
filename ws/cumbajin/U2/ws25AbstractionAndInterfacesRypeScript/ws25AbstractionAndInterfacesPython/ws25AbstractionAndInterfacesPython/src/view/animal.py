"""Main application for Dylan's Animal Farm."""

from datetime import date

from src.model import Chicken, Cow, FarmAnimal, Food, GrazeAnimal, Location, Sheep


def show_animal_type(animal: FarmAnimal) -> None:
    """Demonstrate polymorphism using a common abstract type."""
    print(f"farmAnimalForFeeding is a --> {type(animal).__name__}")


def send_to_graze(animal: GrazeAnimal, location: Location) -> None:
    """Use an object through the GrazeAnimal interface."""
    animal.graze(location)


def main() -> None:
    print("Hello! This is Dylan's Animal Farm!")

    born_on_date = date(2020, 10, 10)
    food = Food("corn")

    farm_animal: FarmAnimal = Chicken(
        0, "Palish", born_on_date, True, 1, True
    )
    print(f"farmAnimal is a --> {type(farm_animal).__name__}")
    print(f"my farm animal --> {farm_animal}")

    chicken = Chicken(2, "Paleesh", date.today(), True, 10, True)
    print(f"chicken --> {chicken}")

    # Polymorphism with the abstract FarmAnimal type.
    farm_animal_for_feeding: FarmAnimal = Chicken(
        4, "Palish", born_on_date, True, 10, True
    )
    show_animal_type(farm_animal_for_feeding)

    farm_animal_for_feeding = Cow(
        True, 100.5, 3, "Holstein", date(2022, 2, 20)
    )
    show_animal_type(farm_animal_for_feeding)

    farm_animal_for_feeding = Chicken(
        0, "Palish", born_on_date, True, 4, True
    )
    show_animal_type(farm_animal_for_feeding)
    print(f"farmAnimalForFeeding --> {farm_animal_for_feeding}")

    cow = Cow(True, 100.5, 3, "Holstein", date(2022, 2, 20))

    # Implementations of the abstract feed method.
    chicken.feed(food, 2.0)
    food = Food("hay")
    cow.feed(food, 1.0)

    # Python alternative to Java method overloading.
    cow.milk()
    cow.milk(3.2)
    cow.milk(5)
    cow.milk(5, born_on_date)

    # Interface implementation.
    pasture = Location(1, "North pasture")
    send_to_graze(cow, pasture)

    sheep = Sheep(date(2026, 9, 1), 5, "Merino", date(2021, 4, 15))
    send_to_graze(sheep, pasture)


if __name__ == "__main__":
    main()
