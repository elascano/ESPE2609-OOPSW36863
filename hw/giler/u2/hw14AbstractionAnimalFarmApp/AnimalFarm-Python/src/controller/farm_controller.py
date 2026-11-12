from src.model.chicken import Chicken
from src.model.cow import Cow
from src.view.console_view import ConsoleView

class FarmController:
    def __init__(self):
        self.animals = []
        self.view = ConsoleView()

    def add_chicken(self, id, breed, born_on_date, is_molting, number_of_laid_egg_in_month, is_meat):
        self.animals.append(Chicken(id, breed, born_on_date, is_molting, number_of_laid_egg_in_month, is_meat))

    def add_cow(self, id, breed, born_on_date, is_producing_milk, liters_of_milk_for_week):
        self.animals.append(Cow(id, breed, born_on_date, is_producing_milk, liters_of_milk_for_week))

    def process_animals(self):
        self.view.show_message("\n--- Processing Animals ---")
        for animal in self.animals:
            animal.feed()
            if isinstance(animal, Chicken):
                animal.lay_an_egg()
            elif isinstance(animal, Cow):
                animal.milking()