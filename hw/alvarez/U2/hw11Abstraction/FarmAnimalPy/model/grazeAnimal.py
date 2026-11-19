from abc import ABC, abstractmethod
from model.Location import Location


class grazeAnimal(ABC):
    @abstractmethod
    def graze(self, Location: Location) -> None:
        pass