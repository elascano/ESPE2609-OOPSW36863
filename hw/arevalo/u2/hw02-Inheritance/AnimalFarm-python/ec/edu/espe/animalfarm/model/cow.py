from datetime import date

from ec.edu.espe.animalfarm.model.farm_animal import FarmAnimal


class Cow(FarmAnimal):
    def __init__(
        self, is_producing_milk: bool, liters_of_milk_for_week: float,
        id: int, breed: str, born_on_date: date
    ):
        super().__init__(id, breed, born_on_date)
        self._is_producing_milk = is_producing_milk
        self._liters_of_milk_for_week = liters_of_milk_for_week

    def milk(self):
        print("milking the cow")

    def __str__(self) -> str:
        return (
            f"Cow{{{super().__str__()}is_producing_milk={self._is_producing_milk}, "
            f"liters_of_milk_for_week={self._liters_of_milk_for_week}}}"
        )

    def is_producing_milk(self) -> bool:
        return self._is_producing_milk

    def set_is_producing_milk(self, is_producing_milk: bool):
        self._is_producing_milk = is_producing_milk

    def get_liters_of_milk_for_week(self) -> float:
        return self._liters_of_milk_for_week

    def set_liters_of_milk_for_week(self, liters_of_milk_for_week: float):
        self._liters_of_milk_for_week = liters_of_milk_for_week
