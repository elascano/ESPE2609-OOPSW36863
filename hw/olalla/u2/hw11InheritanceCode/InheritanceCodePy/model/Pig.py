from model.FarmAnimal import FarmAnimal


class Pig(FarmAnimal):
    def __init__(self, animal_id, breed, born_on_date, is_ready_to_eat):
        super().__init__(animal_id, breed, born_on_date)
        self.is_ready_to_eat = is_ready_to_eat

    def __str__(self):
        return (f"{super().__str__()} | ready_to_eat={self.is_ready_to_eat}")
