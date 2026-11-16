from datetime import datetime
from ec.edu.espe.model.FarmAnimal import FarmAnimal


class Chicken(FarmAnimal):
    def __init__(self, isMolting: bool, numberOfLaidEggsInAMonth: int, isMeat: bool, id: int, breed: str, bornOnDate: datetime):
        super().__init__(id, breed, bornOnDate)
        self.__isMolting = isMolting
        self.__numberOfLaidEggsInAMonth = numberOfLaidEggsInAMonth
        self.__isMeat = isMeat

    def layAnEgg(self):
        print("Chicken is laying an egg () ")

    def __str__(self):
        return f"Chicken{{{super().__str__()}isMolting={self.__isMolting}, numberOfLaidEggsInAMonth={self.__numberOfLaidEggsInAMonth}, isMeat={self.__isMeat}}}"

    def getAgeInMonths(self):
        return super().getAgeInMonths()

    def isIsMolting(self):
        return self.__isMolting

    def setIsMolting(self, isMolting: bool):
        self.__isMolting = isMolting

    def getNumberOfLaidEggsInAMonth(self):
        return self.__numberOfLaidEggsInAMonth

    def setNumberOfLaidEggsInAMonth(self, numberOfLaidEggsInAMonth: int):
        self.__numberOfLaidEggsInAMonth = numberOfLaidEggsInAMonth

    def isIsMeat(self):
        return self.__isMeat

    def setIsMeat(self, isMeat: bool):
        self.__isMeat = isMeat
