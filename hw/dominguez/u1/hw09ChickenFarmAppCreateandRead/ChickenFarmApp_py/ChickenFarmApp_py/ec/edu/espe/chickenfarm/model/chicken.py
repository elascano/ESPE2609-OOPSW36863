from datetime import date

from ec.edu.espe.chickenfarm.model.egg import Egg
from ec.edu.espe.chickenfarm.model.poop import Poop


class Chicken:
    def __init__(self, chicken_id, name, color, born_on_date, molting):
        self.id = chicken_id
        self.name = name
        self.color = color
        self.born_on_date = born_on_date  
        self.age_in_years = 0
        self.molting = molting

    def do_stuff(self):
        self._cluck()
        self._wander()
        self._eat()
        self._drink(1.3)
        print("poop -->", self._poop())
        print("egg -->", self._lay_an_egg())

    def _cluck(self):
        print(f"The chicken {self.name} is clucking ...")

    def _wander(self):
        print(f"The chicken {self.name} is wandering ...")

    def _eat(self):
        print(f"The chicken {self.name} is eating ...")

    def _drink(self, amount_of_water):
        print(f"The chicken {self.name} is drinking --> {amount_of_water} ml of water")

    def _poop(self):
        return Poop(2, "green", "M")

    def _lay_an_egg(self):
        return Egg(self.id, "B")

    def compute_age_in_years(self):
        today = date.today()
        age = today.year - self.born_on_date.year
        if (today.month, today.day) < (self.born_on_date.month, self.born_on_date.day):
            age -= 1
        return age

    def set_age_in_years(self, age_in_years):
        self.age_in_years = self.compute_age_in_years()

    def __repr__(self):
        return (f"Chicken{{id={self.id}, name={self.name}, color={self.color}, "
                f"bornOnDate={self.born_on_date}, age={self.age_in_years}, molting={self.molting}}}")
