from .farm_animal import FarmAnimal
from .food import Food
from datetime import datetime
class Chicken(FarmAnimal):
    def __init__(self, is_molting: bool, laid_eggs: int, is_meat: bool, id_val: int, breed: str, born_on_date: datetime):
        super().__init__(id_val, breed, born_on_date)
        self.is_molting = is_molting
        self.number_of_laid_eggs_in_months = laid_eggs
        self.is_meat = is_meat
    def feed(self, food: Food, amount_of_food: int):
        print(f"feeding a chicken with -->{amount_of_food} of {food}")
    def lay_an_egg(self):
        print("Chicken is laying an egg")
    def __str__(self):
        return f"Chicken{{{super().__str__()}isMolting={self.is_molting}, numberOfLaidEggsInMonths={self.number_of_laid_eggs_in_months}, isMeat={self.is_meat}}}"