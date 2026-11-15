
from abc import ABC
from datetime import date


class FarmAnimal(ABC):

    def __init__(self, id, breed, born_on_date):
        self._id = id
        self._breed = breed
        self._born_on_date = born_on_date

    def get_age_in_months(self):
        return 0

    def __str__(self):
        return (
            f"id = {self._id}, "
            f"breed = {self._breed}, "
            f"bornOnDate = {self._born_on_date}, "
        )

    @property
    def id(self):
        return self._id

    @id.setter
    def id(self, id):
        self._id = id

    @property
    def breed(self):
        return self._breed

    @breed.setter
    def breed(self, breed):
        self._breed = breed

    @property
    def born_on_date(self):
        return self._born_on_date

    @born_on_date.setter
    def born_on_date(self, born_on_date):
        self._born_on_date = born_on_date
