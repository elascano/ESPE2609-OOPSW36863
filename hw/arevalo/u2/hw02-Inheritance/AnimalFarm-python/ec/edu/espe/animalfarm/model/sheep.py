from datetime import date

from ec.edu.espe.animalfarm.model.farm_animal import FarmAnimal


class Sheep(FarmAnimal):
    def __init__(
        self, last_shearing: date, wool_weight_in_kg: float, wool_color: str,
        id: int, breed: str, born_on_date: date
    ):
        super().__init__(id, breed, born_on_date)
        self._last_shearing = last_shearing
        self._wool_weight_in_kg = wool_weight_in_kg
        self._wool_color = wool_color

    def __str__(self) -> str:
        return (
            f"Sheep{{{super().__str__()}last_shearing={self._last_shearing:%d/%m/%Y}, "
            f"wool_weight_in_kg={self._wool_weight_in_kg}, "
            f"wool_color={self._wool_color}}}"
        )

    def get_last_shearing(self) -> date:
        return self._last_shearing

    def set_last_shearing(self, last_shearing: date):
        self._last_shearing = last_shearing

    def get_wool_weight_in_kg(self) -> float:
        return self._wool_weight_in_kg

    def set_wool_weight_in_kg(self, wool_weight_in_kg: float):
        self._wool_weight_in_kg = wool_weight_in_kg

    def get_wool_color(self) -> str:
        return self._wool_color

    def set_wool_color(self, wool_color: str):
        self._wool_color = wool_color
