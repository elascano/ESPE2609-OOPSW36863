from abc import ABC, abstractmethod
from model.Location import Location


class GrazeAnimal(ABC):
    @abstractmethod
    def graze(self, location):
        """Send the animal to eat grass at a location"""