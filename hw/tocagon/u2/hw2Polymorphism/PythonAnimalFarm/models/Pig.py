from models.FarmAnimal import FarmAnimal

class Pig(FarmAnimal):
    def __init__(self, weight, isAdult, fatPorcentage, id, breed, bornOnDate):

        super().__init__(id,breed,bornOnDate)

        self.weight= weight
        self.isAdult= isAdult
        self.fatPorcentage= fatPorcentage

    def feed(self):
        print("Feeding the Pig")

    def checkHealth(self):
        if self.weight < 40:
            print("The pig is underweight.")
        elif self.fatPorcentage > 30:
         print("The pig has a high fat percentage.")
        else:
            print("The pig is healthy.")

    def __str__(self):
        return(
            f"Pig{{{super().__str__()}, "
            f"weight={self.weight}, "
            f"is Adult={self.isAdult}, "
            f"fat porcentage={self.fatPorcentage}%}}"
        )
    
    def get_weight(self):
        return self.weight
        
    def set_weight(self, weight):
        self.weight= weight
    
    def get_isAdult(self):
        return self.isAdult
    
    def set_isAdult(self, isAdult):
        self.isAdult= isAdult

    def get_fatPorcentage(self):
        return self.fatPorcentage

    def set_fatPorcentage(self, fatPorcentage):
        self.fatPorcentage= fatPorcentage