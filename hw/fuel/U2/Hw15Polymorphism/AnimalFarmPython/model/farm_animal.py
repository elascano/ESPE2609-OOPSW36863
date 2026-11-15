from abc import ABC, abstractmethod


class FarmAnimal(ABC):

    def __init__(self, id, breed, born_on_date):
        self.id = id
        self.breed = breed
        self.born_on_date = born_on_date

    @abstractmethod
    def feed(self, food, amount_of_food):
        pass

    def get_age_in_months(self):
        return 0

    def __str__(self):
        return (
            f"FarmAnimal{{id={self.id}, "
            f"breed={self.breed}, "
            f"born_on_date={self.born_on_date}}}"
        )