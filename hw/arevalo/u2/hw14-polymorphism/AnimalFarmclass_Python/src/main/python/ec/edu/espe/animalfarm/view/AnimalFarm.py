"""Program entry point in ec.edu.espe.animalfarm.view."""

from datetime import datetime
from ec.edu.espe.animalfarm.model.Chicken import Chicken
from ec.edu.espe.animalfarm.model.Cow import Cow
from ec.edu.espe.animalfarm.model.FarmAnimal import FarmAnimal
from ec.edu.espe.animalfarm.model.Pig import Pig
from ec.edu.espe.animalfarm.model.Sheep import Sheep


# @author Anthony Arévalo, MosQ, ESPE
class AnimalFarm:
    @staticmethod
    def main(args: list[str]) -> None:
        print("Welcome to Anthony's Animal Farm!")
        bornOnDate = datetime(2020, 10, 10)
        farmAnimal: FarmAnimal = Chicken(True, 0, True, 0, "Holstein", bornOnDate)

        print("FarmAnimal --> is a " + type(farmAnimal).__name__)
        print("my farm animal --->" + str(farmAnimal))

        farmAnimal = Cow(True, 0, 0, "Palich", datetime(2022, 10, 20))
        print("cow --> " + type(farmAnimal).__name__)

        chicken = Chicken(True, 10, True, 2, "Paleesh", datetime.now())
        print("chicken --->" + str(chicken))

        cow: FarmAnimal = Cow(True, 100.5, 3, "holstein", datetime(2022, 10, 20))
        print("Cow: " + str(cow))

        cow = Chicken(True, 4, True, 0, "paleesh", bornOnDate)
        print("FarmAnimal reassigned to Chicken --> " + str(cow))

        cow2 = Cow(True, 2, 4, "Holstein", bornOnDate)
        cow2.milk()
        chicken.layAnEgg()

        # Pig and Sheep inherit their ID, breed, and birth date from FarmAnimal.
        pig: FarmAnimal = Pig(85.5, 2.5, True, 5, "Yorkshire", bornOnDate)
        print("Pig: " + str(pig))

        sheep: FarmAnimal = Sheep(datetime.now(), 3.2, "White", 6, "Merino", bornOnDate)
        print("Sheep: " + str(sheep))


if __name__ == "__main__":
    import sys
    AnimalFarm.main(sys.argv[1:])
