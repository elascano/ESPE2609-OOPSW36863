from datetime import date, datetime

from animalfarmapp.model import Chicken, Cow, FarmAnimal, Food


def main() -> None:
    born_on_date = date(2020, 11, 10)
    food = Food("grains corn")

    print("hello this is Andy's Animal Farm ! ")
    farm_animal: FarmAnimal = Chicken(True, 0, True, 0, "Palish", born_on_date)
    farm_animal = Chicken(True, 0, True, 0, "Palish", born_on_date)
    print(f"farmAnimal is a -->{type(farm_animal)}")
    print(f"my farm animal -->{farm_animal}")

    chicken = Chicken(True, 10, True, 2, "Paleesh", born_on_date)
    print(f"chicken -->{chicken}")
    chicken.lay_an_egg()

    cow: FarmAnimal = Cow(True, 100.5, 5, "holstein", date(2022, 9, 20))
    print(f"cow -->{cow}")
    farm_animal_for_feeding: FarmAnimal = Chicken(True, 4, True, 0, "palish", born_on_date)

    cow1 = Cow(True, 0, 0, "Palish", born_on_date)

    print(f"farmAnimalForFeeding is a --->{type(farm_animal_for_feeding)}")
    print(f"farmAnimalForFeeding is a --->{type(farm_animal_for_feeding).__name__}")
    print(f"farmAnimalForFeeding --->{type(cow).__name__}")
    print(f"farmAnimalForFeeding --->{type(farm_animal_for_feeding).__name__}")
    print(f"farmAnimalForFeeding -->{farm_animal_for_feeding}")
    cow1.milk(10)

    chicken.feed(food, 2)
    food = Food("hay")

    cow1.feed(food, 1)

    cow1.milk()
    cow1.milk(3.2)
    cow1.milk(5)
    cow1.milk(1, datetime(2020, 11, 10, 0, 0))


if __name__ == "__main__":
    main()
