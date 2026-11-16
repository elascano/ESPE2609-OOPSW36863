from model.FarmAnimal import FarmAnimal
from model.GrazeAnimal import GrazeAnimal


class Sheep(FarmAnimal, GrazeAnimal):
    def __init__(self, animal_id, breed, born_on_date, number_of_offspring,
                 is_ready_to_shear, last_shearing, wool_kg_per_shearing):
        super().__init__(animal_id, breed, born_on_date, number_of_offspring)
        self.is_ready_to_shear = is_ready_to_shear
        self.last_shearing = last_shearing
        self.wool_kg_per_shearing = wool_kg_per_shearing

    def graze(self, location):
        print(f"Sending the sheep to eat grass at --> {location}")

    def feed(self, food, amount_of_food, unit):
        print(f"Feeding a sheep with --> {amount_of_food}{unit} of {food}")

    def cuts(self, cuts):
        print(f"Cutting a sheep into --> {cuts}")

    def shear(self):
        print("Shearing the sheep...")

    def wool_produce_per_month(self, wool, unit):
        print(f"Wool produced --> {wool}{unit}")

    def __str__(self):
        return (f"{super().__str__()} | ready_to_shear={self.is_ready_to_shear}, "
                f"last_shearing={self.last_shearing}, "
                f"wool_kg_per_shearing={self.wool_kg_per_shearing}")