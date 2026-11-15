
from datetime import date
from model.farm_animal import FarmAnimal


class Cow(FarmAnimal):

    def __init__(self, is_producing_milk, liters_of_milk_per_week,
                 id, breed, born_on_date):

        super().__init__(id, breed, born_on_date)

        self.is_producing_milk = is_producing_milk
        self.liters_of_milk_per_week = liters_of_milk_per_week

    def get_age_in_months(self):
        today = date.today()

        months = (today.year - self.born_on_date.year) * 12
        months += today.month - self.born_on_date.month

        if today.day < self.born_on_date.day:
            months -= 1

        return months

    def milk(self):
        print("The cow is producing milk")

    def __str__(self):
        return (
            f"Cow{{{super().__str__()}, "
            f"isProducingMilk = {self.is_producing_milk}, "
            f"litersOfMilkPerWeek = {self.liters_of_milk_per_week}}}"
        )
