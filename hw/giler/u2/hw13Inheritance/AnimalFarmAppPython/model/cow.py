from .farm_animal import FarmAnimal

class Cow(FarmAnimal):
    def __init__(self, id: int, breed: str, produces_milk: bool):
        super().__init__(id, breed)
        self.produces_milk = produces_milk