from model.farm_animal import FarmAnimal

class Cow(FarmAnimal):
    def __init__(self, name: str, age: int, liters_of_milk: float):
        super().__init__(name, age)
        self.liters_of_milk = liters_of_milk

    def make_sound(self) -> str:
        return "Moo!"

    def __str__(self) -> str:
        return f"Cow -> {super().__str__()}, Milk production: {self.liters_of_milk}L, Sound: {self.make_sound()}"