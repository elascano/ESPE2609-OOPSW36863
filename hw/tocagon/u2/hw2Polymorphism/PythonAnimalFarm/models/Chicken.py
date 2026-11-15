from models.FarmAnimal import FarmAnimal

class Chicken(FarmAnimal):
    def __init__(self, isMolting, numberOfLaidEggsInAMonth, isMeat, id, breed, bornOnDate):

        super().__init__(id,breed,bornOnDate)

        self.isMolting= isMolting
        self.numberOfLaidEggsInAMonth= numberOfLaidEggsInAMonth
        self.isMeat= isMeat

    def feed(self):
        print("Feeding the Chicken")

    def layAnEgg(self):
        print("Chicken is laying an egg()")
    
    #to string() pero en python
    def __str__(self):
        return(
            f"Chicken{{{super().__str__()}, "
            f"is molting={self.isMolting}, "
            f"number of laid eggs in a month={self.numberOfLaidEggsInAMonth}, "
            f"is meat={self.isMeat}}}"
        )

    def get_isMolting(self):
        return self.isMolting
    
    def set_isMolting(self, isMolting):
        self.isMolting= isMolting

    def get_numberOfLaidEggsInAMonth(self):
        return self.numberOfLaidEggsInAMonth

    def set_numberOfLaidEggsInAMonth(self, numberOfLaidEggsInAMonth):
        self.numberOfLaidEggsInAMonth= numberOfLaidEggsInAMonth

    def get_isMeat(self):
        return self.isMeat

    def set_isMeat(self, isMeat):
        self.isMeat= isMeat
