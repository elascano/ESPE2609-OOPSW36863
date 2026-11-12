from .farm_animal import FarmAnimal

class Chicken(FarmAnimal):
    def __init__(self, id: int, breed: str, is_molting: bool):
        super().__init__(id, breed)
        self.is_molting = is_molting