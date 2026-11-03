import datetime as dt
from Egg import Egg
from Poop import Poop

class Chicken:
    id = 0

    def __init__(self, name, color, born_on_date, molting):
        Chicken.id += 1
        self.id = Chicken.id
        self.name = name
        self.color = color
        self.born_on_date = dt.date.fromisoformat(born_on_date) if isinstance(born_on_date, str) else born_on_date
        self.age_in_year = self.__compute_age_years()
        self.molting = molting

    def __compute_age_years(self):
        today = dt.date.today()
        year = today.year - self.born_on_date.year
        if (today.month, today.day) < (self.born_on_date.month, self.born_on_date.day):
            year -= 1
        return year

    def __cluck(self):
        print(f"The Chicken {self.name} is clucking")

    def __eat(self):
        print(f"The Chicken {self.name} is eating")

    def __drink(self, amount_of_water):
        print(f"The Chicken {self.name} is drinking ---- {amount_of_water} liters")

    def __poop(self):
        poop = Poop("Green", "s")
        print(poop)

    def __lay_an_egg(self):
        egg = Egg("M")
        print(egg)

    def do_sftuff(self):
        self.__cluck()
        self.__eat()
        self.__drink(10)
        self.__eat()
        self.__poop()
        self.__lay_an_egg()

    def to_dict(self):
        return {
            "id": self.id,
            "name": self.name,
            "color": self.color,
            "born_on_date": self.born_on_date.isoformat(),
            "molting": self.molting
        }

    @classmethod
    def from_dict(cls, data):
        chicken = cls(data["name"], data["color"], data["born_on_date"], data["molting"])
        chicken.id = data["id"]
        if chicken.id > cls.id:
            cls.id = chicken.id
        return chicken

    def __str__(self):
        return f"Chicken [ID: {self.id}, Name: {self.name}, Age: {self.age_in_year} years, Molting: {self.molting}]"