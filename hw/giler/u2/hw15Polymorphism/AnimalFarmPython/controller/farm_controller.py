from datetime import datetime
from model.chicken import Chicken
from model.cow import Cow
from model.pig import Pig
from model.sheep import Sheep
from model.food import Food
from model.location import Location
from view.farm_view import FarmView

class FarmController:
    def __init__(self):
        self.view = FarmView()
    def run(self):
        born_on_date = datetime(2020, 11, 10)
        self.view.print_title()

        food = Food("corn")

        farm_animal = Chicken(True, 1, True, 0, "Paliish", born_on_date)
        self.view.print_animal_type("farmAnimal", farm_animal.__class__.__name__)
        self.view.print_message(f"My farm animal --> {farm_animal}")

        chicken = Chicken(True, 10, True, 2, "Paleesh", born_on_date)
        self.view.print_message(f"Chicken ---> {chicken}")
        chicken.lay_an_egg()

        cow = Cow(True, 100.5, 3, "Holstein", born_on_date)
        self.view.print_animal_type("cow", cow.__class__.__name__)

        cow_as_chicken = Chicken(True, 4, True, 0, "Paliish", born_on_date)
        self.view.print_animal_type("cow", cow_as_chicken.__class__.__name__)

        farm_animal_for_feeding = Chicken(True, 5, True, 0, "Paliish", born_on_date)
        self.view.print_animal_type("farmAnimalForFeeding", farm_animal_for_feeding.__class__.__name__)

        farm_animal_for_feeding_cow = Cow(True, 100.6, 0, "Holstein", born_on_date)
        self.view.print_animal_type("farmAnimalForFeeding", farm_animal_for_feeding_cow.__class__.__name__)

        cow1 = Cow(True, 10, 5, "Holstein", datetime(2020, 11, 10))
        cow1.milk()

        chicken.feed(food, 2)

        food_grass = Food("grass")
        cow1.feed(food_grass, 3)

        cow1.milk()
        cow1.milk(3.23)
        cow1.milk(2.0)
        cow1.milk(1.0, born_on_date)

        self.view.print_separator("Testing Sheep")
        pasture = Location(1, "North Pasture")
        shearing_date = datetime(2023, 6, 15)

        sheep = Sheep(4.5, "Fine", shearing_date, 10, "Merino", born_on_date)
        self.view.print_message(str(sheep))
        sheep.graze(pasture)

        alfalfa = Food("alfalfa")
        sheep.feed(alfalfa, 3)
        sheep.shear_for_market()

        self.view.print_separator("Testing Pig")
        pig_for_meat = Pig(90.0, 110.0, False, 11, "Duroc", born_on_date)
        pig_breeder = Pig(120.0, 150.0, True, 12, "Yorkshire", born_on_date)

        self.view.print_message(str(pig_for_meat))
        scraps = Food("vegetables and grains")
        pig_for_meat.feed(scraps, 10)
        pig_for_meat.calculate_meat_yield()
        pig_for_meat.collect_manure()
        pig_for_meat.produce_piglets()

        self.view.print_message("\nTesting Breeder Pig:")
        pig_breeder.produce_piglets()