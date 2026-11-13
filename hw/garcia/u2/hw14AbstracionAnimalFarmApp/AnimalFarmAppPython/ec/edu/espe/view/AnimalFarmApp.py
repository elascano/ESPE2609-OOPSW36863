from datetime import datetime
from ec.edu.espe.model.Chicken import Chicken
from ec.edu.espe.model.Cow import Cow
from ec.edu.espe.model.FarmAnimal import FarmAnimal


def main():
    print("Hello, This is Jesus Animal Farm!")

    farmAnimal: FarmAnimal
    bornOnDate = datetime(2020, 11, 10)
    farmAnimal = Chicken(True, 4, True, 3, "Poultry", bornOnDate)
    print("farmAnimal is a -->", type(farmAnimal).__name__)
    print("My farm animal -->", farmAnimal)

    chicken = Chicken(True, 10, True, 2, "Paleesh", datetime.now())
    print("Chicken -->", chicken)
    chicken.layAnEgg()

    print("farmAnimal is a -->", type(chicken))
    print("farmAnimal is a -->", type(chicken).__name__)

    cow = Cow(True, 100.5, 3, "holstein", datetime(2023, 9, 20))
    print("Cow -->", cow)
    print("Cow is -->", type(cow))
    print("Cow is -->", type(cow).__name__)
    cow.milk()

    chicken1: FarmAnimal = Chicken(True, 4, True, 0, "palish", bornOnDate)
    print("Chicken -->", chicken1)

    cow1 = Cow(True, 0, 0, "Molestein", bornOnDate)
    print("Cow is -->", type(cow).__name__)
    cow1.milk()


if __name__ == "__main__":
    main()
