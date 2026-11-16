from abc import ABC, abstractmethod

from .location import Location


class GrazeAnimal(ABC):
    """Interfaz para animales que pastan."""

    @abstractmethod
    def graze(self, location: Location) -> None:
        ...
