"""Connect user input in the view with animal model objects."""

from model.Chicken import Chicken
from model.Cow import Cow
from model.Pig import Pig
from model.Sheep import Sheep
from view.AnimalView import AnimalView


class AnimalController:
    def __init__(self, view: AnimalView):
        self.view = view

    def run(self) -> None:
        while True:
            option = self.view.show_menu()
            if option == 1:
                chicken = self.create_chicken()
                print("Chicken ->", chicken)
            elif option == 2:
                cow = self.create_cow()
                print("Cow ->", cow)
                cow.milk()
            elif option == 3:
                pig = self.create_pig()
                print("Pig ->", pig)
            elif option == 4:
                sheep = self.create_sheep()
                print("Sheep ->", sheep)
            elif option == 5:
                print("Exiting program...")
                break
            else:
                print("Invalid option.")
            print()

    def create_chicken(self) -> Chicken:
        print("----- ENTER CHICKEN DATA -----")
        id = self.view.read_id()
        bread = self.view.read_bread()
        born_on_date = self.view.read_date("born date")
        is_molting = self.view.read_bool("Is molting? (true/false): ")
        number_off_lat_is_month = self.view.read_int(
            "Number of eggs this month: "
        )
        is_meat = self.view.read_bool("Is meat? (true/false): ")
        return Chicken(id, bread, born_on_date, is_molting,
                       number_off_lat_is_month, is_meat)

    def create_cow(self) -> Cow:
        print("----- ENTER COW DATA -----")
        id = self.view.read_id()
        bread = self.view.read_bread()
        born_on_date = self.view.read_date("born date")
        is_producing_milk = self.view.read_bool(
            "Is producing milk? (true/false): "
        )
        liters_of_milk_per_week = self.view.read_float(
            "Liters of milk per week: "
        )
        return Cow(is_producing_milk, liters_of_milk_per_week,
                   id, bread, born_on_date)

    def create_pig(self) -> Pig:
        print("----- ENTER PIG DATA -----")
        id = self.view.read_id()
        bread = self.view.read_bread()
        born_on_date = self.view.read_date("born date")
        return Pig(id, bread, born_on_date)

    def create_sheep(self) -> Sheep:
        print("----- ENTER SHEEP DATA -----")
        id = self.view.read_id()
        bread = self.view.read_bread()
        born_on_date = self.view.read_date("born date")
        last_sheering = self.view.read_date("last sheering date")
        return Sheep(last_sheering, id, bread, born_on_date)
