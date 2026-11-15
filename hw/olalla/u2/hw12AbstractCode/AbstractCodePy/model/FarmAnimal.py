from abc import ABC, abstractmethod
from datetime import date


class FarmAnimal(ABC):

    def __init__(self, animal_id, breed, born_on_date):
        self.animal_id = animal_id
        self.breed = breed
        self.born_on_date = born_on_date

    def get_age_in_months(self):
        today = date.today()
        age_in_months = (today.year - self.born_on_date.year) * 12 + (today.month - self.born_on_date.month)
        return age_in_months

    @abstractmethod
    def make_sound(self):
        pass        

    def __str__(self):
        return (f"{self.__class__.__name__}(id={self.animal_id}, "
                f"breed={self.breed},"
                f"age={self.get_age_in_months()} months)")
