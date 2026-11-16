from abc import ABC, abstractmethod


class grazeAnimal(ABC):
    @abstractmethod
    def graze(self, location):
        pass
