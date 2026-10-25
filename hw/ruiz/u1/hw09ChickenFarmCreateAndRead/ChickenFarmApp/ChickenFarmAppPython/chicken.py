from datetime import date

from egg import Egg
from poop import Poop


class Chicken:
    def __init__(self, id, name, color, born_on_date, molting):
        self._id = id
        self._name = name
        self._color = color
        self._born_on_date = born_on_date
        self._age_in_years = self.compute_age_in_years()
        self._molting = molting

 
    def do_stuff(self):
        self._cluck()
        self._wander()
        self._eat()
        self._drink(1.3)
        print("poop --> " + str(self._poop()))
        print("egg --> " + str(self._lay_an_egg()))

    def _cluck(self):
        print(f"The chicken {self._name} is clucking...")

    def _wander(self):
        print(f"The chicken {self._name} is wandering...")

    def _eat(self):
        print(f"The chicken {self._name} is eating...")

    def _drink(self, amount_of_water):
        print(f"The chicken {self._name} is drinking --> {amount_of_water} ml of water")

    def _poop(self):
        return Poop(2, "green", "M")

    def _lay_an_egg(self):
        return Egg(2, "S")

    def compute_age_in_years(self):
        today = date.today()
        birth = self._born_on_date
        age = today.year - birth.year
        if (today.month, today.day) < (birth.month, birth.day):
            age -= 1
        return age

    def __str__(self):
        return (f"Chicken{{id={self._id}, name={self._name}, color={self._color}, "
                f"bornOnDate={self._born_on_date}, age={self._age_in_years}, "
                f"molting={str(self._molting).lower()}}}")

    
    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, value):
        self._id = value

    @property
    def name(self):
        return self._name

    @name.setter
    def name(self, value):
        self._name = value

    @property
    def color(self):
        return self._color

    @color.setter
    def color(self, value):
        self._color = value

    @property
    def born_on_date(self):
        return self._born_on_date

    @born_on_date.setter
    def born_on_date(self, value):
        self._born_on_date = value

    @property
    def age_in_years(self):
        return self._age_in_years

    @age_in_years.setter
    def age_in_years(self, value):
        self._age_in_years = value

    @property
    def molting(self):
        return self._molting

    @molting.setter
    def molting(self, value):
        self._molting = value