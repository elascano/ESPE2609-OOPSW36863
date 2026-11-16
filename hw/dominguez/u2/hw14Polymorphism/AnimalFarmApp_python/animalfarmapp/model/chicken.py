from datetime import datetime

from .farm_animal import FarmAnimal
from .food import Food


class Chicken(FarmAnimal):
    def __init__(self, is_molting: bool, number_of_laid_eggs_in_a_month: int,
                 is_meat: bool, id: int, breed: str, born_on_date: datetime) -> None:
        super().__init__(id, breed, born_on_date)
        self.is_molting = is_molting
        self.number_of_laid_eggs_in_a_month = number_of_laid_eggs_in_a_month
        self.is_meat = is_meat

    def feed(self, food: Food, amount_of_food: int) -> None:
        print(f"feeding a chicken with {amount_of_food} of {food}")

    def lay_an_egg(self) -> None:
        print("chicken is laying an egg ()")

    def __str__(self) -> str:
        return (f"Chicken{{{super().__str__()}isMolting={self.is_molting}, "
                f"numberOfLaidEggsInAMonth={self.number_of_laid_eggs_in_a_month}, "
                f"isMeat={self.is_meat}}}")
