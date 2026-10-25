from datetime import date

from model.poop import Poop
from model.egg import Egg
class Chicken:

    def __init__(self, id, name, color, born_on_date, molting):
        self.id = id
        self.name = name
        self.color = color
        self.born_on_date = born_on_date
        self.molting = molting

    def compute_age_in_years(self):
        today = date.today()

        return today.year - self.born_on_date.year - (
                (today.month, today.day)
                < (self.born_on_date.month, self.born_on_date.day)
        )

    def do_stuff(self):
        self.cluck()
        self.wander()
        self.drink(1.3)

        print("poop --->", self.poop())
        print(self.lay_an_egg())

    def cluck(self):
        print(f"The chicken {self.name} is clucking")

    def wander(self):
        print(f"The chicken {self.name} is wandering")

    def eat(self):
        print(f"The chicken {self.name} is eating")

    def drink(self, amount_of_water):
        print(
            f"The chicken {self.name} is drinking "
            f"{amount_of_water} ml of water"
        )

    def poop(self):
       
        return Poop(2, "green", "M")

    def lay_an_egg(self):
       
        return Egg(2, "S")

    def __str__(self):
        return (
            f"Chicken{{"
            f"id={self.id}, "
            f"name='{self.name}', "
            f"color='{self.color}', "
            f"age={self.compute_age_in_years()}, "
            f"molting={self.molting}"
            f"}}"
        )