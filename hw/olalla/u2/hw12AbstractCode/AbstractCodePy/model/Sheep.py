from model.FarmAnimal import FarmAnimal


class Sheep(FarmAnimal):
    def __init__(self, animal_id, breed, born_on_date, last_shearing, 
                 producing_milk, litters_of_milk):
        super().__init__(animal_id, breed, born_on_date)
        self.last_shearing = last_shearing
        self.producing_milk = producing_milk
        self.litters_of_milk = litters_of_milk

    def milk(self):
        print("Sheep with milk")

    def make_sound(self):
        return "Baa!"

    def __str__(self):
        return (f"{super().__str__()} | last_shearing={self.last_shearing}"
                f"producing_milk={self.producing_milk}, "
                f"litters_of_milk={self.litters_of_milk}")