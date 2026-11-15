
from abc import ABC, abstractmethod
from datetime import date


class FarmAnimal(ABC):

    def __init__(self, id, breed, born_on_date):
        self.id = id
        self.breed = breed
        self.born_on_date = born_on_date

    @abstractmethod
    def get_age_in_months(self):
        pass

    def __str__(self):
        return (
            f"id = {self.id}, "
            f"breed = {self.breed}, "
            f"bornOnDate = {self.born_on_date}"
        )
