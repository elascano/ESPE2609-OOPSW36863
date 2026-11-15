from .farm_animal import FarmAnimal

class Chicken(FarmAnimal):
    def __init__(self, id: int, breed: str, born_on_date: str, is_molting: bool, number_of_laid_egg_in_month: int, is_meat: bool):
        super().__init__(id, breed, born_on_date)
        self.is_molting = is_molting
        self.number_of_laid_egg_in_month = number_of_laid_egg_in_month
        self.is_meat = is_meat

    def feed(self):
        pass

    def lay_an_egg(self):
        print("chicken is laying an egg...")

    def __str__(self):
        # Convertimos booleanos a string en minúscula para replicar el output exacto ("true" en lugar de "True")
        return f"Chicken{{id={self.id}, breed={self.breed}, bornOnDate={self.born_on_date},isMolting={str(self.is_molting).lower()}, numberOfLaidEggInMonth={self.number_of_laid_egg_in_month}, isMeat={str(self.is_meat).lower()}}}"