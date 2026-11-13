from datetime import datetime
from ec.edu.espe.animalfarm.model.FarmAnimal import FarmAnimal


# @author Anthony Arevalo, MosQ, ESPE
class Pig(FarmAnimal):
    def __init__(self, weightInKg: float, dailyFoodIntakeInKg: float, isCastrated: bool, id: int, breed: str, bornOnDate: datetime) -> None:
        super().__init__(id, breed, bornOnDate)
        self.__weightInKg = weightInKg
        self.__dailyFoodIntakeInKg = dailyFoodIntakeInKg
        self.__isCastrated = isCastrated

    def toString(self) -> str:
        return (
            "Pig{" + super().toString()
            + f"weightInKg={self.__weightInKg}, dailyFoodIntakeInKg={self.__dailyFoodIntakeInKg}, isCastrated={str(self.__isCastrated).lower()}" + "}"
        )

    def getWeightInKg(self) -> float:
        return self.__weightInKg

    def setWeightInKg(self, weightInKg: float) -> None:
        self.__weightInKg = weightInKg

    def getDailyFoodIntakeInKg(self) -> float:
        return self.__dailyFoodIntakeInKg

    def setDailyFoodIntakeInKg(self, dailyFoodIntakeInKg: float) -> None:
        self.__dailyFoodIntakeInKg = dailyFoodIntakeInKg

    def isCastrated(self) -> bool:
        return self.__isCastrated

    def setCastrated(self, isCastrated: bool) -> None:
        self.__isCastrated = isCastrated
