from model.farm_animal import FarmAnimal
class Sheep(FarmAnimal):
    def __init__(self, last_shearing, is_shorn, kg_of_wool_per_shearing, id, breed, born_on_date):
        super(). __init__(id, breed, born_on_date)
        self.last_shearing = last_shearing
        self.is_shorn = is_shorn
        self.kg_of_wool_per_shearing = kg_of_wool_per_shearing

    def shear(self):
        print("shearning the sheep")

    def __str__(self):
        return "Sheep {" + super().__str__() + ", lastShearing = " + str(self.last_shearing.day) + "/" + str(self.last_shearing.month) + "/" + str(self.last_shearing.year) + ", isShorn = " + str(self.is_shorn) + ", kgOfWoolPerShearing = " + str(self.kg_of_wool_per_shearing) + "}"
    
