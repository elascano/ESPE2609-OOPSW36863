from abc import ABC, abstractmethod


class GrazeAnimal(ABC):

    @abstractmethod
    def graze(self, location):
        pass