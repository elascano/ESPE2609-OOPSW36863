
from model.farm_animal import FarmAnimal


class Sheep(FarmAnimal):

    def __init__(self, wool_length, is_producing_wool,
                 id, breed, born_on_date):

        super().__init__(id, breed, born_on_date)

        self._wool_length = wool_length
        self._is_producing_wool = is_producing_wool

    def shear(self):
        print("Shearing the sheep")

    def __str__(self):
        return (
            f"Sheep{{{super().__str__()}"
            f"woolLength={self._wool_length}, "
            f"isProducingWool={self._is_producing_wool}}}"
        )

    @property
    def wool_length(self):
        return self._wool_length

    @wool_length.setter
    def wool_length(self, value):
        self._wool_length = value

    @property
    def is_producing_wool(self):
        return self._is_producing_wool

    @is_producing_wool.setter
    def is_producing_wool(self, value):
        self._is_producing_wool = value
