from datetime import date
from model.Chicken import Chicken
from model.ChickenCoop import ChickenCoop

class ChickenFarmer:
    def __init__(self):
       
        self.chicken_farmer_id = 1
        self.name = "Andy"
        
        self.coops = []
        
       
        chickens = [
            Chicken(0, "pepita", "black", date(2020, 10, 21), True)
        ]
        

        
        mi_primer_gallinero = ChickenCoop(1, chickens)
        self.coops.append(mi_primer_gallinero)

    def __str__(self):
        coops_str = f"[{', '.join(str(coop) for coop in self.coops)}]"
        return f"ChickenFarmer{{chickenFarmerId={self.chicken_farmer_id}, name={self.name}, coops={coops_str}}}"