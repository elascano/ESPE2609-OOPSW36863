
from model.farm_animal import FarmAnimal


class Cow(FarmAnimal):

    def __init__(self, is_producing_milk, liters_of_milk_per_week,
                 id, breed, born_on_date):

        super().__init__(id, breed, born_on_date)

        self._is_producing_milk = is_producing_milk
        self._liters_of_milk_per_week = liters_of_milk_per_week

    def milk(self):
        print("Milking the cow")

    def __str__(self):
        return (
            f"Cow{{{super().__str__()}"
            f"IsProducingMilk={self._is_producing_milk}, "
            f"litersOfMilkPerWeek={self._liters_of_milk_per_week}}}"
        )

    @property
    def is_producing_milk(self):
        return self._is_producing_milk

    @is_producing_milk.setter
    def is_producing_milk(self, value):
        self._is_producing_milk = value

    @property
    def liters_of_milk_per_week(self):
        return self._liters_of_milk_per_week

    @liters_of_milk_per_week.setter
    def liters_of_milk_per_week(self, value):
        self._liters_of_milk_per_week = value
