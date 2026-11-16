from abc import ABC, abstractmethod
from datetime import date
from model.Food import Food
from model.Cuts import Cuts


class FarmAnimal(ABC):

    def __init__(self, animal_id, breed, born_on_date, number_of_offspring):
        self.animal_id = animal_id
        self.breed = breed
        self.born_on_date = born_on_date
        self.number_of_offspring = number_of_offspring

    def get_age_in_months(self):
        today = date.today()
        age_in_months = (today.year - self.born_on_date.year) * 12 + (today.month - self.born_on_date.month)
        return age_in_months

    @abstractmethod
    def feed(self, food: Food, amount_of_food: int, unit: str):
        """Feed the animal with their own food"""        

    @abstractmethod
    def cuts(self, cuts: Cuts):
        """Cut the animal into their own cuts"""        

    def give_birth(self, offspring):        
        print(f"Number of offspring the {self.__class__.__name__}: gave birth --> {offspring}")

    def __str__(self):
        return (f"{self.__class__.__name__}(id={self.animal_id}, "
                f"breed={self.breed},"
                f"age={self.get_age_in_months()} months)")
