from datetime import date

from model.Chicken import Chicken
from model.Cow import Cow
from model.Pig import Pig
from model.Sheep import Sheep


def main():
    born_on_date = date.today()
    print("Hello this is Julian's Animal Farm!")

    animals = [
        Chicken(1, "Paleesh", born_on_date, True, 10, True),
        Cow(2, "Holstein", born_on_date, True, 25),
        Pig(3, "Duroc", born_on_date, False),
        Sheep(4, "Merino", born_on_date, date(2026, 4, 1)),
    ]
    
    for animal in animals:
        print(animal)


if __name__ == "__main__":
    main()
