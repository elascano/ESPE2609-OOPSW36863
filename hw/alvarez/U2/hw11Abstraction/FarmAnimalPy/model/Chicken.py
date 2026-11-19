from datetime import datetime
from model.FarmAnimal import FarmAnimal
from model.Food import Food


class Chicken(FarmAnimal):
    def __init__(
        self,
        is_molting: bool,
        number_of_laid_eggs_in_a_month: int,
        is_meat: bool,
        id: int,
        breed: str,
        born_on_date: datetime,
    ):
        super().__init__(id, breed, born_on_date)
        self.__is_molting = is_molting
        self.__number_of_laid_eggs_in_a_month = number_of_laid_eggs_in_a_month
        self.__is_meat = is_meat

    def feed(self, food: Food, amount_of_food: int) -> None:
        print(f"feeding a chicken with -->{amount_of_food} of {food}")

    def lay_an_egg(self) -> None:
        self.__number_of_laid_eggs_in_a_month += 1
        print("chicken is laying an egg() ")

    def __str__(self) -> str:
        return (
            f"Chicken{{{super().__str__()}isMolting={str(self.__is_molting).lower()}, "
            f"numberOfLaidEggsInAMonth={self.__number_of_laid_eggs_in_a_month}, "
            f"isMeat={str(self.__is_meat).lower()}}}"
        )

    def is_is_molting(self) -> bool:
        return self.__is_molting

    def set_is_molting(self, is_molting: bool) -> None:
        self.__is_molting = is_molting

    def get_number_of_laid_egg_in_month(self) -> int:
        return self.__number_of_laid_eggs_in_a_month

    def set_number_of_laid_egg_in_month(self, number_of_laid_egg_in_month: int) -> None:
        self.__number_of_laid_eggs_in_a_month = number_of_laid_egg_in_month

    def is_is_meat(self) -> bool:
        return self.__is_meat

    def set_is_meat(self, is_meat: bool) -> None:
        self.__is_meat = is_meat