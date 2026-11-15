from .farm_animal import FarmAnimal
from .graze_animal import GrazeAnimal
from .food import Food
from .location import Location
from datetime import datetime
class Cow(FarmAnimal, GrazeAnimal):
    def __init__(self, is_producing: bool, liters_per_week: float, id_val: int, breed: str, born_on_date: datetime):
        super().__init__(id_val, breed, born_on_date)
        self.is_producing_milk = is_producing
        self.liters_of_milk_per_week = liters_per_week
    def milk(self, amount: float = None, time: datetime = None):
        if amount is not None and time is not None:
            print(f"milking the cow for {amount} liters, at {time.hour}:{time.minute}")
            self.liters_of_milk_per_week += amount
        elif amount is not None:
            print(f"milking the cow for {amount} liters")
            self.liters_of_milk_per_week += amount
        else:
            print("milking the cow as I need")
    def graze(self, location: Location):
        print(f"Cow is grazing at --> {location.description}")
    def feed(self, food: Food, amount_of_food: int):
        print(f"feeding a cow in the stable with --> {food}")
    def __str__(self):
        return f"Cow{{{super().__str__()}isProductingMilk={self.is_producing_milk}, litersOfMilkPerWeek={self.liters_of_milk_per_week}}}"