from abc import ABC, abstractmethod
from datetime import date, datetime

from .food import Food


class FarmAnimal(ABC):
    def __init__(self, id: int, breed: str, born_on_date: datetime) -> None:
        self.id = id
        self.breed = breed
        self.born_on_date = born_on_date

    @abstractmethod
    def feed(self, food: Food, amount_of_food: int) -> None:
        """Feed the animals with their own food."""

    def get_age_in_months(self) -> int:
        today = date.today()
        born = self.born_on_date
        months = (today.year - born.year) * 12 + (today.month - born.month)
        if today.day < born.day:
            months -= 1
        return max(months, 0)

    def __str__(self) -> str:
        b = self.born_on_date
        return (f"id={self.id}, breed={self.breed}, "
                f"bornOnDate={b.day}/{b.month}/{b.year}, ")
