from .FarmAnimal import FarmAnimal
from .grazeAnimal import grazeAnimal


class Cow(FarmAnimal, grazeAnimal):
    def __init__(self, IsProducingMilk: bool, litersOfMilkPerWeek: float, id: int, breed: str, bornOnDate):
        super().__init__(id, breed, bornOnDate)
        self.IsProducingMilk = IsProducingMilk
        self.litersOfMilkPerWeek = litersOfMilkPerWeek

    def graze(self, location):
        print(f"Sending the cow to eat grass at --> {location}")

    def feed(self, food, amountOfFood: int):
        print(f"Feeding a cow in the stabel with --> {food}")

    def __str__(self):
        return f"Cow{{{super().__str__()}IsProducingMilk = {self.IsProducingMilk}, litersOfMilkPerWeek = {self.litersOfMilkPerWeek}}}"

    def milk(self, amountOfLiters=None, hour=None):
        if amountOfLiters is None:
            print("Milking the cow ")
        elif hour is not None:
            print(f"Milking the cow for {amountOfLiters} liters, at {hour.hour}:{hour.minute}")
        else:
            self.litersOfMilkPerWeek += amountOfLiters
            print(f"Milking the cow -->{amountOfLiters}")

    def isIsProducingMilk(self):
        return self.IsProducingMilk

    def setIsProducingMilk(self, IsProducingMilk: bool):
        self.IsProducingMilk = IsProducingMilk

    def getLitersOfMilkPerWeek(self):
        return self.litersOfMilkPerWeek

    def setLitersOfMilkPerWeek(self, litersOfMilkPerWeek: float):
        self.litersOfMilkPerWeek = litersOfMilkPerWeek
