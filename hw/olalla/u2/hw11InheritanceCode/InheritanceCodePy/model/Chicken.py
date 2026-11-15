from model.FarmAnimal import FarmAnimal


class Chicken(FarmAnimal):
    def __init__(self, animal_id, breed, born_on_date,
                 is_molting, number_of_laid_eggs_in_months, is_meat):
        super().__init__(animal_id, breed, born_on_date)
        self.is_molting = is_molting
        self.number_of_laid_eggs_in_months = number_of_laid_eggs_in_months
        self.is_meat = is_meat

    def lay_an_egg(self):
        self.number_of_laid_eggs_in_months += 1
        print("Chicken lays an egg ")

    def __str__(self):
        return (f"{super().__str__()} | molting={self.is_molting}, "
                f"eggs/month={self.number_of_laid_eggs_in_months}, "
                f"meat={self.is_meat}")

