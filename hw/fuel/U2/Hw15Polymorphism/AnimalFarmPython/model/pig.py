from model.farm_animal import FarmAnimal


class Pig(FarmAnimal):

    def __init__(self, is_producing_meat, weight_in_pounds,
                 meat_type, id, breed, born_on_date):

        super().__init__(id, breed, born_on_date)

        self.is_producing_meat = is_producing_meat
        self.weight_in_pounds = weight_in_pounds
        self.meat_type = meat_type

    def feed(self, food, amount_of_food):
        print(
            f"Feeding a pig with ---> "
            f"{amount_of_food} of {food}"
        )

    def gain_weight(self, amount):
        self.weight_in_pounds += amount
        print(
            f"The pig's new weight is "
            f"{self.weight_in_pounds} pounds"
        )

    def __str__(self):
        return (
            f"Pig{{is_producing_meat={self.is_producing_meat}, "
            f"weight_in_pounds={self.weight_in_pounds}, "
            f"meat_type={self.meat_type}}} {super().__str__()}"
        )