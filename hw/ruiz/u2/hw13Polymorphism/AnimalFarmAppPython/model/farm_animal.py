from abc import ABC, abstractmethod
class FarmAnimal (ABC):
    def __init__(self, id, breed, born_on_date):
        self.id = id
        self.breed = breed
        self.born_on_date = born_on_date

    @abstractmethod
    def feed(self, food, amount_of_food):
        pass
    
    def __str__(self):
        return "id = " + str(self.id) + ", breed = " + self.breed + ", bornOnDate = " + str(self.born_on_date.day) + "/" + str(self.born_on_date.month) + "/" + str(self.born_on_date.year)
