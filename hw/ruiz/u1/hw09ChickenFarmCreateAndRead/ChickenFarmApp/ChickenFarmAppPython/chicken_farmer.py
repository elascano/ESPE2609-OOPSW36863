from datetime import date

from chicken import Chicken
from chicken_coop import ChickenCoop


class ChickenFarmer:
    def __init__(self):
        self.chicken_farmer_id = 1
        self.name = ""
        self.coops = [None] * 2

        chickens = [None] * 2
        chickens[0] = Chicken(0, "pepita", "black", date.today(), True)
        chickens[1] = Chicken(0, "marujita", "black", date.today(), True)

        # Igual que en el Java, ambos gallineros comparten el mismo arreglo de pollos
        self.coops[0] = ChickenCoop(0, chickens)
        self.coops[1] = ChickenCoop(1, chickens)

    def __str__(self):
        local_coops = ""
        for coop in self.coops:
            local_coops += str(coop)
            local_coops += "\n"
        return (f"ChickenFarmer{{chickenFarmerId={self.chicken_farmer_id}, "
                f"name={self.name}, coops={local_coops}}}")