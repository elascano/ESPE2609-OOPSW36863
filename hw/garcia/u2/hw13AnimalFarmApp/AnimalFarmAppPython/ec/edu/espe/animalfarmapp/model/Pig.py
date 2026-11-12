from datetime import date
from ec.edu.espe.animalfarmapp.model.FarmAnimal import FarmAnimal


class Pig(FarmAnimal):
    def __init__(
        self,
        weight_kg: float,
        is_for_breeding: bool,
        id: int,
        breed: str,
        born_on_date: date,
    ):
        super().__init__(id, breed, born_on_date)
        self._weight_kg = weight_kg
        self._is_for_breeding = is_for_breeding

    def __str__(self) -> str:
        return (
            f"Pig{{{super().__str__()}weightKg={self._weight_kg}, "
            f"isForBreeding={self._is_for_breeding}}}"
        )

    def get_weight_kg(self) -> float:
        return self._weight_kg

    def set_weight_kg(self, weight_kg: float) -> None:
        self._weight_kg = weight_kg

    def is_is_for_breeding(self) -> bool:
        return self._is_for_breeding

    def set_is_for_breeding(self, is_for_breeding: bool) -> None:
        self._is_for_breeding = is_for_breeding

    def feed(self) -> None:
        print("Feeding the pig...")
