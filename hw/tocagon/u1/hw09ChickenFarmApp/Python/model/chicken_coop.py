from datetime import datetime
from .chicken import Chicken


class ChickenCoop:
    MAX_CHICKENS = 10

    def __init__(self, chicken_coop_id=0, chickens=None):
        self.chicken_coop_id = chicken_coop_id
        self.chickens = chickens if chickens is not None else []

    def add(self, chicken):
        if len(self.chickens) < self.MAX_CHICKENS:
            self.chickens.append(chicken)
        else:
            print("Maximum!!")

    def add_from_input(self):
        id = int(input("ID: "))
        name = input("Name: ")
        color = input("Color: ")
        molting = input("Molting (true/false): ").strip().lower() == "true"
        born_on_date = datetime.strptime(input("Born on (yyyy-MM-dd): "), "%Y-%m-%d").date()

        self.add(Chicken(id, name, color, born_on_date, molting))
        print("Chicken added!")

    def remove(self, chicken_id):
        for chicken in self.chickens:
            if chicken.id == chicken_id:
                self.chickens.remove(chicken)
                return
        print(f"No chicken was found with the ID --> {chicken_id}")

    def next(self, position):
        if position < len(self.chickens):
            return self.chickens[position]
        return None

    def __str__(self):
        lines = "\n\t".join(str(c) for c in self.chickens)
        return f"ChickenCoop{{chickenCoopId={self.chicken_coop_id}, chickens=\n\t{lines}}}"