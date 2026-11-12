from datetime import date

from ec.edu.espe.animalfarm.model.farm_animal import FarmAnimal


class Pig(FarmAnimal):
    def __init__(
        self, weight_in_kg: float, daily_food_intake_in_kg: float,
        is_castrated: bool, id: int, breed: str, born_on_date: date
    ):
        super().__init__(id, breed, born_on_date)
        self._weight_in_kg = weight_in_kg
        self._daily_food_intake_in_kg = daily_food_intake_in_kg
        self._is_castrated = is_castrated

    def __str__(self) -> str:
        return (
            f"Pig{{{super().__str__()}weight_in_kg={self._weight_in_kg}, "
            f"daily_food_intake_in_kg={self._daily_food_intake_in_kg}, "
            f"is_castrated={self._is_castrated}}}"
        )

    def get_weight_in_kg(self) -> float:
        return self._weight_in_kg

    def set_weight_in_kg(self, weight_in_kg: float):
        self._weight_in_kg = weight_in_kg

    def get_daily_food_intake_in_kg(self) -> float:
        return self._daily_food_intake_in_kg

    def set_daily_food_intake_in_kg(self, daily_food_intake_in_kg: float):
        self._daily_food_intake_in_kg = daily_food_intake_in_kg

    def is_castrated(self) -> bool:
        return self._is_castrated

    def set_castrated(self, is_castrated: bool):
        self._is_castrated = is_castrated
