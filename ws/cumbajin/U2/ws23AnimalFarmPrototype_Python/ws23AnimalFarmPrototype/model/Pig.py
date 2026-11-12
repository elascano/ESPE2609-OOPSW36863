"""Pig inherits the common fields from FarmAnimal."""

from datetime import date
from model.FarmAnimal import FarmAnimal


class Pig(FarmAnimal):
    def __init__(self, id: int, bread: str, born_on_date: date):
        super().__init__(id, bread, born_on_date)

    def __str__(self) -> str:
        return f"Pig{{{super().__str__()}}}"
