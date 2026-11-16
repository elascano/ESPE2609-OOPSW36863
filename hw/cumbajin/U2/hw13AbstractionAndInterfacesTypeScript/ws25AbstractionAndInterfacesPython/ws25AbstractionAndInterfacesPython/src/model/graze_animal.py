"""Interface for animals that can graze."""

from abc import ABC, abstractmethod

from .location import Location


class GrazeAnimal(ABC):
    """Interface implemented by animals that graze in a location."""

    @abstractmethod
    def graze(self, location: Location) -> None:
        """Send the animal to graze at the specified location."""
