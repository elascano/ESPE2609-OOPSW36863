from abc import ABC, abstractmethod
from datetime import date

from .food import Food


class FarmAnimal(ABC):
    """Los animales de la granja."""

    def __init__(self, id: int, breed: str, born_on_date: date):
        self.id = id
        self.breed = breed
        self.born_on_date = born_on_date

    @abstractmethod
    def feed(self, food: Food, amount_of_food: int) -> None:
        """Alimenta al animal con su propia comida."""

    def get_age_in_months(self, today: date | None = None) -> int:
        today = today or date.today()
        b = self.born_on_date
        months = (today.year - b.year) * 12 + (today.month - b.month)
        if today.day < b.day:
            months -= 1
        return max(months, 0)

    def __str__(self) -> str:
        b = self.born_on_date
        return (f"id={self.id}, breed={self.breed}, "
                f"bornOnDate={b.day}/{b.month}/{b.year},")
