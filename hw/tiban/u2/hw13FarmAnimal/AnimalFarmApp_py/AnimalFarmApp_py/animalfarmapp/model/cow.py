from datetime import date, datetime

from .farm_animal import FarmAnimal
from .food import Food
from .graze_animal import GrazeAnimal
from .location import Location


class Cow(FarmAnimal, GrazeAnimal):
    """Las vacas."""

    def __init__(self, is_producing_milk: bool, liters_of_milk_per_week: float,
                 id: int, breed: str, born_on_date: date):
        super().__init__(id, breed, born_on_date)
        self.is_producing_milk = is_producing_milk
        self.liters_of_milk_per_week = liters_of_milk_per_week

    def graze(self, location: Location) -> None:
        print(f"sending the cow to eat grass at -->{location}")

    def feed(self, food: Food, amount_of_food: int) -> None:
        print(f"feeding a cow with -->{food}")

    def milk(self, amount_of_liters: float | None = None,
             hour: datetime | None = None) -> None:
        """Ordeña la vaca. Reemplaza la sobrecarga de métodos de Java:

        milk()                  -> ordeña "como se necesite"
        milk(liters)            -> suma los litros (int o float)
        milk(liters, hour)      -> registra litros y hora (no acumula, como en el original)
        """
        if amount_of_liters is None:
            print("milking the cow as I need.")
        elif hour is not None:
            print(f"milking the cow for{amount_of_liters} liters, "
                  f"at {hour.hour}:{hour.minute}")
        else:
            self.liters_of_milk_per_week += amount_of_liters
            print(f"milking the cow for {amount_of_liters} liters.")

    def __str__(self) -> str:
        return (f"Cow{{{super().__str__()}isProducingMilk={self.is_producing_milk}, "
                f"litersOfMilkPerWeek={self.liters_of_milk_per_week}}}")
