from abc import ABC, abstractmethod

from .location import Location


class GrazeAnimal(ABC):
    @abstractmethod
    def graze(self, location: Location) -> None:
        ...
