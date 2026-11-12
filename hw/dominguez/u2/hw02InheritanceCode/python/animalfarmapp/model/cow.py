from datetime import date
from .farm_animal import FarmAnimal


class Cow(FarmAnimal):
    def __init__(self, is_producting_milk: bool, liter_of_milk_per_week: float,
                 id: int, breed: str, born_on_date: date):
        super().__init__(id, breed, born_on_date)
        self._is_producting_milk = is_producting_milk
        self._liter_of_milk_per_week = liter_of_milk_per_week

    def milk(self) -> None:
        print("milkin the cow")

    def __str__(self) -> str:
        return (f"Cow{{{super().__str__()}isProductingMilk={self._is_producting_milk}, "
                f"literOfMilkPerWeek={self._liter_of_milk_per_week}}}")

    @property
    def is_producting_milk(self) -> bool:
        return self._is_producting_milk

    @is_producting_milk.setter
    def is_producting_milk(self, value: bool) -> None:
        self._is_producting_milk = value

    @property
    def liter_of_milk_per_week(self) -> float:
        return self._liter_of_milk_per_week

    @liter_of_milk_per_week.setter
    def liter_of_milk_per_week(self, value: float) -> None:
        self._liter_of_milk_per_week = value
