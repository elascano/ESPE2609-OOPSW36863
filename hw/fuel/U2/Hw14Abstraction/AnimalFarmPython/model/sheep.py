
from datetime import date
from model.farm_animal import FarmAnimal


class Sheep(FarmAnimal):

    def __init__(self, wool_length, is_producing_wool,
                 id, breed, born_on_date):

        super().__init__(id, breed, born_on_date)

        self.wool_length = wool_length
        self.is_producing_wool = is_producing_wool

    def get_age_in_months(self):
        today = date.today()

        months = (today.year - self.born_on_date.year) * 12
        months += today.month - self.born_on_date.month

        if today.day < self.born_on_date.day:
            months -= 1

        return months

    def shear(self):
        print("Shearing the sheep")

    def __str__(self):
        return (
            f"Sheep{{{super().__str__()}, "
            f"woolLength = {self.wool_length}, "
            f"isProducingWool = {self.is_producing_wool}}}"
        )
