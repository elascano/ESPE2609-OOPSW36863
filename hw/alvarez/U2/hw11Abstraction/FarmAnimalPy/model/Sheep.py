from datetime import datetime
from model.FarmAnimal import FarmAnimal
from model.Food import Food
from model.grazeAnimal import grazeAnimal
from model.Location import Location


class Sheep(FarmAnimal, grazeAnimal):
    def __init__(
        self,
        last_shearing: datetime,
        is_producing_wool: bool,
        id: int,
        breed: str,
        born_on_date: datetime,
    ):
        super().__init__(id, breed, born_on_date)
        self.__last_shearing = last_shearing
        self.__is_producing_wool = is_producing_wool

    def graze(self, location: Location) -> None:
        print(f"sending the sheep to eat grass at -->{location}")

    def feed(self, food: Food, amount_of_food: int) -> None:
        print(f"feeding a sheep with -->{amount_of_food} of {food}")

    def shear(self) -> None:
        print("shearing the sheep for wool")

    def __str__(self) -> str:
        return (
            f"Sheep{{{super().__str__()}lastShearing={self.__last_shearing.day}/{self.__last_shearing.month}/{self.__last_shearing.year}, "
            f"isProducingWool={str(self.__is_producing_wool).lower()}}}"
        )

    def get_last_shearing(self) -> datetime:
        return self.__last_shearing

    def set_last_shearing(self, last_shearing: datetime) -> None:
        self.__last_shearing = last_shearing

    def is_is_producing_wool(self) -> bool:
        return self.__is_producing_wool

    def set_is_producing_wool(self, is_producing_wool: bool) -> None:
        self.__is_producing_wool = is_producing_wool