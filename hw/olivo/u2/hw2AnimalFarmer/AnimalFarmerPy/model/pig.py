from datetime import datetime, timedelta
from model.mammal import Mammal
from model.medicine_record import MedicineRecord
from model.food import Food

class Pig(Mammal):
    def __init__(self, is_market_ready: bool, pregnant: bool, breed: str, born_on_date: datetime, 
                 weight_in_kg: float, sex: str, medicines_record: list[MedicineRecord], is_meat: bool):
        super().__init__(pregnant, breed, born_on_date, weight_in_kg, sex, medicines_record, is_meat)
        self.__is_market_ready = is_market_ready
    
    def get_is_market_ready(self) -> bool:
        return self.__is_market_ready
        
    def set_is_market_ready(self, is_market_ready: bool):
        self.__is_market_ready = is_market_ready
    
    def compute_carcass_yield_Percentage(self,weight_carcass_yield:float)->float:
        weight_live=self.__weight_in_kg
        
        rendiment_carcass = (weight_carcass_yield / weight_live)*100
        return (round(rendiment_carcass,2))
        
    # Implement abstract methods
    def feed(self, food: Food, amount_of_food: float):
        print(f"Pig [ID: {self.get_id()}] is eating {food.get_name()}, {amount_of_food} kg.")

    def check_if_ready_to_eat(self) -> bool:
        standard_min_weight = 100.0
        current_weight = self.get_weight_in_kg()
        is_ready = current_weight >= standard_min_weight or self.__is_market_ready
        
        print(f"Pig [ID: {self.get_id()}] - Weight: {current_weight} kg | Ready to eat: {is_ready}")
        return is_ready

    def compute_next_medicine_date(self, last_medicine: datetime) -> datetime:
        days_interval = 30 if self.get_is_pregnant() else 45
        next_medicine_date = last_medicine + timedelta(days=days_interval)
        return next_medicine_date

    def __str__(self):
        born_str = self.get_born_on_date().strftime('%d-%m-%Y') if self.get_born_on_date() else "N/A"
        return (
            f"Pig [ID: {self.get_id()}, Breed: {self.get_breed()}, "
            f"Born on: {born_str}, Weight: {self.get_weight_in_kg()} kg, "
            f"Sex: {self.get_sex()}, Pregnant: {self.get_is_pregnant()}, "
            f"Medicines Record: {len(self.get_medicines_record())} entries, "
            f"Is Meat: {self.get_is_meat()}, Market Ready: {self.__is_market_ready}]"
        )