import json
from datetime import date
from .egg import Egg
from .poop import Poop


class Chicken:
    def __init__(self, id, name, color, born_on_date, molting):
        self.id = id
        self.name = name
        self.color = color
        self.born_on_date = born_on_date   # objeto date
        self.molting = molting

    def do_stuff(self):
        self._cluck()
        self._wander()
        self._drink(1.4)
        print("poop -->", self._poop())
        print("egg -->", self._lay_an_egg())

    def _cluck(self):
        print(f"The chicken {self.name} is clucking")

    def _wander(self):
        print(f"The chicken {self.name} is wandering")

    def _eat(self):
        print(f"The chicken {self.name} is eating...")

    def _drink(self, amount_of_water):
        print(f"The chicken {self.name} is drinking --> {amount_of_water} ml of water")

    def _poop(self):
        return Poop(2, "green", "M")

    def _lay_an_egg(self):
        return Egg(2, "S")

    def compute_age_in_years(self):
        today = date.today()
        age = today.year - self.born_on_date.year
        if (today.month, today.day) < (self.born_on_date.month, self.born_on_date.day):
            age -= 1
        return age

    def to_json(self):
        return json.dumps({
            "id": self.id,
            "name": self.name,
            "color": self.color,
            "bornOnDate": str(self.born_on_date),
            "ageInYears": self.compute_age_in_years(),
            "molting": self.molting,
        })

    def to_csv(self):
        return (f"{self.id},{self.name},{self.color},{self.born_on_date},"
                f"{self.compute_age_in_years()},{self.molting}")

    def __str__(self):
        return (f"Chicken{{id={self.id}, name={self.name}, color={self.color}, "
                f"bornOnDate={self.born_on_date}, ageInYears={self.compute_age_in_years()}, "
                f"molting={self.molting}}}")