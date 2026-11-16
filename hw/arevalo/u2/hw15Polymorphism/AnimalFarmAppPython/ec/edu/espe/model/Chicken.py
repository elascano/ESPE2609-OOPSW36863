from .FarmAnimal import FarmAnimal


class Chicken(FarmAnimal):
    def __init__(self, isMolting: bool, numberOfLaidEggsInAMonth: int, isMeat: bool, id: int, breed: str, bornOnDate):
        super().__init__(id, breed, bornOnDate)
        self._isMolting = isMolting
        self._numberOfLaidEggsInAMonth = numberOfLaidEggsInAMonth
        self._isMeat = isMeat

    def feed(self, food, amountOfFood: int):
        print(f"Feeding a Chicken with --> {amountOfFood} of {food}")

    def layAnEgg(self):
        print("Chicken is laying an egg () ")

    def __str__(self):
        return f"Chicken{{{super().__str__()}isMolting={self._isMolting}, numberOfLaidEggsInAMonth={self._numberOfLaidEggsInAMonth}, isMeat={self._isMeat}}}"

    def isIsMolting(self):
        return self._isMolting

    def setIsMolting(self, isMolting: bool):
        self._isMolting = isMolting

    def getNumberOfLaidEggsInAMonth(self):
        return self._numberOfLaidEggsInAMonth

    def setNumberOfLaidEggsInAMonth(self, numberOfLaidEggsInAMonth: int):
        self._numberOfLaidEggsInAMonth = numberOfLaidEggsInAMonth

    def isIsMeat(self):
        return self._isMeat

    def setIsMeat(self, isMeat: bool):
        self._isMeat = isMeat
