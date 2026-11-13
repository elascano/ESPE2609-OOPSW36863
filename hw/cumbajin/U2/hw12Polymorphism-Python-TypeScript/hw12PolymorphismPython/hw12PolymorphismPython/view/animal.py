from datetime import date

from model import Chicken, Cow, FarmAnimal


def main() -> None:
    print("Hello This is Dylan's Animal Farm!")

    born_on_date = date(2020, 10, 10)

    farm_animal: FarmAnimal = Chicken(
        0, "palish", born_on_date, True, 1, True
    )

    print(f"farmAnimal is a --> {type(farm_animal).__name__}")
    print(f"my farm animal --> {farm_animal}")

    chicken = Chicken(2, "Paleesh", date.today(), True, 10, True)
    print(f"chicken --> {chicken}")

    # The same FarmAnimal reference points to different subclass objects.
    farm_animal_for_feeding: FarmAnimal = Chicken(
        4, "palish", born_on_date, True, 10, True
    )
    print(
        "farmAnimalForFeeding is a --> "
        f"{type(farm_animal_for_feeding).__name__}"
    )

    farm_animal_for_feeding = Cow(
        True, 100.5, 3, "Holstein", date(2022, 2, 20)
    )
    print(
        "farmAnimalForFeeding is a --> "
        f"{type(farm_animal_for_feeding).__name__}"
    )

    farm_animal_for_feeding = Chicken(
        0, "palish", born_on_date, True, 4, True
    )
    print(
        "farmAnimalForFeeding is a --> "
        f"{type(farm_animal_for_feeding).__name__}"
    )
    print(f"farmAnimalForFeeding --> {farm_animal_for_feeding}")

    cow = Cow(True, 100.5, 3, "Holstein", date(2022, 2, 20))
    cow.milk()


if __name__ == "__main__":
    main()
