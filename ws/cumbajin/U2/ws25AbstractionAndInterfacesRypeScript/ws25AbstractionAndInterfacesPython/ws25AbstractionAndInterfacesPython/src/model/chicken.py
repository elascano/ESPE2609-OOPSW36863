"""Chicken model."""

from datetime import date

from .farm_animal import FarmAnimal
from .food import Food


class Chicken(FarmAnimal):
    """Concrete FarmAnimal implementation for a chicken."""

    def __init__(
        self,
        animal_id: int,
        breed: str,
        born_on_date: date,
        is_molting: bool,
        number_of_layings_month: int,
        is_meat: bool,
    ) -> None:
        super().__init__(animal_id, breed, born_on_date)
        self.is_molting = is_molting
        self.number_of_layings_month = number_of_layings_month
        self.is_meat = is_meat

    def feed(self, food: Food, amount_of_food: float) -> None:
        print(
            f"Feeding a chicken with --> {amount_of_food} "
            f"of {food} in the month"
        )

    def __str__(self) -> str:
        return (
            f"Chicken{{{super().__str__()}, isMolting={self.is_molting}, "
            f"numberOfLayingsMonth={self.number_of_layings_month}, "
            f"isMeat={self.is_meat}}}"
        )
