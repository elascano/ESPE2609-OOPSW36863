from abc import ABC, abstractmethod
from datetime import datetime


class FarmAnimal(ABC):
    def __init__(self, id: int, breed: str, bornOnDate: datetime):
        self._id = id
        self._breed = breed
        self._bornOnDate = bornOnDate

    @abstractmethod
    def feed(self, food, amountOfFood: int):
        pass

    def __str__(self):
        return f"id = {self._id}, breed = {self._breed}, bornOnDate = {self._bornOnDate.day}/{self._bornOnDate.month - 1}/{self._bornOnDate.year}, "

    def getAgeInMonths(self):
        return 0

    def getId(self):
        return self._id

    def setId(self, id: int):
        self._id = id

    def getBreed(self):
        return self._breed

    def setBreed(self, breed: str):
        self._breed = breed

    def getBornOnDate(self):
        return self._bornOnDate

    def setBornOnDate(self, bornOnDate: datetime):
        self._bornOnDate = bornOnDate
