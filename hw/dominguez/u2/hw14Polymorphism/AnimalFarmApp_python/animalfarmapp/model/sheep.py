from datetime import datetime

from .farm_animal import FarmAnimal
from .food import Food


class Sheep(FarmAnimal):
    def __init__(self, last_shearing: datetime, weight_wool: float,
                 id: int, breed: str, born_on_date: datetime) -> None:
        super().__init__(id, breed, born_on_date)
        self.last_shearing = last_shearing
        self.weight_wool = weight_wool

    def feed(self, food: Food, amount_of_food: int) -> None:
        print(f"feeding a sheep with {amount_of_food} of {food}")

    def shearing(self, new_wool: float) -> None:
        self.weight_wool = round(self.weight_wool + new_wool, 2)
        print(f"The sheep produce {self.weight_wool}kg of  wool")
        self.last_shearing = datetime.now()

    def __str__(self) -> str:
        return f"Sheep{{lastSheering={self.last_shearing}, weightWool={self.weight_wool}}}"
