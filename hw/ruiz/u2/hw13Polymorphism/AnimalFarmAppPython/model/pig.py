from model.farm_animal import FarmAnimal
class Pig(FarmAnimal):
    def __init__(self, is_meat, weight_in_kg, is_pregnant, id, breed, born_on_date):
        super(). __init__(id, breed, born_on_date)
        self.is_meat = is_meat
        self.weight_in_kg = weight_in_kg
        self.is_pregnant = is_pregnant

    def feed(self, food, amount_of_food):
        print("feeding a pig with ---> " + str(amount_of_food) + " kg of " + str(food))

    def select(self):
        print("selecting the pig for slaughter")

    def __str__(self):
        return "Pig {" + super().__str__() + ", isMeat = " + str(self.is_meat) + ", weightInKg = " + str(self.weight_in_kg) + ", isPregnant = " + str(self.is_pregnant) + "}"