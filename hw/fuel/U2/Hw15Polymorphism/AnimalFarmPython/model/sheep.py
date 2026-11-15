from model.farm_animal import FarmAnimal
from model.graze_animal import GrazeAnimal


class Sheep(FarmAnimal, GrazeAnimal):

    def __init__(self, is_producing_wool, wool_in_pounds,
                 wool_color, id, breed, born_on_date):

        super().__init__(id, breed, born_on_date)

        self.is_producing_wool = is_producing_wool
        self.wool_in_pounds = wool_in_pounds
        self.wool_color = wool_color

    def feed(self, food, amount_of_food):
        print(
            f"Feeding a sheep with ---> "
            f"{amount_of_food} of {food}"
        )

    def graze(self, location):
        print(f"The sheep is grazing at ---> {location}")

    def shear_wool(self):
        print("Shearing the sheep...")

    def __str__(self):
        return (
            f"Sheep{{is_producing_wool={self.is_producing_wool}, "
            f"wool_in_pounds={self.wool_in_pounds}, "
            f"wool_color={self.wool_color}}} {super().__str__()}"
        )