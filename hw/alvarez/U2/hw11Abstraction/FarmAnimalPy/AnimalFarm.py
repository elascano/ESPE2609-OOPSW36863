from datetime import datetime, timedelta
from model.Chicken import Chicken
from model.Cow import Cow
from model.FarmAnimal import FarmAnimal
from model.Food import Food
from model.Location import Location
from model.Pig import Pig
from model.Sheep import Sheep


def java_date(year: int, month: int, day: int) -> datetime:
    base = datetime(year + 1900, 1, 1)
    new_year = base.year + (month // 12)
    new_month = (month % 12) + 1
    return datetime(new_year, new_month, 1) + timedelta(days=day - 1)


class AnimalFarm:
    @staticmethod
    def main() -> None:
        born_on_date = java_date(2020, 10, 10)
        farm_animal: FarmAnimal = Chicken(True, 0, True, 0, "Palish", born_on_date)
        food = Food("grains corn")

        print("Hello this is Juan's Animal Farm!")

        farm_animal = Chicken(True, 0, True, 0, "Palish", born_on_date)
        print(f"farmAnimal is a -->class ec.edu.espe.animalfarm.model.{type(farm_animal).__name__}")
        print(f"my farm animal -->{farm_animal}")

        chicken = Chicken(True, 10, True, 2, "Paleesh", born_on_date)
        print(f"chicken -->{chicken}")
        chicken.lay_an_egg()

        cow: FarmAnimal = Cow(True, 100.5, 5, "holstein", java_date(2022, 20, 20))
        print(f"cow -->{cow}")
        cow_1_poly: FarmAnimal = Chicken(True, 4, True, 0, "palish", born_on_date)

        cow1 = Cow(True, 0.0, 0, "Palish", born_on_date)

        print(f"Cow is a --->class ec.edu.espe.animalfarm.model.{type(cow_1_poly).__name__}")
        print(f"Cow is a --->{type(cow_1_poly).__name__}")
        print(f"Cow is a -->{type(cow).__name__}")
        print(f"Cow is a --->{type(cow_1_poly).__name__}")
        print(f"Cow is a -->{cow_1_poly}")
        cow1.milk(10)

        chicken.feed(food, 2)
        food = Food("hay")

        cow1.feed(food, 1)

        cow1.milk()
        cow1.milk(3.2)
        cow1.milk(5)
        cow1.milk(1, born_on_date)

        location = Location(1, "North Pasture")
        sheep = Sheep(java_date(2023, 5, 15), True, 3, "Merino", born_on_date)
        print(f"sheep -->{sheep}")
        sheep.graze(location)
        sheep.feed(food, 3)
        sheep.shear()

        pig = Pig(85.5, False, 4, "Landrace", born_on_date)
        print(f"pig -->{pig}")
        pig.feed(Food("balanced feed"), 5)
        print(f"pig after feeding -->{pig}")


if __name__ == "__main__":
    AnimalFarm.main()