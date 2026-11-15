from model.farm_animal import FarmAnimal


class Chicken(FarmAnimal):

    def __init__(self, is_molting, number_of_laid_eggs_in_a_month,
                 is_meat, id, breed, born_on_date):

        super().__init__(id, breed, born_on_date)

        self.is_molting = is_molting
        self.number_of_laid_eggs_in_a_month = number_of_laid_eggs_in_a_month
        self.is_meat = is_meat

    def feed(self, food, amount_of_food):
        print(
            f"Feeding a chicken with ---> "
            f"{amount_of_food} of {food}"
        )

    def lay_an_egg(self):
        print("Chicken is laying an egg ()")

    def __str__(self):
        return (
            f"Chicken{{is_molting={self.is_molting}, "
            f"number_of_laid_eggs_in_a_month={self.number_of_laid_eggs_in_a_month}, "
            f"is_meat={self.is_meat}}} {super().__str__()}"
        )