"""Cow inherits from FarmAnimal."""

from datetime import date
from model.FarmAnimal import FarmAnimal


class Cow(FarmAnimal):
    def __init__(self, is_producing_milk: bool, liters_of_milk_per_week: float,
                 id: int, bread: str, born_on_date: date):
        super().__init__(id, bread, born_on_date)
        self.is_producing_milk = is_producing_milk
        self.liters_of_milk_per_week = liters_of_milk_per_week

    def milk(self) -> None:
        print("Milking the cow")

    def __str__(self) -> str:
        return (
            f"Cow{{{super().__str__()}, "
            f"isProducingMilk={str(self.is_producing_milk).lower()}, "
            f"litersOfMilkPerWeek={self.liters_of_milk_per_week}}}"
        )
