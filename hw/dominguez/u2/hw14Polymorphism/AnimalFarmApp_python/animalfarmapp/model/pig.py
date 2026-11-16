from datetime import datetime

from .farm_animal import FarmAnimal
from .food import Food


class Pig(FarmAnimal):
    def __init__(self, is_meat: bool, id: int, breed: str, born_on_date: datetime) -> None:
        super().__init__(id, breed, born_on_date)
        self.is_meat = is_meat

    def rooting(self) -> None:
        print("The pig is rooting")

    def wallowing(self) -> None:
        print("The pig is wallowing")

    def feed(self, food: Food, amount_of_food: int) -> None:
        print(f"feeding a pigs in the stable with {amount_of_food} of {food}")

    def __str__(self) -> str:
        return f"Pig{{{super().__str__()}isMeat={self.is_meat}}}"
