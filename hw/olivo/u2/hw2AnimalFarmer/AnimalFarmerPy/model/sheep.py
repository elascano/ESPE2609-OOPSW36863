from datetime import datetime, timedelta
from model.mammal import Mammal
from model.medicine_record import MedicineRecord
from model.food import Food

class Sheep(Mammal):
    def __init__(self, last_shearing: datetime, pregnant: bool, breed: str, born_on_date: datetime, 
                 weight_in_kg: float, sex: str, medicines_record: list[MedicineRecord], is_meat: bool):
        super().__init__(pregnant, breed, born_on_date, weight_in_kg, sex, medicines_record, is_meat)
        self.__last_shearing = last_shearing
    
    def get_last_shearing(self) -> datetime:
        return self.__last_shearing
        
    def set_last_shearing(self, last_shearing: datetime):
        self.__last_shearing = last_shearing
    
    def compute_next_shearing_date(self) -> datetime:
        return self.__last_shearing + timedelta(days=365)
        
    def compute_next_medicine_date(self, last_medicine: datetime) -> datetime:
        days_interval = 30 if self.get_pregnant() else 60
        next_medicine_date = last_medicine + timedelta(days=days_interval)
        return next_medicine_date

    # Implement abstract methods
    def feed(self, food: Food, amount_of_food: float):
        new_weight = self.get_weight_in_kg() + (amount_of_food * 0.05)
        self.set_weight_in_kg(new_weight)
        print(f"Sheep [ID: {self.get_id()}] is eating {food.get_name()}, {amount_of_food} kg.")

    def check_if_ready_to_eat(self) -> bool:
        standard_min_weight = 45.0
        current_weight = self.get_weight_in_kg()
        is_ready = current_weight >= standard_min_weight
        print(f"Sheep [ID: {self.get_id()}] - Weight: {current_weight} kg | Ready to eat: {is_ready}")
        return is_ready

    def __str__(self):
        shearing_str = self.__last_shearing.strftime('%d-%m-%Y') if self.__last_shearing else "N/A"
        born_str = self.get_born_on_date().strftime('%d-%m-%Y') if self.get_born_on_date() else "N/A"
        return (
            f"Sheep [ID: {self.get_id()}, Breed: {self.get_breed()}, "
            f"Born on: {born_str}, Weight: {self.get_weight_in_kg()} kg, "
            f"Sex: {self.get_sex()}, Pregnant: {self.get_pregnant()}, "
            f"Medicines Record: {len(self.get_medicines_record())} entries, "
            f"Is Meat: {self.get_is_meat()}, Last Shearing: {shearing_str}]"
        )