
from model.farm_animal import FarmAnimal


class Chicken(FarmAnimal):

    def __init__(self, is_molting, number_of_laid_eggs_in_a_month, is_meat,
                 id, breed, born_on_date):

        super().__init__(id, breed, born_on_date)

        self._is_molting = is_molting
        self._number_of_laid_eggs_in_a_month = number_of_laid_eggs_in_a_month
        self._is_meat = is_meat

    def lay_egg(self):
        print("The chicken laid an egg")

    def __str__(self):
        return (
            f"Chicken{{{super().__str__()}"
            f"isMolting={self._is_molting}, "
            f"numberOfLaidEggsInAMonth={self._number_of_laid_eggs_in_a_month}, "
            f"isMeat={self._is_meat}}}"
        )

    @property
    def is_molting(self):
        return self._is_molting

    @is_molting.setter
    def is_molting(self, value):
        self._is_molting = value

    @property
    def number_of_laid_eggs_in_a_month(self):
        return self._number_of_laid_eggs_in_a_month

    @number_of_laid_eggs_in_a_month.setter
    def number_of_laid_eggs_in_a_month(self, value):
        self._number_of_laid_eggs_in_a_month = value

    @property
    def is_meat(self):
        return self._is_meat

    @is_meat.setter
    def is_meat(self, value):
        self._is_meat = value
