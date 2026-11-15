from model.FarmAnimal import FarmAnimal


class Cow(FarmAnimal):
    def __init__(self, animal_id, breed, born_on_date,
                 is_producing_milk, liters_of_milk):
        super().__init__(animal_id, breed, born_on_date)
        self.is_producing_milk = is_producing_milk
        self.liters_of_milk = liters_of_milk

    def milk(self):
        print("Milking the cow")

    def __str__(self):
        return (f"{super().__str__()} | producing_milk={self.is_producing_milk}, "
                f"liters={self.liters_of_milk}")