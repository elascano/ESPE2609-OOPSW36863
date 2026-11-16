from model.FarmAnimal import FarmAnimal


class Cow(FarmAnimal):
    def __init__(self, animal_id, breed, born_on_date, number_of_offspring,
                 is_producing_milk, liters_of_milk):
        super().__init__(animal_id, breed, born_on_date, number_of_offspring)
        self.is_producing_milk = is_producing_milk
        self.liters_of_milk = liters_of_milk
    
    def feed(self, food, amount_of_food, unit):
        print(f"Feeding a cow with --> {amount_of_food}{unit} of {food}")

    def cuts(self, cuts):
        print(f"Cutting a cow into --> {cuts}")

    def milk(self):
        print("Milking the cow")

    def __str__(self):
        return (f"{super().__str__()} | producing_milk={self.is_producing_milk}, "
                f"liters={self.liters_of_milk}")