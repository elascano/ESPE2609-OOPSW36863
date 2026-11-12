from datetime import date
from ec.edu.espe.animalfarmapp.model.FarmAnimal import FarmAnimal


class Cow(FarmAnimal):
    def __init__(
        self,
        is_producing_milk: bool,
        liters_of_milk_per_week: float,
        id: int,
        breed: str,
        born_on_date: date,
    ):
        super().__init__(id, breed, born_on_date)
        self._is_producing_milk = is_producing_milk
        self._liters_of_milk_per_week = liters_of_milk_per_week

    def __str__(self) -> str:
        return (
            f"Cow{{{super().__str__()}IsProducingMilk={self._is_producing_milk}, "
            f"litersOfMilkPerWeek={self._liters_of_milk_per_week}}}"
        )

    def milk(self) -> None:
        print("Milking the cow ")

    def is_is_producing_milk(self) -> bool:
        return self._is_producing_milk

    def set_is_producing_milk(self, is_producing_milk: bool) -> None:
        self._is_producing_milk = is_producing_milk

    def get_liters_of_milk_per_week(self) -> float:
        return self._liters_of_milk_per_week

    def set_liters_of_milk_per_week(self, liters_of_milk_per_week: float) -> None:
        self._liters_of_milk_per_week = liters_of_milk_per_week
