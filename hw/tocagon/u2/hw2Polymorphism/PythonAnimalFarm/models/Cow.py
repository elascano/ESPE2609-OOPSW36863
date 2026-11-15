from models.FarmAnimal import FarmAnimal

class Cow(FarmAnimal):

    def __init__(self, isProducingMilk, litersOfMilkPerWeek, id, breed, bornOnDate):
        super().__init__(id, breed, bornOnDate)

        self.isProducingMilk= isProducingMilk
        self.litersOfMilkPerWeek= litersOfMilkPerWeek

    def feed(self):
        print("Feeding the Cow")
          
    def __str__(self):
        return(
            f"Cow{{{super().__str__()}, "
            f"isProducingMilk={self.isProducingMilk}, "
            f"litersOfMilkPerWeek={self.litersOfMilkPerWeek}}}"
        )

    def getIsProducingMilk(self):
        return self.isProducingMilk

    def setIsProducingMilk(self, isProducingMilk):
        self.isProducingMilk = isProducingMilk

    def getLitersOfMilkPerWeek(self):
        return self.litersOfMilkPerWeek

    def setLitersOfMilkPerWeek(self, litersOfMilkPerWeek):
        self.litersOfMilkPerWeek = litersOfMilkPerWeek

    def milk(self):
        print("Milking the Cow")