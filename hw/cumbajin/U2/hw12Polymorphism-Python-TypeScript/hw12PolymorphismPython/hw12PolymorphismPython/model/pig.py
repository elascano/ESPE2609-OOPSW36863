from datetime import date

from .farm_animal import FarmAnimal


class Pig(FarmAnimal):
    def __init__(self, animal_id: int, breed: str, born_on_date: date) -> None:
        super().__init__(animal_id, breed, born_on_date)

    def __str__(self) -> str:
        return f"Pig{{{self._farm_animal_data()}}}"
