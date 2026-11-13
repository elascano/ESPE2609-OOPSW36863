from datetime import date

from .farm_animal import FarmAnimal


class Cow(FarmAnimal):
    def __init__(
        self,
        is_producing_milk: bool,
        liters_of_milk_per_week: float,
        animal_id: int,
        breed: str,
        born_on_date: date,
    ) -> None:
        super().__init__(animal_id, breed, born_on_date)
        self.__is_producing_milk = is_producing_milk
        self.__liters_of_milk_per_week = liters_of_milk_per_week

    @property
    def is_producing_milk(self) -> bool:
        return self.__is_producing_milk

    @is_producing_milk.setter
    def is_producing_milk(self, is_producing_milk: bool) -> None:
        self.__is_producing_milk = is_producing_milk

    @property
    def liters_of_milk_per_week(self) -> float:
        return self.__liters_of_milk_per_week

    @liters_of_milk_per_week.setter
    def liters_of_milk_per_week(self, liters: float) -> None:
        self.__liters_of_milk_per_week = liters

    def milk(self) -> None:
        print("Milking the cow")

    def __str__(self) -> str:
        return (
            f"Cow{{{self._farm_animal_data()}, "
            f"isProducingMilk={self.is_producing_milk}, "
            f"litersOfMilkPerWeek={self.liters_of_milk_per_week}}}"
        )
