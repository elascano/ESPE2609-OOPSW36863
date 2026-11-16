from .FarmAnimal import FarmAnimal
from .grazeAnimal import grazeAnimal


class Sheep(FarmAnimal, grazeAnimal):
    def __init__(self, woolLength: float, isSheared: bool, id: int, breed: str, bornOnDate):
        super().__init__(id, breed, bornOnDate)
        self.woolLength = woolLength
        self.isSheared = isSheared

    def graze(self, location):
        print(f"Sending the sheep to eat grass at --> {location}")

    def __str__(self):
        return f"Sheep{{{super().__str__()}woolLength = {self.woolLength}, isSheared = {self.isSheared}}}"

    def feed(self, food, amountOfFood: int):
        print(f"Feeding sheep with --> {food} amount of food --> {amountOfFood}")

    def shearWool(self):
        if not self.isSheared:
            self.isSheared = True
            self.woolLength = 0
            print("Sheep has been sheared successfully")
        else:
            print("Shee has already been sheared")

    def getWoolLength(self):
        return self.woolLength

    def setWoolLength(self, woolLength: float):
        self.woolLength = woolLength

    def isIsSheared(self):
        return self.isSheared

    def setIsSheared(self, isSheared: bool):
        self.isSheared = isSheared
