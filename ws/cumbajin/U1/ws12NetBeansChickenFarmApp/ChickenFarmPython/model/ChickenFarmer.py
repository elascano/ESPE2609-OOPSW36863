
from datetime import datetime
from model.Chicken import Chicken
from model.ChickenCoop import ChickenCoop

"""
@author Dylan Cumbajin, MosQ, @ESPE
"""

class ChickenFarmer:

    def __init__(self):
        self.chickenFarmerId = 1
        self.name = ""
        self.coops = [None] * 2

        chickens = [None] * 2

        chickens[0] = Chicken(0, "pepita", "black", datetime.now(), True)
        chickens[1] = Chicken(0, "marujita", "black", datetime.now(), True)

        self.coops[0] = ChickenCoop(0, chickens)
        self.coops[1] = ChickenCoop(1, chickens)

    def __str__(self):
        return (f"ChickenFarmer{{chickenFarmerId={self.chickenFarmerId}, "
                f"name={self.name}, coops={self.coops}}}")
