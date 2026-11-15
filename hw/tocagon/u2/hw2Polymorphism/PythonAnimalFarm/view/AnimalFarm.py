from datetime import date

from models.FarmAnimal import FarmAnimal
from models.Chicken import Chicken
from models.Cow import Cow
from models.Pig import Pig
from models.Sheep import Sheep

def main():

    print("Hello this is Nohemi's Animal Farms!")

    bornOnDate = date(2020, 11, 10)

    farmAnimal = Chicken(True, 1, True, 0, "Palish", bornOnDate)

    print("farm animal is a -->", type(farmAnimal))

    print("farm animal --->", farmAnimal)

    chicken = Chicken(True, 20, False, 2, "Paleesh", date.today())

    print("my Chicken", chicken)

    farmAnimalForFeeding = Chicken(True, 10, True, 4, "Palish", bornOnDate)

    print("farmAnimalForFeeding is a -->", type(farmAnimalForFeeding).__name__)

    cow = Cow(True, 100.5, 3, "holstein", date.today())

    print("my cow -->", cow)

    print("farmAnimalForFeeding is a -->", type(cow).__name__)

    cow1 = Cow(True, 0, 0, "Palish", bornOnDate)

    farmAnimalForFeeding = Chicken(True, 4, True, 0, "palish", bornOnDate)

    print("farmAnimalForFeeding is a -->", type(farmAnimalForFeeding).__name__)

    chicken1 = Chicken(True, 10, True, 2, "Palish", bornOnDate)

    print("chicken -->", chicken1)

    chicken.layAnEgg()

    cow.milk()

    print("New Animals")
    pig= Pig(78.5, False, 45, 1, "Pietrain", bornOnDate)
    print("my pig-->", pig)
    pig.checkHealth()

    pig1= Pig(50.6, False, 48, 2, "Pietrain", bornOnDate)
    print("my pig-->", pig1)
    pig1.checkHealth()

    sheep= Sheep("white", 5.5, False, 1, "Lincoln", bornOnDate)
    print("my sheep-->", sheep)
    sheep.shearWool()

if __name__ == "__main__":
    main()