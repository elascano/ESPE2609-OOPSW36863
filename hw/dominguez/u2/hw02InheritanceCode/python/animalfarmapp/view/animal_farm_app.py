from datetime import date

from animalfarmapp.model import Chicken, Cow, FarmAnimal, Pig, Sheep


def main() -> None:
    print("Hello This is Mateo's Animal Farm!")

    farm_animal = FarmAnimal(1, "holstein", date.today())
    print("my farm animal ---> ", farm_animal)

    chicken = Chicken(True, 10, True, 2, "Paleesh", date.today())
    print("chicken ---> ", chicken)

    cow = Cow(True, 100.5, 3, "", date.today())
    print("cow ---> ", cow)

    pig = Pig(True, 4, "Duroc", date.today())
    print("pig ---> ", pig)

    sheep = Sheep(date.today(), 15, "Texel", date.today())
    print("sheep ---> ", sheep)


if __name__ == "__main__":
    main()
