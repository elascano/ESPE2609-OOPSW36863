from abc import ABC, abstractmethod

class FarmAnimal(ABC):
    def __init__(self, name: str, age: int):
        self.name = name
        self.age = age

    @abstractmethod
    def make_sound(self) -> str:
        pass

    def __str__(self) -> str:
        return f"Animal: {self.name}, Age: {self.age} years"