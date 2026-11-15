from model.FarmAnimal import FarmAnimal


class Sheep(FarmAnimal):
    def __init__(self, animal_id, breed, born_on_date, last_shearing):
        super().__init__(animal_id, breed, born_on_date)
        self.last_shearing = last_shearing

    def __str__(self):
        return (f"{super().__str__()} | last_shearing={self.last_shearing}")