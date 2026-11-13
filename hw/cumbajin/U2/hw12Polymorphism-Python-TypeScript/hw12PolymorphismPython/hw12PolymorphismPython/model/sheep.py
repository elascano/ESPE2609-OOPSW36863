from datetime import date

from .farm_animal import FarmAnimal


class Sheep(FarmAnimal):
    def __init__(
        self,
        last_shearing: date,
        animal_id: int,
        breed: str,
        born_on_date: date,
    ) -> None:
        super().__init__(animal_id, breed, born_on_date)
        self.__last_shearing = last_shearing

    @property
    def last_shearing(self) -> date:
        return self.__last_shearing

    @last_shearing.setter
    def last_shearing(self, last_shearing: date) -> None:
        self.__last_shearing = last_shearing

    def __str__(self) -> str:
        return (
            f"Sheep{{{self._farm_animal_data()}, "
            f"lastShearing={self.last_shearing.year}}}"
        )
