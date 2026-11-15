
from model.farm_animal import FarmAnimal


class Pig(FarmAnimal):

    def __init__(self, weight, is_breeding,
                 id, breed, born_on_date):

        super().__init__(id, breed, born_on_date)

        self._weight = weight
        self._is_breeding = is_breeding

    def feed(self):
        print("Feeding the pig")

    def __str__(self):
        return (
            f"Pig{{{super().__str__()}"
            f"weight={self._weight}, "
            f"isBreeding={self._is_breeding}}}"
        )

    @property
    def weight(self):
        return self._weight

    @weight.setter
    def weight(self, value):
        self._weight = value

    @property
    def is_breeding(self):
        return self._is_breeding

    @is_breeding.setter
    def is_breeding(self, value):
        self._is_breeding = value
