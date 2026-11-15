from abc import ABC, abstractmethod

class FarmAnimal(ABC):
    def __init__(self, id: int, breed: str, born_on_date: str):
        self.id = id
        self.breed = breed
        self.born_on_date = born_on_date

    @abstractmethod
    def feed(self):
        pass