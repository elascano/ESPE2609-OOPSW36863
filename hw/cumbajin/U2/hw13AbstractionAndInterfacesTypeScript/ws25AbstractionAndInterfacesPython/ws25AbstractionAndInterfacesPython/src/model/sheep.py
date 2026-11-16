"""Sheep model."""

from datetime import date

from .farm_animal import FarmAnimal
from .food import Food
from .graze_animal import GrazeAnimal
from .location import Location


class Sheep(FarmAnimal, GrazeAnimal):
    """A sheep that implements feeding and grazing behavior."""

    def __init__(
        self,
        last_shearing: date,
        animal_id: int,
        breed: str,
        born_on_date: date,
    ) -> None:
        super().__init__(animal_id, breed, born_on_date)
        self.last_shearing = last_shearing

    def feed(self, food: Food, amount_of_food: float) -> None:
        print(f"Feeding a sheep with --> {amount_of_food} of {food}")

    def graze(self, location: Location) -> None:
        print(f"Sending the sheep to eat grass at --> {location}")

    def __str__(self) -> str:
        return (
            f"Sheep{{{super().__str__()}, "
            f"lastShearing={self.last_shearing.isoformat()}}}"
        )
