
from datetime import date
from model.farm_animal import FarmAnimal


class Chicken(FarmAnimal):

    def __init__(self, is_molting, number_of_laid_eggs_in_a_month,
                 is_meat, id, breed, born_on_date):

        super().__init__(id, breed, born_on_date)

        self.is_molting = is_molting
        self.number_of_laid_eggs_in_a_month = number_of_laid_eggs_in_a_month
        self.is_meat = is_meat

    def get_age_in_months(self):
        today = date.today()

        months = (today.year - self.born_on_date.year) * 12
        months += today.month - self.born_on_date.month

        if today.day < self.born_on_date.day:
            months -= 1

        return months

    def lay_an_egg(self):
        print("The chicken is laying an egg")

    def __str__(self):
        return (
            f"Chicken{{{super().__str__()}, "
            f"isMolting = {self.is_molting}, "
            f"numberOfLaidEggsInAMonth = {self.number_of_laid_eggs_in_a_month}, "
            f"isMeat = {self.is_meat}}}"
        )
