from abc import ABC, abstractmethod
from datetime import datetime
from .food import Food
class FarmAnimal(ABC):
    def __init__(self, id_val: int, breed: str, born_on_date: datetime):
        self.id = id_val
        self.breed = breed
        self.born_on_date = born_on_date
    @abstractmethod
    def feed(self, food: Food, amount_of_food: int): pass
    def get_age_in_months(self) -> int: return 0
    def __str__(self):
        return f"id={self.id}, breed={self.breed}, bornOnDate={self.born_on_date.day}/{self.born_on_date.month}/{self.born_on_date.year},"