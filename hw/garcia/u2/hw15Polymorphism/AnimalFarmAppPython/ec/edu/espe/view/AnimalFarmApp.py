from datetime import datetime
from ec.edu.espe.model.Chicken import Chicken
from ec.edu.espe.model.Cow import Cow
from ec.edu.espe.model.FarmAnimal import FarmAnimal
from ec.edu.espe.model.Food import Food
from ec.edu.espe.model.Location import Location
from ec.edu.espe.model.Pig import Pig
from ec.edu.espe.model.Sheep import Sheep
from ec.edu.espe.model.grazeAnimal import grazeAnimal


def main():
    print("Hello, This is Jesus's Animal Farm!")

    bornOnDate = datetime(2020, 11, 10)
    food = Food("Corn")

    farmAnimal = Chicken(True, 4, True, 3, "Poultry", bornOnDate)
    print("farmAnimal is a -->", type(farmAnimal).__name__)
    print("My farm animal -->", farmAnimal)

    chicken = Chicken(True, 10, True, 2, "Paleesh", datetime.now())
    print("Chicken -->", chicken)
    chicken.layAnEgg()

    print("farmAnimal is a -->", type(chicken).__name__)
    print("farmAnimal is a -->", type(chicken).__name__)

    cow = Cow(True, 100.5, 3, "holstein", datetime(2022, 9, 20))
    print("Cow -->", cow)
    print("Cow is -->", type(cow).__name__)
    print("Cow is -->", type(cow).__name__)
    cow.milk()

    chicken1 = Chicken(True, 4, True, 0, "palish", bornOnDate)
    print("Chicken -->", chicken1)

    cow1 = Cow(True, 0, 0, "Molestein", bornOnDate)
    print("Cow is -->", type(cow).__name__)
    cow1.milk(10)

    chicken.feed(food, 1)
    food = Food("Hay")
    cow1.feed(food, 1)

    cow1.milk()
    cow1.milk(3.2)
    cow1.milk(5)
    cow1.milk(1, bornOnDate)

    pig = Pig(0, 3, "Yorkshire", bornOnDate)
    print("Pig -->", pig)
    print("Pig is -->", type(pig).__name__)
    pig.feed(food, 2)
    pig.registerLitter(8)

    sheep = Sheep(10.5, False, 4, "Merino", bornOnDate)
    print("Sheep -->", sheep)
    print("Sheep is -->", type(sheep).__name__)
    sheep.feed(food, 2)
    sheep.shearWool()

    location = Location(1, "Green pasture")
    grazer1: grazeAnimal = cow1
    grazer2: grazeAnimal = sheep
    grazer1.graze(location)
    grazer2.graze(location)


if __name__ == "__main__":
    main()
