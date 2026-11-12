from model.farm_animal import FarmAnimal

class Chicken(FarmAnimal):
    def __init__(self, name: str, age: int, eggs_per_week: int):
        super().__init__(name, age)
        self.eggs_per_week = eggs_per_week

    def make_sound(self) -> str:
        return "Cluck! Cluck!"

    def __str__(self) -> str:
        return f"Chicken -> {super().__str__()}, Eggs per week: {self.eggs_per_week}, Sound: {self.make_sound()}"