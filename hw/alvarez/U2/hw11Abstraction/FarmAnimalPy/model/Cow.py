from datetime import datetime
from typing import Optional
from model.FarmAnimal import FarmAnimal
from model.Food import Food
from model.grazeAnimal import grazeAnimal
from model.Location import Location


class Cow(FarmAnimal, grazeAnimal):
    def __init__(
        self,
        is_producing_milk: bool,
        liters_of_milk_for_week: float,
        id: int,
        breed: str,
        born_on_date: datetime,
    ):
        super().__init__(id, breed, born_on_date)
        self.__is_producing_milk = is_producing_milk
        self.__liters_of_milk_per_week = liters_of_milk_for_week

    def graze(self, location: Location) -> None:
        print(f"sending the cow to eat grass at -->{location}")

    def feed(self, food: Food, amount_of_food: int) -> None:
        print(f"feeding a cow with -->{food}")

    def milk(self, amount_of_liters: Optional[float] = None, hour: Optional[datetime] = None) -> None:
        if amount_of_liters is None:
            print("milking the cow as I need")
        elif hour is None:
            self.__liters_of_milk_per_week += amount_of_liters
            print(f"milking the cow for {amount_of_liters} liters.")
        else:
            print(f"milking the cow for{amount_of_liters} liters, at {hour.hour}:{hour.minute}")

    def __str__(self) -> str:
        return (
            f"Cow{{{super().__str__()}isProducingMilk={str(self.__is_producing_milk).lower()}, "
            f"litersOfMilkForWeek={self.__liters_of_milk_per_week}}}"
        )

    def is_is_producing_milk(self) -> bool:
        return self.__is_producing_milk

    def set_is_producing_milk(self, is_producing_milk: bool) -> None:
        self.__is_producing_milk = is_producing_milk

    def get_liters_of_milk_per_week(self) -> float:
        return self.__liters_of_milk_per_week

    def set_liters_of_milk_per_week(self, liters_of_milk_per_week: float) -> None:
        self.__liters_of_milk_per_week = liters_of_milk_per_week