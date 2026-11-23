from model.farm_animal import FarmAnimal
class Chicken(FarmAnimal):
    def __init__(self, is_molting, number_of_laid_eggs_in_a_month, is_meat, id, breed, born_on_date):
        super(). __init__(id, breed, born_on_date)
        self.is_molting = is_molting
        self.number_of_laid_eggs_in_a_month = number_of_laid_eggs_in_a_month
        self.is_meat = is_meat

    def lay_an_egg(self):
        print("chicken is laying an egg")
        
    def __str__(self):
        return "Chicken {" + super().__str__() + ", isMolting = " + str(self.is_molting) + ", numberOfLaidEggsInAMonth = " + str(self.number_of_laid_eggs_in_a_month) + ", isMeat = " + str(self.is_meat) + "}"