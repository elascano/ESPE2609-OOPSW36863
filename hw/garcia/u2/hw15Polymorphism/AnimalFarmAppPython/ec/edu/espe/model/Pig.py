from .FarmAnimal import FarmAnimal


class Pig(FarmAnimal):
    def __init__(self, numberOfPigletsPerLitter: int, id: int, breed: str, bornOnDate):
        super().__init__(id, breed, bornOnDate)
        self.numberOfPigletsPerLitter = numberOfPigletsPerLitter

    def feed(self, food, amountOfFood: int):
        print(f"Feeding pig with --> {food} amount of food --> {amountOfFood}")

    def __str__(self):
        return f"Pig{{{super().__str__()}numberOfPigletsPerLitter = {self.numberOfPigletsPerLitter}}}"

    def registerLitter(self, numberOfPiglets: int):
        self.setNumberOfPigletsPerLitter(numberOfPiglets)

    def getNumberOfPigletsPerLitter(self):
        return self.numberOfPigletsPerLitter

    def setNumberOfPigletsPerLitter(self, numberOfPigletsPerLitter: int):
        self.numberOfPigletsPerLitter = numberOfPigletsPerLitter
