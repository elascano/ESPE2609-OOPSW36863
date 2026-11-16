from datetime import datetime
from typing import Optional

from .farm_animal import FarmAnimal
from .food import Food


class Cow(FarmAnimal):
    def __init__(self, is_producing_milk: bool, liter_of_milk_per_week: float,
                 id: int, breed: str, born_on_date: datetime) -> None:
        super().__init__(id, breed, born_on_date)
        self.is_producing_milk = is_producing_milk
        self.liter_of_milk_per_week = liter_of_milk_per_week

    def feed(self, food: Food, amount_of_food: int) -> None:
        print(f"feeding a cow in the stable with {amount_of_food} of {food}")

    def milk(self, amount_of_liters: Optional[float] = None,
             hour: Optional[datetime] = None) -> None:
        """Replaces the four Java overloads of milk():
        milk(), milk(int), milk(float) and milk(int, Date)."""
        if amount_of_liters is None:
            print("milking the cow as I need")
            return
        self.liter_of_milk_per_week = round(self.liter_of_milk_per_week + amount_of_liters, 2)
        if hour is None:
            print(f"milking the cow for {amount_of_liters} liters")
        else:
            print(f"milking the cow for {amount_of_liters} liters, "
                  f"at {hour.hour}:{hour.minute}")

    def __str__(self) -> str:
        return (f"Cow{{{super().__str__()}isProductingMilk={self.is_producing_milk}, "
                f"literOfMilkPerWeek={self.liter_of_milk_per_week}}}")
