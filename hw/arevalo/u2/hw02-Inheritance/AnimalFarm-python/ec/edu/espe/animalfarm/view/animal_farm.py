from datetime import date

from ec.edu.espe.animalfarm.model.chicken import Chicken
from ec.edu.espe.animalfarm.model.cow import Cow
from ec.edu.espe.animalfarm.model.farm_animal import FarmAnimal
from ec.edu.espe.animalfarm.model.pig import Pig
from ec.edu.espe.animalfarm.model.sheep import Sheep


class AnimalFarm:
    @staticmethod
    def main():
        print("Welcome to Anthony's Animal Farm!")
        today = date.today()

        farm_animal = FarmAnimal(1, "holstein", today)
        print(f"Farm animal: {farm_animal}")

        chicken = Chicken(True, 10, True, 2, "Paleesh", today)
        print(f"Chicken: {chicken}")

        # Java's new Date(222, 20, 20) normalizes to September 20, 2123.
        cow: FarmAnimal = Cow(True, 100.5, 3, "holstein", date(2123, 9, 20))
        print(f"Cow: {cow}")

        # Subclasses inherit their ID, breed, and birth date from FarmAnimal.
        pig: FarmAnimal = Pig(85.5, 2.5, True, 4, "Yorkshire", today)
        print(f"Pig: {pig}")

        sheep: FarmAnimal = Sheep(today, 3.2, "White", 5, "Merino", today)
        print(f"Sheep: {sheep}")


if __name__ == "__main__":
    AnimalFarm.main()
