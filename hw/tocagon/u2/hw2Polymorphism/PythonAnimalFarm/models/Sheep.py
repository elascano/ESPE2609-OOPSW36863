from models.FarmAnimal import FarmAnimal

class Sheep(FarmAnimal):
    def __init__(self, woolColor, woolWeight, isSheared, id, breed, bornOnDate):

        super().__init__(id,breed,bornOnDate)

        self.woolColor= woolColor
        self.woolWeight= woolWeight
        self.isSheared= isSheared

    def feed(self):
        print("Feeding the Sheep")

    def shearWool(self):
        if not self.isSheared:
            print("shearing the wool...")
            self.isSheared=True
            self.woolWeight=0
        else:
            print("The sheep is already sheared")

    def __str__(self):
        return(
            f"Sheep{{{super().__str__()}, "
            f"is woolColor={self.woolColor}, "
            f"wool weight{self.woolWeight}, "
            f"is sheared={self.isSheared}}}"
        )

    #setters and getters
    def get_woolColor(self):
        return self.woolColor
    
    def set_woolColor(self, woolColor):
        self.woolColor= woolColor

    def get_woolWeight(self):
        return self.woolWeight

    def set_woolWeight(self, woolWeight):
        self.woolWeight= woolWeight

    def get_isSheared(self):
        return self.isSheared

    def set_isSheared(self, isSheared):
        self.isSheared= isSheared
