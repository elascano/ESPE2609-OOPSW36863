from datetime import date
from ec.edu.espe.animalfarmapp.model.FarmAnimal import FarmAnimal


class Sheep(FarmAnimal):
    def __init__(
        self,
        wool_production_kg: float,
        is_sheared: bool,
        id: int,
        breed: str,
        born_on_date: date,
    ):
        super().__init__(id, breed, born_on_date)
        self._wool_production_kg = wool_production_kg
        self._is_sheared = is_sheared

    def __str__(self) -> str:
        return (
            f"Sheep{{{super().__str__()}woolProductionkg={self._wool_production_kg}, "
            f"isSheared={self._is_sheared}}}"
        )

    def get_wool_production_kg(self) -> float:
        return self._wool_production_kg

    def set_wool_production_kg(self, wool_production_kg: float) -> None:
        self._wool_production_kg = wool_production_kg

    def is_is_sheared(self) -> bool:
        return self._is_sheared

    def set_is_sheared(self, is_sheared: bool) -> None:
        self._is_sheared = is_sheared

    def shear(self) -> None:
        self._is_sheared = True
        print("The sheep has been sheared")
