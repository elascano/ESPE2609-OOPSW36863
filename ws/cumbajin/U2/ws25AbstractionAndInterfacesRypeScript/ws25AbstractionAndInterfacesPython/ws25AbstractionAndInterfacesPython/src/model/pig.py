"""Pig model."""

from datetime import date

from .farm_animal import FarmAnimal
from .food import Food


class Pig(FarmAnimal):
    """Concrete FarmAnimal implementation for a pig."""

    def __init__(self, animal_id: int, breed: str, born_on_date: date) -> None:
        super().__init__(animal_id, breed, born_on_date)

    def feed(self, food: Food, amount_of_food: float) -> None:
        print(f"Feeding a pig with --> {amount_of_food} of {food}")

    def __str__(self) -> str:
        return f"Pig{{{super().__str__()}}}"
