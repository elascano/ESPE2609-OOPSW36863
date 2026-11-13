from datetime import datetime
from ec.edu.espe.animalfarm.model.FarmAnimal import FarmAnimal


# @author Anthony Arevalo, MosQ, ESPE
class Sheep(FarmAnimal):
    def __init__(self, lastShearing: datetime, woolWeightInKg: float, woolColor: str, id: int, breed: str, bornOnDate: datetime) -> None:
        super().__init__(id, breed, bornOnDate)
        self.__lastShearing = lastShearing
        self.__woolWeightInKg = woolWeightInKg
        self.__woolColor = woolColor

    def toString(self) -> str:
        return (
            "Sheep{" + super().toString()
            + f"lastShearing={self.__lastShearing}, woolWeightInKg={self.__woolWeightInKg}, woolColor={self.__woolColor}" + "}"
        )

    def getLastShearing(self) -> datetime:
        return self.__lastShearing

    def setLastShearing(self, lastShearing: datetime) -> None:
        self.__lastShearing = lastShearing

    def getWoolWeightInKg(self) -> float:
        return self.__woolWeightInKg

    def setWoolWeightInKg(self, woolWeightInKg: float) -> None:
        self.__woolWeightInKg = woolWeightInKg

    def getWoolColor(self) -> str:
        return self.__woolColor

    def setWoolColor(self, woolColor: str) -> None:
        self.__woolColor = woolColor
