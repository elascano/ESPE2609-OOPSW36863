from datetime import datetime
from ec.edu.espe.animalfarm.model.FarmAnimal import FarmAnimal


# @author Alvarez Juan Jose, MosQ, ESPE
class Chicken(FarmAnimal):
    def __init__(self, isMolting: bool, numberOfLaidEggInMonth: int, isMeat: bool, id: int, breed: str, bornOnDate: datetime) -> None:
        super().__init__(id, breed, bornOnDate)
        self.__isMolting = isMolting
        self.__numberOfLaidEggInMonth = numberOfLaidEggInMonth
        self.__isMeat = isMeat

    def layAnEgg(self) -> None:
        print("chicken is laying an egg()")

    def toString(self) -> str:
        return (
            "Chicken{" + super().toString()
            + f"isMolting={str(self.__isMolting).lower()}, numberOfLaidEggInMonth={self.__numberOfLaidEggInMonth}, isMeat={str(self.__isMeat).lower()}" + "}"
        )

    def isIsMolting(self) -> bool:
        return self.__isMolting

    def setIsMolting(self, isMolting: bool) -> None:
        self.__isMolting = isMolting

    def getNumberOfLaidEggInMonth(self) -> int:
        return self.__numberOfLaidEggInMonth

    def setNumberOfLaidEggInMonth(self, numberOfLaidEggInMonth: int) -> None:
        self.__numberOfLaidEggInMonth = numberOfLaidEggInMonth

    def isIsMeat(self) -> bool:
        return self.__isMeat

    def setIsMeat(self, isMeat: bool) -> None:
        self.__isMeat = isMeat
