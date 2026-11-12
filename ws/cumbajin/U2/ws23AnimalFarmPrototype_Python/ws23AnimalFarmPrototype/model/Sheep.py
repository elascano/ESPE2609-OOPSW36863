"""Sheep inherits from FarmAnimal and stores last shearing date."""

from datetime import date
from model.FarmAnimal import FarmAnimal


class Sheep(FarmAnimal):
    def __init__(self, last_sheering: date, id: int, bread: str,
                 born_on_date: date):
        super().__init__(id, bread, born_on_date)
        # Keep "sheering" spelling from the original Java workshop.
        self.last_sheering = last_sheering

    def __str__(self) -> str:
        return (
            f"Sheep{{{super().__str__()}, "
            f"lastSheering={self.last_sheering.year}}}"
        )
