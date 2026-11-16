from abc import ABC, abstractmethod
from datetime import datetime


class FarmAnimal(ABC):
    def __init__(self, id: int, breed: str, bornOnDate: datetime):
        self.__id = id
        self.__breed = breed
        self.__bornOnDate = bornOnDate

    def __str__(self):
        return f"id = {self.__id}, breed = {self.__breed}, bornOnDate = {self.__bornOnDate.day}/{self.__bornOnDate.month}/{self.__bornOnDate.year}, "

    @abstractmethod
    def getAgeInMonths(self):
        return 0

    def getId(self):
        return self.__id

    def setId(self, id: int):
        self.__id = id

    def getBreed(self):
        return self.__breed

    def setBreed(self, breed: str):
        self.__breed = breed

    def getBornOnDate(self):
        return self.__bornOnDate

    def setBornOnDate(self, bornOnDate: datetime):
        self.__bornOnDate = bornOnDate
