from model.FarmAnimal import FarmAnimal


class Pig(FarmAnimal):
    def __init__(self, animal_id, breed, born_on_date, number_of_offspring,
                 weight_in_kg, is_ready_to_eat):
        super().__init__(animal_id, breed, born_on_date, number_of_offspring)
        self.weight_in_kg = weight_in_kg
        self.is_ready_to_eat = is_ready_to_eat

    def feed(self, food, amount_of_food, unit):
        print(f"Feeding a pig with --> {amount_of_food}{unit} of {food}")

    def cuts(self, cuts):
        print(f"Cutting a pig into --> {cuts}")

    def gain_weight(self, kg):
        print(f"The currently weight of the pig --> {kg}")

    def produce_manure(self, manure, unit):
        print(f"Pig's manure produced --> {manure}{unit}")

    def __str__(self):
        return (f"{super().__str__()} | weight_in_kg={self.weight_in_kg}, "
                f"ready_to_eat={self.is_ready_to_eat}")
