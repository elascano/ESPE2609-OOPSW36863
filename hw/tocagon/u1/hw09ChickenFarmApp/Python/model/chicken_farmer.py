from datetime import date
from .chicken import Chicken
from .chicken_coop import ChickenCoop


class ChickenFarmer:
    def __init__(self, chicken_farmer_id=1, name="", coops=None):
        self.chicken_farmer_id = chicken_farmer_id
        self.name = name
        self.coops = coops if coops is not None else []

    def __str__(self):
        coops_text = "\n".join(str(c) for c in self.coops)
        return (f"ChickenFarmer{{chickenFarmerId={self.chicken_farmer_id}, "
                f"name={self.name}, coops=\n{coops_text}}}")