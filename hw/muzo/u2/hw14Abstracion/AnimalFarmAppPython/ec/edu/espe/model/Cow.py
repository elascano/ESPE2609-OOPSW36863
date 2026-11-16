from datetime import datetime
from ec.edu.espe.model.FarmAnimal import FarmAnimal


class Cow(FarmAnimal):
    def __init__(self, IsProducingMilk: bool, litersOfMilkPerWeek: float, id: int, breed: str, bornOnDate: datetime):
        super().__init__(id, breed, bornOnDate)
        self.__IsProducingMilk = IsProducingMilk
        self.__litersOfMilkPerWeek = litersOfMilkPerWeek

    def __str__(self):
        return f"Cow{{{super().__str__()}IsProducingMilk={self.__IsProducingMilk}, litersOfMilkPerWeek={self.__litersOfMilkPerWeek}}}"

    def milk(self):
        print("Milking the cow ")

    def getAgeInMonths(self):
        return super().getAgeInMonths()

    def isIsProducingMilk(self):
        return self.__IsProducingMilk

    def setIsProducingMilk(self, IsProducingMilk: bool):
        self.__IsProducingMilk = IsProducingMilk

    def getLitersOfMilkPerWeek(self):
        return self.__litersOfMilkPerWeek

    def setLitersOfMilkPerWeek(self, litersOfMilkPerWeek: float):
        self.__litersOfMilkPerWeek = litersOfMilkPerWeek
