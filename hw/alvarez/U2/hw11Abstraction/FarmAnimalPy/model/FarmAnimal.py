from abc import ABC, abstractmethod
from datetime import datetime
from model.Food import Food


class FarmAnimal(ABC):
    def __init__(self, id: int, breed: str, born_on_date: datetime):
        self.__id = id
        self.__breed = breed
        self.__born_on_date = born_on_date

    @abstractmethod
    def feed(self, food: Food, amount_of_food: int) -> None:
        pass

    def get_age_in_months(self) -> int:
        return 0

    def __str__(self) -> str:
        return (
            f"id={self.__id}, breed={self.__breed}, "
            f"bornOnDate={self.__born_on_date.day}/{self.__born_on_date.month}/{self.__born_on_date.year},"
        )

    def get_id(self) -> int:
        return self.__id

    def set_id(self, id: int) -> None:
        self.__id = id

    def get_breed(self) -> str:
        return self.__breed

    def set_breed(self, breed: str) -> None:
        self.__breed = breed

    def get_born_on_date(self) -> datetime:
        return self.__born_on_date

    def set_born_on_date(self, born_on_date: datetime) -> None:
        self.__born_on_date = born_on_date