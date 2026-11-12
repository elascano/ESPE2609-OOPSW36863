from .farm_animal import FarmAnimal

class Cow(FarmAnimal):
    def __init__(self, id: int, breed: str, born_on_date: str, is_producing_milk: bool, liters_of_milk_for_week: float):
        super().__init__(id, breed, born_on_date)
        self.is_producing_milk = is_producing_milk
        self.liters_of_milk_for_week = liters_of_milk_for_week

    def feed(self):
        pass

    def milking(self):
        print("milking the cow")

    def __str__(self):
        return f"Cow{{id={self.id}, breed={self.breed}, bornOnDate={self.born_on_date},isProducingMilk={str(self.is_producing_milk).lower()},  litersOfMilkForWeek={self.liters_of_milk_for_week}}}"