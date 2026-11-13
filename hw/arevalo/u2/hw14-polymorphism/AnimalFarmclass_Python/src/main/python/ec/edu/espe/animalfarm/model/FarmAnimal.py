from abc import ABC, abstractmethod
from datetime import datetime


# @author Anthony Arévalo, MosQ, ESPE
class FarmAnimal(ABC):
    @abstractmethod
    def __init__(self, id: int, breed: str, bornOnDate: datetime) -> None:
        self.__id = id
        self.__breed = breed
        self.__bornOnDate = bornOnDate

    def getAgeInMonths(self) -> int:
        return 0

    def toString(self) -> str:
        return (
            f"id={self.__id}, breed={self.__breed}, "
            f"bornOnDate={self.__bornOnDate.day}/"
            f"{self.__bornOnDate.month}/{self.__bornOnDate.year},"
        )

    def __str__(self) -> str:
        return self.toString()

    def getId(self) -> int:
        return self.__id

    def setId(self, id: int) -> None:
        self.__id = id

    def getBreed(self) -> str:
        return self.__breed

    def setBreed(self, breed: str) -> None:
        self.__breed = breed

    def getBornOnDate(self) -> datetime:
        return self.__bornOnDate

    def setBornOnDate(self, bornOnDate: datetime) -> None:
        self.__bornOnDate = bornOnDate
