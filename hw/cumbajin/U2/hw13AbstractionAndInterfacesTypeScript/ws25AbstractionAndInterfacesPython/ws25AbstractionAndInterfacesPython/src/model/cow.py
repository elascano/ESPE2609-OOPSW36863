"""Cow model."""

from datetime import date, datetime

from .farm_animal import FarmAnimal
from .food import Food
from .graze_animal import GrazeAnimal
from .location import Location


class Cow(FarmAnimal, GrazeAnimal):
    """A cow that implements feeding and grazing behavior."""

    def __init__(
        self,
        is_producing_milk: bool,
        liters_of_milk_per_week: float,
        animal_id: int,
        breed: str,
        born_on_date: date,
    ) -> None:
        super().__init__(animal_id, breed, born_on_date)
        self.is_producing_milk = is_producing_milk
        self.liters_of_milk_per_week = liters_of_milk_per_week

    def feed(self, food: Food, amount_of_food: float) -> None:
        print(f"Feeding a cow with --> {amount_of_food} of {food}")

    def graze(self, location: Location) -> None:
        print(f"Sending the cow to eat grass at --> {location}")

    def milk(
        self,
        amount_of_liters: int | float | None = None,
        hour: date | datetime | None = None,
    ) -> None:
        """Python alternative to the overloaded Java milk methods."""
        if amount_of_liters is None:
            print("Milking the cow as I need")
            return

        self.liters_of_milk_per_week += float(amount_of_liters)
        message = f"Milking the cow for --> {amount_of_liters} liters"
        if hour is not None:
            message += f", at --> {hour}"
        print(message)

    def __str__(self) -> str:
        return (
            f"Cow{{{super().__str__()}, "
            f"isProducingMilk={self.is_producing_milk}, "
            f"litersOfMilkPerWeek={self.liters_of_milk_per_week}}}"
        )
