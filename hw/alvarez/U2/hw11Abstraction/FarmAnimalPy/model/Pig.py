from datetime import datetime
from model.FarmAnimal import FarmAnimal
from model.Food import Food


class Pig(FarmAnimal):
    def __init__(
        self,
        weight: float,
        is_ready_for_slaughter: bool,
        id: int,
        breed: str,
        born_on_date: datetime,
    ):
        super().__init__(id, breed, born_on_date)
        self.__weight = weight
        self.__is_ready_for_slaughter = is_ready_for_slaughter

    def feed(self, food: Food, amount_of_food: int) -> None:
        self.__weight += amount_of_food * 0.5
        print(f"feeding a pig with -->{amount_of_food} of {food}")

    def __str__(self) -> str:
        return (
            f"Pig{{{super().__str__()}weight={self.__weight}, "
            f"isReadyForSlaughter={str(self.__is_ready_for_slaughter).lower()}}}"
        )

    def get_weight(self) -> float:
        return self.__weight

    def set_weight(self, weight: float) -> None:
        self.__weight = weight

    def is_is_ready_for_slaughter(self) -> bool:
        return self.__is_ready_for_slaughter

    def set_is_ready_for_slaughter(self, is_ready_for_slaughter: bool) -> None:
        self.__is_ready_for_slaughter = is_ready_for_slaughter