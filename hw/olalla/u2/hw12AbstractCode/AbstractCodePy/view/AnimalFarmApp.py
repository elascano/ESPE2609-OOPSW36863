from datetime import date

from model.Chicken import Chicken
from model.Cow import Cow
from model.Pig import Pig
from model.Sheep import Sheep


def main():
    born_on_date = date.today()
    print("Hello this is Julian's Animal Farm!\n")

    chicken = Chicken(1, "Paleesh", born_on_date, True, 10, True)
    print(chicken)
    chicken.lay_an_egg()
    print(f"The chicken says: {chicken.make_sound()}", "\n")

    cow = Cow(2, "Holstein", born_on_date, True, 25)
    print(cow)
    cow.milk()
    print(f"The cow says: {cow.make_sound()}", "\n")

    pig = Pig(3, "Duroc", born_on_date, True)
    print(pig)
    pig.cleaning()
    print(f"The pig says: {pig.make_sound()}", "\n")

    sheep = Sheep(4, "Merino", born_on_date, date(2026, 4, 1), True, 5)
    print(sheep)
    sheep.milk()
    print(f"The sheep says: {sheep.make_sound()}", "\n")


if __name__ == "__main__":
    main()
