"""Chicken inherits from FarmAnimal."""

from datetime import date
from model.FarmAnimal import FarmAnimal


class Chicken(FarmAnimal):
    def __init__(self, id: int, bread: str, born_on_date: date,
                 is_molting: bool, number_off_lat_is_month: int,
                 is_meat: bool):
        super().__init__(id, bread, born_on_date)
        self.is_molting = is_molting
        self.number_off_lat_is_month = number_off_lat_is_month
        self.is_meat = is_meat

    def __str__(self) -> str:
        return (
            f"Chicken{{{super().__str__()}, "
            f"isMolting={str(self.is_molting).lower()}, "
            f"numberOffLatIsMonth={self.number_off_lat_is_month}, "
            f"isMeat={str(self.is_meat).lower()}}}"
        )
