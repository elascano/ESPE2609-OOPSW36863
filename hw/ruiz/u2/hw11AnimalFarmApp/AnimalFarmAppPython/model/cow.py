from model.farm_animal import FarmAnimal

class Cow(FarmAnimal):
    def __init__(self, is_producing_milk, liters_of_milk_per_week, id, breed, born_on_date):
        super(). __init__(id, breed, born_on_date)
        self.is_producing_milk = is_producing_milk
        self.liters_of_milk_per_week = liters_of_milk_per_week

    def __str__(self):
        return "Cow {" + super().__str__() + ", isProducingMilk = " + str(self.is_producing_milk) + ", litersOfMilkPerWeek = " + str(self.liters_of_milk_per_week) + "}"