from .farm_animal import FarmAnimal
from .food import Food
from datetime import datetime
class Pig(FarmAnimal):
    def __init__(self, current_weight: float, target_weight: float, is_breeder: bool, id_val: int, breed: str, born_on_date: datetime):
        super().__init__(id_val, breed, born_on_date)
        self.current_weight = current_weight
        self.target_market_weight = target_weight
        self.is_breeder = is_breeder
    def calculate_meat_yield(self) -> float:
        meat_yield = self.current_weight * 0.70
        print(f"This pig can yield {meat_yield} kg of saleable meat.")
        return meat_yield
    def collect_manure(self) -> float:
        manure = self.current_weight * 0.05
        print(f"Collected {manure} kg of manure for crop fertilizer.")
        return manure
    def produce_piglets(self) -> int:
        if self.is_breeder:
            piglets = 8
            print(f"The sow gave birth to {piglets} new piglets!")
            return piglets
        else:
            print("This pig is for meat, not a breeder.")
            return 0
    def feed(self, food: Food, amount_of_food: int):
        gained = amount_of_food * 0.8
        self.current_weight += gained
        print(f"Feeding the pig with --> {amount_of_food} of {food}. It gained {gained} kg. Current weight: {self.current_weight}")
    def __str__(self):
        return f"Pig{{{super().__str__()}currentWeight={self.current_weight}kg, targetMarketWeight={self.target_market_weight}kg, isBreeder={self.is_breeder}}}"