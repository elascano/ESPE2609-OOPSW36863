"""Abstract farm animal model."""

from abc import ABC, abstractmethod
from datetime import date

from .food import Food


class FarmAnimal(ABC):
    """Abstract base class shared by every farm animal."""

    def __init__(self, animal_id: int, breed: str, born_on_date: date) -> None:
        self.id = animal_id
        self.breed = breed
        self.born_on_date = born_on_date

    @abstractmethod
    def feed(self, food: Food, amount_of_food: float) -> None:
        """Feed the animal with its own food."""

    def get_age_in_months(self) -> int:
        today = date.today()
        months = (today.year - self.born_on_date.year) * 12
        months += today.month - self.born_on_date.month
        if today.day < self.born_on_date.day:
            months -= 1
        return max(months, 0)

    def __str__(self) -> str:
        return (
            f"FarmAnimal{{id={self.id}, breed={self.breed}, "
            f"bornOnDate={self.born_on_date.isoformat()}}}"
        )
