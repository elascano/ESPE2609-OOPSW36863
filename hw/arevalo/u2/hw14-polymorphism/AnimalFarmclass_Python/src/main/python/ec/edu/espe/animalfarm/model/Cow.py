from datetime import datetime
from ec.edu.espe.animalfarm.model.FarmAnimal import FarmAnimal


# @author Alvarez Juan Jose, MosQ, ESPE
class Cow(FarmAnimal):
    def __init__(self, isProducingMilk: bool, litersOfMilkForWeek: float, id: int, breed: str, bornOnDate: datetime) -> None:
        super().__init__(id, breed, bornOnDate)
        self.__isProducingMilk = isProducingMilk
        self.__litersOfMilkForWeek = litersOfMilkForWeek

    def milk(self) -> None:
        print("milking the cow")

    def toString(self) -> str:
        return (
            "Cow{" + super().toString()
            + f"isProducingMilk={str(self.__isProducingMilk).lower()}, litersOfMilkForWeek={self.__litersOfMilkForWeek}" + "}"
        )

    def isIsProducingMilk(self) -> bool:
        return self.__isProducingMilk

    def setIsProducingMilk(self, isProducingMilk: bool) -> None:
        self.__isProducingMilk = isProducingMilk

    def getLitersOfMilkForWeek(self) -> float:
        return self.__litersOfMilkForWeek

    def setLitersOfMilkForWeek(self, litersOfMilkForWeek: float) -> None:
        self.__litersOfMilkForWeek = litersOfMilkForWeek
