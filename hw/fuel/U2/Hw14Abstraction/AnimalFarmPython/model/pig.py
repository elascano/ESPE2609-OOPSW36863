
from datetime import date
from model.farm_animal import FarmAnimal


class Pig(FarmAnimal):

    def __init__(self, weight, is_breeding, id, breed, born_on_date):

        super().__init__(id, breed, born_on_date)

        self.weight = weight
        self.is_breeding = is_breeding

    def get_age_in_months(self):
        today = date.today()

        months = (today.year - self.born_on_date.year) * 12
        months += today.month - self.born_on_date.month

        if today.day < self.born_on_date.day:
            months -= 1

        return months

    def feed(self):
        print("The pig is eating")

    def __str__(self):
        return (
            f"Pig{{{super().__str__()}, "
            f"weight = {self.weight}, "
            f"isBreeding = {self.is_breeding}}}"
        )
