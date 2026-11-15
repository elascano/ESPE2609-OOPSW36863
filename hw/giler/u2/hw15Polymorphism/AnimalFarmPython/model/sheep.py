from .farm_animal import FarmAnimal
from .graze_animal import GrazeAnimal
from .food import Food
from .location import Location
from datetime import datetime
class Sheep(FarmAnimal, GrazeAnimal):
    def __init__(self, wool_weight: float, wool_quality: str, last_shearing: datetime, id_val: int, breed: str, born_on_date: datetime):
        super().__init__(id_val, breed, born_on_date)
        self.wool_weight = wool_weight
        self.wool_quality = wool_quality
        self.last_shearing_date = last_shearing
    def shear_for_market(self) -> float:
        if self.wool_weight > 0:
            harvested = self.wool_weight
            print(f"Shearing the sheep. Harvested {harvested} kg of {self.wool_quality} wool.")
            self.wool_weight = 0
            self.last_shearing_date = datetime.now()
            return harvested
        else:
            print("No wool ready to shear on this sheep.")
            return 0
    def graze(self, location: Location):
        print(f"Sheep is grazing at --> {location.description}. Wool is growing!")
        self.wool_weight += 0.5
    def feed(self, food: Food, amount_of_food: int):
        print(f"Feeding a sheep with --> {amount_of_food} units of {food}")
    def __str__(self):
        return f"Sheep{{{super().__str__()}woolWeight={self.wool_weight}, woolQuality={self.wool_quality}, lastShearingDate={self.last_shearing_date}}}"