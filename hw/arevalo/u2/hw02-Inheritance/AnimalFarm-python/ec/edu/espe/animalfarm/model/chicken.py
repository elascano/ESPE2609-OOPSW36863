from datetime import date

from ec.edu.espe.animalfarm.model.farm_animal import FarmAnimal


class Chicken(FarmAnimal):
    def __init__(
        self, is_molting: bool, number_of_laid_egg_in_month: int,
        is_meat: bool, id: int, breed: str, born_on_date: date
    ):
        super().__init__(id, breed, born_on_date)
        self._is_molting = is_molting
        self._number_of_laid_egg_in_month = number_of_laid_egg_in_month
        self._is_meat = is_meat

    def __str__(self) -> str:
        return (
            f"Chicken{{{super().__str__()}is_molting={self._is_molting}, "
            f"number_of_laid_egg_in_month={self._number_of_laid_egg_in_month}, "
            f"is_meat={self._is_meat}}}"
        )

    def is_molting(self) -> bool:
        return self._is_molting

    def set_is_molting(self, is_molting: bool):
        self._is_molting = is_molting

    def get_number_of_laid_egg_in_month(self) -> int:
        return self._number_of_laid_egg_in_month

    def set_number_of_laid_egg_in_month(self, number_of_laid_egg_in_month: int):
        self._number_of_laid_egg_in_month = number_of_laid_egg_in_month

    def is_meat(self) -> bool:
        return self._is_meat

    def set_is_meat(self, is_meat: bool):
        self._is_meat = is_meat
