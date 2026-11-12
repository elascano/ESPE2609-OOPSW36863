from datetime import date
from .farm_animal import FarmAnimal


class Pig(FarmAnimal):
    def __init__(self, is_meat: bool, id: int, breed: str, born_on_date: date):
        super().__init__(id, breed, born_on_date)
        self._is_meat = is_meat

    def __str__(self) -> str:
        return f"Pig{{{super().__str__()}isMeat={self._is_meat}}}"

    @property
    def is_meat(self) -> bool:
        return self._is_meat

    @is_meat.setter
    def is_meat(self, value: bool) -> None:
        self._is_meat = value
