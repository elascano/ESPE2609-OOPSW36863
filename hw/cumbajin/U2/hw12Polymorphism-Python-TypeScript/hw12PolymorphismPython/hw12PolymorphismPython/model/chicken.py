from datetime import date

from .farm_animal import FarmAnimal


class Chicken(FarmAnimal):
    def __init__(
        self,
        animal_id: int,
        breed: str,
        born_on_date: date,
        is_molting: bool,
        number_of_laid_eggs_last_month: int,
        is_meat: bool,
    ) -> None:
        super().__init__(animal_id, breed, born_on_date)
        self.__is_molting = is_molting
        self.__number_of_laid_eggs_last_month = number_of_laid_eggs_last_month
        self.__is_meat = is_meat

    @property
    def is_molting(self) -> bool:
        return self.__is_molting

    @is_molting.setter
    def is_molting(self, is_molting: bool) -> None:
        self.__is_molting = is_molting

    @property
    def number_of_laid_eggs_last_month(self) -> int:
        return self.__number_of_laid_eggs_last_month

    @number_of_laid_eggs_last_month.setter
    def number_of_laid_eggs_last_month(self, quantity: int) -> None:
        self.__number_of_laid_eggs_last_month = quantity

    @property
    def is_meat(self) -> bool:
        return self.__is_meat

    @is_meat.setter
    def is_meat(self, is_meat: bool) -> None:
        self.__is_meat = is_meat

    def __str__(self) -> str:
        return (
            f"Chicken{{{self._farm_animal_data()}, "
            f"isMolting={self.is_molting}, "
            f"numberOfLaidEggsLastMonth={self.number_of_laid_eggs_last_month}, "
            f"isMeat={self.is_meat}}}"
        )
