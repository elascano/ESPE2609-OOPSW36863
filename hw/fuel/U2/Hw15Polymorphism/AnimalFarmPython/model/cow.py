from model.farm_animal import FarmAnimal
from model.graze_animal import GrazeAnimal


class Cow(FarmAnimal, GrazeAnimal):

    def __init__(self, is_producing_milk, liters_of_milk_per_week,
                 id, breed, born_on_date):

        super().__init__(id, breed, born_on_date)

        self.is_producing_milk = is_producing_milk
        self.liters_of_milk_per_week = liters_of_milk_per_week
        self.food = None

    def graze(self, location):
        print(f"Feeding a cow in the stable with ---> {self.food}")

    def feed(self, food, amount_of_food):
        print(f"Feeding a cow with ---> {food}")

    def milk(self, amount_of_liters=None, hour=None):

        if amount_of_liters is None:
            print("Milking the cow as I need")

        else:
            self.liters_of_milk_per_week += amount_of_liters

            if hour is not None:
                print(
                    f"The cow produced {self.liters_of_milk_per_week} "
                    f"liters of milk per week at {hour.strftime('%H:%M')}"
                )
            else:
                print(
                    f"The cow produced {self.liters_of_milk_per_week} "
                    f"liters of milk per week"
                )

    def __str__(self):
        return (
            f"Cow{{is_producing_milk={self.is_producing_milk}, "
            f"liters_of_milk_per_week={self.liters_of_milk_per_week}, "
            f"food={self.food}}} {super().__str__()}"
        )