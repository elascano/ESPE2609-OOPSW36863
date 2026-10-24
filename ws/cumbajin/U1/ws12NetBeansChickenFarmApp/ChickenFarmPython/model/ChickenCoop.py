
"""
@author Dylan Cumbajin, MosQ, @ESPE
"""

class ChickenCoop:

    def __init__(self, chickenCoopId, chickens):
        self.chickenCoopId = chickenCoopId
        self.chickens = chickens
        self.currentIndex = 0

    # Add a chicken
    def add(self, chicken):
        if chicken is None:
            return

        for i in range(len(self.chickens)):
            if self.chickens[i] is None:
                self.chickens[i] = chicken
                print("Chicken added -->", chicken.getName())
                return

        print("The chicken coop is full")

    # Remove a chicken
    def remove(self, chickenId):
        for i in range(len(self.chickens)):
            if self.chickens[i] is not None and self.chickens[i].getId() == chickenId:

                for j in range(i, len(self.chickens) - 1):
                    self.chickens[j] = self.chickens[j + 1]

                self.chickens[len(self.chickens) - 1] = None

                if self.currentIndex > i:
                    self.currentIndex -= 1

                print("Chicken removed -->", chickenId)
                return

        print("Chicken not found")

    # Reset iteration
    def resetIteration(self):
        self.currentIndex = 0

    # Get the next chicken
    def next(self):
        while self.currentIndex < len(self.chickens):
            chicken = self.chickens[self.currentIndex]
            self.currentIndex += 1

            if chicken is not None:
                return chicken

        return None

    def __str__(self):
        return (f"ChickenCoop{{chickenCoopId={self.chickenCoopId}, "
                f"chickens={self.chickens}}}")

    def getChickenCoopId(self):
        return self.chickenCoopId

    def setChickenCoopId(self, chickenCoopId):
        self.chickenCoopId = chickenCoopId

    def getChickens(self):
        return self.chickens

    def setChickens(self, chickens):
        self.chickens = chickens
