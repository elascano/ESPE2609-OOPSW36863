
from datetime import datetime, date
from model.Egg import Egg
from model.Poop import Poop

"""
@author Dylan Cumbajin, MosQ, @ESPE
"""

class Chicken:

    # Constructor
    def __init__(self, id=0, name="", color="", bornOnDate=None, molting=False):
        self.id = id
        self.name = name
        self.color = color
        self.bornOnDate = bornOnDate
        self.ageInYears = 0
        self.molting = molting

        if self.bornOnDate is not None:
            self.ageInYears = self.computeAgeInYears()

    # Compute chicken age
    def computeAgeInYears(self):
        if self.bornOnDate is None:
            return 0

        today = date.today()
        birth = self.bornOnDate

        age = today.year - birth.year

        if today.month < birth.month:
            age -= 1
        elif today.month == birth.month and today.day < birth.day:
            age -= 1

        return age

    # Chicken behavior
    def doStuff(self):
        self.cluck()
        self.wander()
        self.drink(1.3)
        print("poop -->", self.poop())
        print("egg -->", self.layAnEgg())

    def cluck(self):
        print("The chicken " + self.name + " is clucking ...")

    def wander(self):
        print("The chicken " + self.name + " is wandering ...")

    def eat(self):
        print("The chicken " + self.name + " is eating ...")

    def drink(self, amountOfWater):
        print("The chicken " + self.name + " is drinking -->", amountOfWater, "ml of water")

    def poop(self):
        poop = Poop(2, "green", "M")
        return poop

    def layAnEgg(self):
        egg = Egg(2, "S")
        return egg

    def __str__(self):
        return (f"Chicken{{id={self.id}, name={self.name}, "
                f"color={self.color}, bornOnDate={self.bornOnDate}, "
                f"ageInYears={self.ageInYears}, molting={str(self.molting).lower()}}}")

    # Getters and Setters
    def getId(self):
        return self.id

    def setId(self, id):
        self.id = id

    def getName(self):
        return self.name

    def setName(self, name):
        self.name = name

    def getColor(self):
        return self.color

    def setColor(self, color):
        self.color = color

    def getBornOnDate(self):
        return self.bornOnDate

    def setBornOnDate(self, bornOnDate):
        self.bornOnDate = bornOnDate

    def getAgeInYears(self):
        return self.ageInYears

    def setAgeInYears(self, ageInYears=None):
        if ageInYears is None:
            self.ageInYears = self.computeAgeInYears()
        else:
            self.ageInYears = ageInYears

    def isMolting(self):
        return self.molting

    def setMolting(self, molting):
        self.molting = molting
